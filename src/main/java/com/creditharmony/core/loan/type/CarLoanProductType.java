package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 车借产品类型
 * @Class Name CarLoanProductType
 * @author 陈伟东
 * @Create In 2016年2月16日
 */
public enum CarLoanProductType {
	GPS("CJ01","GPS"),
	TRANSFER("CJ02","移交"),
	PLEDGE("CJ03","质押");

	private static Map<String, CarLoanProductType> nameMap = new HashMap<String, CarLoanProductType>(
			100);
	private static Map<String, CarLoanProductType> codeMap = new HashMap<String, CarLoanProductType>(
			100);

	static {
		CarLoanProductType[] allValues = CarLoanProductType.values();
		for (CarLoanProductType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanProductType(String code, String name) {
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

	public static CarLoanProductType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanProductType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
