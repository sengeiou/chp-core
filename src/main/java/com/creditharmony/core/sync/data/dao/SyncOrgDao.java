package com.creditharmony.core.sync.data.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.sync.data.entity.SyncOrg;

/**
 * 同步组织结构dao
 * @Class Name SyncOrgDao
 * @author 张永生
 * @Create In 2015年12月2日
 */
@CoreBatisDao
public interface SyncOrgDao extends CrudDao<SyncOrg> {

	/**
	 * 条件查询SyncOrg对象
	 * 2015年12月7日
	 * By 张永生
	 * @param filter
	 * @return
	 */
	public List<SyncOrg> findByParams(Map<String,Object> filter);
	
	/**
	 * 分页查询
	 * 2015年12月8日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<SyncOrg> findByPage(Map<String,Object> params, PageBounds pageBounds);
	
}
