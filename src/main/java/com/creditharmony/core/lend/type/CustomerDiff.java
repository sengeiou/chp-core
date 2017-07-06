package com.creditharmony.core.lend.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name CustomerDiff
 * @author 王彬彬
 * @Create In 2015年12月25日
 */
public enum CustomerDiff {
	WORKING("1","工薪类"),
	
	OPERATING("0","经营类");
	
	private static Map<String, CustomerDiff> nameMap = new HashMap<String, CustomerDiff>(
			10);
	private static Map<String, CustomerDiff> codeMap = new HashMap<String, CustomerDiff>(
			10);

	static {
		CustomerDiff[] allValues = CustomerDiff.values();
		for (CustomerDiff obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CustomerDiff(String code, String name) {
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

	public static CustomerDiff parseByName(String name) {
		return nameMap.get(name);
	}

	public static CustomerDiff parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
