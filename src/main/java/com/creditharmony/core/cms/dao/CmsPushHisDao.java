package com.creditharmony.core.cms.dao;

import com.creditharmony.core.cms.entity.CmsPushHis;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;


@CoreBatisDao
public interface CmsPushHisDao extends CrudDao<CmsPushHis> {
    int deleteByPrimaryKey(String id);

    int insert(CmsPushHis record);

    int insertSelective(CmsPushHis record);

    CmsPushHis selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CmsPushHis record);

    int updateByPrimaryKey(CmsPushHis record);
}