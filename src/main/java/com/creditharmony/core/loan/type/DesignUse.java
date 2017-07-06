/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDesignUse.java
 * @Create By 王彬彬
 * @Create In 2016年1月5日 上午11:34:48
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 规划用途
 * @Class Name DesignUse
 * @author 王彬彬
 * @Create In 2016年1月5日
 */
public enum DesignUse {
	HOME("0", "住宅"),

	BUSINESS("1", "商用"),

	HOME_BUSINESS("2", "商住两用"),

	INDUSTRY("3", "工业"),

	OTHER("4", "其他");
	private static Map<String, DesignUse> nameMap = new HashMap<String, DesignUse>(
			10);
	private static Map<String, DesignUse> codeMap = new HashMap<String, DesignUse>(
			10);

	static {
		DesignUse[] allValues = DesignUse.values();
		for (DesignUse obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DesignUse(String code, String name) {
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

	public static DesignUse parseByName(String name) {
		return nameMap.get(name);
	}

	public static DesignUse parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
