package com.creditharmony.core.cms.dao;

import java.util.List;

import com.creditharmony.core.cms.entity.CmsPush;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface CmsPushDao extends CrudDao<CmsPush> {
    int deleteByPrimaryKey(String id);

    int insert(CmsPush record);

    int insertSelective(CmsPush record);

    CmsPush selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CmsPush record);

    int updateByPrimaryKey(CmsPush record);
    
    int insertBatch(CmsPush record);
    
    List<CmsPush> findAll();
    
    List<CmsPush> findOverdueList(); 
}