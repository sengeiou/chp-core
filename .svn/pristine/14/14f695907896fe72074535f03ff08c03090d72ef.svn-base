/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeYESON.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:29:32
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name YESON(是否标识)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum ZhrefundStatus {

	YES("1", "生效"),

	NO("2", "失效");

	private static Map<String, ZhrefundStatus> nameMap = new HashMap<String, ZhrefundStatus>(10);
	private static Map<String, ZhrefundStatus> codeMap = new HashMap<String, ZhrefundStatus>(10);

	static {
		ZhrefundStatus[] allValues = ZhrefundStatus.values();
		for (ZhrefundStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ZhrefundStatus(String code, String name) {
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

	public static ZhrefundStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static ZhrefundStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
