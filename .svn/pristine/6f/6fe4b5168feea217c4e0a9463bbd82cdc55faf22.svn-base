package com.creditharmony.core.log.dao;

import com.creditharmony.core.log.entity.OrgLog;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface OrgLogDao  extends CrudDao<OrgLog>{
    int deleteByPrimaryKey(String id);

    int insertSelective(OrgLog record);

    OrgLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrgLog record);

    int updateByPrimaryKey(OrgLog record);
}