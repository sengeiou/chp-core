/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeFrozenReason.java
 * @Create By 王彬彬
 * @Create In 2016年3月3日 上午9:58:58
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 冻结原因
 * @Class Name FrozenReason
 * @author 王彬彬
 * @Create In 2016年3月3日
 */
public enum FrozenReason {
	RISK_STOP("0","风险拦截"),
	
	CUSTOMER_GIVEUP("1","客户放弃"),
	
	OTHER("2","其他");
	
	private static Map<String, FrozenReason> nameMap = new HashMap<String, FrozenReason>(
			10);
	private static Map<String, FrozenReason> codeMap = new HashMap<String, FrozenReason>(
			10);

	static {
		FrozenReason[] allValues = FrozenReason.values();
		for (FrozenReason obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FrozenReason(String code, String name) {
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

	public static FrozenReason parseByName(String name) {
		return nameMap.get(name);
	}

	public static FrozenReason parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
