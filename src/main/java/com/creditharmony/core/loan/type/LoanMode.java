package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * (借款模式区分)
 * 
 * @Class Name LoanMode
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum LoanMode {
	FTG("0", "非TG"),
	
	TG("1", "TG");
	
	private static Map<String, LoanMode> nameMap = new HashMap<String, LoanMode>(10);
	private static Map<String, LoanMode> codeMap = new HashMap<String, LoanMode>(10);

	static {
		LoanMode[] allValues = LoanMode.values();
		for (LoanMode obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanMode(String code, String name) {
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

	public static LoanMode parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanMode parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
