/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeLoanUse.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:31:52
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name LoanUse（借款用途）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum LoanUse {
	OPERATERUN("0", "经营"),

	TURNOVER("1", "周转"),

	CONSUME("2", "消费"),
	
	BUYCAR("3", "购车"),
	
	FITMENT("4", "装修"),
	
	DAILY_CONSUMPTION("5", "日常生活消费"),
	
	EDUCATION("6", "教育培训"),
	
	TOURISM("7", "旅游"),
	
	MEDICAL("8", "医疗"),
	
	MARRIAGE("9", "婚嫁"),
	
	EXPAND_PRODUCTION_AND_BUSINESS("10", "扩大生产经营"),
	
	SHOPPING("11", "购买货物/原材料/设备"),
	
	OTHER("12", "其它");

	private static Map<String, LoanUse> nameMap = new HashMap<String, LoanUse>(
			10);
	private static Map<String, LoanUse> codeMap = new HashMap<String, LoanUse>(
			10);

	static {
		LoanUse[] allValues = LoanUse.values();
		for (LoanUse obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanUse(String code, String name) {
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

	public static LoanUse parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanUse parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
