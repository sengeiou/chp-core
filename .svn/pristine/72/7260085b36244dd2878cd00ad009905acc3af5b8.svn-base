/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeHouseBuyWay.java
 * @Create By 王彬彬
 * @Create In 2015年12月30日 下午12:09:04
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 购买方式
 * @Class Name HouseBuyWay
 * @author 王彬彬
 * @Create In 2015年12月30日
 */
public enum HouseBuyWay {
	ALL("0", "全额"),

	MORTGAGE("1", "按揭");
	
	private static Map<String, HouseBuyWay> nameMap = new HashMap<String, HouseBuyWay>(
			10);
	private static Map<String, HouseBuyWay> codeMap = new HashMap<String, HouseBuyWay>(
			10);

	static {
		HouseBuyWay[] allValues = HouseBuyWay.values();
		for (HouseBuyWay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private HouseBuyWay(String code, String name) {
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

	public static HouseBuyWay parseByName(String name) {
		return nameMap.get(name);
	}

	public static HouseBuyWay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
