/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeSmsType.java
 * @Create By 王彬彬
 * @Create In 2016年3月8日 下午9:50:04
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 汇金短信类型
 * @Class Name SmsType
 * @author 王彬彬
 * @Create In 2016年3月8日
 */
public enum SmsType {
	REMIND("0", "汇金还款提醒短信(当月)"),
	
	REMIND_NEXT("1", "汇金还款提醒短信(次月)"),

	JZHOPEN("2", "金账户开户"),
	
	HJ_PIN_VERIFY("3", "汇金签约短信验证"),
	
	HJ_ACCOUNT_REMIND("hjar", "汇金还款提醒存入账户短信"),
	
	HJ_CAR_PIN_SIGN("06", "车借确认先签署");
	
	

	private static Map<String, SmsType> nameMap = new HashMap<String, SmsType>(
			5);
	private static Map<String, SmsType> codeMap = new HashMap<String, SmsType>(
			5);

	static {
		SmsType[] allValues = SmsType.values();
		for (SmsType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SmsType(String code, String name) {
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

	public static SmsType parseByName(String name) {
		return nameMap.get(name);
	}

	public static SmsType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
