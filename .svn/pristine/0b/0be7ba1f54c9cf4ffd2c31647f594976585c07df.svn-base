/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeUrgeCounterofferResult.java
 * @Create By 王彬彬
 * @Create In 2016年3月3日 下午3:42:25
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 回盘结果(催收服务费)
 * @Class Name UrgeCounterofferResult
 * @author 王彬彬
 * @Create In 2016年3月3日
 */
public enum UrgeCounterofferResult {
	PREPAYMENT("0","待划扣"),
	
	PAYMENT_FAILED("1","划扣失败"),
	
	PAYMENT_SUCCEED("2","划扣成功"),
	
	PROCESS("3","处理中"),
	
	PROCESSED("4","处理中(导出)"),
	
	TO_ACCOUNT_VERIFY("5","待查账"),
	
	ACCOUNT_VERIFIED("6","查账成功"),
	
	ACCOUNT_RETURN("7","查账退回"),
	
	VERIFIED_FAILED("8","查账失败");
	
	private static Map<String, UrgeCounterofferResult> nameMap = new HashMap<String, UrgeCounterofferResult>(
			20);
	private static Map<String, UrgeCounterofferResult> codeMap = new HashMap<String, UrgeCounterofferResult>(
			20);

	static {
		UrgeCounterofferResult[] allValues = UrgeCounterofferResult.values();
		for (UrgeCounterofferResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private UrgeCounterofferResult(String code, String name) {
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

	public static UrgeCounterofferResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static UrgeCounterofferResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
