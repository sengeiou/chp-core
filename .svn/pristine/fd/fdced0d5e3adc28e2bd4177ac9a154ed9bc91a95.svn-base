/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCreditStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月24日 下午3:55:30
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name CreditStatus
 * @author 王彬彬
 * @Create In 2015年12月24日
 */
public enum CreditStatus {
	PAUSE("0", "暂存"),

	SUBMIT("1", "提交");
	private static Map<String, CreditStatus> nameMap = new HashMap<String, CreditStatus>(
			10);
	private static Map<String, CreditStatus> codeMap = new HashMap<String, CreditStatus>(
			10);

	static {
		CreditStatus[] allValues = CreditStatus.values();
		for (CreditStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CreditStatus(String code, String name) {
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

	public static CreditStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static CreditStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
