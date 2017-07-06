/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDeductStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:42:14
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name DeductStatus 划扣状态
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum DeductStatus {
	DEDUCT_FAILED("0","划扣失败"),
	
	DEDUCT_SUCCEED("1","划扣成功"),
	
	DEDUCT_PROCESS("2","划扣处理中");
	
	private static Map<String, DeductStatus> nameMap = new HashMap<String, DeductStatus>(
			10);
	private static Map<String, DeductStatus> codeMap = new HashMap<String, DeductStatus>(
			10);

	static {
		DeductStatus[] allValues = DeductStatus.values();
		for (DeductStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DeductStatus(String code, String name) {
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

	public static DeductStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
