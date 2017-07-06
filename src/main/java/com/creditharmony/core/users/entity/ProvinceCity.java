package com.creditharmony.core.users.entity;

import com.creditharmony.core.persistence.DataEntity;

/**
 * 省市级实体
 * @Class Name ProvinceCity
 * @author 周树华
 * @Create In 2015年11月17日
 */
public class ProvinceCity extends DataEntity<ProvinceCity> {
	
	private static final long serialVersionUID = -7338836374301816767L;
	
	private String areaCode;     //区域编码
	private String areaType;     //区域类型
	private String areaName;     //区域名称
	private String shortName;    //简称
	private String parentId;       //父Id
	private String cityCarCode;
	
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCityCarCode() {
		return cityCarCode;
	}
	public void setCityCarCode(String cityCarCode) {
		this.cityCarCode = cityCarCode;
	}
}
