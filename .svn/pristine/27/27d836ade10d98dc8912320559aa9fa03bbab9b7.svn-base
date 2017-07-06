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
 * @Class Name SendEmailStatus(邮件发送状态)
 * @author 于飞
 * @Create In 2016年11月02日
 */
public enum SendEmailStatus {
	UNSEND("0","未发送"),
	
	SUCCESS("1","发送成功"),
	
	UNUSE("2","作废"),
	
	FAIL("3","发送失败");
	
	private static Map<String, SendEmailStatus> nameMap = new HashMap<String, SendEmailStatus>(
			10);
	private static Map<String, SendEmailStatus> codeMap = new HashMap<String, SendEmailStatus>(
			10);

	static {
		SendEmailStatus[] allValues = SendEmailStatus.values();
		for (SendEmailStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SendEmailStatus(String code, String name) {
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

	public static SendEmailStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static SendEmailStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
