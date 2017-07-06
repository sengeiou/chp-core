package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.ModuleMenu;

/**
 * 模块菜单DAO接口
 * @Class Name ModuleMenuDao
 * @author 张永生
 * @Create In 2015年11月4日
 */
@CoreBatisDao
public interface ModuleMenuDao extends CrudDao<ModuleMenu> {

	/**
	 * 组合模块Id条件查询模块菜单
	 * @param params
	 * @return
	 */
	List<ModuleMenu> findByModuleId(Map<String,String> params);
	
	/**
	 * 条件查询模块菜单
	 * @param params
	 * @return
	 */
	ModuleMenu getByParams(Map<String,String> params);
}
