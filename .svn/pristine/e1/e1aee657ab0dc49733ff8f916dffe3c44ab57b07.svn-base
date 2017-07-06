/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeLoansendResult.java
 * @Create By 王彬彬
 * @Create In 2015年12月24日 下午5:01:28
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 放款结果
 * @Class Name LoansendResult
 * @author 王彬彬
 * @Create In 2015年12月24日
 */
public enum LoansendResult {
	LOAN_SENDED_SUCCEED("0","放款成功"),
	
	LOAN_SENDED_FAILED("1","放款失败"),

	LOAN_PROCESS("2","放款处理中");
	
	private static Map<String, LoansendResult> nameMap = new HashMap<String, LoansendResult>(
			10);
	private static Map<String, LoansendResult> codeMap = new HashMap<String, LoansendResult>(
			10);

	static {
		LoansendResult[] allValues = LoansendResult.values();
		for (LoansendResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoansendResult(String code, String name) {
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

	public static LoansendResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoansendResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
