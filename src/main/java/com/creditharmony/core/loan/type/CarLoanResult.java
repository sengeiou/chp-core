/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * (车借审核结果)
 * @Class Name CarLoanResult
 * @author 李静辉
 * @Create In 2016年2月2日
 */
public enum CarLoanResult {

	THROUGH              ("1","通过"),
	CONDITIONAL_THROUGH  ("2","附条件通过"),
	REFUSED              ("3","拒绝"),
	BACK                 ("4","退回"),
	CUSTOMER_GIVE_UP     ("5","客户放弃"),
	DETERMINED           ("6","待定"),
	DELAY         	  ("7","延时处理");
	
	private static Map<String, CarLoanResult> nameMap = new HashMap<String, CarLoanResult>(
			100);
	private static Map<String, CarLoanResult> codeMap = new HashMap<String, CarLoanResult>(
			100);

	static {
		CarLoanResult[] allValues = CarLoanResult.values();
		for (CarLoanResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanResult(String code, String name) {
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

	public static CarLoanResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
