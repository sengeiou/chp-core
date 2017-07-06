package com.creditharmony.core.sync.data.entity;

import java.util.Date;

import com.creditharmony.core.persistence.DataEntity;

/**
 * 同步角色对象
 * 即：从系统管理模块同步角色到业务模块:汇金和财富
 * @Class Name SyncRole
 * @author 张永生
 * @Create In 2015年12月2日
 */
public class SyncRole extends DataEntity<SyncRole> {

	private static final long serialVersionUID = -1428901748627956297L;
	
	private String roleId;                    // 角色Id
	private int    batchNo;                   // 批次号
	private Date   versionTime;           	// 版本时间,即数据产生的时间
	private String syncModuleName;            // 同步模块的名称
	private String syncType;                  // 同步数据类型：参见SyncDataType:TYPE_ADD,TYPE_DELETE,TYPE_MODIFY 
	private Integer syncStatus;           	// 同步状态,参见SyncStatus:0-未同步;1-同步失败;2-同步成功
	private String name; 						// 角色名称
	private String enName;					    // 英文名称
	private String roleType;					// 角色类型
	private String dataScope;					// 数据范围
	private String oldName; 					// 原角色名称
	private String oldEnName;					// 原英文名称
	private String sysData; 					// 是否是系统数据
	private String useable; 					// 是否是可用
	private String orgType;                     // 组织机构类型
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public int getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}
	public Date getVersionTime() {
		return versionTime;
	}
	public void setVersionTime(Date versionTime) {
		this.versionTime = versionTime;
	}
	public String getSyncModuleName() {
		return syncModuleName;
	}
	public void setSyncModuleName(String syncModuleName) {
		this.syncModuleName = syncModuleName;
	}
	public String getSyncType() {
		return syncType;
	}
	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}
	public Integer getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
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
	public String getSysData() {
		return sysData;
	}
	public void setSysData(String sysData) {
		this.sysData = sysData;
	}
	public String getUseable() {
		return useable;
	}
	public void setUseable(String useable) {
		this.useable = useable;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	
}
