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
 * @Class Name EvalResult(评估结果)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum EvalResult {
	NORMAL("0","正常"),
	ABNORMAL("1","异常"),
	INVALID("2","无效")
	;


	private static Map<String, EvalResult> nameMap = new HashMap<String, EvalResult>(
			100);
	private static Map<String, EvalResult> codeMap = new HashMap<String, EvalResult>(
			100);

	static {
		EvalResult[] allValues = EvalResult.values();
		for (EvalResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private EvalResult(String code, String name) {
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

	public static EvalResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static EvalResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
