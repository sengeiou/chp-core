package com.creditharmony.core.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.google.common.collect.Lists;

/**
 * 分页工具类
 * @Class Name PageUtil
 * @author 张永生
 * @Create In 2015年11月24日
 */
public class PageUtil {

	public static long COUNT_ZERO = 0;
	/**
	 * 获取当前页
	 * @param request
	 * @return
	 */
	public static int getPageNo(HttpServletRequest request){
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		return Integer.parseInt(pageNo);
	}
	
	
	/**
	 * 分页信息转换
	 * @param <T>
	 * @param <T>
	 * @param <E>
	 * @param sourcePage
	 * @param targetPage
	 */
	public static <T, E> void convertPage(Page<E> sourcePage,Page<T> targetPage,List<T> result){
		CommonUtils.pageConversion(sourcePage, targetPage);
		targetPage.setList(result);
	}
	
	/**
	 * 将PageList<T>转换为Page<T>
	 * 2015年12月1日
	 * By 张永生
	 * @param pageList
	 * @param page
	 */
	public static <T> void convertPage(PageList<T> pageList, Page<T> page) {
		List<T> dataList = Lists.newArrayList();
		for (T item : pageList) {
			dataList.add(item);
		}
		page.setCount(pageList.getPaginator() != null ? pageList.getPaginator()
				.getTotalCount() : COUNT_ZERO);
		page.setList(dataList);
	}
	
}
