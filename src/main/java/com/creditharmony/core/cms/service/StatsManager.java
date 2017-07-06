package com.creditharmony.core.cms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.core.cms.dao.ArticleDao;
import com.creditharmony.core.cms.entity.Category;
import com.creditharmony.core.cms.entity.Site;
import com.creditharmony.core.service.BaseManager;
import com.creditharmony.core.users.entity.Org;

/**
 * 统计Manager
 * @Class Name StatsManager
 * @author 张永生
 * @Create In 2015年11月24日
 */
@Service
public class StatsManager extends BaseManager {

	@Autowired
	private ArticleDao articleDao;
	
	public List<Category> article(Map<String, Object> paramMap) {
		Category category = new Category();
		
		Site site = new Site();
		site.setId(Site.getCurrentSiteId());
		category.setSite(site);
		
		Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
		if (beginDate == null){
			beginDate = DateUtils.setDays(new Date(), 1);
			paramMap.put("beginDate", DateUtils.formatDate(beginDate, "yyyy-MM-dd"));
		}
		category.setBeginDate(beginDate);
		Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
		if (endDate == null){
			endDate = DateUtils.addDays(DateUtils.addMonths(beginDate, 1), -1);
			paramMap.put("endDate", DateUtils.formatDate(endDate, "yyyy-MM-dd"));
		}
		category.setEndDate(endDate);
		
		String categoryId = (String)paramMap.get("categoryId");
		if (categoryId != null && !("".equals(categoryId))){
			category.setId(categoryId);
			category.setParentIds(categoryId);
		}
		
		String orgId = (String)(paramMap.get("orgId"));
		Org org = new Org();
		if (orgId != null && !("".equals(orgId))){
			org.setId(orgId);
			category.setOrg(org);
		}else{
			category.setOrg(org);
		}
		List<Category> list = articleDao.findStats(category);
		return list;
	}

}
