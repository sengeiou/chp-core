package com.creditharmony.core.users.dao;

import java.util.List;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.IpLocalConfig;
@CoreBatisDao
public interface IpLocalConfigDao  extends CrudDao<IpLocalConfig>{
    int deleteByPrimaryKey(String id);

    int insertSelective(IpLocalConfig record);

    IpLocalConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IpLocalConfig record);

    int updateByPrimaryKey(IpLocalConfig record);
    
    public List<String> findIpList(IpLocalConfig ic);
}