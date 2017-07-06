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
 * @Class Name CreditCardAccountStatus 【信用卡账户状态】：正常/销户/未激活/止付/冻结/呆账/逾期 
 * @author 李静辉
 * @Create In 2016年1月13日
 */
public enum CreditCardAccountStatus {
		/**
			 * 
		0	正常
		1	销户
		2	未激活
		3	止付
		4	冻结
		5	呆账
		 */
	NORMAL("1", "正常"),
	HOUSEHOLDS("2", "销户"),
	NOT_ACTIVATED("3", "未激活"),
	STOP("4", "止付"),
	FREEZE("5", "冻结"),
	OF_BAD_DEBTS("6", "呆账"),
	OVERDUE("7","逾期");


	private static Map<String, CreditCardAccountStatus> nameMap = new HashMap<String, CreditCardAccountStatus>(
			100);
	private static Map<String, CreditCardAccountStatus> codeMap = new HashMap<String, CreditCardAccountStatus>(
			100);

	static {
		CreditCardAccountStatus[] allValues = CreditCardAccountStatus.values();
		for (CreditCardAccountStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CreditCardAccountStatus(String code, String name) {
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

	public static CreditCardAccountStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static CreditCardAccountStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
