package com.fzu.demo.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fzu.demo.common.caiutils.CqTimeLottery;

@Mapper
public interface CaiTimeDao {

    int insertSelectiveCaiTime(CqTimeLottery user);
    
    int insertCaiTime(CqTimeLottery user);
    
    int insertCaiTimeByBatch(List<CqTimeLottery> list);
    
    List<CqTimeLottery> queryCaiTimeList(CqTimeLottery user);
    
    CqTimeLottery queryLastestCaiTime();
    
}
