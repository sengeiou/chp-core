/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRspNextStep.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:12:13
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RspNextStep 电销咨询下一步
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum NextStep {
	CONTINUE_CONFIRM("0","继续跟踪"),
	
	CUSTOMER_GIVEUP("1","客户放弃"),
	
	INCONFORMITY ("2","不符合进件条件"),
	
	CUSTOMER_INTO("3","已进件"),
	
	STORE_GIVEUP("4","门店放弃"),
	
	TO_APPLY("5","待申请");
	
	private static Map<String, NextStep> nameMap = new HashMap<String, NextStep>(
			10);
	private static Map<String, NextStep> codeMap = new HashMap<String, NextStep>(
			10);

	static {
		NextStep[] allValues = NextStep.values();
		for (NextStep obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private NextStep(String code, String name) {
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

	public static NextStep parseByName(String name) {
		return nameMap.get(name);
	}

	public static NextStep parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
