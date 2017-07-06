package com.creditharmony.core.security.web;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.common.util.RemoteAddrUtils;
import com.creditharmony.core.security.custom.CustomFormAuthenticationFilter;
import com.creditharmony.core.security.custom.CustomUsernamePasswordToken;
import com.creditharmony.core.security.util.PortalPropertiesUtil;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.service.UserManager;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.core.web.BaseController;


/**
 * portal統一各系统认证入口（shiro认证）
 * @Class Name LoginSsoController
 * @author 陈伟东
 * @Create In 2015年12月10日
 */
@Controller
public class LoginSsoController extends BaseController{
	
	@Value("${portalLink}")
	private String portalLink;
	@Autowired
	private UserManager userManager;
	/**
	 * was认证成功后shiro登录
	 * @throws IOException 
	 */
	@RequestMapping(value = {"/sso/login","a/sso/login"}, method = RequestMethod.GET)
	public String login(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		long tid = System.nanoTime();
		logger.info("tid:{},step:{}",tid,"第0步：shiro认证开始");
		String userName = "";
		String password  = "";
		if(request.getRemoteUser() != null){
			userName = request.getRemoteUser();
			password  = request.getRemoteUser();
		}else{
			userName = getUsername(request);
			password  = getPassword(request);
		}
		Subject currentUser = SecurityUtils.getSubject();
		boolean rememberMe = isRememberMe(request);
		String host = RemoteAddrUtils.getRemoteAddr((HttpServletRequest)request);
		String captcha = getCaptcha(request);
		boolean mobile = isMobileLogin(request);
		logger.info("tid:{},step:{},userName:{}",tid,"第1步：shiro认证回调开始",userName);	
		CustomUsernamePasswordToken token = 
				new CustomUsernamePasswordToken(userName, 
						password.toCharArray(), 
						rememberMe, host, captcha, mobile);		
		currentUser.login(token);
		logger.info("tid:{},step:{},userName:{}",tid,"第2步：shiro认证回调结束",userName);
		//用户密码为初始密码则让用户修改密码
		if(PortalPropertiesUtil.getInitialPasswordResetEnable()){
			User user = userManager.get(userName);
			if(user != null ){
				Object obj = UserUtils.getSession().getAttribute("uptpwd_password");
				String pass = obj == null?"":String.valueOf(obj);
				if(StringUtils.isEmpty(user.getPassword()) || 
						user.getPassword().equals(pass)){
					logger.debug("密码为初始密码，需重新修改密码！");
					response.sendRedirect( request.getContextPath() + "/uptpwd.jsp");
				}
				logger.info("tid:{},step:{},userName:{}",tid,"第3步：修改初始密码结束",userName);
			}
		}
		
		SavedRequest saveRequest = WebUtils.getAndClearSavedRequest(request);
		if(saveRequest != null){
			String queryString = saveRequest.getQueryString();
			if(!StringUtils.isEmpty(queryString)){
				String[] pars = queryString.split("&");
				if(pars != null && pars.length >=1){
					for(String par:pars){
						String[] parameter = par.split("=");
						if(parameter != null && parameter.length == 2){
							model.addAttribute(parameter[0], parameter[1]);
						}
					}
				}
			}
			logger.info("tid:{},step:{},userName:{}",tid,"第4步：登录成功",userName);
			return "redirect:" + saveRequest.getRequestURI().substring(saveRequest.getRequestURI().indexOf("/", 1));
		}else{
			return "redirect:" + adminPath;
		}
	}
	
	/**
	 * 跳转到portal应用
	 */
	@RequestMapping(value = "/toportal", method = RequestMethod.GET)
	public String toportal(HttpServletRequest request,HttpServletResponse response) {
		return "redirect:" + portalLink;
	}
	
	
	
    private boolean isRememberMe(ServletRequest request) {
        return WebUtils.isTrue(request, CustomFormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
    }

    private String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, CustomFormAuthenticationFilter.DEFAULT_CAPTCHA_PARAM);
	}
    
    private boolean isMobileLogin(ServletRequest request) {
        return WebUtils.isTrue(request, CustomFormAuthenticationFilter.DEFAULT_MOBILE_PARAM);
    }
    
    private String getUsername(ServletRequest request) {
        return WebUtils.getCleanParam(request, CustomFormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
    }

    private String getPassword(ServletRequest request) {
        return WebUtils.getCleanParam(request, CustomFormAuthenticationFilter.DEFAULT_PASSWORD_PARAM);
    }
	
}
