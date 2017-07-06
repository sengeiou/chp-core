package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 委托状态
 * 
 * @Class Name TrustmentStatus
 * @author 朱杰
 * @Create In 2016年3月9日
 */
public enum TrustmentStatus {
	WWT("0","未委托"),
	YWT("1","已委托");

	private static Map<String, TrustmentStatus> nameMap = new HashMap<String, TrustmentStatus>(
			100);
	private static Map<String, TrustmentStatus> codeMap = new HashMap<String, TrustmentStatus>(
			100);

	static {
		TrustmentStatus[] allValues = TrustmentStatus.values();
		for (TrustmentStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TrustmentStatus(String code, String name) {
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

	public static TrustmentStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static TrustmentStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
