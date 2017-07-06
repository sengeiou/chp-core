package com.creditharmony.core.sync.data.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncUser;

/**
 * 同步用户dao
 * @Class Name SyncUserDao
 * @author 张永生
 * @Create In 2015年12月2日
 */
@CoreBatisDao
public interface SyncUserDao extends CrudDao<SyncUser> {

	/**
	 * 条件查询SyncUser对象
	 * 2015年12月7日
	 * By 张永生
	 * @param filter
	 * @return
	 */
	public List<SyncUser> findByParams(Map<String,Object> filter);
	
	/**
	 * 分页查询
	 * 2015年12月8日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<SyncUser> findByPage(Map<String,Object> params, PageBounds pageBounds);
	
	/**
	 * 根据角色查询用户
	 * @param filter
	 * @return
	 */
	public List<SyncUser> findUserByRoleId(Map<String,Object> filter);
	
}
