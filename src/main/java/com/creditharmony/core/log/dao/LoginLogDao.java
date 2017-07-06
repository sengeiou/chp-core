package com.creditharmony.core.log.dao;

import com.creditharmony.core.log.entity.LoginLog;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface LoginLogDao extends CrudDao<LoginLog>{
    int deleteByPrimaryKey(String id);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
}