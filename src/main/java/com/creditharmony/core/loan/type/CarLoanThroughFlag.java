package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 车借通过标识
 * @Class Name CarLoanThroughFlag
 * @author 申诗阔
 * @Create In 2016年5月26日
 */
public enum CarLoanThroughFlag {

	CONDITIONAL		("1", "附条件"),
	P2P				("2", "P2P"),
	HARMONY			("3", "财富");
	
	private static Map<String, CarLoanThroughFlag> nameMap = new HashMap<String, CarLoanThroughFlag>(
			3);
	private static Map<String, CarLoanThroughFlag> codeMap = new HashMap<String, CarLoanThroughFlag>(
			3);

	static {
		CarLoanThroughFlag[] allValues = CarLoanThroughFlag.values();
		for (CarLoanThroughFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanThroughFlag(String code, String name) {
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

	public static CarLoanThroughFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanThroughFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
