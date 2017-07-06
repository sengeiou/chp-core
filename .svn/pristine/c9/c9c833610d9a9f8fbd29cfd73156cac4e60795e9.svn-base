package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 查账匹配结果
 * @Class Name BankSerialCheck
 * @author 王彬彬
 * @Create In 2015年12月25日
 */
public enum BankSerialCheck {
	
	CHECKE_SUCCEED("0","未查账"),
	
	OFFLINE_CHECK("1","待人工查账"),
	
	CHECKE_OVER("2","已查账"),
	
	CHECKE_FAILED("3","查账失败");

	private static Map<String, BankSerialCheck> nameMap = new HashMap<String, BankSerialCheck>(
			10);
	private static Map<String, BankSerialCheck> codeMap = new HashMap<String, BankSerialCheck>(
			10);

	static {
		BankSerialCheck[] allValues = BankSerialCheck.values();
		for (BankSerialCheck obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private BankSerialCheck(String code, String name) {
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

	public static BankSerialCheck parseByName(String name) {
		return nameMap.get(name);
	}

	public static BankSerialCheck parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
