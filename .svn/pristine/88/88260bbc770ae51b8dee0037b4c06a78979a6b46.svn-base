package com.creditharmony.core.log.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creditharmony.core.log.dao.LogDao;
import com.creditharmony.core.log.entity.Log;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.service.CoreManager;

/**
 * 日志Manager
 * @Class Name logManager
 * @author 张永生
 * @Create In 2015年11月24日
 */
@Service
public class LogManager extends CoreManager<LogDao, Log> {
	
	/**
	 * 根据log参数和pageBounds来查询日志数据
	 * 2015年12月1日
	 * By 张永生
	 * @param log
	 * @param pageBounds
	 * @return
	 */
	public List<Log> findList(Log log, PageBounds pageBounds){
		return dao.findList(log, pageBounds);
	}
	
}
