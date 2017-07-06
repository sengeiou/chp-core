package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.RoleModuleMenu;

/**
 * 角色DAO接口
 * @Class Name RoleDao
 * @author 张永生
 * @Create In 2015年11月27日
 */
@CoreBatisDao
public interface RoleDao extends CrudDao<Role> {

	
	public List<Role> getByName(Role role);
	
	/**
	 * 通过角色英文名称查询角色
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public List<Role> getByEnName(Role role);
	
	/**
	 * 分页查询角色
	 * 2015年12月18日
	 * By 张永生
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<Role> findByParams(Map<String,Object> params, PageBounds pageBounds);
	
	public List<Role> findByParamsForPage(Map<String,Object> params, PageBounds pageBounds);
	
	public List<Role> findByParams(Map<String,Object> params);
	
	/**
	 * 条件查询角色
	 * 与findByParams的区别是
	 * 根据机构类型只查询角色表
	 * 2016年6月20日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Role> queryByParams(Map<String,Object> params);
	
	/**
	 * 建立角色与模块的关系
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public int insertRoleModule(Role role);
	
	/**
	 * 清除角色与模块的关系
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public int deleteRoleModule(Role role);
	
	/**
	 * 建立角色与菜单的关系
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public int insertRoleMenu(Role role);
	
	/**
	 * 清除角色与菜单的关系
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public int deleteRoleMenu(Role role);
	
	/**
	 * 删除角色、模块与菜单的关系
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public int deleteRoleModuleMenu(Role role);
	
	/**
	 * 删除角色、模块与菜单的关系
	 * 根据角色id和moduleList进行删除
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public int removeRoleModuleMenu(Role role);
	
	/**
	 * 建立角色、模块与菜单的关系
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @return
	 */
	public int insertRoleModuleMenu(Role role);
	
	public int deleteRoleResourceAuth(Map<String,String> params);
	
	public int insertRoleResourceAuth(Role role);
	
	/**
	 * 条件查询角色
	 * 2015年12月18日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Role> findByUserId(Map<String,Object> params);
	
	/**
	 * 条件查询数据授权
	 * 2016年1月26日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<RoleModuleMenu> findDataAuth(Map<String,Object> params);
	/**
	 * 根据moduleId查询所有的菜单角色关系 add by tjg.
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> findRoleMenuByModuleId(String moduleId);
	/**
	 * 根据当前用户角色id查询角色的系统信息 add by tjg.
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> findRoleModule(List<String> list);

}
