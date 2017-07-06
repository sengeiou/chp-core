/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeChannelFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:43:08
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name EmailType(邮件发送类型)
 * @author 于飞
 * @Create In 2016年11月02日
 */
public enum EmailType {
	PAYBACKREMIND("1","还款提醒邮件"),
	
	SPRINGBUSINESS("2","春节业务提醒邮件"),
	
	NATIONALBUSINESS("3","国庆节业务提醒邮件"),
	
	BIRTHDAYBLESS("4","生日祝福邮件"),
	
	NEWYEARBLESS("5","元旦祝福邮件"),
	
	SPRINGBLESS("6","春节祝福邮件"),
	
	ZHONGQIUBLESS("7","中秋节祝福邮件"),
	
	DUANWUBLESS("8","端午节祝福邮件");
	
	private static Map<String, EmailType> nameMap = new HashMap<String, EmailType>(
			10);
	private static Map<String, EmailType> codeMap = new HashMap<String, EmailType>(
			10);

	static {
		EmailType[] allValues = EmailType.values();
		for (EmailType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private EmailType(String code, String name) {
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

	public static EmailType parseByName(String name) {
		return nameMap.get(name);
	}

	public static EmailType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
