/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCreditType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:38:45
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 债权类型
 * @Class Name CreditType 
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum CreditType {
	MORTGAGE("0","抵押类"),
	
	NOMORTGAGE("1","非抵押类");
	
	private static Map<String, CreditType> nameMap = new HashMap<String, CreditType>(
			10);
	private static Map<String, CreditType> codeMap = new HashMap<String, CreditType>(
			10);

	static {
		CreditType[] allValues = CreditType.values();
		for (CreditType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CreditType(String code, String name) {
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

	public static CreditType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CreditType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
