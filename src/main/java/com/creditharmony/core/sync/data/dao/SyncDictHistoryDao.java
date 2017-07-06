package com.creditharmony.core.sync.data.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncDictHistory;

/**
 * 同步数据字典历史dao
 * @Class Name SyncDictHistoryDao
 * @author 陈伟东
 * @Create In 2015年12月28日
 */
@CoreBatisDao
public interface SyncDictHistoryDao extends CrudDao<SyncDictHistory>{
	/**
	 * 条件查询SyncDictHistory对象
	 * 2015年12月28日
	 * By 陈伟东
	 * @param filter
	 * @return
	 */
	public List<SyncDictHistory> findByParams(Map<String,Object> filter);
}