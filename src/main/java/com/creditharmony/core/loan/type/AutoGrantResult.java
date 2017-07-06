/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeSmsType.java
 * @Create By 王彬彬
 * @Create In 2016年3月8日 下午9:50:04
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 自动放款结果
 * @Class Name SmsType
 * @author 王彬彬
 * @Create In 2016年3月8日
 */
public enum AutoGrantResult {
	SUCCESS("0","成功"),
	
	FAILED("1","失败"),
	
	PROCESS("2","放款中"),
	
	NO_PROCESS("3","未处理");

	private static Map<String, AutoGrantResult> nameMap = new HashMap<String, AutoGrantResult>(
			5);
	private static Map<String, AutoGrantResult> codeMap = new HashMap<String, AutoGrantResult>(
			5);

	static {
		AutoGrantResult[] allValues = AutoGrantResult.values();
		for (AutoGrantResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AutoGrantResult(String code, String name) {
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

	public static AutoGrantResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static AutoGrantResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
