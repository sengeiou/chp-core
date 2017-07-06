package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 债权区分标识
 * @Class Name LoanDistinguish
 * @author 周俊
 * @Create In 2016年4月18日
 */
public enum LoanDistinguish {
	JX("1","JX"),
	DJR("2","DJR"),
	HJ("3","HJ");
	
	private static Map<String, LoanDistinguish> nameMap = new HashMap<String, LoanDistinguish>();
	private static Map<String, LoanDistinguish> codeMap = new HashMap<String, LoanDistinguish>();
	
	static {
		LoanDistinguish[] allValues = LoanDistinguish.values();
		for (LoanDistinguish obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}
	
	private String code;
	private String name;
	
	private LoanDistinguish(String code,String name){
		this.setName(name);
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static LoanDistinguish parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanDistinguish parseByCode(String code) {
		return codeMap.get(code);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
}
