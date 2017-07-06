package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 催收返款状态
 * @Class Name UrgeRepay
 * @author 王彬彬
 * @Create In 2015年12月25日
 */
public enum UrgeRepay {
	
	REPAY_TO_APPLY("0","待申请返款"),
	
	REPAY_TO("1","待返款"),
	
	REPAY_BACK("2","返款退回"),
	
	REPAIED("3","已返款");
	
	private static Map<String, UrgeRepay> nameMap = new HashMap<String, UrgeRepay>(
			10);
	private static Map<String, UrgeRepay> codeMap = new HashMap<String, UrgeRepay>(
			10);

	static {
		UrgeRepay[] allValues = UrgeRepay.values();
		for (UrgeRepay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private UrgeRepay(String code, String name) {
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

	public static UrgeRepay parseByName(String name) {
		return nameMap.get(name);
	}

	public static UrgeRepay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
