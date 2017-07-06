package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 借款期限
 * @Class Name CarLoanDeadline
 * @author 陈伟东
 * @Create In 2016年2月16日
 */
public enum CarLoanDeadline {
	THIRTY("0","30"),
	NINETY("1","90"),
	ONE_HUNDRED_EIGHTY("2","180"),
	TWO_HUNDRED_SEVENTY("3","270"),
	THREE_HUNDRED_SIXTY("4","360");
	

	private static Map<String, CarLoanDeadline> nameMap = new HashMap<String, CarLoanDeadline>(
			100);
	private static Map<String, CarLoanDeadline> codeMap = new HashMap<String, CarLoanDeadline>(
			100);

	static {
		CarLoanDeadline[] allValues = CarLoanDeadline.values();
		for (CarLoanDeadline obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanDeadline(String code, String name) {
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

	public static CarLoanDeadline parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanDeadline parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
