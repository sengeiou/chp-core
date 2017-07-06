package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.IpConfig;

/**
 * 用户DAO接口
 * @Class Name UserIpConfigDao
 * @author 范子银
 * @Create In 2016年10月26日
 */
@CoreBatisDao
public interface IpConfigDao extends CrudDao<IpConfig> {


	public List<IpConfig> findUserByOrgId(IpConfig ipConfig);  //列表
	
	public long findAllCount(Map<String,Object> params);  //查询 
	
	public List<IpConfig> findByParams(Map<String,Object> params, PageBounds pageBounds);  //分页查询  
	
	public List<String> findIpList(IpConfig ic);	
	
    int deleteByPrimaryKey(String id);

    int insertSelective(IpConfig record);

    IpConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IpConfig record);

    int updateByPrimaryKey(IpConfig record);
}

		

