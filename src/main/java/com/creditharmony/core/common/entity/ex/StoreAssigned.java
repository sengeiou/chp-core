package com.creditharmony.core.common.entity.ex;

import java.util.Date;

/**
 * 已分配门店信息
 * @author chenwd
 *
 */
public class StoreAssigned {

	private String memberId;	//分配给的成员id
	private String memberName;	//分配给的成员姓名
	private String groupName; 	//分配成员所属的小组（机构）名称
	private Integer storeAssignedCount;	//该成员已分配的门店数量
	private String storeName;	//分配的门店名称
	private Date assignTime;	//分配时间
	private String dataDomainId;	//分配关系主键
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getStoreAssignedCount() {
		return storeAssignedCount;
	}
	public void setStoreAssignedCount(Integer storeAssignedCount) {
		this.storeAssignedCount = storeAssignedCount;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Date getAssignTime() {
		return assignTime;
	}
	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}
	public String getDataDomainId() {
		return dataDomainId;
	}
	public void setDataDomainId(String dataDomainId) {
		this.dataDomainId = dataDomainId;
	}
	
}
