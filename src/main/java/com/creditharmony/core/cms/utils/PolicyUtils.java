package com.creditharmony.core.cms.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.ui.Model;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cms.entity.ArticlePolicy;
import com.creditharmony.core.cms.entity.CategoryPolicy;
import com.creditharmony.core.cms.entity.CategoryPolicy;
import com.creditharmony.core.cms.entity.Link;
import com.creditharmony.core.cms.entity.Site;
import com.creditharmony.core.cms.service.ArticlePolicyManager;
import com.creditharmony.core.cms.service.CategoryPolicyManager;
import com.creditharmony.core.cms.service.LinkManager;
import com.creditharmony.core.cms.service.SiteManager;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.mapper.JsonMapper;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.redis.key.CacheKeys;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.service.UserManager;
import com.creditharmony.core.users.util.UserUtils;
import com.google.common.collect.Lists;

/**
 * 内容管理工具类
 * @Class Name CmsUtils
 * @author 张永生
 * @Create In 2016年1月7日
 */
public class PolicyUtils {
	
	private static SiteManager siteManager = SpringContextHolder.getBean(SiteManager.class);
	private static CategoryPolicyManager categoryPolicyManager = SpringContextHolder.getBean(CategoryPolicyManager.class);
	private static ArticlePolicyManager articlePolicyManager = SpringContextHolder.getBean(ArticlePolicyManager.class);
	private static LinkManager linkManager = SpringContextHolder.getBean(LinkManager.class);
    private static ServletContext context = SpringContextHolder.getBean(ServletContext.class);
    private static UserManager userManager = SpringContextHolder.getBean(UserManager.class);
	/**
	 * 获得站点列表
	 */
	public static List<Site> getSiteList(){
		@SuppressWarnings("unchecked")
		List<Site> siteList = (List<Site>)RedisUtils.getObject(CacheKeys.CMS_CACHE);
		if (siteList == null){
			Page<Site> page = new Page<Site>(1, 1);
			page = siteManager.findPage(page, new Site());
			siteList = page.getList();
			RedisUtils.saveObject(CacheKeys.CMS_CACHE, siteList);
		}
		return siteList;
	}
	
	/**
	 * 获得站点信息
	 * @param siteId 站点编号
	 */
	public static Site getSite(String siteId){
		String id = "1";
		if (StringUtils.isNotBlank(siteId)){
			id = siteId;
		}
		for (Site site : getSiteList()){
			if (site.getId().equals(id)){
				return site;
			}
		}
		return new Site(id);
	}
	
	/**
	 * 获得主导航列表
	 * @param siteId 站点编号
	 */
	public static List<CategoryPolicy> getMainNavPolicyList(String siteId){
		CategoryPolicy categoryPolicy = new CategoryPolicy();
		categoryPolicy.setSite(new Site(siteId));
		categoryPolicy.setParent(new CategoryPolicy("1"));
		categoryPolicy.setInMenu(Global.SHOW);
		Page<CategoryPolicy> page = new Page<CategoryPolicy>(1, -1);
		page = categoryPolicyManager.find(page, categoryPolicy);
		List<CategoryPolicy> mainNavList = page.getList();
		return mainNavList;
	}
	/**
	 * 获取栏目
	 * @param categoryPolicyId 栏目编号
	 * @return
	 */
	public static CategoryPolicy getCategoryPolicy(String categoryPolicyId){
		return categoryPolicyManager.get(categoryPolicyId);
	}
	
	/**
	 * 获得栏目列表
	 * @param siteId 站点编号
	 * @param parentId 分类父编号
	 * @param number 获取数目
	 * @param param  预留参数，例： key1:'value1', key2:'value2' ...
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public static List<CategoryPolicy> getCategoryPolicyList(String siteId, String parentId, int number, String param){
		Page<CategoryPolicy> page = new Page<CategoryPolicy>(1, number, -1);
		CategoryPolicy categoryPolicy = new CategoryPolicy();
		categoryPolicy.setSite(new Site(siteId));
		categoryPolicy.setParent(new CategoryPolicy(parentId));
		if (StringUtils.isNotBlank(param)){
			Map map = JsonMapper.getInstance().fromJson("{"+param+"}", Map.class);
		}
		page = categoryPolicyManager.find(page, categoryPolicy);
		return page.getList();
	}

	/**
	 * 获取栏目
	 * @param categoryPolicyIds 栏目编号
	 * @return
	 */
	public static List<CategoryPolicy> getCategoryPolicyListByIds(String categoryPolicyIds){
		return categoryPolicyManager.findByIds(categoryPolicyIds);
	}
	
	/**
	 * 获取文章
	 * @param articlePolicyId 文章编号
	 * @return
	 */
	public static ArticlePolicy getArticlePolicy(String articlePolicyId){
		return articlePolicyManager.get(articlePolicyId);
	}
	
	/**
	 * 获取文章列表
	 * @param siteId 站点编号
	 * @param categoryPolicyId 分类编号
	 * @param number 获取数目
	 * @param param  预留参数，例： key1:'value1', key2:'value2' ...
	 * 			posid	推荐位（1：首页焦点图；2：栏目页文章推荐；）
	 * 			image	文章图片（1：有图片的文章）
	 *          orderBy 排序字符串
	 * @return
	 * ${fnc:getArticlePolicyList(categoryPolicy.site.id, categoryPolicy.id, not empty pageSize?pageSize:8, 'posid:2, orderBy: \"hits desc\"')}"
	 */
	public static List<ArticlePolicy> getArticlePolicyList(String siteId, String categoryPolicyId, int number, String param){
		Page<ArticlePolicy> page = new Page<ArticlePolicy>(1, number, -1);
		CategoryPolicy categoryPolicy = new CategoryPolicy(categoryPolicyId, new Site(siteId));
		categoryPolicy.setParentIds(categoryPolicyId);
		ArticlePolicy articlePolicy = new ArticlePolicy(categoryPolicy);
		if (StringUtils.isNotBlank(param)){
			@SuppressWarnings({ "rawtypes" })
			Map map = JsonMapper.getInstance().fromJson("{"+param+"}", Map.class);
			if (new Integer(1).equals(map.get("posid")) || new Integer(2).equals(map.get("posid"))){
				articlePolicy.setPosid(String.valueOf(map.get("posid")));
			}
			if (new Integer(1).equals(map.get("image"))){
				articlePolicy.setImage(Global.YES);
			}
			if (StringUtils.isNotBlank((String)map.get("orderBy"))){
				page.setOrderBy((String)map.get("orderBy"));
			}
		}
		articlePolicy.setDelFlag(ArticlePolicy.DEL_FLAG_NORMAL);
		page = articlePolicyManager.findPage(page, articlePolicy, false);
		return page.getList();
	}
	
	public static List<ArticlePolicy> getArticlePolicyListByRole(String siteId, String categoryPolicyId, int number, String param){
		Page<ArticlePolicy> page = new Page<ArticlePolicy>(1, number, -1);
		CategoryPolicy categoryPolicy = new CategoryPolicy(categoryPolicyId, new Site(siteId));
		categoryPolicy.setParentIds(categoryPolicyId);
		ArticlePolicy articlePolicy = new ArticlePolicy(categoryPolicy);
		if (StringUtils.isNotBlank(param)){
			@SuppressWarnings({ "rawtypes" })
			Map map = JsonMapper.getInstance().fromJson("{"+param+"}", Map.class);
			if (new Integer(1).equals(map.get("posid")) || new Integer(2).equals(map.get("posid"))){
				articlePolicy.setPosid(String.valueOf(map.get("posid")));
			}
			if (new Integer(1).equals(map.get("image"))){
				articlePolicy.setImage(Global.YES);
			}
			if (StringUtils.isNotBlank((String)map.get("orderBy"))){
				page.setOrderBy((String)map.get("orderBy"));
			}
		}
		User userInfo = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		List<Map<String,String>> userRoleOrgList = userManager.findUserRoleOrgByUserId(userInfo.getId());
		articlePolicy.setDelFlag(ArticlePolicy.DEL_FLAG_NORMAL);
		page = articlePolicyManager.findPage(page, articlePolicy, userRoleOrgList);
		return page.getList();
	}
	/**
	 * 获取链接
	 * @param linkId 文章编号
	 * @return
	 */
	public static Link getLink(String linkId){
		return linkManager.get(linkId);
	}
	

    /**
     * 获得文章动态URL地址
   	 * @param articlePolicy
   	 * @return url
   	 */
    public static String getUrlDynamic(ArticlePolicy articlePolicy) {
        if(StringUtils.isNotBlank(articlePolicy.getLink())){
            return articlePolicy.getLink();
        }
        StringBuilder str = new StringBuilder();
        str.append(context.getContextPath()).append(Global.getFrontPath()+"/policy");
        str.append("/view-").append(articlePolicy.getCategoryPolicy().getId()).append("-").append(articlePolicy.getId()).append(Global.getUrlSuffix());
        str.append("?number="+Math.random());
        return str.toString();
    }

    /**
     * 获得栏目动态URL地址
   	 * @param categoryPolicy
   	 * @return url
   	 */
    public static String getUrlDynamic(CategoryPolicy categoryPolicy) {
        if(StringUtils.isNotBlank(categoryPolicy.getHref())){
            if(!categoryPolicy.getHref().contains("://")){
                return context.getContextPath()+Global.getFrontPath()+"/policy"+categoryPolicy.getHref();
            }else{
                return categoryPolicy.getHref();
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(context.getContextPath()).append(Global.getFrontPath()+"/policy");
        str.append("/list-").append(categoryPolicy.getId()).append(Global.getUrlSuffix());
        //str.append("?number="+Math.random());
        return str.toString();
    }

    /**
     * 从图片地址中去除ContextPath地址
   	 * @param src
   	 * @return src
   	 */
    public static String formatImageSrcToDb(String src) {
        if(StringUtils.isBlank(src)) return src;
        if(src.startsWith(context.getContextPath() + "/userfiles")){
            return src.substring(context.getContextPath().length());
        }else{
            return src;
        }
    }

    /**
     * 从图片地址中加入ContextPath地址
   	 * @param src
   	 * @return src
   	 */
    public static String formatImageSrcToWeb(String src) {
        if(StringUtils.isBlank(src)) return src;
        if(src.startsWith(context.getContextPath() + "/userfiles")){
            return src;
        }else{
            return context.getContextPath()+src;
        }
    }
    
    public static void addViewConfigAttribute(Model model, String param){
        if(StringUtils.isNotBlank(param)){
            @SuppressWarnings("rawtypes")
			Map map = JsonMapper.getInstance().fromJson(param, Map.class);
            if(map != null){
                for(Object o : map.keySet()){
                    model.addAttribute("viewConfig_"+o.toString(), map.get(o));
                }
            }
        }
    }

    public static void addViewConfigAttribute(Model model, CategoryPolicy categoryPolicy){
        List<CategoryPolicy> categoryPolicyList = Lists.newArrayList();
        CategoryPolicy c = categoryPolicy;
        boolean goon = true;
        do{
            if(c.getParent() == null || c.getParent().isRoot()){
                goon = false;
            }
            categoryPolicyList.add(c);
            c = c.getParent();
        }while(goon);
        Collections.reverse(categoryPolicyList);
        for(CategoryPolicy ca : categoryPolicyList){
        	addViewConfigAttribute(model, ca.getViewConfig());
        }
    }
    
    public static void addViewPolicyConfigAttribute(Model model, CategoryPolicy categoryPolicyPolicy){
        List<CategoryPolicy> categoryPolicyList = Lists.newArrayList();
        CategoryPolicy c = categoryPolicyPolicy;
        boolean goon = true;
        do{
            if(c.getParent() == null || c.getParent().isRoot()){
                goon = false;
            }
            categoryPolicyList.add(c);
            c = c.getParent();
        }while(goon);
        Collections.reverse(categoryPolicyList);
        for(CategoryPolicy ca : categoryPolicyList){
        	addViewConfigAttribute(model, ca.getViewConfig());
        }
    }
}