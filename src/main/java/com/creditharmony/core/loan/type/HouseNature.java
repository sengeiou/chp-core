/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeHouseNature.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:44:18
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name HouseNature（房产性质）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum HouseNature {
	MORTGAGE("0","商业按揭房"),
	
	NO_MORTGAGE("1","无按揭房"),
	
	ACCUMULATION("2","公积金按揭购房"),
	
	SELF_BUILD("3","自建房"),
	
	RENTING("4","租用"),
	
	RELATIONSHIP_HOUSE("5","亲属住房"),
	
	DORM("6","宿舍"),
	
	OTHER("7","其他");
	private static Map<String, HouseNature> nameMap = new HashMap<String, HouseNature>(
			10);
	private static Map<String, HouseNature> codeMap = new HashMap<String, HouseNature>(
			10);

	static {
		HouseNature[] allValues = HouseNature.values();
		for (HouseNature obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private HouseNature(String code, String name) {
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

	public static HouseNature parseByName(String name) {
		return nameMap.get(name);
	}

	public static HouseNature parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
