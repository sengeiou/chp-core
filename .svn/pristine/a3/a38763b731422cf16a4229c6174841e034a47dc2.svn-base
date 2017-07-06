package com.creditharmony.core.sync.data.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncRoleHistory;

/**
 * 同步角色dao
 * @Class Name SyncRoleHistoryDao
 * @author 陈伟东
 * @Create In 2015年12月25日
 */
@CoreBatisDao
public interface SyncRoleHistoryDao extends CrudDao<SyncRoleHistory> {
	
	/**
	 * 条件查询SyncRoleHistory对象
	 * 2015年12月25日
	 * By 陈伟东
	 * @param filter
	 * @return
	 */
	public List<SyncRoleHistory> findByParams(Map<String,Object> filter);
}