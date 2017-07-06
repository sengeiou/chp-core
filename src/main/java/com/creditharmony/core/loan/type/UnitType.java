/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeUnitType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:27:18
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name UnitType
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum UnitType {
	GOVER("0", "政府机构"),

	INSTITUTION("1", "机关事业"),

	ENTERPRISES("2", "私企"),

	FOREIGN_FUNDED_INS("3", "三资机构"),

	NATIONAL_COMPANY("4", "国有企业"),

	SELF_OPERATE("5", "个体");

	private static Map<String, UnitType> nameMap = new HashMap<String, UnitType>(
			10);
	private static Map<String, UnitType> codeMap = new HashMap<String, UnitType>(
			10);

	static {
		UnitType[] allValues = UnitType.values();
		for (UnitType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private UnitType(String code, String name) {
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

	public static UnitType parseByName(String name) {
		return nameMap.get(name);
	}

	public static UnitType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
