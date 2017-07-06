/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typePosPlat.java
 * @Create By 王彬彬
 * @Create In 2016年1月19日 下午4:01:43
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * pos平台
 * @Class Name PosPlat
 * @author 王彬彬
 * @Create In 2016年1月19日
 */
public enum PosPlat {
	POS("0","易宝POS");
	
	private static Map<String, PosPlat> nameMap = new HashMap<String, PosPlat>(
			10);
	private static Map<String, PosPlat> codeMap = new HashMap<String, PosPlat>(
			10);

	static {
		PosPlat[] allValues = PosPlat.values();
		for (PosPlat obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PosPlat(String code, String name) {
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

	public static PosPlat parseByName(String name) {
		return nameMap.get(name);
	}

	public static PosPlat parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
