/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRsStatus.java
 * @Create By 王彬彬
 * @Create In 2016年2月1日 下午5:52:32
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 电销咨询状态
 * @Class Name RsStatus
 * @author 王彬彬
 * @Create In 2016年2月1日
 */
public enum RsStatus {
	CONTINUE_CONFIRM("0","继续跟踪"),
	
	CUSTOMER_GIVEUP("1","客户放弃"),
	
	INCONFORMITY ("2","不符合进件条件"),
	
	CUSTOMER_INTO("3","已进件"),
	
	STORE_GIVEUP("4","门店放弃"),
	
	SEND_TO_STORE("5","发送至门店"),
	
	NO_GET_ORDER("6","未取单"),
	
	GET_ORDER("7","已取单"),
	
	STORE_BACK("8","门店退回");

	private static Map<String, RsStatus> nameMap = new HashMap<String, RsStatus>(
			10);
	private static Map<String, RsStatus> codeMap = new HashMap<String, RsStatus>(
			10);

	static {
		RsStatus[] allValues = RsStatus.values();
		for (RsStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RsStatus(String code, String name) {
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

	public static RsStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static RsStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
