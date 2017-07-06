package com.creditharmony.core.cms.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creditharmony.common.util.ObjectHelper;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cache.OrgCache;
import com.creditharmony.core.cms.entity.Article;
import com.creditharmony.core.cms.entity.Category;
import com.creditharmony.core.cms.entity.Comment;
import com.creditharmony.core.cms.entity.Link;
import com.creditharmony.core.cms.entity.Site;
import com.creditharmony.core.cms.service.ArticleDataManager;
import com.creditharmony.core.cms.service.ArticleManager;
import com.creditharmony.core.cms.service.CategoryManager;
import com.creditharmony.core.cms.service.CommentManager;
import com.creditharmony.core.cms.service.LinkManager;
import com.creditharmony.core.cms.service.SiteManager;
import com.creditharmony.core.cms.type.ArticleModule;
import com.creditharmony.core.cms.type.ShowModes;
import com.creditharmony.core.cms.utils.CmsUtils;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.servlet.ValidateCodeServlet;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.service.UserManager;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.core.web.BaseController;
import com.creditharmony.core.cms.utils.StringSplitUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 网站Controller
 * @Class Name FrontController
 * @author 张永生
 * @Create In 2016年1月7日
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class FrontController extends BaseController{
	
	@Autowired
	private ArticleManager articleManager;
	@Autowired
	private ArticleDataManager articleDataManager;
	@Autowired
	private LinkManager linkManager;
	@Autowired
	private CommentManager commentManager;
	@Autowired
	private CategoryManager categoryManager;
	@Autowired
	private SiteManager siteManager;
	@Autowired
	private UserManager userManager;
	
	/**
	 * 网站首页
	 */
	@RequestMapping
	public String index(Model model) {
		Site site = CmsUtils.getSite(Site.defaultSiteId());
		model.addAttribute("site", site);
		model.addAttribute("isIndex", true);
		return "modules/cms/front/themes/" + site.getTheme() + "/frontIndex";
	}
	
	/**
	 * 网站首页
	 */
	@RequestMapping(value = "index-{siteId}${urlSuffix}")
	public String index(@PathVariable String siteId, Model model) {
		if (siteId.equals("1")){
			return "redirect:"+Global.getFrontPath();
		}
		Site site = CmsUtils.getSite(siteId);
		// 子站有独立页面，则显示独立页面
		if (StringUtils.isNotBlank(site.getCustomIndexView())){
			model.addAttribute("site", site);
			model.addAttribute("isIndex", true);
			return "modules/cms/front/themes/" + site.getTheme()
					+ "/frontIndex" + site.getCustomIndexView();
		}
		// 否则显示子站第一个栏目
		List<Category> mainNavList = CmsUtils.getMainNavList(siteId);
		if (mainNavList.size() > 0){
			String firstCategoryId = CmsUtils.getMainNavList(siteId).get(0).getId();
			return "redirect:" + Global.getFrontPath() + "/list-" + firstCategoryId + Global.getUrlSuffix();
		}else{
			model.addAttribute("site", site);
			return "modules/cms/front/themes/"+site.getTheme()+"/frontListCategory";
		}
	}
	
	/**
	 * 显示内容
	 */
	@RequestMapping(value = "view-{categoryId}-{contentId}${urlSuffix}")
	public String view(@PathVariable String categoryId, @PathVariable String contentId, Model model) {
		Category category = categoryManager.get(categoryId);
		if (category==null){
			Site site = CmsUtils.getSite(Site.defaultSiteId());
			model.addAttribute("site", site);
			return "error/404";
		}
		model.addAttribute("site", category.getSite());
		if (ArticleModule.ARTICLE.equals(category.getModule())){
			// 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
			List<Category> categoryList = Lists.newArrayList();
			if (category.getParent().getId().equals("1")){
				categoryList.add(category);
			}else{
				categoryList = categoryManager.findByParentId(category.getParent().getId(), category.getSite().getId());
			}
			// 获取文章内容
			Article article = articleManager.get(contentId);
			if (article==null || !Article.DEL_FLAG_NORMAL.equals(article.getDelFlag())){
				return "error/404";
			}
			// 文章阅读次数+1
			articleManager.updateHitsAddOne(contentId);
			// 获取推荐文章列表
			List<Object[]> relationList = articleManager
					.findByIds(articleDataManager.get(article.getId()).getRelation());
			// 将数据传递到视图
			model.addAttribute("category", categoryManager.get(article.getCategory().getId()));
			model.addAttribute("categoryList", categoryList);
			article.setArticleData(articleDataManager.get(article.getId()));
			model.addAttribute("article", article);
			model.addAttribute("relationList", relationList); 
            CmsUtils.addViewConfigAttribute(model, article.getCategory());
            CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
            Site site = siteManager.get(category.getSite().getId());
            model.addAttribute("site", site);
			return "modules/cms/front/themes/" + site.getTheme() + "/" + getTemplate(article);
		}
		return "error/404";
	}
	
	/**
	 * 内容列表
	 */
	@RequestMapping(value = "list-{categoryId}${urlSuffix}")
	public String list(
			@PathVariable String categoryId,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "15") Integer pageSize,
			Model model) {
		Category category = categoryManager.get(categoryId);
		if (category == null) {
			Site site = CmsUtils.getSite(Site.defaultSiteId());
			model.addAttribute("site", site);
			return "error/404";
		}
		Site site = siteManager.get(category.getSite().getId());
		model.addAttribute("site", site);
		// 2：简介类栏目，栏目第一条内容
		if (ShowModes.FIRST_CONTENT.equals(category.getShowModes())
				&& ArticleModule.ARTICLE.equals(category.getModule())) {
			// 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
			List<Category> categoryList = Lists.newArrayList();
			if (category.getParent().getId().equals("1")){
				categoryList.add(category);
			}else{
				categoryList = categoryManager.findByParentId(category
						.getParent().getId(), category.getSite().getId());
			}
			model.addAttribute("category", category);
			model.addAttribute("categoryList", categoryList);
			// 获取文章内容
			Page<Article> page = new Page<Article>(1, 1, -1);
			Article article = new Article(category);
			page = articleManager.findPage(page, article, false);
			if (page.getList().size()>0){
				article = page.getList().get(0);
				article.setArticleData(articleDataManager.get(article.getId()));
				articleManager.updateHitsAddOne(article.getId());
			}
			model.addAttribute("article", article);
            CmsUtils.addViewConfigAttribute(model, category);
            CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
			return "modules/cms/front/themes/" + site.getTheme() + "/" + getTemplate(article);
		}else{
			List<Category> categoryList = categoryManager.findByParentId(
					category.getId(), category.getSite().getId());
			// 展现方式为1 、无子栏目或公共模型，显示栏目内容列表
			if (ShowModes.FIRST_CATEGORY_LIST.equals(category.getShowModes()) || categoryList.size() == 0) {
				// 有子栏目并展现方式为1，则获取第一个子栏目；无子栏目，则获取同级分类列表。
				if (categoryList.size() > 0) {
					category = categoryList.get(0);
				} else {
					// 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
					if (category.getParent().getId().equals("1")) {
						categoryList.add(category);
					} else {
						categoryList = categoryManager.findByParentId(category
								.getParent().getId(), category.getSite()
								.getId());
					}
				}
				model.addAttribute("category", category);
				model.addAttribute("categoryList", categoryList);
				// 获取内容列表
				if (ArticleModule.ARTICLE.equals(category.getModule())){
					Page<Article> page = new Page<Article>(pageNo, pageSize);
					page = articleManager.findPage(page, new Article(category), false);
					model.addAttribute("page", page);
					// 如果第一个子栏目为简介类栏目，则获取该栏目第一篇文章
					if (ShowModes.FIRST_CONTENT.equals(category.getShowModes())){
						Article article = new Article(category);
						if (page.getList().size()>0){
							article = page.getList().get(0);
							article.setArticleData(articleDataManager.get(article.getId()));
							articleManager.updateHitsAddOne(article.getId());
						}
						model.addAttribute("article", article);
			            CmsUtils.addViewConfigAttribute(model, category);
			            CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
						return "modules/cms/front/themes/"+site.getTheme()+"/"+getTemplate(article);
					}
				}else if (ArticleModule.LINK.equals(category.getModule())){
					Page<Link> page = new Page<Link>(1, -1);
					page = linkManager.findPage(page, new Link(category), false);
					model.addAttribute("page", page);
				}
				String view = "/frontList";
				if (StringUtils.isNotBlank(category.getCustomListView())){
					view = "/"+category.getCustomListView();
				}
	            CmsUtils.addViewConfigAttribute(model, category);
				site = siteManager.get(category.getSite().getId());
				return "modules/cms/front/themes/"
						+ siteManager.get(category.getSite().getId()).getTheme() + view;
			} else{  // 有子栏目：显示子栏目列表
				model.addAttribute("category", category);
				model.addAttribute("categoryList", categoryList);
				String view = "/frontListCategory";
				if (StringUtils.isNotBlank(category.getCustomListView())){
					view = "/"+category.getCustomListView();
				}
	            CmsUtils.addViewConfigAttribute(model, category);
				return "modules/cms/front/themes/"+site.getTheme()+view;
			}
		}
	}

	/**
	 * 内容列表
	 */
	@RequestMapping(value = "listByUser-{categoryId}${urlSuffix}")
	public String listByUser(
			@PathVariable String categoryId,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "15") Integer pageSize,
			Model model) {
		User userInfo = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		Category category = categoryManager.get(categoryId);
		if (category == null) {
			Site site = CmsUtils.getSite(Site.defaultSiteId());
			model.addAttribute("site", site);
			return "error/404";
		}
		Site site = siteManager.get(category.getSite().getId());
		model.addAttribute("site", site);
		// 2：简介类栏目，栏目第一条内容
		if (ShowModes.FIRST_CONTENT.equals(category.getShowModes())
				&& ArticleModule.ARTICLE.equals(category.getModule())) {
			// 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
			List<Category> categoryList = Lists.newArrayList();
			if (category.getParent().getId().equals("1")){
				categoryList.add(category);
			}else{
				categoryList = categoryManager.findByParentId(category
						.getParent().getId(), category.getSite().getId());
			}
			model.addAttribute("category", category);
			model.addAttribute("categoryList", categoryList);
			// 获取文章内容
			Page<Article> page = new Page<Article>(1, 1, -1);
			Article article = new Article(category);
			if(null != userInfo){
				List<Map<String,String>> userRoleOrgList = userManager.findUserRoleOrgByUserId(userInfo.getId());
				Set<String> orgIds = Sets.newHashSet();
				for(Map<String,String> map:userRoleOrgList){
					String orgId = map.get("orgId");
					orgIds.add(map.get("orgId"));
					Org orgItem = OrgCache.getInstance().get(orgId);
					String parentIds = orgItem != null ? orgItem.getParentIds() : "";
					String[] parentIdsArray = StringSplitUtil.split(parentIds);
					if(ObjectHelper.isNotEmpty(parentIdsArray)){
						for(String pIdItem : parentIdsArray){
							orgIds.add(pIdItem);
						}
					}
				}
				page = articleManager.findPage(page, article, new ArrayList<String>(orgIds));
			}
			if (page.getList().size()>0){
				article = page.getList().get(0);
				article.setArticleData(articleDataManager.get(article.getId()));
				articleManager.updateHitsAddOne(article.getId());
			}
			model.addAttribute("article", article);
            CmsUtils.addViewConfigAttribute(model, category);
            CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
			return "modules/cms/front/themes/" + site.getTheme() + "/" + getTemplate(article);
		}else{
			List<Category> categoryList = categoryManager.findByParentId(
					category.getId(), category.getSite().getId());
			// 展现方式为1 、无子栏目或公共模型，显示栏目内容列表
			if (ShowModes.FIRST_CATEGORY_LIST.equals(category.getShowModes()) || categoryList.size() == 0) {
				// 有子栏目并展现方式为1，则获取第一个子栏目；无子栏目，则获取同级分类列表。
				if (categoryList.size() > 0) {
					category = categoryList.get(0);
				} else {
					// 如果没有子栏目，并父节点为跟节点的，栏目列表为当前栏目。
					if (category.getParent().getId().equals("1")) {
						categoryList.add(category);
					} else {
						categoryList = categoryManager.findByParentId(category
								.getParent().getId(), category.getSite()
								.getId());
					}
				}
				model.addAttribute("category", category);
				model.addAttribute("categoryList", categoryList);
				// 获取内容列表
				if (ArticleModule.ARTICLE.equals(category.getModule())){
					if(userInfo!=null){
						List<Map<String,String>> userRoleOrgList = userManager.findUserRoleOrgByUserId(userInfo.getId());
						Set<String> orgIds = Sets.newHashSet();
						for(Map<String,String> map:userRoleOrgList){
							String orgId = map.get("orgId");
							orgIds.add(map.get("orgId"));
							Org orgItem = OrgCache.getInstance().get(orgId);
							String parentIds = orgItem != null ? orgItem.getParentIds() : "";
							String[] parentIdsArray = StringSplitUtil.split(parentIds);
							if(ObjectHelper.isNotEmpty(parentIdsArray)){
								for(String pIdItem : parentIdsArray){
									orgIds.add(pIdItem);
								}
							}
						}
						Page<Article> page = new Page<Article>(pageNo, pageSize);
						page = articleManager.findPage(page, new Article(category), new ArrayList<String>(orgIds));
						model.addAttribute("page", page);
						// 如果第一个子栏目为简介类栏目，则获取该栏目第一篇文章
						if (ShowModes.FIRST_CONTENT.equals(category.getShowModes())){
							Article article = new Article(category);
							if (page.getList().size()>0){
								article = page.getList().get(0);
								article.setArticleData(articleDataManager.get(article.getId()));
								articleManager.updateHitsAddOne(article.getId());
							}
							model.addAttribute("article", article);
							CmsUtils.addViewConfigAttribute(model, category);
							CmsUtils.addViewConfigAttribute(model, article.getViewConfig());
							return "modules/cms/front/themes/"+site.getTheme()+"/"+getTemplate(article);
						}
					}
				}else if (ArticleModule.LINK.equals(category.getModule())){
					Page<Link> page = new Page<Link>(1, -1);
					page = linkManager.findPage(page, new Link(category), false);
					model.addAttribute("page", page);
				}
				String view = "/frontList";
				if (StringUtils.isNotBlank(category.getCustomListView())){
					view = "/"+category.getCustomListView();
				}
	            CmsUtils.addViewConfigAttribute(model, category);
				site = siteManager.get(category.getSite().getId());
				return "modules/cms/front/themes/"
						+ siteManager.get(category.getSite().getId()).getTheme() + view;
			} else{ // 有子栏目：显示子栏目列表
				model.addAttribute("category", category);
				model.addAttribute("categoryList", categoryList);
				String view = "/frontListCategory";
				if (StringUtils.isNotBlank(category.getCustomListView())){
					view = "/"+category.getCustomListView();
				}
	            CmsUtils.addViewConfigAttribute(model, category);
				return "modules/cms/front/themes/"+site.getTheme()+view;
			}
		}
	}

	
	/**
	 * 内容列表（通过url自定义视图）
	 */
	@RequestMapping(value = "listc-{categoryId}-{customView}${urlSuffix}")
	public String listCustom(
			@PathVariable String categoryId,
			@PathVariable String customView,
			@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "15") Integer pageSize,
			Model model) {
		Category category = categoryManager.get(categoryId);
		if (category==null){
			Site site = CmsUtils.getSite(Site.defaultSiteId());
			model.addAttribute("site", site);
			return "error/404";
		}
		Site site = siteManager.get(category.getSite().getId());
		model.addAttribute("site", site);
		List<Category> categoryList = categoryManager.findByParentId(category.getId(), category.getSite().getId());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryList);
        CmsUtils.addViewConfigAttribute(model, category);
		return "modules/cms/front/themes/" + site.getTheme() + "/frontListCategory" + customView;
	}
	
	/**
	 * 内容评论
	 */
	@RequestMapping(value = "comment", method=RequestMethod.GET)
	public String comment(String theme, Comment comment,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<Comment> page = new Page<Comment>(request, response);
		Comment c = new Comment();
		c.setCategory(comment.getCategory());
		c.setContentId(comment.getContentId());
		c.setDelFlag(Comment.DEL_FLAG_NORMAL);
		page = commentManager.findPage(page, c);
		model.addAttribute("page", page);
		model.addAttribute("comment", comment);
		return "modules/cms/front/themes/" + theme + "/frontComment";
	}
	
	/**
	 * 内容评论保存
	 */
	@ResponseBody
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	public String commentSave(Comment comment, String validateCode,
			@RequestParam(required = false) String replyId,
			HttpServletRequest request) {
		if (StringUtils.isNotBlank(validateCode)){
			if (ValidateCodeServlet.validate(request, validateCode)){
				if (StringUtils.isNotBlank(replyId)){
					Comment replyComment = commentManager.get(replyId);
					if (replyComment != null){
						comment.setContent("<div class=\"reply\">"+replyComment.getName()+":<br/>"
								+replyComment.getContent()+"</div>"+comment.getContent());
					}
				}
				comment.setIp(request.getRemoteAddr());
				comment.setCreateTime(new Date());
				comment.setDelFlag(Comment.DEL_FLAG_AUDIT);
				commentManager.save(comment);
				return "{result:1, message:'提交成功。'}";
			}else{
				return "{result:2, message:'验证码不正确。'}";
			}
		}else{
			return "{result:2, message:'验证码不能为空。'}";
		}
	}

    private String getTemplate(Article article){
        if(StringUtils.isBlank(article.getCustomContentView())){
            String view = null;
            Category category = article.getCategory();
            boolean isContinue = true;
			do {
				if (StringUtils.isNotBlank(category.getCustomContentView())) {
					view = category.getCustomContentView();
					isContinue = false;
				} else if (category.getParent() == null || category.getParent().isRoot()) {
					isContinue = false;
				} else {
					category = category.getParent();
				}
			} while (isContinue);
            return StringUtils.isBlank(view) ? Article.DEFAULT_TEMPLATE : view;
        }else{
            return article.getCustomContentView();
        }
    }
	
	/**
	 * 站点地图
	 */
	@RequestMapping(value = "map-{siteId}${urlSuffix}")
	public String map(@PathVariable String siteId, Model model) {
		Site site = CmsUtils.getSite(siteId != null ? siteId : Site
				.defaultSiteId());
		model.addAttribute("site", site);
		return "modules/cms/front/themes/" + site.getTheme() + "/frontMap";
	}
}
