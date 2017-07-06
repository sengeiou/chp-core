package com.creditharmony.core.report.entity;

import com.creditharmony.core.persistence.DataEntity;

/**
 * 角色数据权限表的实体
 * @Class Name RoleDataRange
 * @author 张岩
 * @Create In 2016年08月16日
 */
public class RoleDataRange extends DataEntity<RoleDataRange> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7916121166662254640L;

	private String roleId;
	private String orgIds;
	private String orgType;
	private String isExport;
	private String field1;
	private String field2;
	private String field3;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getOrgIds() {
		return orgIds;
	}
	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getIsExport() {
		return isExport;
	}
	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	
	
}
