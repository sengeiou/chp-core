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
 * 退款类别
 * 
 * @Class Name LiveWith
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum AppStatus {
	FIRST_CHECK("0", "待初审"),

	FIRST_CHECK_RETURN("1", "初审退回"),

	FINAL_CHECK("2", "待终审"),

	FINAL_CHECK_RETURN("3", "终审退回"),

	WAIT_RETURN("4", "待退款"),

	HAS_RETURN("5", "已退款"),

	FAIL_RETURN("6", "退款失败"),
	
	DATA_MANAGER_RETURN("7", "数据管理部退回");

	private static Map<String, AppStatus> nameMap = new HashMap<String, AppStatus>(
			10);
	private static Map<String, AppStatus> codeMap = new HashMap<String, AppStatus>(
			10);

	static {
		AppStatus[] allValues = AppStatus.values();
		for (AppStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AppStatus(String code, String name) {
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

	public static AppStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static AppStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
