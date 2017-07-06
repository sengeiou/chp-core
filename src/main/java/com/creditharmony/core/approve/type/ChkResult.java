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
 * @Class Name ChkResult（审核结果）
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum ChkResult {THROUGH("0","通过"),
	REFUSE_TO_BORROW("1","拒借"),
	TO_REFUSE_TO_BORROW("2","拟拒借");


	private static Map<String, ChkResult> nameMap = new HashMap<String, ChkResult>(
			100);
	private static Map<String, ChkResult> codeMap = new HashMap<String, ChkResult>(
			100);

	static {
		ChkResult[] allValues = ChkResult.values();
		for (ChkResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ChkResult(String code, String name) {
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

	public static ChkResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static ChkResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
