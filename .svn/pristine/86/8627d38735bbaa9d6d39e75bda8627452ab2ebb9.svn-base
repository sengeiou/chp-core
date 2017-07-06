/**
 * 
 */
package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;


/**
 * 第三方接口用存折、银行卡等类型
 * @author 施大勇
 * 2016年04月05日
 */
public enum CardOrBookType {
	BANKCARD("00", "卡"),
	PASSBOOK("01", "折");
	
	private static Map<String, CardOrBookType> nameMap = new HashMap<String, CardOrBookType>(5);
	private static Map<String, CardOrBookType> codeMap = new HashMap<String, CardOrBookType>(5);

	static {
		CardOrBookType[] allValues = CardOrBookType.values();
		for (CardOrBookType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CardOrBookType(String code, String name) {
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

	public static CardOrBookType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CardOrBookType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
