package com.creditharmony.core.threenet.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.threenet.entity.ThreeNetOrgHistory;

/**
 * 三网组织结构同步历史dao
 * @Class Name ThreeNetOrgHistoryDao
 * @author 张永生
 * @Create In 2016年2月29日
 */
@CoreBatisDao
public interface ThreeNetOrgHistoryDao extends CrudDao<ThreeNetOrgHistory> {

	/**
	 * 分页查询
	 * 2016年2月29日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<ThreeNetOrgHistory> findByPage(Map<String,Object> params, PageBounds pageBounds);
}
