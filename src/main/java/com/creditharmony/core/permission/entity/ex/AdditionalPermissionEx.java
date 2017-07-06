package com.creditharmony.core.permission.entity.ex;

import com.creditharmony.core.permission.entity.AdditionalPermission;

/**
 * 额外权限控制entity
 * 
 * @author chenwd
 *
 */
public class AdditionalPermissionEx extends AdditionalPermission {
	

	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
}
