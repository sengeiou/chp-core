package com.creditharmony.core.common.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.CookieUtils;
import com.creditharmony.common.util.IdGen;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.common.type.BooleanType;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.log.service.LoginLogManager;
import com.creditharmony.core.mapper.JsonMapper;
import com.creditharmony.core.security.Principal;
import com.creditharmony.core.security.custom.CustomFormAuthenticationFilter;
import com.creditharmony.core.security.shiro.session.CustomShiroSessionDAO;
import com.creditharmony.core.security.util.PortalPropertiesUtil;
import com.creditharmony.core.servlet.ValidateCodeServlet;
import com.creditharmony.core.users.dao.MenuDao;
import com.creditharmony.core.users.entity.Menu;
import com.creditharmony.core.users.entity.OnOff;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.service.OnOffManager;
import com.creditharmony.core.users.service.OrgManager;
import com.creditharmony.core.users.service.UserManager;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.core.web.BaseController;
import com.google.common.collect.Maps;

/**
 * 登录控制器
 * @Class Name LoginController
 * @author 张永生
 * @Create In 2016年1月7日
 */
@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private CustomShiroSessionDAO sessionDAO;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private OrgManager orgManager;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private LoginLogManager loginLogManger;
	@Autowired
	private OnOffManager onOffManager;
	
	/**
	 * 管理登录
	 */
	@RequestMapping(value = "${adminPath}/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		Principal principal = UserUtils.getPrincipal();
		// 如果已登录，再次访问主页，则退出原账号。
		if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
			CookieUtils.setCookie(response, "LOGINED", "false");
		}
		// 如果已经登录，则跳转到管理首页
		if(principal != null && !principal.isMobileLogin()){
			return "redirect:" + adminPath;
		}

		return "modules/sys/sysLogin";
	}

	/**
	 * 登录失败，真正登录的POST请求由Filter完成
	 */
	@RequestMapping(value = "${adminPath}/login", method = RequestMethod.POST)
	public String loginFail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Principal principal = UserUtils.getPrincipal();
		// 如果已经登录，则跳转到管理首页
		if(principal != null){
			return "redirect:" + adminPath;
		}
		String username = WebUtils.getCleanParam(request, CustomFormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
		boolean rememberMe = WebUtils.isTrue(request, CustomFormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
		boolean mobile = WebUtils.isTrue(request, CustomFormAuthenticationFilter.DEFAULT_MOBILE_PARAM);
		String exception = (String)request.getAttribute(CustomFormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String message = (String)request.getAttribute(CustomFormAuthenticationFilter.DEFAULT_MESSAGE_PARAM);
		
		if (StringUtils.isBlank(message) || StringUtils.equals(message, "null")){
			message = "用户或密码错误, 请重试.";
		}
		model.addAttribute(CustomFormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		model.addAttribute(CustomFormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM, rememberMe);
		model.addAttribute(CustomFormAuthenticationFilter.DEFAULT_MOBILE_PARAM, mobile);
		model.addAttribute(CustomFormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, exception);
		model.addAttribute(CustomFormAuthenticationFilter.DEFAULT_MESSAGE_PARAM, message);
		
		if (logger.isDebugEnabled()){
			logger.debug("login fail, message: {}, exception: {}", message, exception);
		}
		// 非授权异常，登录失败，验证码加1。
		if (!UnauthorizedException.class.getName().equals(exception)){
			model.addAttribute("isValidateCodeLogin", isValidateCodeLogin(username, true, false));
		}
		// 验证失败清空验证码
		request.getSession().setAttribute(ValidateCodeServlet.VALIDATE_CODE, IdGen.uuid());
		// 如果是手机登录，则返回JSON字符串
		if (mobile){
	        return renderString(response, model);
		}
		return "modules/sys/sysLogin";
	}
	
	@RequestMapping(value = "${adminPath}/syslogin")
	public String syslogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/sys/sysLogin";
	}

	/**
	 * 登录成功，进入管理首页
	 * @throws IOException 
	 */
	@RequestMapping(value = "${adminPath}")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		
		//portal直接进入业务系统待办列表地址
		String showmenuid = request.getParameter("menuId");
		if(!StringUtils.isEmpty(showmenuid)){
			Menu menu = menuDao.get(showmenuid);
			if(menu != null){
				model.addAttribute("menuUrl", menu.getHref());
				model.addAttribute("menuName", menu.getName());
			}
		}
		model.addAttribute("menuId", showmenuid);
		
		Principal principal = UserUtils.getPrincipal();
		//如果principal为null，则刷新当前链接，防止portal中点击业务菜单sso进入业务系统时内部错误
		if(principal == null){
			String url = adminPath;
			if(!StringUtils.isEmpty(showmenuid)){
				url = url + "?menuId=" + showmenuid;
			}
			String ssousr = request.getParameter("ssousr");
			if(!StringUtils.isEmpty(ssousr)){
				if(!StringUtils.isEmpty(showmenuid)){
					url = url + "&ssousr=" + ssousr;
				}else{
					url = url + "?ssousr=" + ssousr;
				}
			}
			return "redirect:" + url;
		}
		
		User user = userManager.get(principal.getId());
		//用户密码为初始密码则让用户修改密码
		if(PortalPropertiesUtil.getInitialPasswordResetEnable()){
			if (user != null) {
				Object obj = UserUtils.getSession().getAttribute("uptpwd_password");
				String pass = obj == null?"":String.valueOf(obj);
				if (StringUtils.isEmpty(user.getPassword())
						|| user.getPassword().equals(pass)) {
					logger.debug("密码为初始密码，需重新修改密码！");
					response.sendRedirect(request.getContextPath() + "/uptpwd.jsp");
				}
			}
		}
		
		// 登录成功后，验证码计算器清零
		isValidateCodeLogin(principal.getLoginName(), false, true);
		// 如果已登录，再次访问主页，则退出原账号。
		if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
			String logined = CookieUtils.getCookie(request, "LOGINED");
			if (StringUtils.isBlank(logined) || "false".equals(logined)){
				CookieUtils.setCookie(response, "LOGINED", "true");
			}else if (StringUtils.equals(logined, "true")){
				UserUtils.getSubject().logout();
				return "redirect:" + adminPath + "/login";
			}
		}
		// 如果是手机登录，则返回JSON字符串
		if (principal.isMobileLogin()){
			if (request.getParameter("login") != null){
				return renderString(response, principal);
			}
			if (request.getParameter("index") != null){
				return "modules/sys/sysIndex";
			}
			return "redirect:" + adminPath + "/login";
		}
		String orgId = request.getParameter("orgId");
		if(null != orgId && !"".equals(orgId)){
			User userInfo = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
			userInfo.setDepartment(orgManager.get(orgId));
			
			String departmentId1 = UserUtils.getUser().getDepartment().getId();
			logger.info("world 切换前departmentId："+departmentId1);
			
			UserUtils.getSession().setAttribute(SystemConfigConstant.SESSION_USER_INFO, userInfo);
			
			String departmentId2 = UserUtils.getUser().getDepartment().getId();
			logger.info("world 切换后departmentId："+departmentId2);
		}else{
			orgId = user!=null?user.getDepartment().getId():"";
		}
		model.addAttribute("orgId", orgId);
		List<Map<String,String>> userOrg = orgManager.selUserOrgByUserId(principal.getId());
		model.addAttribute("userOrgList", userOrg);
		return "modules/sys/sysIndex";
	}
	
	/**
	 * 获取主题方案
	 */
	@RequestMapping(value = "/theme/{theme}")
	public String getThemeInCookie(@PathVariable String theme, HttpServletRequest request, HttpServletResponse response){
		if (StringUtils.isNotBlank(theme)){
			CookieUtils.setCookie(response, "theme", theme);
		}else{
			CookieUtils.getCookie(request, "theme");
		}
		return "redirect:" + request.getParameter("url");
	}
	
	/**
	 * 是否是验证码登录
	 * @param useruame 用户名
	 * @param isFail 计数加1
	 * @param clean 计数清零
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isValidateCodeLogin(String useruame, boolean isFail, boolean clean){
		Map<String, Integer> loginFailMap = (Map<String, Integer>)RedisUtils.getMap("loginFailMap");
		if (loginFailMap==null){
			loginFailMap = Maps.newHashMap();
			RedisUtils.saveMap("loginFailMap", loginFailMap);
		}
		Integer loginFailNum = loginFailMap.get(useruame);
		if (loginFailNum==null){
			loginFailNum = 0;
		}
		if (isFail){
			loginFailNum++;
			loginFailMap.put(useruame, loginFailNum);
		}
		if (clean){
			loginFailMap.remove(useruame);
		}
		return loginFailNum >= 3;
	}
	
	/**
	 * 跳转标签页
	 * @return
	 */
	@RequestMapping(value="${adminPath}/tab")
	public String tab(){
		return "modules/sys/tab";
	}
	
	/**
	 * 跳转弹出页
	 * @return
	 */
	@RequestMapping(value="${adminPath}/toArtDialog")
	public String toArtDialog(){
		return "modules/sys/artDialog";
	}
}
