package com.creditharmony.core.listener;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;

import com.creditharmony.core.common.service.SystemManager;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		if (!SystemManager.printKeyLoadMessage()){
			return null;
		}
		return super.initWebApplicationContext(servletContext);
	}
}
