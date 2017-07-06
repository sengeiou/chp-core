/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:35:59
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 借款状态(放款后状态)
 * 
 * @Class Name LoanStatus（借款状态）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum LoanStatus {

	/**
	 * 还款中
	 */
	REPAYMENT(LoanApplyStatus.REPAYMENT.getCode(), LoanApplyStatus.REPAYMENT
			.getName()),

	/**
	 * 逾期
	 */
	OVERDUE(LoanApplyStatus.OVERDUE.getCode(), LoanApplyStatus.OVERDUE
			.getName()),

	/**
	 * 结清
	 */
	SETTLE(LoanApplyStatus.SETTLE.getCode(), LoanApplyStatus.SETTLE.getName()),

	/**
	 * 提前结清
	 */
	EARLY_SETTLE(LoanApplyStatus.EARLY_SETTLE.getCode(),
			LoanApplyStatus.EARLY_SETTLE.getName()),

//	/**
//	 * 提前结清待审核
//	 */
//	EARLY_SETTLE_VERIFY(LoanApplyStatus.EARLY_SETTLE_VERIFY.getCode(),
//			LoanApplyStatus.EARLY_SETTLE_VERIFY.getName()),

	/**
	 * 结清待确认
	 */
	SETTLE_CONFIRM(LoanApplyStatus.SETTLE_CONFIRM.getCode(),
			LoanApplyStatus.SETTLE_CONFIRM.getName());

	private static Map<String, LoanStatus> nameMap = new HashMap<String, LoanStatus>(
			10);
	private static Map<String, LoanStatus> codeMap = new HashMap<String, LoanStatus>(
			10);
	public static Map<String, String> statusMap = new Hashtable<String, String>();

	static {
		LoanStatus[] allValues = LoanStatus.values();
		for (LoanStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanStatus(String code, String name) {
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

	public static LoanStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	public static String getNameByCode(String code) {
		if (statusMap.isEmpty()) {
			statusMap.put(LoanStatus.REPAYMENT.code, LoanStatus.REPAYMENT.name);
			statusMap.put(LoanStatus.OVERDUE.code, LoanStatus.OVERDUE.name);
			statusMap.put(LoanStatus.EARLY_SETTLE.code,
					LoanStatus.EARLY_SETTLE.name);
//			statusMap.put(LoanStatus.EARLY_SETTLE_VERIFY.code,
//					LoanStatus.EARLY_SETTLE_VERIFY.name);
			statusMap.put(LoanStatus.SETTLE_CONFIRM.code,
					LoanStatus.SETTLE_CONFIRM.name);
			statusMap.put(LoanStatus.SETTLE.code, LoanStatus.SETTLE.name);
		}
		return statusMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
