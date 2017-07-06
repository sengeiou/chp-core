package com.creditharmony.core.autoBill.entity;

import java.io.Serializable;

public class AutoBillInfo implements Serializable{
	/**
	 * long serialVersionUID 
	 */
	private static final long serialVersionUID = 1L;
	private String sysId;// 流水号
	private String id;
	private String status;

	public AutoBillInfo(){
		
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	

}
