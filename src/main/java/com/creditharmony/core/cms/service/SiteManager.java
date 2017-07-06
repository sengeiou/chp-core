package com.creditharmony.core.cms.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.core.cms.dao.SiteDao;
import com.creditharmony.core.cms.entity.Site;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
/**
 * 站点Service
 * @version 2015-10-15
 */
@Service
public class SiteManager extends CoreManager<SiteDao, Site> {

	public Page<Site> findPage(Page<Site> page, Site site) {
		site.getSqlMap().put("site", dataScopeFilter(site.getCurrentUser(), "o", "u"));
		return super.findPage(page, site);
	}

	@Transactional(readOnly = false)
	public void save(Site site) {
		if (site.getCopyright()!=null){
			site.setCopyright(StringEscapeUtils.unescapeHtml4(site.getCopyright()));
		}
		super.save(site);
		RedisUtils.remove("site_"+site.getId());
		RedisUtils.remove("siteList");
	}
	
	@Transactional(readOnly = false)
	public void delete(Site site, Boolean isRe) {
		//siteDao.updateDelFlag(id, isRe!=null&&isRe?Site.DEL_FLAG_NORMAL:Site.DEL_FLAG_DELETE);
		site.setDelFlag(isRe!=null&&isRe?Site.DEL_FLAG_NORMAL:Site.DEL_FLAG_DELETE);
		super.delete(site);
		//siteDao.delete(id);
		RedisUtils.remove("site_"+site.getId());
		RedisUtils.remove("siteList");
	}
	
}
