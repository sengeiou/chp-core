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
 * @Class Name SalaryTraceFlag(工资流水标记)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum SalaryTraceFlag {
	COMMONLY_USED_SAVINGS("0","常用储蓄"),
	PAY_WATER("1","工资流水");


	private static Map<String, SalaryTraceFlag> nameMap = new HashMap<String, SalaryTraceFlag>(
			100);
	private static Map<String, SalaryTraceFlag> codeMap = new HashMap<String, SalaryTraceFlag>(
			100);

	static {
		SalaryTraceFlag[] allValues = SalaryTraceFlag.values();
		for (SalaryTraceFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SalaryTraceFlag(String code, String name) {
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

	public static SalaryTraceFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static SalaryTraceFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
