/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeMaintainStatus.java
 * @Create By 王彬彬
 * @Create In 2016年2月25日 下午5:57:30
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 维护类型
 * 
 * @Class Name MaintainStatus
 * @author 王彬彬
 * @Create In 2016年2月25日
 */
public enum MaintainType {
	ADD("0","新增"),
	
	CHANGE("1","修改");

	private static Map<String, MaintainType> nameMap = new HashMap<String, MaintainType>(
			10);
	private static Map<String, MaintainType> codeMap = new HashMap<String, MaintainType>(
			10);

	static {
		MaintainType[] allValues = MaintainType.values();
		for (MaintainType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private MaintainType(String code, String name) {
		this.name = name;
		this.code = code;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static MaintainType parseByName(String name) {
		return nameMap.get(name);
	}

	public static MaintainType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
