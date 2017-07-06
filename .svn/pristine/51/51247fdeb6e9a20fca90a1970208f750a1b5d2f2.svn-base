/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeVerityStatus.java
 * @Create By 王彬彬
 * @Create In 2016年3月8日 下午6:30:04
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name VerityStatus
 * @author 王彬彬
 * @Create In 2016年3月8日
 */
public enum VerityStatus {
	PASS("0","审核通过"),
	
	RETURN("1","审核退回");
	

	private static Map<String, VerityStatus> nameMap = new HashMap<String, VerityStatus>(
			20);
	private static Map<String, VerityStatus> codeMap = new HashMap<String, VerityStatus>(
			20);

	static {
		VerityStatus[] allValues = VerityStatus.values();
		for (VerityStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private VerityStatus(String code, String name) {
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

	public static VerityStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static VerityStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
