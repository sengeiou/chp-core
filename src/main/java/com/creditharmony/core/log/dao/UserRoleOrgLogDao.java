package com.creditharmony.core.log.dao;

import com.creditharmony.core.log.entity.UserRoleOrgLog;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface UserRoleOrgLogDao  extends CrudDao<UserRoleOrgLog>{
    int deleteByPrimaryKey(String id);

    int insertSelective(UserRoleOrgLog record);

    UserRoleOrgLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoleOrgLog record);

    int updateByPrimaryKey(UserRoleOrgLog record);
}