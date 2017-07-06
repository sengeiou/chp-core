/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeChargeType.java
 * @Create By 王彬彬
 * @Create In 2015年12月23日 下午4:22:09
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 冲抵类型（门店冲抵、风控冲抵、提前结清冲抵、系统冲抵
 * ）
 * 
 * @Class Name ChargeType
 * @author 王彬彬
 * @Create In 2015年12月23日
 */
public enum ChargeType {
	CHARGE_STORE("0", "门店冲抵"),

	CHARGE_RISK("1", "风控冲抵"),

	CHARGE_PRESETTLE("2", "提前结清冲抵"),
	
	CHARGE_SYSTEM("3","系统冲抵");


	private static Map<String, ChargeType> nameMap = new HashMap<String, ChargeType>(
			10);
	private static Map<String, ChargeType> codeMap = new HashMap<String, ChargeType>(
			10);

	static {
		ChargeType[] allValues = ChargeType.values();
		for (ChargeType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ChargeType(String code, String name) {
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

	public static ChargeType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ChargeType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
