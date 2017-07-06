/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRepayWay.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:48:48
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RepayWay(还款方式)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RepayWay {
	SELF_REPAYMENT("0","独立还款"),
	
	FAMILY_REPAYMENT("1","家人协助还款"),
	
	OTHER_REPAYMENT("2","其他方式还款");
	
	private static Map<String, RepayWay> nameMap = new HashMap<String, RepayWay>(
			10);
	private static Map<String, RepayWay> codeMap = new HashMap<String, RepayWay>(
			10);

	static {
		RepayWay[] allValues = RepayWay.values();
		for (RepayWay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RepayWay(String code, String name) {
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

	public static RepayWay parseByName(String name) {
		return nameMap.get(name);
	}

	public static RepayWay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
