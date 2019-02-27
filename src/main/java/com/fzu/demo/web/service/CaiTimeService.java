package com.fzu.demo.web.service;

import java.util.List;

import com.fzu.demo.common.caiutils.CaiStaQuery;
import com.fzu.demo.common.caiutils.CaiTimeStatis;
import com.fzu.demo.common.caiutils.CqTimeLottery;

public interface CaiTimeService {

	int insertSelectiveCaiTime(CqTimeLottery user);

	int insertCaiTime(CqTimeLottery user);

	List<CqTimeLottery> queryCaiTimeList(CqTimeLottery user);
	
	public List<CaiTimeStatis> queryCaiTimeStaList(CaiStaQuery user);
}
