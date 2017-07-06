package com.creditharmony.core.sync.data.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncDataBatch;

/**
 * 同步数据批次dao
 * @Class Name SyncDataBatchDao
 * @author 张永生
 * @Create In 2015年12月2日
 */
@CoreBatisDao
public interface SyncDataBatchDao extends CrudDao<SyncDataBatch> {

	/**
	 * 条件查询同步数据批次表
	 * 2015年12月7日
	 * By 张永生
	 * @param filter
	 * @return
	 */
	public List<SyncDataBatch> findByParams(Map<String,Object> filter);
}
