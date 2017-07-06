package com.creditharmony.core.log.dao;

import com.creditharmony.core.log.entity.UserLog;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface UserLogDao  extends CrudDao<UserLog>{
    int deleteByPrimaryKey(String id);

    int insertSelective(UserLog record);

    UserLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);
}