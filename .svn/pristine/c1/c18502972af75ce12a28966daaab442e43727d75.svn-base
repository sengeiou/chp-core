package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name Name AccountType 第三方平台用账户类型
 * @author 施大勇
 * @Create In 2016年02月03日
 */
public enum AccountType {
	PERSONAL("11", "个人账户"),
	COMPANY("12", "企业账户"),
	PLATFORM("20", "平台账户");
	private static Map<String, AccountType> nameMap = new HashMap<String, AccountType>(10);
	private static Map<String, AccountType> codeMap = new HashMap<String, AccountType>(10);
	static {
		AccountType[] allValues = AccountType.values();
		for (AccountType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AccountType(String code, String name) {
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

	public static AccountType parseByName(String name) {
		return nameMap.get(name);
	}

	public static AccountType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
