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
 * 限制进件
 * @Class Name InputLimit
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum InputLimit {

	NO_LIMIT("0","可进件"),
	
	HAS_LIMIT("1","限制进件");

	private static Map<String, InputLimit> nameMap = new HashMap<String, InputLimit>(10);
	private static Map<String, InputLimit> codeMap = new HashMap<String, InputLimit>(10);

	static {
		InputLimit[] allValues = InputLimit.values();
		for (InputLimit obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private InputLimit(String code, String name) {
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

	public static InputLimit parseByName(String name) {
		return nameMap.get(name);
	}

	public static InputLimit parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
