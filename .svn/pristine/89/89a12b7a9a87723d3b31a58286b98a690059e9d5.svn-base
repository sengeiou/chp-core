package com.creditharmony.core.users.entity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.creditharmony.common.util.Collections3;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.persistence.DataEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

/**
 * 角色实体
 * @Class Name Role
 * @author 张永生
 * @Create In 2015年12月24日
 */
public class Role extends DataEntity<Role> {
	
	private static final long serialVersionUID = 1L;
	private String name; 			// 角色名称
	private String enName;			// 英文名称
	private String roleType;		// 角色类型
	private String dataScope;		// 数据范围
	private String oldName; 		// 原角色名称
	private String oldEnName;		// 原英文名称
	private String sysData; 		// 是否是系统数据
	private String useable; 		// 是否是可用
	
	private User user;				// 根据用户ID查询角色列表
//	private List<User> userList = Lists.newArrayList(); // 拥有用户列表
	private List<Menu> menuList = Lists.newArrayList(); // 拥有菜单列表
	private List<Module> moduleList = Lists.newArrayList();  //拥有的模块列表
	private Module module;		    // 用来辅助保存t_gl_role_module_menu
	private String orgType;
	private String orgTypeName;     //组织机构类型名称
	private List<ResourceAuth> resAuthList = Lists.newArrayList();
	private String moduleIds;
	private String moduleStr;
	
	// 用户修改页面是否被选中该角色
	private transient boolean selected;
	// 数据范围（1：所有数据；2：所在公司及以下数据；3：所在公司数据；4：所在部门及以下数据；5：所在部门数据；8：仅本人数据；9：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
	public static final String DATA_SCOPE_COMPANY = "3";
	public static final String DATA_SCOPE_ORG_AND_CHILD = "4";
	public static final String DATA_SCOPE_ORG = "5";
	public static final String DATA_SCOPE_SELF = "8";
	public static final String DATA_SCOPE_CUSTOM = "9";
	
	public Role() {
		super();
		this.dataScope = DATA_SCOPE_SELF;
		this.useable = Global.YES;
	}
	
	public Role(String id){
		super(id);
	}
	
	public Role(User user) {
		this();
		this.user = user;
	}
	
	public Role(Module module) {
		this();
		this.module = module;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public String getSysData() {
		return sysData;
	}

	public void setSysData(String sysData) {
		this.sysData = sysData;
	}

	@Length(min=1, max=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min=1, max=100)
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}
	
	@Length(min=1, max=100)
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getOldEnName() {
		return oldEnName;
	}

	public void setOldEnName(String oldEnName) {
		this.oldEnName = oldEnName;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<String> getMenuIdList() {
		List<String> menuIdList = Lists.newArrayList();
		for (Menu menu : menuList) {
			menuIdList.add(menu.getId());
		}
		return menuIdList;
	}

	public void setMenuIdList(List<String> menuIdList) {
		menuList = Lists.newArrayList();
		for (String menuId : menuIdList) {
			Menu menu = new Menu();
			menu.setId(menuId);
			menuList.add(menu);
		}
	}

	public String getMenuIds() {
		return StringUtils.join(getMenuIdList(), ",");
	}
	
	public void setMenuIds(String menuIds) {
		menuList = Lists.newArrayList();
		if (menuIds != null){
			String[] ids = StringUtils.split(menuIds, ",");
			setMenuIdList(Lists.newArrayList(ids));
		}
	}
	
	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}
	
	@JsonIgnore
	public List<String> getModuleIdList() {
		List<String> moduleIdList = Lists.newArrayList();
		for (Module module : moduleList) {
			moduleIdList.add(module.getId());
		}
		return moduleIdList;
	}
	
	public void setModuleIdList(List<String> moduleIdList) {
		moduleList = Lists.newArrayList();
		for (String moduleId : moduleIdList) {
			Module module = new Module();
			module.setId(moduleId);
			moduleList.add(module);
		}
	}
	
	/**
	 * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
	 */
	public String getModuleNames() {
		return Collections3.extractToString(moduleList, "name", ",");
	}

	/**
	 * 获取权限字符串列表
	 */
	public List<String> getPermissions() {
		List<String> permissions = Lists.newArrayList();
		for (Menu menu : menuList) {
			if (menu.getPermission()!=null && !"".equals(menu.getPermission())){
				permissions.add(menu.getPermission());
			}
		}
		return permissions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgTypeName() {
		return orgTypeName;
	}

	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}

	public List<ResourceAuth> getResAuthList() {
		return resAuthList;
	}

	public void setResAuthList(List<ResourceAuth> resAuthList) {
		this.resAuthList = resAuthList;
	}

	public String getModuleIds() {
		return moduleIds;
	}

	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}

	public String getModuleStr() {
		return moduleStr;
	}

	public void setModuleStr(String moduleStr) {
		this.moduleStr = moduleStr;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	
}
