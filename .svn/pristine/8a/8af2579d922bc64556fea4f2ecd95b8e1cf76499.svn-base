/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeVisitFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月26日 上午11:49:45
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 访问标识（0-未访问；1-已暗访；2-已明访）
 * 
 * @Class Name VisitFlag
 * @author 王彬彬
 * @Create In 2015年12月26日
 */
public enum VisitFlag {
	NO_VISIT("0", "未暗访"),

	SECRET_VISIT("1", "已暗访"),

	BRIGHT_VISIT("2", "已明访");

	private static Map<String, VisitFlag> nameMap = new HashMap<String, VisitFlag>(
			10);
	private static Map<String, VisitFlag> codeMap = new HashMap<String, VisitFlag>(
			10);

	static {
		VisitFlag[] allValues = VisitFlag.values();
		for (VisitFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private VisitFlag(String code, String name) {
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

	public static VisitFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static VisitFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
