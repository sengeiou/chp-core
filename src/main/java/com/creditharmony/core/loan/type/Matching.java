/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeMatching.java
 * @Create By 王彬彬
 * @Create In 2016年1月19日 下午3:59:56
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * POS催收匹配状态
 * @Class Name Matching
 * @author 王彬彬
 * @Create In 2016年1月19日
 */
public enum Matching {
	NO_MATCH("0","未匹配"),
	
	MATCHED("1","已匹配"),
	
	CHECKED("2","已查账");
	
	private static Map<String, Matching> nameMap = new HashMap<String, Matching>(
			10);
	private static Map<String, Matching> codeMap = new HashMap<String, Matching>(
			10);

	static {
		Matching[] allValues = Matching.values();
		for (Matching obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private Matching(String code, String name) {
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

	public static Matching parseByName(String name) {
		return nameMap.get(name);
	}

	public static Matching parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
