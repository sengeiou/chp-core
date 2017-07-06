package com.creditharmony.core.users.entity;

import java.util.Date;
import java.util.List;

import com.creditharmony.core.persistence.DataEntity;

/**
 * 员工机构关联-entity
 * 
 * @Class Name UserOrg
 * @author 周亮
 * @Create In 2015年12月9日
 */
public class UserRoleOrg extends DataEntity<UserRoleOrg> {
	
	private static final long serialVersionUID = 1L;
	
    /** 用户ID */
    private String userId;
    private String userName;
    
    /** 组织机构ID */
    private String orgId;
    
    private String orgName;
    
    private String orgType;
    
    private String roleId;
    private String roleName;
    /** 创建人 */
    private String createBy;
    /** 创建时间 */
    private Date createTime;
    /** 修改人 */
    private String modifyBy;
    /** 最后修改时间 */
    private Date modifyTime;
    
    private List<Role> roles;
    /** 机构是否可用 : Global.NO 不可用， Global.YES 可用 */
    private String orgUseable;   
    
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifyBy
	 */
	public String getModifyBy() {
		return modifyBy;
	}
	/**
	 * @param modifyBy the modifyBy to set
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrgUseable() {
		return orgUseable;
	}
	public void setOrgUseable(String orgUseable) {
		this.orgUseable = orgUseable;
	}
	
	
}