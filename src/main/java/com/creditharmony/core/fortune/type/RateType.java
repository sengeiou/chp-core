/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeJobType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:28:19
 */
package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 利率类型
 * @Class Name RateType
 * @author 柳慧
 * @Create In 2016年1月18日
 */
public enum RateType {
	MONTH_RATE("1","月利率"),
	
	YEAR_RATE("2","年利率");
	
	private static Map<String, RateType> nameMap = new HashMap<String, RateType>(
			10);
	private static Map<String, RateType> codeMap = new HashMap<String, RateType>(
			10);

	static {
		RateType[] allValues = RateType.values();
		for (RateType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RateType(String code, String name) {
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

	public static RateType parseByName(String name) {
		return nameMap.get(name);
	}

	public static RateType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
