package com.creditharmony.core.users.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.cache.UserCache;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.security.Principal;
import com.creditharmony.core.service.BaseManager;
import com.creditharmony.core.type.ModuleName;
import com.creditharmony.core.users.constants.MenuConstants;
import com.creditharmony.core.users.dao.AreaDao;
import com.creditharmony.core.users.dao.MenuDao;
import com.creditharmony.core.users.dao.ModuleDao;
import com.creditharmony.core.users.dao.ModuleMenuDao;
import com.creditharmony.core.users.dao.OrgDao;
import com.creditharmony.core.users.dao.RoleDao;
import com.creditharmony.core.users.dao.UserDao;
import com.creditharmony.core.users.entity.Area;
import com.creditharmony.core.users.entity.Menu;
import com.creditharmony.core.users.entity.Module;
import com.creditharmony.core.users.entity.ModuleMenu;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;

/**
 * 用户工具类
 * @Class Name UserUtils
 * @author 张永生
 * @Create In 2015年12月1日
 */
public class UserUtils {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static OrgDao orgDao = SpringContextHolder.getBean(OrgDao.class);
	private static ModuleMenuDao moduleMenuDao = SpringContextHolder.getBean(ModuleMenuDao.class);
	private static ModuleDao moduleDao = SpringContextHolder.getBean(ModuleDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_ORG_ID_ = "oid_";

	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_ORG_LIST = "orgList";
	public static final String CACHE_ORG_ALL_LIST = "orgAllList";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id){
		User user = userDao.get(id);
		if (user == null){
			return null;
		}
		user.setRoleList(roleDao.findList(new Role(user)));
		return user;
	}
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByLoginName(String loginName){
		User user = userDao.getByLoginName(new User(null, loginName.toLowerCase()));
		if (user == null){
			return null;
		}
		user.setRoleList(roleDao.findList(new Role(user)));
		return user;
	}
	
	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(){

	}
	
	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(User user){

	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static User getUser(){
		try{
			User user = (User) getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
			if(null == user){
				return getUserInfo();
			}else{
				return user;
			}
		}catch(Exception e){
			return getUserInfo();
		}
	}
	
	private static User getUserInfo(){
		Principal principal = getPrincipal();
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}
		return new User();
	}
	
	
	public static String getUserId(){
		Principal principal = getPrincipal();
		if (principal!=null){
			User user = getUser(principal.getId());
			if (user != null){
				return user.getId();
			}
			return "";
		}
		return "";
	}
	
	/**
	 * 根据用户id查找用户
	 * 2016年6月7日
	 * By 张永生
	 * @param id
	 * @return
	 */
	public static User getUser(String id){
		//session中获取user对象
		User user = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		//redis缓存中获取user对象
		if(null == user){
			user = UserCache.getInstance().get(id);
		}
		//shiro中获取user对象
		if(null == user){
			Principal principal = getPrincipal();
			if (principal!=null){
				user = get(principal.getId());
			}
		}
		if(null == user)
			user = new User();
		
		return user;
	}

	/**
	 * 获取当前用户角色列表
	 * @return
	 */
	public static List<Role> getRoleList(){
		List<Role> roleList = null;
		User user = getUser();
		if (user.isAdmin()){
			roleList = roleDao.findAllList(new Role());
		}else{
			Role role = new Role();
			role.getSqlMap().put("dsf", BaseManager.dataScopeFilter(user.getCurrentUser(), "o", "u"));
			roleList = roleDao.findList(role);
		}
		return roleList;
	}
	
	/**
	 * 获取当前用户授权菜单
	 * @return
	 */
	public static List<Menu> getMenuList(String moduleKey){
		String flag = "";
		if(moduleKey.equals("MODULE_CAR")){
			flag = "MODULE_CAR";
			moduleKey = "MODULE_LOAN";
		}else if(moduleKey.equals("MODULE_LOAN")){
			flag = "MODULE_LOAN";
		}
		List<Menu> menuList = new ArrayList<Menu>();
		User user = getUser();
		User userInfo = (User) getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		Module module = getModule(moduleKey);
		ModuleMenu moduleMenu = getModuleMenu(module.getId());
		if (user.isAdmin()){
			if(ModuleName.MODULE_SYS_MANAGE.value.equals(module.getModuleKey())){
				Map<String,String> queryMap = new HashMap<String,String>();
				queryMap.put("moduleMenuId", moduleMenu.getId());
				queryMap.put("delFlag", DeleteFlagType.NORMAL);
				menuList = menuDao.findAllByParams(queryMap);
			}
		}else{
			if(flag.equals("MODULE_CAR")){ 
				menuList = getCarMenuList(moduleKey);    //获取车借菜单，去除信借
			}else if(flag.equals("MODULE_LOAN")){//信借菜单
				menuList = getCreditMenuList(moduleKey); //获取信借菜单，去除车借
			}else{
				Map<String,String> queryMap = new HashMap<String,String>();
				queryMap.put("userId", user.getId());
				queryMap.put("moduleId", module.getId());
				queryMap.put("orgId", userInfo != null ? userInfo.getDepartment().getId() : null);
				queryMap.put("delFlag", DeleteFlagType.NORMAL);
				menuList = menuDao.findByUserId(queryMap);
			}
		}
		Menu rootMenu = getRootMenu(moduleMenu.getId(), user.getId(),
				userInfo != null ? userInfo.getDepartment().getId() : "");
		getSession().setAttribute("rootId", rootMenu != null ? rootMenu.getId() : "");
		return menuList;
	}
	
	/**
	 * 获取车借菜单,去除信借菜单
	 * 2017年3月2日
	 * By zqa
	 * @param moduleKey
	 * @return
	 */
	public static List<Menu> getCarMenuList(String moduleKey){
		List<Menu> menuList = new ArrayList<Menu>();
		User user = getUser();
		User userInfo = (User) getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		Module module = getModule(moduleKey);
		Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("userId", user.getId());
		queryMap.put("moduleId", module.getId());
		queryMap.put("orgId", userInfo != null ? userInfo.getDepartment().getId() : null);
		queryMap.put("delFlag", DeleteFlagType.NORMAL);
		queryMap.put("parentId", "ebf03dce30ce486d8f6b0e5135552e9e"); //信借菜单ID
		menuList = menuDao.findByUserIdAndParentId(queryMap);
		return menuList;
	}
	
	/**
	 * 获取信借菜单，去除车借菜单
	 * 2017年3月2日
	 * By zqa
	 * @param moduleKey
	 * @return
	 */
	public static List<Menu> getCreditMenuList(String moduleKey){
		List<Menu> menuList = new ArrayList<Menu>();
		User user = getUser();
		User userInfo = (User) getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		Module module = getModule(moduleKey);
		Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("userId", user.getId());
		queryMap.put("moduleId", module.getId());
		queryMap.put("orgId", userInfo != null ? userInfo.getDepartment().getId() : null);
		queryMap.put("delFlag", DeleteFlagType.NORMAL); 
		queryMap.put("parentId", "822c283c2c544c408397994ee20c413d"); //车借菜单ID
		menuList = menuDao.findByUserIdAndParentId(queryMap);
		return menuList;
	}
	
	/**
	 * 获取当前用户授权4级以上菜单（左侧树的菜单--不含左侧一级菜单）
	 * @return
	 */
	public static List<Menu> getMenuListUserOwn(){
		List<Menu> menuList = new ArrayList<Menu>();
		User user = getUser();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("userId", user.getId());
		queryMap.put("delFlag", DeleteFlagType.NORMAL);
		queryMap.put("menuLevel", 4);
		PageBounds pageBounds = new PageBounds(1,10);
		menuList = menuDao.getMenuListUserOwnNew(queryMap,pageBounds);
		return menuList;
	}
	/**
	 * 获取当前用户授权4级以上(任职部门)菜单（左侧树的菜单--不含左侧一级菜单）
	 * @return
	 */
	public static List<Menu> getMenuListUserOwnDefault(){
		List<Menu> menuList = new ArrayList<Menu>();
		User user = getUser();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("userId", user.getId());
		queryMap.put("delFlag", DeleteFlagType.NORMAL);
		queryMap.put("menuLevel", 3);
		PageBounds pageBounds = new PageBounds(1,10);
		menuList = menuDao.getMenuListUserOwnDefault(queryMap,pageBounds);
		return menuList;
	}

	private static Module getModule(String moduleKey) {
		Map<String,String> keyMap = new HashMap<String,String>();
		keyMap.put("moduleKey", moduleKey);
		keyMap.put("delFlag", DeleteFlagType.NORMAL);
		Module module = moduleDao.getByKey(keyMap);
		return module;
	}

	private static ModuleMenu getModuleMenu(String moduleId) {
		Map<String,String> paramsMap = new HashMap<String,String>();
		paramsMap.put("moduleId", moduleId);
		paramsMap.put("delFlag", DeleteFlagType.NORMAL);
		List<ModuleMenu> dataList = moduleMenuDao.findByModuleId(paramsMap);
		ModuleMenu moduleMenu = null;
		if(ArrayHelper.isNotEmpty(dataList)){
			moduleMenu = dataList.get(0);
		}
		return moduleMenu;
	}

	private static Menu getRootMenu(String moduleMenuId, String userId, String orgId) {
		Map<String,String> rootMap = new HashMap<String,String>();
		rootMap.put("userId", userId);
		rootMap.put("orgId", orgId);
		rootMap.put("moduleMenuId", moduleMenuId);
		rootMap.put("parentId", MenuConstants.ROOT_PARENT_ID);
		rootMap.put("delFlag", DeleteFlagType.NORMAL);
		Menu rootMenu = menuDao.getRootMenu(rootMap);
		return rootMenu;
	}
	
	/**
	 * 获取当前用户授权的区域
	 * @return
	 */
	public static List<Area> getAreaList(){
		List<Area> areaList = areaDao.findAllList(new Area());
		return areaList;
	}
	
	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Org> getOrgList(){
		List<Org> orgList = null;
		User user = getUser();
		if (user.isAdmin()){
			orgList = orgDao.findAllList(new Org());
		}else{
			Org org = new Org();
			org.getSqlMap().put("dsf", BaseManager.dataScopeFilter(user, "a", ""));
			orgList = orgDao.findList(org);
		}
		return orgList;
	}

	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<Org> getOrgAllList(){
		List<Org> orgList = orgDao.findAllList(new Org());
		return orgList;
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}
	
}
