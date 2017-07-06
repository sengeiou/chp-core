/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeSexFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月24日 下午12:16:07
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name SexFlag
 * @author 王彬彬
 * @Create In 2015年12月24日
 */
public enum SexFlag {
	MALE("0", "男"),

	FEMALE("1", "女");

	private static Map<String, SexFlag> nameMap = new HashMap<String, SexFlag>(
			5);
	private static Map<String, SexFlag> codeMap = new HashMap<String, SexFlag>(
			5);

	static {
		SexFlag[] allValues = SexFlag.values();
		for (SexFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SexFlag(String code, String name) {
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

	public static SexFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static SexFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
