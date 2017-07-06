/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRepayType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:03:02
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RepayType(还款类型)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RepayType {
	COLLECTION_PAYMET("0", "集中划扣"),

	PREPAYMENT("1", "提前还款"),

	OVERDUE_REPAYMET("2", "逾期还款"),

	EARLY_SETTLE("3", "提前结清"),

	ACCOUNT_CHECK("4", "还款日查账"),
	
	PAYBACK_APPLY("5", "还款申请");

	private static Map<String, RepayType> nameMap = new HashMap<String, RepayType>(
			10);
	private static Map<String, RepayType> codeMap = new HashMap<String, RepayType>(
			10);

	static {
		RepayType[] allValues = RepayType.values();
		for (RepayType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RepayType(String code, String name) {
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

	public static RepayType parseByName(String name) {
		return nameMap.get(name);
	}

	public static RepayType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
