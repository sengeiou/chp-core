package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.Module;
import com.creditharmony.core.users.entity.Role;

/**
 * 模块信息DAO接口
 * @Class Name ModuleDao
 * @author 张永生
 * @Create In 2015年11月3日
 */
@CoreBatisDao
public interface ModuleDao extends CrudDao<Module> {
	
	public Module getByKey(Map<String, String> params);
	
	/**
	 * 根据角色ID查询模块
	 * 2015年11月5日 By 张永生
	 * @param params
	 * @return
	 */
	public List<Module> findModuleByRole(Map<String, String> params);
	/**
	 * 根据角色id获取所有模块
	 * 2016年3月18日
	 * By 何军
	 * @param list
	 * @return
	 */
	public List<Module> findModuleByRoleIds(Map<String, Object> params);
	
	/**
	 * 条件查询模块
	 * 2016年1月13日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Module> findByRole(Role role);
	
}
