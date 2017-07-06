package com.creditharmony.core.threenet.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.threenet.entity.ThreeNetOrg;

/**
 * 三网组织结构dao
 * @Class Name ThreeNetOrgDao
 * @author 张永生
 * @Create In 2016年2月29日
 */
@CoreBatisDao
public interface ThreeNetOrgDao extends CrudDao<ThreeNetOrg> {

	/**
	 * 条件查询ThreeNetOrg对象
	 * 2016年2月29日
	 * By 张永生
	 * @param filter
	 * @return
	 */
	public List<ThreeNetOrg> findByParams(Map<String,Object> filter);
	
	/**
	 * 分页查询
	 * 2016年2月29日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<ThreeNetOrg> findByPage(Map<String,Object> params, PageBounds pageBounds);
	
}
