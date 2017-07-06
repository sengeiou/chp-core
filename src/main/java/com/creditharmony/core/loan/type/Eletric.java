/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeEletric.java
 * @Create By 王彬彬
 * @Create In 2016年2月25日 下午2:23:20
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 电催管辖标识
 * @Class Name Eletric
 * @author 王彬彬
 * @Create In 2016年2月25日
 */
public enum Eletric {
	ELETRIC("1","电催管辖"),
	PHONESAlE("2","电销");
	private static Map<String, Eletric> nameMap = new HashMap<String, Eletric>(
			10);
	private static Map<String, Eletric> codeMap = new HashMap<String, Eletric>(
			10);

	static {
		Eletric[] allValues = Eletric.values();
		for (Eletric obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private Eletric(String code, String name) {
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

	public static Eletric parseByName(String name) {
		return nameMap.get(name);
	}

	public static Eletric parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
