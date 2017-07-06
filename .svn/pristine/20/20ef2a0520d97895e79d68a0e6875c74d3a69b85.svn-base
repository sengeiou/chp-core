/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.lend.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name LoanProductType (信借產品類型)
 * @author 李静辉
 * @Create In 2016年1月13日
 */
public enum LoanProductType {
	/**
	 * 
1	薪水借
2	精英借A
3	精英借B
4	优卡借
5	优房借
6	楼易借
7	小微企业借
8	老板借
	 */
	SALARY_BY("1","薪水借"),
	ELITE_BORROW_A("2","精英借A"),
	ELITE_BORROW_B("3","精英借B"),
	BY_YOUKA("4","优卡借"),
	EXCELLENT_ROOM_BORROW("5","优房借"),
	FLOOR_EASY_TO_BORROW("6","楼易借"),
	SMALL_AND_MICRO_ENTERPRISES_TO_BORROW("7","小微企业借"),
	BOSS_TO_BORROW("8","老板借");

	private static Map<String, LoanProductType> nameMap = new HashMap<String, LoanProductType>(
			100);
	private static Map<String, LoanProductType> codeMap = new HashMap<String, LoanProductType>(
			100);

	static {
		LoanProductType[] allValues = LoanProductType.values();
		for (LoanProductType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanProductType(String code, String name) {
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

	public static LoanProductType parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanProductType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
