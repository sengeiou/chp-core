/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeAgainstStatus.java
 * @Create By 王彬彬
 * @Create In 2016年1月5日 上午11:26:59
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name AgainstStatus
 * @author 王彬彬
 * @Create In 2016年1月5日
 */
public enum AgainstStatus {
	NO_AGAINST("0", "未冲抵"),

	AGAINST_VERIFY("1", "冲抵待审核"),

	AGAINST_CONFIRM("2", "冲抵待确认"),

	AIAINST("3", "冲抵成功"),
	
	PAYBACK_RETURN("4", "借款人服务部退回"),
	
	RIS_PAYBACK_RETURN("5","风控退回"),
	
	AGAINST_FAILED("6","冲抵失败");
	
	private static Map<String, AgainstStatus> nameMap = new HashMap<String, AgainstStatus>(
			10);
	private static Map<String, AgainstStatus> codeMap = new HashMap<String, AgainstStatus>(
			10);

	static {
		AgainstStatus[] allValues = AgainstStatus.values();
		for (AgainstStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AgainstStatus(String code, String name) {
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

	public static AgainstStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static AgainstStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
