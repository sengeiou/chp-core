/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeLoanType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:39:32
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name LoanType（借款类型）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum LoanType {
	HONOUR_LOAN("0","信借"),
	
	CAR_LOAN("1","车借"),
	
	HOUSE_LOAN("2","房借"),
	
	IPC_LOAN("3","IPC");
	
	private static Map<String, LoanType> nameMap = new HashMap<String, LoanType>(
			10);
	private static Map<String, LoanType> codeMap = new HashMap<String, LoanType>(
			10);

	static {
		LoanType[] allValues = LoanType.values();
		for (LoanType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanType(String code, String name) {
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

	public static LoanType parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
