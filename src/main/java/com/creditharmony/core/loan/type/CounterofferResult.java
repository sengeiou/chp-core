/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCounterofferResult.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:08:35
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name CounterofferResult （回盘结果）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum CounterofferResult {
	PREPAYMENT("0", "待划扣"),

	PAYMENT_FAILED("1", "失败"),

	PAYMENT_SUCCEED("2", "成功"),

	PROCESS("3", "处理中"),

	PROCESSED("4", "处理中(导出)"),

	PAYMENT_CONTINUE("5", "失败(待处理)"),

	RETURN("6", "退回"),
	
	PROCESS_TIMEOUT("7","划扣中"),
	
	STORE_GIVEUP("8","门店放弃");




	private static Map<String, CounterofferResult> nameMap = new HashMap<String, CounterofferResult>(
			10);
	private static Map<String, CounterofferResult> codeMap = new HashMap<String, CounterofferResult>(
			10);

	static {
		CounterofferResult[] allValues = CounterofferResult.values();
		for (CounterofferResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CounterofferResult(String code, String name) {
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

	public static CounterofferResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static CounterofferResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
