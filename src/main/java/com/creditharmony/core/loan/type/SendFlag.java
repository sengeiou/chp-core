/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeSendFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月24日 下午12:07:34
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否发送财富
 * @Class Name SendFlag
 * @author 王彬彬
 * @Create In 2015年12月24日
 */
public enum SendFlag {
	NO("0", "未发送"),

	YES("1", "已发送"),

	ALL("2", "全部");

	private static Map<String, SendFlag> nameMap = new HashMap<String, SendFlag>(
			5);
	private static Map<String, SendFlag> codeMap = new HashMap<String, SendFlag>(
			5);

	static {
		SendFlag[] allValues = SendFlag.values();
		for (SendFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SendFlag(String code, String name) {
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

	public static SendFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static SendFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
