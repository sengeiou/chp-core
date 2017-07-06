/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRaiseRole.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:34:39
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RaiseRole(上调角色)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RaiseRole {
	STORE_UP("0","门店上调"),
	
	CITY_MAMAGER_UP("1","城市经理上调"),
	
	PROV_COMPANY_UP("2","省分公司上调"),
	
	PRESIDENT_UP("3","总裁上调");
	
	private static Map<String, RaiseRole> nameMap = new HashMap<String, RaiseRole>(
			10);
	private static Map<String, RaiseRole> codeMap = new HashMap<String, RaiseRole>(
			10);

	static {
		RaiseRole[] allValues = RaiseRole.values();
		for (RaiseRole obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RaiseRole(String code, String name) {
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

	public static RaiseRole parseByName(String name) {
		return nameMap.get(name);
	}

	public static RaiseRole parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
