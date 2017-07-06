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
 * @Class Name PledgeFlag(抵押标志)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum PledgeFlag {
	MORTGAGE("0","抵押"),
	NO_MORTGAGE("1","未抵押")
	;


	private static Map<String, PledgeFlag> nameMap = new HashMap<String, PledgeFlag>(
			100);
	private static Map<String, PledgeFlag> codeMap = new HashMap<String, PledgeFlag>(
			100);

	static {
		PledgeFlag[] allValues = PledgeFlag.values();
		for (PledgeFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PledgeFlag(String code, String name) {
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

	public static PledgeFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static PledgeFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
