package com.creditharmony.core.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.type.UserStatus;
import com.creditharmony.core.users.util.UserUtils;

public class ShiroSsoFilter implements Filter {
	private static Logger logger = LoggerFactory.getLogger(ShiroSsoFilter.class);
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
        try{
        	HttpServletRequest httpSReq = (HttpServletRequest)request;
        	HttpServletResponse httRes = (HttpServletResponse)response;
        	//was认证后登陆其他业务应用时，同一浏览器以不同账号登陆时，将原账号从shiro中退出
    		String ssouser = request.getParameter("ssousr");
    		String userId = httpSReq.getRemoteUser();
    		//logger.info("ssouser:{},userId:{}",ssouser,userId);
    		if(!StringUtils.isEmpty(ssouser)){
    			if((!StringUtils.isEmpty(userId) && !ssouser.equals(userId)) 
    					|| (StringUtils.isEmpty(request.getParameter("menuId")) && StringUtils.isEmpty(request.getParameter("menuId")))){
    				SecurityUtils.getSubject().logout();
    			}
    		}
    		User user = UserUtils.getUser();
    		if(UserStatus.FROZEN.equals(user.getStatus())){
    			httRes.sendRedirect(httpSReq.getContextPath() + "/frozen.jsp");
    		}else{
    			filterChain.doFilter(request, response);  
    		}
        }catch(Exception e){
        	e.printStackTrace();
        }
     
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
	     

}
