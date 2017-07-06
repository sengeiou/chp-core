/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeLiveWith.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:26:09
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 退款申请状态
 * @Class Name LiveWith
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum AppType {

	BLUE_RETURN("0","蓝补退款"),
	
	URGE_RETURN("1","催收服务费退款");
	
	
	private static Map<String, AppType> nameMap = new HashMap<String, AppType>(
			10);
	private static Map<String, AppType> codeMap = new HashMap<String, AppType>(
			10);

	static {
		AppType[] allValues = AppType.values();
		for (AppType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AppType(String code, String name) {
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

	public static AppType parseByName(String name) {
		return nameMap.get(name);
	}

	public static AppType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
