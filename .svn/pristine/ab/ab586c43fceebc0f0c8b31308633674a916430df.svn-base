package com.creditharmony.core.threenet.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.threenet.entity.ThreeNetUserHistory;

/**
 * 三网用户同步历史dao
 * @Class Name ThreeNetUserHistoryDao
 * @author 张永生
 * @Create In 2016年2月29日
 */
@CoreBatisDao
public interface ThreeNetUserHistoryDao extends CrudDao<ThreeNetUserHistory> {

	/**
	 * 分页查询
	 * 2016年2月29日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<ThreeNetUserHistory> findByPage(Map<String,Object> params, PageBounds pageBounds);
}
