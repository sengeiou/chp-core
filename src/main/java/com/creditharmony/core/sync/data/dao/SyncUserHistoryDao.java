package com.creditharmony.core.sync.data.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncUserHistory;

/**
 * 同步用户历史dao
 * @Class Name SyncOrgHistoryDao
 * @author 张永生
 * @Create In 2015年12月2日
 */
@CoreBatisDao
public interface SyncUserHistoryDao extends CrudDao<SyncUserHistory> {

	/**
	 * 分页查询
	 * 2015年12月8日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<SyncUserHistory> findByPage(Map<String,Object> params, PageBounds pageBounds);
}
