package com.creditharmony.core.mybatis.paginator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 清除mybatis分页监听器
 * @Class Name CleanupMybatisPaginatorListener
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class CleanupMybatisPaginatorListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent servletContextEvent) {

	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		OffsetLimitInterceptor.Pool.shutdownNow();
	}
}
