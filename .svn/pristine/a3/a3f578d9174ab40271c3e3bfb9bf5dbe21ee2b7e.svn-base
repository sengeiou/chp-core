package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name EmailTemplateType(汇金邮件模板类型)
 * @author WJJ
 * @Create In 2016年12月7日
 */
public enum EmailTemplateType {

	ONE("1", "普通电子结清通知书"),

	TWO("2", "ZCJ电子结清通知书"),

	THR("3", "金信电子结清通知书"),
	
	FOU("4", "普通电子协议"),

	FIV("5", "ZCJ电子协议"),

	SIX("6", "金信电子协议"),
	
	SEV("7", "车借电子协议");

	private static Map<String, EmailTemplateType> nameMap = new HashMap<String, EmailTemplateType>(
			10);
	private static Map<String, EmailTemplateType> codeMap = new HashMap<String, EmailTemplateType>(
			10);

	static {
		EmailTemplateType[] allValues = EmailTemplateType.values();
		for (EmailTemplateType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private EmailTemplateType(String code, String name) {
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

	public static EmailTemplateType parseByName(String name) {
		return nameMap.get(name);
	}

	public static EmailTemplateType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
