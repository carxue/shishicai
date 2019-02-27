package com.fzu.demo.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fzu.demo.common.caiutils.CaiStaQuery;
import com.fzu.demo.common.caiutils.CaiTimeStatis;
import com.fzu.demo.common.caiutils.CaiTimeStatisResult;
import com.fzu.demo.common.caiutils.CqTimeLottery;

@Mapper
public interface CaiTimeStatisDao {

    int insertSelectiveCaiTimeStatis(CaiTimeStatis user);
    
    int insertCaiTimeStatis(CaiTimeStatis user);
    
    int insertCaiTimeStatisByBatch(List<CaiTimeStatis> list);
    
    /**
     * 查询统计已经统计好的每天数据默认15天
     * @param user
     * @return
     */
    List<CaiTimeStatis> queryCaiTimeStatisList(CaiStaQuery user);
    
    /**
     * 查询统计表中最新的一条数据
     * @return
     */
    CaiTimeStatis queryLastestCaiTimeStatistics();
    
    /**
     * 查询每天的各种组合成的组三的数据统计
     * @param user
     * @return
     */
    List<CaiTimeStatisResult> queryCaiTimeThirdStatisList(CqTimeLottery user);
    
    /**
     * 查询每天的组5各类型统计
     * @param user
     * @return
     */
    List<CaiTimeStatisResult> queryCaiTimeFiveStatisList(CqTimeLottery user);
    
    /**
     * 删除最新的一条数据
     * @param openDate
     * @return
     */
    int deleteCaiStaByDate(Integer openDate);
    
    /**
     * 查询某一天是否存在
     * @param user
     * @return
     */
    CaiTimeStatis queryCaiTimeFiveStatisByDay(Integer openDate);
}
