/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRegistered.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:23:55
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name Registered(户口)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum Registered {
	LOCAL_CITY("0", "本地城镇户口"),

	LOCAL_VILLAGE("1", "本地农村户口"),

	OUT_CITY("2", "外地城镇户口"),

	OUT_VILLAGE("3", "外地农村户口");

	private static Map<String, Registered> nameMap = new HashMap<String, Registered>(
			10);
	private static Map<String, Registered> codeMap = new HashMap<String, Registered>(
			10);

	static {
		Registered[] allValues = Registered.values();
		for (Registered obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private Registered(String code, String name) {
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

	public static Registered parseByName(String name) {
		return nameMap.get(name);
	}

	public static Registered parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
