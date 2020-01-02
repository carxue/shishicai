package com.fzu.demo.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fzu.demo.common.caiutils.CaiTimeStatis;
import com.fzu.demo.common.caiutils.CaiTimeStatisResult;
import com.fzu.demo.common.caiutils.CqTimeLottery;
import com.fzu.demo.web.mapper.CaiTimeStatisDao;

@Component
public class EveryDayStatisticsTimer {
	private static final Logger logger = LoggerFactory.getLogger(EveryDayStatisticsTimer.class);

	private static final String zu_third = "组三";
	private static final String zu_five20 = "组20";
	private static final String zu_five30 = "组30";
	private static final String zu_five10 = "组10";
	private static final String zu_five5 = "组5";
	private static final String zu_five120 = "组120";

	@Autowired
	CaiTimeStatisDao caiTimeStatisDao;

	private static Integer openDate = 20191008;

	@PostConstruct
	public void initQueryDay() {
		CaiTimeStatis caTime = caiTimeStatisDao.queryLastestCaiTimeStatistics();
		if (null != caTime) {
			openDate = caTime.getOpenDate();
			caiTimeStatisDao.deleteCaiStaByDate(openDate);
		}
	}

	// 解锁.定时每20s拉取数据到数据库
	@Scheduled(cron = "${cai.statisticstimer}")
	public void autoCheckTripTicketOfMinuter() {
		logger.info("------- auto time statistic begin ---------");
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		Integer today = Integer.parseInt(df.format(date));
		
		String openDateStr = openDate.toString();
		int year = Integer.parseInt(openDateStr.substring(0, 4));
		int month = Integer.parseInt(openDateStr.substring(4, 6)) - 1;
		int day = Integer.parseInt(openDateStr.substring(6, 8));
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, 0, 0, 0);
		Integer queryDay = Integer.parseInt(df.format(c.getTime()));
		
		while (queryDay < today) {
			try {
				caiTimeStatisDao.insertSelectiveCaiTimeStatis(initCaiTimeStatistics(queryDay));
				c.add(Calendar.DAY_OF_MONTH, 1);
				queryDay = Integer.parseInt(df.format(c.getTime()));
				openDate = queryDay;
			} catch (Exception e) {// 如果已经存在则删除，下次定时任务重新插入
				CaiTimeStatis result = caiTimeStatisDao.queryCaiTimeFiveStatisByDay(queryDay);
				if (result != null) caiTimeStatisDao.deleteCaiStaByDate(queryDay);
				logger.error("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~在{}添加统计数据时出现重复数据,异常信息:{}", queryDay, e.getMessage());
			}
		}
		if (queryDay.intValue() == today.intValue()) {
			caiTimeStatisDao.deleteCaiStaByDate(queryDay);
			caiTimeStatisDao.insertSelectiveCaiTimeStatis(initCaiTimeStatistics(queryDay));
		}
		logger.info("------- auto time statistic end ---------");
	}

	private CaiTimeStatis initCaiTimeStatistics(Integer queryDay) {
		List<CaiTimeStatisResult> queryList = null;
		CaiTimeStatis insertSta = new CaiTimeStatis();
		insertSta.setOpenDate(queryDay);
		CqTimeLottery user = new CqTimeLottery();
		user.setOpenDate(queryDay);
		// 123
		user.setZuThirdPosition123("123");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition123Count(cai1.getCount());
					insertSta.setZuThirdPosition123BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition123Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition123BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition123Count(queryList.get(0).getCount());
			}
		}
		// 124
		user.setZuThirdPosition123(null);
		user.setZuThirdPosition124("124");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition124Count(cai1.getCount());
					insertSta.setZuThirdPosition124BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition124Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition124BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition124Count(queryList.get(0).getCount());
			}
		}
		// 125
		user.setZuThirdPosition124(null);
		user.setZuThirdPosition125("125");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition125Count(cai1.getCount());
					insertSta.setZuThirdPosition125BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition125Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition125BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition125Count(queryList.get(0).getCount());
			}
		}
		// 134
		user.setZuThirdPosition125(null);
		user.setZuThirdPosition134("134");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition134Count(cai1.getCount());
					insertSta.setZuThirdPosition134BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition134Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition134BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition134Count(queryList.get(0).getCount());
			}
		}
		// 135
		user.setZuThirdPosition134(null);
		user.setZuThirdPosition135("135");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition135Count(cai1.getCount());
					insertSta.setZuThirdPosition135BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition135Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition135BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition135Count(queryList.get(0).getCount());
			}
		}
		// 145
		user.setZuThirdPosition135(null);
		user.setZuThirdPosition145("145");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition145Count(cai1.getCount());
					insertSta.setZuThirdPosition145BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition145Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition145BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition145Count(queryList.get(0).getCount());
			}
		}
		// 234
		user.setZuThirdPosition145(null);
		user.setZuThirdPosition234("234");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition234Count(cai1.getCount());
					insertSta.setZuThirdPosition234BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition234Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition234BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition234Count(queryList.get(0).getCount());
			}
		}
		// 235
		user.setZuThirdPosition234(null);
		user.setZuThirdPosition235("235");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition235Count(cai1.getCount());
					insertSta.setZuThirdPosition235BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition235Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition235BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition235Count(queryList.get(0).getCount());
			}
		}
		// 245
		user.setZuThirdPosition235(null);
		user.setZuThirdPosition245("245");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition245Count(cai1.getCount());
					insertSta.setZuThirdPosition245BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition245Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition245BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition245Count(queryList.get(0).getCount());
			}
		}
		// 345
		user.setZuThirdPosition245(null);
		user.setZuThirdPosition345("345");
		queryList = caiTimeStatisDao.queryCaiTimeThirdStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() > 1) {
				CaiTimeStatisResult cai1 = queryList.get(0);
				if (cai1.getType().equals(zu_third)) {
					insertSta.setZuThirdPosition345Count(cai1.getCount());
					insertSta.setZuThirdPosition345BaoCount(queryList.get(1).getCount());
				} else {
					insertSta.setZuThirdPosition345Count(queryList.get(1).getCount());
					insertSta.setZuThirdPosition345BaoCount(cai1.getCount());
				}
			} else {
				insertSta.setZuThirdPosition345Count(queryList.get(0).getCount());
			}
		}
		// five
		queryList = caiTimeStatisDao.queryCaiTimeFiveStatisList(user);
		if (queryList != null && queryList.size() > 0) {
			for (int i = 0; i < queryList.size(); i++) {
				CaiTimeStatisResult result = queryList.get(i);
				String type = result.getType();
				int count = result.getCount();
				if (type.equals(zu_five30)) {
					insertSta.setZuFive30Acount(count);
				} else if (type.equals(zu_five20)) {
					insertSta.setZuFive20Acount(count);
				} else if (type.equals(zu_five10)) {
					insertSta.setZuFive10Acount(count);
				} else if (type.equals(zu_five5)) {
					insertSta.setZuFive5Acount(count);
				} else if (type.equals(zu_five120)) {
					insertSta.setZuFive120Acount(count);
				}
			}
		}
		return insertSta;
	}

}
