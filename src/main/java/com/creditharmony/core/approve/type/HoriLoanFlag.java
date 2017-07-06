/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name HoriLoanFlag(同业借款标记)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum HoriLoanFlag {
	
	YES("1","有"),
	NO("0","无")
;


	private static Map<String, HoriLoanFlag> nameMap = new HashMap<String, HoriLoanFlag>(
			100);
	private static Map<String, HoriLoanFlag> codeMap = new HashMap<String, HoriLoanFlag>(
			100);

	static {
		HoriLoanFlag[] allValues = HoriLoanFlag.values();
		for (HoriLoanFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private HoriLoanFlag(String code, String name) {
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

	public static HoriLoanFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static HoriLoanFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
