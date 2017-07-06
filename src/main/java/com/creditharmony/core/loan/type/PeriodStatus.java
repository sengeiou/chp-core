/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typePeriodStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:07:22
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name PeriodStatus(期供状态)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum PeriodStatus {
	REPAYMENT("0", "待还款"),

	OVERDUE("1", "逾期"),

	REPLEVY("2", "追回"),

	PAID("3", "已还款");

	private static Map<String, PeriodStatus> nameMap = new HashMap<String, PeriodStatus>(
			10);
	private static Map<String, PeriodStatus> codeMap = new HashMap<String, PeriodStatus>(
			10);

	static {
		PeriodStatus[] allValues = PeriodStatus.values();
		for (PeriodStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PeriodStatus(String code, String name) {
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

	public static PeriodStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static PeriodStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
