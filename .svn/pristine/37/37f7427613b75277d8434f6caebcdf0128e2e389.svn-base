package com.creditharmony.core.log.dao;

import java.util.List;

import com.creditharmony.core.log.entity.Log;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 日志DAO接口
 * @Class Name LogDao
 * @author 张永生
 * @Create In 2015年11月27日
 */
@CoreBatisDao
public interface LogDao extends CrudDao<Log> {

	/**
	 * 根据log参数和pageBounds查询日志数据
	 * 2015年12月1日
	 * By 张永生
	 * @param log
	 * @param pageBounds
	 * @return
	 */
	public List<Log> findList(Log log, PageBounds pageBounds);
	
}
