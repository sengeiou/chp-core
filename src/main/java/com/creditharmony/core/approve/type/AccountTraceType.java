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
 * @Class Name AccountTraceType(账户流水类型)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum AccountTraceType {
	PERSONAL_WATER_BILLS("0","个人卡流水"),
	PUBLIC_WATER_BILLS("1","对公流水");


	private static Map<String, AccountTraceType> nameMap = new HashMap<String, AccountTraceType>(
			100);
	private static Map<String, AccountTraceType> codeMap = new HashMap<String, AccountTraceType>(
			100);

	static {
		AccountTraceType[] allValues = AccountTraceType.values();
		for (AccountTraceType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AccountTraceType(String code, String name) {
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

	public static AccountTraceType parseByName(String name) {
		return nameMap.get(name);
	}

	public static AccountTraceType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
