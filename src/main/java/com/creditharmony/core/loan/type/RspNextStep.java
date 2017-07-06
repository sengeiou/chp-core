/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRspNextStep.java
 * @Create By 王彬彬
 * @Create In 2016年2月2日 上午10:37:41
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RspNextStep
 * @author 王彬彬
 * @Create In 2016年2月2日
 */
public enum RspNextStep {
	CONTINUE_CONFIRM("0", "继续跟踪"),

	CUSTOMER_GIVEUP("1", "客户放弃"),

	INCONFORMITY("2", "不符合进件条件"),

	SEND_TO_STORE("5", "发送至门店"),
	
	STORE_GIVEUP("4", "门店放弃");
	
	private static Map<String, RspNextStep> nameMap = new HashMap<String, RspNextStep>(
			10);
	private static Map<String, RspNextStep> codeMap = new HashMap<String, RspNextStep>(
			10);

	static {
		RspNextStep[] allValues = RspNextStep.values();
		for (RspNextStep obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RspNextStep(String code, String name) {
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

	public static RspNextStep parseByName(String name) {
		return nameMap.get(name);
	}

	public static RspNextStep parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
