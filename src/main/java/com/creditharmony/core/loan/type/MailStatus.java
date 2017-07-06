/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeLiveWith.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:26:09
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户管理表_邮寄状态
 * @Class Name MailStatus
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum MailStatus {

	TO_MAKE("0","待制作"),
	
	TO_SEARCH("1","待查找"),
	
	TO_SEND("2","待邮寄"),
	
	SENDED("3","已邮寄"),
	
	MAKING("4","制作中"),
	
	MAKED_FIALED("5","制作失败"),
	
	SEND_RETURN("6","已邮寄退回"),
	
	TO_SEND_RETURN("7","待邮寄退回"),
	
	TO_STORE("8","退回门店");
	
	private static Map<String, MailStatus> nameMap = new HashMap<String, MailStatus>(
			10);
	private static Map<String, MailStatus> codeMap = new HashMap<String, MailStatus>(
			10);

	static {
		MailStatus[] allValues = MailStatus.values();
		for (MailStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private MailStatus(String code, String name) {
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

	public static MailStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static MailStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
