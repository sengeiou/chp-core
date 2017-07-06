package com.creditharmony.core.users.entity;

import com.creditharmony.core.persistence.DataEntity;

/**
 * 资源授权
 * @Class Name ResourceAuth
 * @author 张永生
 * @Create In 2016年1月19日
 */
public class ResourceAuth  extends DataEntity<ResourceAuth>{

	private static final long serialVersionUID = -8308543887261734300L;
	
	public static final String HAS_DISPLAY_YES = "0";
	public static final String HAS_DISPLAY_NO = "1";
	public static final String HAS_EDIT_YES = "0";
	public static final String HAS_EDIT_NO = "1";
	
	private String roleId;               //角色Id
	private String menuId;               //菜单Id
	private String resId;           //资源Id
	private String hasDisplay;           //是否显示:0-显示,1-显示
	private String hasEdit;              //是否可编辑:0-可以编辑,1-不可以编辑
	private Resource resource;
	
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getHasDisplay() {
		return hasDisplay;
	}
	public void setHasDisplay(String hasDisplay) {
		this.hasDisplay = hasDisplay;
	}
	public String getHasEdit() {
		return hasEdit;
	}
	public void setHasEdit(String hasEdit) {
		this.hasEdit = hasEdit;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
}
