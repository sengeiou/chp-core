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
 * @Class Name LoanManFlag(审核步骤类型)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum CheckType {
	XS_FIRST_CREDIT_AUDIT("1","信审初审"),
	XS_SECOND_CREDIT_AUDIT("2","信审复审"),
	XS_THRED_CREDIT_AUDIT("3","信审终审"),
	XS_FINAL_CREDIT_AUDIT("4","信审高级终审"),
	FY_FIRST_CREDIT_AUDIT("5","复议初审"),
	FY_SECOND_CREDIT_AUDIT("6","复议复审"),
	FY_FINAL_CREDIT_AUDIT("7","复议终审"),
	FRAUDS_CREDIT_AUDIT("8","反欺诈判定"),
	APPLY_ENGINE_AUDIT("9","规则引擎"),
	FRAUDS_ENGINE_AUDIT("10","反欺诈引擎判定"),
	SYS_AUTO_AUDIT("11","系统判定"),
	DECSISON_ENGINE_AUDIT("12","决策引擎")
	;


	private static Map<String, CheckType> nameMap = new HashMap<String, CheckType>(
			100);
	private static Map<String, CheckType> codeMap = new HashMap<String, CheckType>(
			100);

	static {
		CheckType[] allValues = CheckType.values();
		for (CheckType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CheckType(String code, String name) {
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

	public static CheckType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CheckType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
