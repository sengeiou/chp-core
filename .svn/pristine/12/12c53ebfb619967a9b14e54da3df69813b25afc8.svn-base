package com.creditharmony.core.threenet.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.threenet.entity.ThreeNetUser;

/**
 * 三网用户dao
 * @Class Name ThreeNetUserDao
 * @author 张永生
 * @Create In 2016年2月29日
 */
@CoreBatisDao
public interface ThreeNetUserDao extends CrudDao<ThreeNetUser> {

	/**
	 * 条件查询SyncUser对象
	 * 2015年12月7日
	 * By 张永生
	 * @param filter
	 * @return
	 */
	public List<ThreeNetUser> findByParams(Map<String,Object> filter);
	
	/**
	 * 分页查询
	 * 2015年12月8日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<ThreeNetUser> findByPage(Map<String,Object> params, PageBounds pageBounds);
	
	/**
	 * 根据角色查询用户
	 * @param filter
	 * @return
	 */
	public List<ThreeNetUser> findUserByRoleId(Map<String,Object> filter);
	
}
