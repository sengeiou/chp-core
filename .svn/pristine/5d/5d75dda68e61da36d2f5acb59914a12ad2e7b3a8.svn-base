/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeBackReason.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:32:03
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name BackReason (退回原因)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum BackReason {
	INFORMATION_ERROR("0", "录入信息与小票信息不符"),

	CASH_NOT_RECIVER("1", "该笔款项未到账"),

	BANK_ERROR("2", "存入银行不符");

	private static Map<String, BackReason> nameMap = new HashMap<String, BackReason>(
			10);
	private static Map<String, BackReason> codeMap = new HashMap<String, BackReason>(
			10);

	static {
		BackReason[] allValues = BackReason.values();
		for (BackReason obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private BackReason(String code, String name) {
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

	public static BackReason parseByName(String name) {
		return nameMap.get(name);
	}

	public static BackReason parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
