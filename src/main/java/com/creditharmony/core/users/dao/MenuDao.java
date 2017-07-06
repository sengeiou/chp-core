package com.creditharmony.core.users.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.Menu;
import com.creditharmony.core.users.entity.Resource;
import com.creditharmony.core.users.entity.ResourceAuth;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.RoleModuleMenu;

/**
 * 菜单DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@CoreBatisDao
public interface MenuDao extends CrudDao<Menu> {
	
	public List<Menu> findAllByParams(Map<String,String> params);

	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Map<String,String> params);
	
	public List<Menu> findByUserIdAndParentId(Map<String,String> params);
	
	public List<Menu> getMenuListUserOwn(Map<String,Object> params,PageBounds pageBounds);
	/**
	 * add by tjg
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	public List<Menu> getMenuListUserOwnNew(Map<String,Object> params,PageBounds pageBounds);
	public List<Menu> getMenuListUserOwnDefault(Map<String,Object> params,PageBounds pageBounds);
	
	public int updateParentIds(Menu menu);
	
	public int updateSort(Menu menu);
	
	public Menu findMenu(Menu menu);
	
	public List<Menu> findMenuByParams(Map<String,String> params);
	
	public List<Menu> findMenuByRoleId(Map<String,String> params);
	
	public List<Resource> findResourceByParams(Map<String,String> params);
	
	public List<ResourceAuth> findResourceAuthByParams(Map<String,String> params);
	
	public List<ResourceAuth> findResourceAuth(Map<String,String> params);
	
	public List<String> findResourceAuthNotIn(Map<String,String> params);
	
	public Menu getRootMenu(Map<String,String> params);
	
	public List<String> findResourceAuthByRole(Map<String,Object> params);
	
	public List<RoleModuleMenu> queryRoleModuleMenu(Role role);
	
	public List<ResourceAuth> queryResourceAuth(Role role);
	
	/**
	 * 根据menuid查询所有的菜单 add by tjg.
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> findAllByModuleMenuId(Map<String, String> params);
}
