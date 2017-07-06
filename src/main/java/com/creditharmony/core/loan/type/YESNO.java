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
public enum YESNO {

	YES("1", "是"),

	NO("0", "否");

	private static Map<String, YESNO> nameMap = new HashMap<String, YESNO>(10);
	private static Map<String, YESNO> codeMap = new HashMap<String, YESNO>(10);

	static {
		YESNO[] allValues = YESNO.values();
		for (YESNO obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private YESNO(String code, String name) {
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

	public static YESNO parseByName(String name) {
		return nameMap.get(name);
	}

	public static YESNO parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
