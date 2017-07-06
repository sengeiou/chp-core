/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeMarriage.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:21:49
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name Marriage(婚姻状况)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum Marriage {
	NO_MARRIED("0","未婚"),
	
	MARRIED("1","已婚"),
	
	DIVORCE("2","离婚"),
	
	WIDOWED("3","丧偶");
	
	private static Map<String, Marriage> nameMap = new HashMap<String, Marriage>(
			10);
	private static Map<String, Marriage> codeMap = new HashMap<String, Marriage>(
			10);

	static {
		Marriage[] allValues = Marriage.values();
		for (Marriage obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private Marriage(String code, String name) {
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

	public static Marriage parseByName(String name) {
		return nameMap.get(name);
	}

	public static Marriage parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
