package com.creditharmony.core.threenet.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.threenet.entity.ThreeNetDataBatch;

/**
 * 同步三网数据批次dao
 * @Class Name ThreeNetDataBatchDao
 * @author 张永生
 * @Create In 2016年2月29日
 */
@CoreBatisDao
public interface ThreeNetDataBatchDao extends CrudDao<ThreeNetDataBatch> {

	/**
	 * 条件查询同步数据批次表
	 * 2015年12月7日
	 * By 张永生
	 * @param filter
	 * @return
	 */
	public List<ThreeNetDataBatch> findByParams(Map<String,Object> filter);
}
