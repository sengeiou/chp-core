/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.fortune.type.HouseCommonType.java
 * @Create By 张进
 * @Create In 2016年01月12日 上午11:57:44
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 房屋共有情况
 * @Class Name HouseCommonType 
 * @author 张进
 * @Create In 2015年12月21日
 */
public enum HouseCommonType {
	OWN("0","自有"),
	
	SPOUSE("1","夫妻共有"),
	
	PARENT("2","父母共有"),
	
	OTHER("3","其他");

	private static Map<String, HouseCommonType> nameMap = new HashMap<String, HouseCommonType>(
			10);
	private static Map<String, HouseCommonType> codeMap = new HashMap<String, HouseCommonType>(
			10);

	static {
		HouseCommonType[] allValues = HouseCommonType.values();
		for (HouseCommonType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private HouseCommonType(String code, String name) {
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

	public static HouseCommonType parseByName(String name) {
		return nameMap.get(name);
	}

	public static HouseCommonType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
