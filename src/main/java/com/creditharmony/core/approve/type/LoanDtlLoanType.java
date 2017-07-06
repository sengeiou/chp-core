package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @Class Name LoanDtlLoanType(贷款明细信息-贷款类型)
 * @author 李静辉
 * @Create In 2016年1月4日
 */
public enum LoanDtlLoanType {
	PERSONAL_INDIVIDUAL_HOUSING_LOANS("0","个人住房贷款"),
	PERSONAL_BUSINESS_LOANS("1","个人经营性贷款"),
	PEASANT_HOUSEHOLD_LOAN("2","农户贷款"),
	PERSONAL_CAR_LOANS("3","个人汽车贷款"),
	PERSONAL_HOUSING_ACCUMULATION_FUND_LOANS("4","个人住房公积金贷款"),
	PERSONAL_COMMERCIAL_HOUSING_LOANS("5","个人商用房（包括商住两用）贷款"),
	INDIVIDUAL_STUDENT_LOANS("6","个人助学贷款"),
	PERSONAL_CONSUMPTION_LOANS("7","个人消费贷款"),
	Other("8","其他")
	;

	private static Map<String, LoanDtlLoanType> nameMap = new HashMap<String, LoanDtlLoanType>(
			100);
	private static Map<String, LoanDtlLoanType> codeMap = new HashMap<String, LoanDtlLoanType>(
			100);

	static {
		LoanDtlLoanType[] allValues = LoanDtlLoanType.values();
		for (LoanDtlLoanType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanDtlLoanType(String code, String name) {
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

	public static LoanDtlLoanType parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanDtlLoanType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
