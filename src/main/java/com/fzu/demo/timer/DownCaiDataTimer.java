package com.fzu.demo.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fzu.demo.common.caiutils.CqTimeLottery;
import com.fzu.demo.common.caiutils.HttpClientJsonUtils;
import com.fzu.demo.web.mapper.CaiTimeDao;

@Component
public class DownCaiDataTimer {
	private static final Logger logger = LoggerFactory.getLogger(DownCaiDataTimer.class);
	@Autowired
    CaiTimeDao caiTimeDao;
	private static CqTimeLottery caTime = null;
	
	@PostConstruct
	public void initQueryDay(){
		caTime = caiTimeDao.queryLastestCaiTime();
	}


    //解锁.定时每20s拉取数据到数据库
    @Scheduled(cron = "${cai.downloadtimer}")
    public void autoCheckTripTicketOfMinuter(){
    	logger.info("------- autoCheckTripTicketOfMinuter begin ---------");
//    	redisUtilSentinel.setString("nima", "学姐", 0);
		int openDate = caTime.getOpenDate();
		String sortNo = caTime.getSortNo();
		if(openDate>0){
			String openDateStr = openDate+"";
			int year = Integer.parseInt(openDateStr.substring(0,4));
			int month = Integer.parseInt(openDateStr.substring(4,6))-1;
			int day = Integer.parseInt(openDateStr.substring(6,8));
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();	
			Integer today = Integer.parseInt(df.format(date));
			Calendar c = Calendar.getInstance();
			c.set(year, month, day, 0, 0, 0);
			Integer queryDay = Integer.parseInt(df.format(c.getTime()));
			while(queryDay<=today){
				queryAndSaveNeedCaipiao(queryDay,sortNo);
				sortNo = null;
				c.add(Calendar.DAY_OF_MONTH, 1);
				queryDay = Integer.parseInt(df.format(c.getTime()));
			}
		}
        logger.info("------- autoCheckTripTicketOfMinuter end ---------");
    }
    
    private void queryAndSaveNeedCaipiao(int day,String num){
		List<CqTimeLottery> list = HttpClientJsonUtils.getEveryDayData(day);
		List<CqTimeLottery> newlist = new ArrayList<CqTimeLottery>();
		if(num!=null){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getSortNo().equals(num)){
					for(int j=i+1;j<list.size();j++){
						newlist.add(list.get(j));
					}
					break;
				}
			}
		}else{
			newlist = list;
		}
		if(newlist!=null&&!newlist.isEmpty()){
			caiTimeDao.insertCaiTimeByBatch(newlist);
			caTime = newlist.get(newlist.size()-1);
		}
	}
}
