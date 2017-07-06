package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name AccountStatus(借款账户状态)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum AccountStatus {
	NORMAL("0", "正常"),

	SETTLE("1", "结清"),

	OVERDUE("2", "逾期"),

	PREPAYMENT("3", "提前结清");

	private static Map<String, AccountStatus> nameMap = new HashMap<String, AccountStatus>(
			10);
	private static Map<String, AccountStatus> codeMap = new HashMap<String, AccountStatus>(
			10);

	static {
		AccountStatus[] allValues = AccountStatus.values();
		for (AccountStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AccountStatus(String code, String name) {
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

	public static AccountStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static AccountStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
