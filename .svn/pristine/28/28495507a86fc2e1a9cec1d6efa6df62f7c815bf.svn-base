package com.creditharmony.core.mybatis.paginator.jackson2;

import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * PageList转json的mapper
 * @Class Name PageListJsonMapper
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class PageListJsonMapper extends ObjectMapper{

	private static final long serialVersionUID = 296737842443694830L;

	public PageListJsonMapper() {
        SimpleModule module = new SimpleModule("PageListJSONModule", new Version(1, 0, 0, null, null, null));
        module.addSerializer(PageList.class, new PageListJsonSerializer(this));
        registerModule(module);
    }
}
