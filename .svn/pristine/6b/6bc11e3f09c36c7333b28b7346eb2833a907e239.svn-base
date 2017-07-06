package com.creditharmony.core.cms.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.cms.entity.CategoryPolicy;
import com.creditharmony.core.persistence.TreeDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
/**
 * 政策栏目Dao
 * @Class Name CategoryPolicyDao
 * @author 张岩
 * @Create In 2017年3月17日
 */
@CoreBatisDao
public interface CategoryPolicyDao extends TreeDao<CategoryPolicy> {
	
	public List<CategoryPolicy> findModule(CategoryPolicy category);
	
	public List<CategoryPolicy> findByModule(String module);
	
	public List<CategoryPolicy> findByParentId(String parentId, String isMenu);

	public List<CategoryPolicy> findByParentIdAndSiteId(CategoryPolicy entity);
	
	public List<Map<String, Object>> findStats(String sql);
	
}
