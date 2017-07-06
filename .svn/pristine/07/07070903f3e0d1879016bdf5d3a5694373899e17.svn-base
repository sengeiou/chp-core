package com.creditharmony.core.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.MenuDao;
import com.creditharmony.core.users.entity.Menu;
import com.creditharmony.core.users.entity.ModuleMenu;
import com.creditharmony.core.users.entity.Resource;
import com.creditharmony.core.users.entity.ResourceAuth;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.RoleModuleMenu;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.util.UserUtils;

/**
 * 菜单管理mananger
 * @Class Name MenuManager
 * @author 张永生
 * @Create In 2015年12月4日
 */
@Service
public class MenuManager extends CoreManager<MenuDao, Menu> {
	
	public Page<Menu> findPage(Page<Menu> page, Menu menu) {
		return super.findPage(page, menu);
	}

	public Menu getMenu(String id){
		return dao.get(id);
	}
	
	public Menu findMenu(String moduleMenuId, String parentId){
		Menu menu = new Menu();
		Menu parent = new Menu();
		parent.setId(parentId);
		ModuleMenu moduleMenu = new ModuleMenu();
		moduleMenu.setId(moduleMenuId);
		menu.setParent(parent);
		menu.setModuleMenu(moduleMenu);
		return dao.findMenu(menu);
	}
	
	public List<Menu> findAll(String moduleMenuId){
		List<Menu> menuList = null;
//		User user = UserUtils.getUser();
//		if (user.isAdmin()){
			ModuleMenu moduleMenu = new ModuleMenu();
			moduleMenu.setId(moduleMenuId);
			Menu menu = new Menu();
			menu.setModuleMenu(moduleMenu);
			menuList = dao.findAllList(menu);
//		}else{
//			Map<String,String> queryMap = new HashMap<String,String>();
//			queryMap.put("userId", user.getId());
//			queryMap.put("delFlag", DeleteFlagType.NORMAL);
//			menuList = dao.findByUserId(queryMap);
//		}
		return menuList;
	}
	

	public Page<Menu> getMenuListUserOwn(Page<Menu> page){
		User user = UserUtils.getUser();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("userId", user.getId());
		queryMap.put("delFlag", DeleteFlagType.NORMAL);
		queryMap.put("menuLevel", 4);
		PageList<Menu> pageList = (PageList<Menu>)dao.getMenuListUserOwnNew(queryMap, new PageBounds(page.getPageNo(), page.getPageSize()));
		PageUtil.convertPage(pageList, page);
		return page;
	}
	public Page<Menu> getMenuListUserOwnDefault(Page<Menu> page){
		User user = UserUtils.getUser();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("userId", user.getId());
		queryMap.put("delFlag", DeleteFlagType.NORMAL);
		queryMap.put("menuLevel", 3);
		PageList<Menu> pageList = (PageList<Menu>)dao.getMenuListUserOwnDefault(queryMap, new PageBounds(page.getPageNo(), page.getPageSize()));
		PageUtil.convertPage(pageList, page);
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(Menu menu) {
		super.save(menu);
	}
	
	@Transactional(readOnly = false)
	public void delete(Menu menu) {
		super.delete(menu);
	}
	
	public List<Menu> findByParentIdsLike(Menu menu){
		return dao.findByParentIdsLike(menu);
	}
	
	@Transactional(readOnly = false)
	public int updateParentIds(Menu menu){
		return dao.updateParentIds(menu);
	}
	
	@Transactional(readOnly = false)
	public int updateSort(Menu menu){
		return dao.updateSort(menu);
	}
	
	public List<Menu> findByParams(String roleId, String moduleId){
		Map<String,String> params = new HashMap<String,String>();
		params.put("moduleId", moduleId);
		params.put("roleId", roleId);
		params.put("delFlag", DeleteFlagType.NORMAL);
		List<Menu> menuList = dao.findMenuByParams(params);
		List<Menu> menuSelectList = dao.findMenuByRoleId(params);
		params.put("type", Resource.TYPE_BUTTON);
		List<Resource> resourceList = dao.findResourceByParams(params);
		List<ResourceAuth> resourceAuthList = dao.findResourceAuthByParams(params);
		for(Menu menu:menuList){
			for(Resource res:resourceList){
				if(menu.getId().equals(res.getMenuId())){
					menu.getResList().add(res);
				}
			}
			StringBuffer resSb = new StringBuffer();
			for(ResourceAuth resAuth:resourceAuthList){
				if(menu.getId().equals(resAuth.getMenuId())){
					resSb.append(resAuth.getResId()+",");
				}
			}
			menu.setResIds(resSb.toString());
			for(Menu menuCheck:menuSelectList){
				if(menu.getId().equals(menuCheck.getId())){
					menu.setHasChecked(true);
					menu.setDataAuth(menuCheck.getDataAuth());
				}
			}
		}
		return menuList;
	}
	
	public List<ResourceAuth> findResourceAuth(String userId,
			String orgId, String menuId, String resKey) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("userId", userId);
		params.put("menuId", menuId);
		params.put("orgId", orgId);
		params.put("resKey", resKey);
		params.put("delFlag", DeleteFlagType.NORMAL);
		params.put("type", Resource.TYPE_BUTTON);
		List<ResourceAuth> resourceAuthList = dao.findResourceAuth(params);
		return resourceAuthList;
	}
	public List<String> findResourceAuthNotIn(String userId,String orgId, String menuId) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("userId", userId);
		params.put("menuId", menuId);
		params.put("orgId", orgId);
		params.put("delFlag", DeleteFlagType.NORMAL);
		params.put("type", Resource.TYPE_BUTTON);
		List<String> resourceKeyList = dao.findResourceAuthNotIn(params);
		return resourceKeyList;
	}
	
	public List<String> findResourceAuthByRole(List<Role> role) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("role", role);
		params.put("delFlag", DeleteFlagType.NORMAL);
		List<String> resourceKeyList = dao.findResourceAuthByRole(params);
		return resourceKeyList;
	}
	
	public List<RoleModuleMenu> queryRoleModuleMenu(Role role){
		List<RoleModuleMenu> rmm=dao.queryRoleModuleMenu(role);
		return rmm;
	}
	
	public List<ResourceAuth> queryResourceAuth(Role role){
		List<ResourceAuth> ra=dao.queryResourceAuth(role);
		return ra;
	}
}
