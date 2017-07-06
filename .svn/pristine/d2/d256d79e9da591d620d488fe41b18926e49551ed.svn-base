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
 * 【贷款账户状态】：正常/结清/逾期/转出/呆账     
 * @Class Name LoanDtlAccountStatus(贷款明细信息-账户状态)
 * @author 李静辉
 * @Create In 2016年1月13日
 */
public enum LoanDtlAccountStatus {
		/**
		* 
			0	正常
			1	结清
			2	逾期
			3	转出
			4	呆账
		 */
	NORMAL("5", "正常"),
	SETTLEMENT("1", "结清"),
	OVERDUE("2", "逾期"),
	TURN_OUT("3", "转出"),
	OF_BAD_DEBTS("4", "呆账");


	private static Map<String, LoanDtlAccountStatus> nameMap = new HashMap<String, LoanDtlAccountStatus>(
			100);
	private static Map<String, LoanDtlAccountStatus> codeMap = new HashMap<String, LoanDtlAccountStatus>(
			100);

	static {
		LoanDtlAccountStatus[] allValues = LoanDtlAccountStatus.values();
		for (LoanDtlAccountStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanDtlAccountStatus(String code, String name) {
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

	public static LoanDtlAccountStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanDtlAccountStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
