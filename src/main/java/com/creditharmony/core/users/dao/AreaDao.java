package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.TreeDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.Area;

/**
 * 区域DAO接口
 * @version 2015-10-16
 */
@CoreBatisDao
public interface AreaDao extends TreeDao<Area> {
	
	/**
	 * 条件查询区域
	 * 2016年1月21日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Area> findByParams(Map<String,Object> params);
}
