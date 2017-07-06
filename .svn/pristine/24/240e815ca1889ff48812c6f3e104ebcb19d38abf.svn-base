/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDeductWay.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:15:12
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name DeductWay 划扣标志(线上、线下)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum DeductWay {
	ONLINE("0", "线上"),

	OFFLINE("1", "线下");

	private static Map<String, DeductWay> nameMap = new HashMap<String, DeductWay>(
			2);
	private static Map<String, DeductWay> codeMap = new HashMap<String, DeductWay>(
			2);

	static {
		DeductWay[] allValues = DeductWay.values();
		for (DeductWay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DeductWay(String code, String name) {
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

	public static DeductWay parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductWay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
