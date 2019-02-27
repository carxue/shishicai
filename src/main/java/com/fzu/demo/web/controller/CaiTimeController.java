package com.fzu.demo.web.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fzu.demo.common.DateUtil;
import com.fzu.demo.common.caiutils.CaiStaQuery;
import com.fzu.demo.common.caiutils.CqTimeLottery;
import com.fzu.demo.common.caiutils.ResponseWrap;
import com.fzu.demo.web.service.CaiTimeService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cai")
public class CaiTimeController {
	private static final Logger logger = LoggerFactory.getLogger(CaiTimeController.class);

	@Autowired
	CaiTimeService caiTimeService;

	@PostMapping("/v1/xday/cai/list")
	@ResponseBody
	public ResponseWrap getCaiList(@ModelAttribute CqTimeLottery user) {
		ResponseWrap wrap = new ResponseWrap();
		wrap.setData(caiTimeService.queryCaiTimeList(user));
		return wrap;
	}

	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request,Map<String, Object> model) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String today = df.format(new Date());
		String url = request.getScheme()+"://"+ request.getServerName()+":"+ request.getServerPort();
		Integer todayInt = Integer.parseInt(today);;
		Integer openDate = null;
		String queryDay = request.getParameter("queryDay");
		if(StringUtils.isNoneBlank(queryDay)){
			openDate = Integer.parseInt(queryDay);
		}else{
			openDate = Integer.parseInt(df.format(new Date()));
		}
		if(openDate>todayInt){
			openDate = todayInt;
		}
		CqTimeLottery user = new CqTimeLottery();
		user.setOpenDate(openDate);
		model.put("caiList", caiTimeService.queryCaiTimeList(user));
		model.put("queryDay", openDate);
		model.put("ctx",url);
		return "cai/welcome";
	}

	@RequestMapping("/echart")
    public String search(HttpServletRequest request,Map<String, Object> model) throws ParseException {
		String url = request.getScheme()+"://"+ request.getServerName()+":"+ request.getServerPort();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String today = df.format(new Date());
		Integer todayInt = Integer.parseInt(today);
		Integer endDate = null;
		String queryDay = request.getParameter("queryDay");
		if(StringUtils.isNoneBlank(queryDay)){
			endDate = Integer.parseInt(queryDay);
		}else{
			endDate = Integer.parseInt(df.format(new Date()));
		}
		if(endDate>todayInt){
			endDate = todayInt;
		}
		Date startDate = DateUtil.getDateAdd(df.parse(endDate.toString()), -29);
		Integer startDateInt = Integer.parseInt(df.format(startDate));
		CaiStaQuery user = new CaiStaQuery();
		user.setStartDay(startDateInt);
		user.setEndDay(endDate);
		Gson gson = new Gson();
		model.put("caiList", gson.toJson(caiTimeService.queryCaiTimeStaList(user)));
		model.put("queryDay", endDate);
		model.put("ctx",url);
        return "cai/echartSta";
    }

}
