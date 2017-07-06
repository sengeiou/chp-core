/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRemarkType.java
 * @Create By 王彬彬
 * @Create In 2016年2月25日 下午4:09:58
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 备注类型
 * @Class Name RemarkType
 * @author 王彬彬
 * @Create In 2016年2月25日
 */
public enum RemarkType {
	LoanFlag("0","汇金"),
	
	APPROVE("1","汇诚");
	
	private static Map<String, RemarkType> nameMap = new HashMap<String, RemarkType>(
			10);
	private static Map<String, RemarkType> codeMap = new HashMap<String, RemarkType>(
			10);

	static {
		RemarkType[] allValues = RemarkType.values();
		for (RemarkType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RemarkType(String code, String name) {
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

	public static RemarkType parseByName(String name) {
		return nameMap.get(name);
	}

	public static RemarkType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
