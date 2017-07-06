package com.creditharmony.core.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.Global;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cms.dao.ArticleDao;
import com.creditharmony.core.cms.dao.ArticleDataDao;
import com.creditharmony.core.cms.dao.CategoryDao;
import com.creditharmony.core.cms.dao.CmsPushDao;
import com.creditharmony.core.cms.entity.Article;
import com.creditharmony.core.cms.entity.ArticleData;
import com.creditharmony.core.cms.entity.Category;
import com.creditharmony.core.cms.entity.CmsPush;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.OrgDao;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.util.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 文章Manager
 * @Class Name ArticleManager
 * @author 张永生
 * @Create In 2015年11月24日
 */
@Service
public class ArticleManager extends CoreManager<ArticleDao, Article> {

	@Autowired
	private ArticleDataDao articleDataDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CmsPushDao cmsPushDao;
	@Autowired
	private OrgDao orgDao;
	@Value("${portalLink}")
	private String portalLink;
	@Value("${frontPath}")
	private String frontPath;
	
    @Transactional(readOnly = false)
	public Page<Article> findPage(Page<Article> page, Article article, boolean isDataScopeFilter) {
		// 更新过期的权重，间隔为“6”个小时
		Date updateExpiredWeightDate =  (Date)RedisUtils.getObject("updateExpiredWeightDate");
		if (updateExpiredWeightDate == null || (updateExpiredWeightDate != null 
				&& updateExpiredWeightDate.getTime() < new Date().getTime())){
			dao.updateExpiredWeight(article);
			RedisUtils.saveObject("updateExpiredWeightDate", DateUtils.addHours(new Date(), 6));
		}
        if (article.getCategory() != null
                && StringUtils.isNotBlank(article.getCategory().getId())
                && !Category.isRoot(article.getCategory().getId())) {
            Category category = categoryDao.get(article.getCategory().getId());
            if (category == null) {
                category = new Category();
            }
            category.setParentIds(category.getId());
            category.setSite(category.getSite());
            article.setCategory(category);
        } else {
            article.setCategory(new Category());
        }
		return super.findPage(page, article);
	}

    @Transactional(readOnly = false)
  	public Page<Article> findPage(Page<Article> page, Article article, List<String> orgIdList) {
  		// 更新过期的权重，间隔为“6”个小时
  		Date updateExpiredWeightDate =  (Date)RedisUtils.getObject("updateExpiredWeightDateByArticle");
  		if (updateExpiredWeightDate == null || (updateExpiredWeightDate != null 
  				&& updateExpiredWeightDate.getTime() < new Date().getTime())){
  			dao.updateExpiredWeight(article);
  			RedisUtils.saveObject("updateExpiredWeightDateByArticle", DateUtils.addHours(new Date(), 6));
  		}
  		Map<String, Object> filter = Maps.newHashMap();
          if (article.getCategory() != null
                  && StringUtils.isNotBlank(article.getCategory().getId())
                  && !Category.isRoot(article.getCategory().getId())) {
              Category category = categoryDao.get(article.getCategory().getId());
              if (category == null) {
                  category = new Category();
              }
              category.setParentIds(category.getId());
              category.setSite(category.getSite());
              article.setCategory(category);
              filter.put("categoryId", category.getId());
          } else {
              article.setCategory(new Category());
          }
          filter.put("posid", article.getPosid());
          filter.put("image", article.getImage());
  		filter.put("delFlag", DeleteFlagType.NORMAL);
  		filter.put("orgIdList", orgIdList);
  		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
  		PageList<Article> pageList = (PageList<Article>) dao.findListByMap(filter, pageBounds);
  		PageUtil.convertPage(pageList, page);
  		return page;
  	}
    
	@Transactional(readOnly = false)
	public void save(Article article) {
		if (article.getArticleData().getContent()!=null){
			article.getArticleData().setContent(StringEscapeUtils.unescapeHtml4(
					article.getArticleData().getContent()));
		}
		// 如果没有审核权限，则将当前内容改为待审核状态
//		if (!UserUtils.getSubject().isPermitted("cms:article:audit")){
//			article.setDelFlag(Article.DEL_FLAG_AUDIT);
//		}
		// 如果栏目不需要审核，则将该内容设为发布状态
		if (article.getCategory()!=null&&StringUtils.isNotBlank(article.getCategory().getId())){
			Category category = categoryDao.get(article.getCategory().getId());
			article.getCategory().setOrg(category.getOrg());
			if (!Global.YES.equals(category.getIsAudit())&&!Article.DEL_FLAG_DELETE.equals(article.getDelFlag())){
				article.setDelFlag(Article.DEL_FLAG_NORMAL);
			}
		}
		cmsPushDao.findAll();
		article.setModifyBy(UserUtils.getUser().getId());
		article.setModifyTime(new Date());
        if (StringUtils.isNotBlank(article.getViewConfig())){
            article.setViewConfig(StringEscapeUtils.unescapeHtml4(article.getViewConfig()));
        }
        
        ArticleData articleData = new ArticleData();;
		if (StringUtils.isBlank(article.getId())){
			article.preInsert();
			articleData = article.getArticleData();
			articleData.setId(article.getId());
			dao.insert(article);
			articleDataDao.insert(articleData);
		}else{
			article.preUpdate();
			articleData = article.getArticleData();
			articleData.setId(article.getId());
			dao.update(article);
			articleDataDao.update(article.getArticleData());
		}
		if("1".equals(article.getPushFlag())){
			if(article.getVerTime()==null){
				Org o=orgDao.get(article.getCategory().getOrg().getId());
				CmsPush p=new CmsPush();
				p.setArticleId(article.getId());
				p.setChannel("loan");	
				p.setUrl(portalLink+frontPath+"/view-"+article.getCategory().getId()+"-"+article.getId()+".html");//http://portal.uat.creditharmony.cn:8224/portal/f/view-0a671e0606cd49b3860953fe0a3c4c1b-57137f09d001450583ae5b7fa7277c6a.html?ssousr=93000081
				p.setParentIds(o.getParentIds()+o.getId()+",");
				p.preInsert();
				cmsPushDao.insertBatch(p);
			}
		}	
		
	}
	
	@Transactional(readOnly = false)
	public void delete(Article article, Boolean isRe) {
		article.setDelFlag(isRe != null && isRe ? Article.DEL_FLAG_NORMAL : Article.DEL_FLAG_DELETE);
		dao.updateDelFlag(article);
	}
	
	/**
	 * 通过编号获取内容标题
	 * @return new Object[]{栏目Id,文章Id,文章标题}
	 */
	public List<Object[]> findByIds(String ids) {
		if(ids == null){
			return new ArrayList<Object[]>();
		}
		List<Object[]> list = Lists.newArrayList();
		String[] idss = StringUtils.split(ids,",");
		Article e = null;
		for(int i=0;(idss.length-i)>0;i++){
			e = dao.get(idss[i]);
			list.add(new Object[]{e.getCategory().getId(),e.getId(),StringUtils.abbr(e.getTitle(),50)});
		}
		return list;
	}
	
	/**
	 * 点击数加一
	 */
	@Transactional(readOnly = false)
	public void updateHitsAddOne(String id) {
		dao.updateHitsAddOne(id);
	}
	
	/**
	 * 更新索引
	 */
	public void createIndex(){
		//dao.createIndex();
	}
	
	/**
	 * 全文检索
	 */
	//FIXME 暂不提供检索功能
	public Page<Article> search(Page<Article> page, String q,
			String categoryId, String beginDate, String endDate) {
		
		// 设置查询条件
//		BooleanQuery query = dao.getFullTextQuery(q, "title","keywords","description","articleData.content");
//		
//		// 设置过滤条件
//		List<BooleanClause> bcList = Lists.newArrayList();
//
//		bcList.add(new BooleanClause(new TermQuery(new Term(Article.FIELD_DEL_FLAG, Article.DEL_FLAG_NORMAL)), Occur.MUST));
//		if (StringUtils.isNotBlank(categoryId)){
//			bcList.add(new BooleanClause(new TermQuery(new Term("category.ids", categoryId)), Occur.MUST));
//		}
//		
//		if (StringUtils.isNotBlank(beginDate) && StringUtils.isNotBlank(endDate)) {   
//			bcList.add(new BooleanClause(new TermRangeQuery("modifyTime", beginDate.replaceAll("-", ""),
//					endDate.replaceAll("-", ""), true, true), Occur.MUST));
//		}   
		
		//BooleanQuery queryFilter = dao.getFullTextQuery((BooleanClause[])bcList.toArray(new BooleanClause[bcList.size()]));
		// 设置排序（默认相识度排序）
		//FIXME 暂时不提供lucene检索
		//Sort sort = null;//new Sort(new SortField("modifyTime", SortField.DOC, true));
		// 全文检索
		//dao.search(page, query, queryFilter, sort);
		// 关键字高亮
		//dao.keywordsHighlight(query, page.getList(), 30, "title");
		//dao.keywordsHighlight(query, page.getList(), 130, "description","articleData.content");
		return page;
	}
	
}
