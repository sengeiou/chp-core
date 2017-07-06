package com.creditharmony.core.cms.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.Global;
import com.creditharmony.core.cms.dao.CategoryPolicyDao;
import com.creditharmony.core.cms.entity.CategoryPolicy;
import com.creditharmony.core.cms.entity.Site;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.TreeManager;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.util.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 政策栏目Manager
 * @Class Name CategoryPolicyManager
 * @author 张岩
 * @Create In 2017年3月17日
 */
@Service
public class CategoryPolicyManager extends TreeManager<CategoryPolicyDao, CategoryPolicy> {

	public static final String CACHE_CATEGORY_LIST = "categoryPolicyList";
	
	private CategoryPolicy entity = new CategoryPolicy();
	
	public List<CategoryPolicy> findByUser(boolean isCurrentSite, String module){
		CategoryPolicy category = new CategoryPolicy();
			category.setOrg(new Org());
			category.setSite(new Site());
			category.setParent(new CategoryPolicy());
			List<CategoryPolicy> list = dao.findList(category);
			// 将没有父节点的节点，找到父节点
			Set<String> parentIdSet = Sets.newHashSet();
			for (CategoryPolicy e : list){
				if (e.getParent()!=null && StringUtils.isNotBlank(e.getParent().getId())){
					boolean isExistParent = false;
					for (CategoryPolicy e2 : list){
						if (e.getParent().getId().equals(e2.getId())){
							isExistParent = true;
							break;
						}
					}
					if (!isExistParent){
						parentIdSet.add(e.getParent().getId());
					}
				}
			}
			if (parentIdSet.size() > 0){
				//FIXME 暂且注释，用于测试
//				dc = dao.createDetachedCriteria();
//				dc.add(Restrictions.in("id", parentIdSet));
//				dc.add(Restrictions.eq("delFlag", Category.DEL_FLAG_NORMAL));
//				dc.addOrder(Order.asc("site.id")).addOrder(Order.asc("sort"));
//				list.addAll(0, dao.find(dc));
			}
		if (isCurrentSite){
			List<CategoryPolicy> categoryList = Lists.newArrayList(); 
			for (CategoryPolicy e : list){
				if (CategoryPolicy.isRoot(e.getId()) || (e.getSite()!=null && e.getSite().getId() !=null 
						&& e.getSite().getId().equals(Site.getCurrentSiteId()))){
					if (StringUtils.isNotEmpty(module)){
						if (module.equals(e.getModule()) || "".equals(e.getModule())){
							categoryList.add(e);
						}
					}else{
						categoryList.add(e);
					}
				}
			}
			return categoryList;
		}
		return list;
	}

	public List<CategoryPolicy> findByParentId(String parentId, String siteId){
		CategoryPolicy parent = new CategoryPolicy();
		parent.setId(parentId);
		entity.setParent(parent);
		Site site = new Site();
		site.setId(siteId);
		entity.setSite(site);
		return dao.findByParentIdAndSiteId(entity);
	}
	
	public Page<CategoryPolicy> find(Page<CategoryPolicy> page, CategoryPolicy category) {
		category.setPage(page);
		category.setInMenu(Global.SHOW);
		page.setList(dao.findModule(category));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(CategoryPolicy category) {
		category.setSite(new Site(Site.getCurrentSiteId()));
		if (StringUtils.isNotBlank(category.getViewConfig())){
            category.setViewConfig(StringEscapeUtils.unescapeHtml4(category.getViewConfig()));
        }
		super.save(category);
		UserUtils.removeCache(CACHE_CATEGORY_LIST);
		RedisUtils.remove("mainNavList_"+category.getSite().getId());
	}
	
	@Transactional(readOnly = false)
	public void delete(CategoryPolicy category) {
		super.delete(category);
		UserUtils.removeCache(CACHE_CATEGORY_LIST);
		RedisUtils.remove("mainNavList_"+category.getSite().getId());
	}
	
	/**
	 * 通过编号获取栏目列表
	 */
	public List<CategoryPolicy> findByIds(String ids) {
		List<CategoryPolicy> list = Lists.newArrayList();
		String[] idss = StringUtils.split(ids,",");
		if (idss.length>0){
//			List<Category> l = dao.findByIdIn(idss);
//			for (String id : idss){
//				for (Category e : l){
//					if (e.getId().equals(id)){
//						list.add(e);
//						break;
//					}
//				}
//			}
			for(String id : idss){
				CategoryPolicy e = dao.get(id);
				if(null != e){
					list.add(e);
				}
				//list.add(dao.get(id));
				
			}
		}
		return list;
	}
	
}
