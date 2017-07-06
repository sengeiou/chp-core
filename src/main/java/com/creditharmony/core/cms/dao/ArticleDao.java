package com.creditharmony.core.cms.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.cms.entity.Article;
import com.creditharmony.core.cms.entity.Category;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 文章DAO接口
 * @author zhoushuhua
 * @version 2015-11-23
 */
@CoreBatisDao
public interface ArticleDao extends CrudDao<Article> {
	
	public List<Article> findByIdIn(String[] ids);
	
	public int updateHitsAddOne(String id);
	
	public int updateExpiredWeight(Article article);
	
	public int updateDelFlag(Article article);
	
	public List<Category> findStats(Category category);
	
	/**
	 * 分页查询
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<Article> findList(Map<String,Object> params, PageBounds pageBounds);
	public List<Article> findByBean(Article article);
	public List<Article> findListByMap(Map<String,Object> params, PageBounds pageBounds);
}
