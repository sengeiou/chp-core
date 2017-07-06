package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name ContractType
 * @author 朱杰
 * @Create In 2016年6月21日
 */
public enum ContractType {
	HT("0", "合同"),

	XY("1", "协议");
	
	private static Map<String, ContractType> nameMap = new HashMap<String, ContractType>(
			10);
	private static Map<String, ContractType> codeMap = new HashMap<String, ContractType>(
			10);

	static {
		ContractType[] allValues = ContractType.values();
		for (ContractType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ContractType(String code, String name) {
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

	public static ContractType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ContractType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
