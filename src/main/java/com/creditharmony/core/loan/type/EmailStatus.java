package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name EmailStatus(汇金邮件状态)
 * @author WJJ
 * @Create In 2017年1月6日
 */
public enum EmailStatus {

	ZERO("0", "电子协议未申请"),
	
	ONE("1", "电子协议待审核"),

	TWO("2", "电子协议发送失败"),

	THR("3", "电子协议申请退回"),
	
	FOU("4", "电子协议已发送"),

	FIV("5", "制作失败"),

	SIX("6", "已发送退回"),
	
	SEV("7", "待发送退回"),
	
	EIG("8", "退回门店");

	private static Map<String, EmailStatus> nameMap = new HashMap<String, EmailStatus>(
			10);
	private static Map<String, EmailStatus> codeMap = new HashMap<String, EmailStatus>(
			10);

	static {
		EmailStatus[] allValues = EmailStatus.values();
		for (EmailStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private EmailStatus(String code, String name) {
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

	public static EmailStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static EmailStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
