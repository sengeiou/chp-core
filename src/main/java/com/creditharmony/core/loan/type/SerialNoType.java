/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeSerialNoType.java
 * @Create By 王彬彬
 * @Create In 2015年12月27日 下午11:42:36
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 编号类型区分
 * 
 * @Class Name SerialNoType
 * @author 王彬彬
 * @Create In 2015年12月27日
 */
public enum SerialNoType {
	CONTRACT("C", "信借"),

	RECONSIDE("F", "复议"),

	CHANGE("X", "修正"),

	RAISE("T", "上调"),

	CUSTOMER("JKKH", "客户"),

	LOAN("JK", "借款");


	private static Map<String, SerialNoType> nameMap = new HashMap<String, SerialNoType>(
			10);
	private static Map<String, SerialNoType> codeMap = new HashMap<String, SerialNoType>(
			10);

	static {
		SerialNoType[] allValues = SerialNoType.values();
		for (SerialNoType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SerialNoType(String code, String name) {
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

	public static SerialNoType parseByName(String name) {
		return nameMap.get(name);
	}

	public static SerialNoType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
