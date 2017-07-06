/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRepayApplyStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:00:44
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RepayApplyStatus（还款申请状态）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RepayApplyStatus {
	SPLIT("0", "待拆分"),

	SPLITED("1", "已拆分"),

	PRE_PAYMENT("2", "待划扣"),

	PRE_ACCOUNT_VERIFY("3", "待查账"),

	PRE_CHARGE("4", "待冲抵"),

	CHARGE_FAILED("5", "冲抵失败"),

	CHARGED("6", "冲抵成功"),

	REPAYMENT_RETURN("7", "还款退回"),

	REPAYMENT_GIVEUP("8", "还款放弃"),
	
	DEDUCTT_FAILED("9","划扣失败"),
	
	MATCH_FAILEN("10","匹配失败"),
	
	TO_PAYMENT("11","待还款"),
	
	HAS_PAYMENT("12","已还款");



	private static Map<String, RepayApplyStatus> nameMap = new HashMap<String, RepayApplyStatus>(
			10);
	private static Map<String, RepayApplyStatus> codeMap = new HashMap<String, RepayApplyStatus>(
			10);

	static {
		RepayApplyStatus[] allValues = RepayApplyStatus.values();
		for (RepayApplyStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RepayApplyStatus(String code, String name) {
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

	public static RepayApplyStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static RepayApplyStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
