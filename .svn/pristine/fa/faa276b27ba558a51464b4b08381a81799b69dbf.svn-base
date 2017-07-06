package com.creditharmony.core.cms.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.cms.entity.Category;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.TreeDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 栏目DAO接口
 * @author zhoushuhua
 * @version 2015-11-23
 */
@CoreBatisDao
public interface CategoryDao extends TreeDao<Category> {
	
	public List<Category> findModule(Category category);
	
	public List<Category> findByModule(String module);
	
	public List<Category> findByParentId(String parentId, String isMenu);

	public List<Category> findByParentIdAndSiteId(Category entity);
	
	public List<Map<String, Object>> findStats(String sql);
	
	/**
	 * 分页查询
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<Category> findList(Map<String,Object> params, PageBounds pageBounds);
	
	/**
	 * 条件查询
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<Category> findList(Map<String,Object> params);
	
	public List<Category> findListByBean(Category entity);
	
	
}
