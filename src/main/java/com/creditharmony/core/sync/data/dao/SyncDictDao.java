package com.creditharmony.core.sync.data.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncDict;

/**
 * 同步数据字典dao
 * @Class Name SyncDictDao
 * @author 陈伟东
 * @Create In 2015年12月28日
 */
@CoreBatisDao
public interface SyncDictDao extends CrudDao<SyncDict>{
	
	/**
	 * 条件查询SyncDict对象
	 * 2015年12月28日
	 * By 陈伟东
	 * @param filter
	 * @return
	 */
	public List<SyncDict> findByParams(Map<String,Object> filter);
	
	/**
	 * 分页查询
	 * 2015年12月28日
	 * By 陈伟东
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<SyncDict> findByPage(Map<String,Object> params, PageBounds pageBounds);
	
}