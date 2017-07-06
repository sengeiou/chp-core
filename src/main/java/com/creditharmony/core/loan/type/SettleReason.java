package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * (结清原因)
 * @Class Name SettleReason
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum SettleReason {
	CONTRACT_OVER("0","原合同到期，借款人还款义务履行完毕"),
	
	CONTRACT_EARLY("1","原合同到内，借款人提前清偿全部借款"),
	
	OTHER("2","其他");

	private static Map<String, SettleReason> nameMap = new HashMap<String, SettleReason>(
			10);
	private static Map<String, SettleReason> codeMap = new HashMap<String, SettleReason>(
			10);

	static {
		SettleReason[] allValues = SettleReason.values();
		for (SettleReason obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SettleReason(String code, String name) {
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

	public static SettleReason parseByName(String name) {
		return nameMap.get(name);
	}

	public static SettleReason parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
