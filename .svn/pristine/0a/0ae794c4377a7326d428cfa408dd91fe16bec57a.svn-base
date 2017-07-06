package com.creditharmony.core.users.dao;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.IpConfig;
import com.creditharmony.core.users.entity.OnOff;
@CoreBatisDao
public interface OnOffDao extends CrudDao<OnOff>{
    int deleteByPrimaryKey(String id);

    int insertSelective(OnOff record);

    OnOff selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OnOff record);

    int updateByPrimaryKey(OnOff record);
    
    OnOff selectByType(String type);
}