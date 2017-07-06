package com.creditharmony.core.hldmng.dao;

import com.creditharmony.core.hldmng.entity.HldMngEntity;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

import java.util.List;

/**
 * 节假日管理-Dao
 * 
 * @Class Name HldMngDao
 * @author 周亮
 * @Create In 2015年11月30日
 */
@CoreBatisDao
public interface HldMngDao {

    /**
     * 检索节假日
     * 
     * @param key
     * @return List<FortuneHldMngEntity>
     */
    public List<HldMngEntity> selHld(HldMngEntity key);
    
    /**
     * 添加节假日
     * 
     * @param record
     * @return List<FortuneHldMngEntity>
     */
    public int insHld(HldMngEntity record);   
    
    /**
     * 删除节假日
     * 
     * @param record
     * @return List<FortuneHldMngEntity>
     */
    public int delHld(HldMngEntity key);
}