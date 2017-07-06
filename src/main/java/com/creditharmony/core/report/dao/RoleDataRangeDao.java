package com.creditharmony.core.report.dao;

import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.report.entity.ReportExport;
import com.creditharmony.core.report.entity.RoleDataRange;

/**
 * 角色数据权限表的dao
 * @Class Name RoleDataRangeDao
 * @author 张岩
 * @Create In 2016年08月16日
 */
@CoreBatisDao
public interface RoleDataRangeDao extends CrudDao<RoleDataRange> {
	/**
	 * 按role_id查询数据
	 * 2016年08月16日
	 * By 张岩
	 * @param role_id
	 * @return
	 */
	RoleDataRange findByRoleId(String roleId);
	
}
