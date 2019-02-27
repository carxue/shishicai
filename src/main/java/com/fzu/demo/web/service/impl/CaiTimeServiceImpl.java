package com.fzu.demo.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzu.demo.common.caiutils.CaiStaQuery;
import com.fzu.demo.common.caiutils.CaiTimeStatis;
import com.fzu.demo.common.caiutils.CqTimeLottery;
import com.fzu.demo.web.mapper.CaiTimeDao;
import com.fzu.demo.web.mapper.CaiTimeStatisDao;
import com.fzu.demo.web.service.CaiTimeService;

@Service
public class CaiTimeServiceImpl implements CaiTimeService {

    private static final Logger logger = LoggerFactory.getLogger(CaiTimeServiceImpl.class);

    @Autowired
    CaiTimeDao caiTimeDao;
    
    @Autowired
    CaiTimeStatisDao caiTimeStatisDao;

	@Override
	public int insertSelectiveCaiTime(CqTimeLottery user) {
		return caiTimeDao.insertSelectiveCaiTime(user);
	}

	@Override
	public int insertCaiTime(CqTimeLottery user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CqTimeLottery> queryCaiTimeList(CqTimeLottery user) {
		return caiTimeDao.queryCaiTimeList(user);
	}
	
	@Override
	public List<CaiTimeStatis> queryCaiTimeStaList(CaiStaQuery user) {
		return caiTimeStatisDao.queryCaiTimeStatisList(user);
	}

}
