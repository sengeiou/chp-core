package com.creditharmony.core.cms.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.cms.entity.Article;
import com.creditharmony.core.cms.entity.ArticlePolicy;
import com.creditharmony.core.cms.entity.CategoryPolicy;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;


@CoreBatisDao
public interface ArticlePolicyDao extends CrudDao<ArticlePolicy> {
	
	public List<ArticlePolicy> findByIdIn(String[] ids);
	
	public int updateHitsAddOne(String id);
	
	public int updateExpiredWeight(ArticlePolicy articlePolicy);
	
	public int updateDelFlag(ArticlePolicy articlePolicy);
	
	public List<CategoryPolicy> findStats(CategoryPolicy categoryPolicy);
	
	/**
	 * 分页查询
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<ArticlePolicy> findList(Map<String,Object> params, PageBounds pageBounds);
	public List<ArticlePolicy> findByBean(ArticlePolicy articlePolicy);
	public List<ArticlePolicy> findListByMap(Map<String,Object> params, PageBounds pageBounds);
	public List<ArticlePolicy> findListByMap(Map<String,Object> params);
}
