/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.lend.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name LoanManFlag(借款人类型)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum LoanManFlag {
	
	MAIN_LOAN("0","主借人"),
	
	COBORROWE_LOAN("1","共借人"),
	
	MATE("2","配偶");

	private static Map<String, LoanManFlag> nameMap = new HashMap<String, LoanManFlag>(
			100);
	private static Map<String, LoanManFlag> codeMap = new HashMap<String, LoanManFlag>(
			100);

	static {
		LoanManFlag[] allValues = LoanManFlag.values();
		for (LoanManFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanManFlag(String code, String name) {
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

	public static LoanManFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanManFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
