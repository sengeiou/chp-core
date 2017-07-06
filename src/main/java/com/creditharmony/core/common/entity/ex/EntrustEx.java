package com.creditharmony.core.common.entity.ex;

import com.creditharmony.core.common.entity.Entrust;

public class EntrustEx extends Entrust{

	private static final long serialVersionUID = -6470209439154340830L;
	
	private String roleType;
	
    private String entrustUserName;

    private String entrustAcceptUserName;
    
    private String departmentId;
    
    private Integer level;

	public String getEntrustUserName() {
		return entrustUserName;
	}

	public void setEntrustUserName(String entrustUserName) {
		this.entrustUserName = entrustUserName;
	}

	public String getEntrustAcceptUserName() {
		return entrustAcceptUserName;
	}

	public void setEntrustAcceptUserName(String entrustAcceptUserName) {
		this.entrustAcceptUserName = entrustAcceptUserName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
}

