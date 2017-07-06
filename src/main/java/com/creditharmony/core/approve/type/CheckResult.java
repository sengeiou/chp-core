/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核结果类型
 * @Class Name CheckResult
 * @author 刘燕军
 * @Create In 2016年2月24日
 */
public enum CheckResult {

	XS_FIRST_BACK("11","退回"),
	XS_FIRST_REFUSAL("12","拒借"),
	XS_FIRST_SUBMIT("13","提交"),
	XS_FIRST_TOREFUSAL("14","拟拒借"),
	XS_FIRST_ABANDON("15","放弃"),
	XS_FIRST_ANTIFRAUD("16","提报反欺诈"),
	XS_FIRST_OUTVISIT("17","外访"),
	
	XS_SECOND_PASS("20","通过"),	
	XS_SECOND_BACK("21","退回协商"),
	XS_SECOND_REFUSAL("22","拒借"),
	XS_SECOND_SUBMIT("23","提交"),
	
	XS_THRED_PASS("30","通过"),	
	XS_THRED_BACK("31","退回协商"),
	XS_THRED_REFUSAL("32","拒借"),
	XS_THRED_SUBMIT("33","提交"),	
	
	XS_FINAL_PASS("40","通过"),	
	XS_FINAL_BACK("41","退回协商"),
	XS_FINAL_REFUSAL("42","拒借"),
	
	FY_FIRST_BACK("51","退回"),
	FY_FIRST_REFUSAL("52","拒借"),
	FY_FIRST_SUBMIT("53","提交"),
	FY_FIRST_TOREFUSAL("54","拟拒借"),
	FY_FIRST_ABANDON("55","放弃"),
	FY_FIRST_ANTIFRAUD("56","提报反欺诈"),
	FY_FIRST_OUTVISIT("57","外访"),
	
	FY_SECOND_PASS("60","通过"),	
	FY_SECOND_BACK("61","退回协商"),
	FY_SECOND_REFUSAL("62","拒借"),
	FY_SECOND_SUBMIT("63","提交"),
	
	FY_FINAL_PASS("70","通过"),	
	FY_FINAL_BACK("71","退回协商"),
	FY_FINAL_REFUSAL("72","拒借"),
	
	FRAUDS_CREDIT_BACK("81","退回"),
	FRAUDS_CREDIT_LIMING ("82","加灰"),
	FRAUDS_CREDIT_BOLDING("83","加黑"),	
	FRAUDS_CREDIT_INNOCENCE("84","清白件"),
	
	APPLY_ENGINE_BACK("91","退回"),
	APPLY_ENGINE_REFUSAL("92","拒借"),
	APPLY_ENGINE_SUBMIT("93","提交"),
	APPLY_ENGINE_ABANDON("94","放弃"),
	
	FRAUDS_ENGINE_TRIGGER("101","触发"),
	FRAUDS_ENGINE_NOTRIGGER("102","未触发"),
	
	SYS_OUTVISIT_OVERTIME("111","外访超时"),
	SYS_BACKSTORE_OVERTIME("112","回退超时"),
	REMARK("113","综合内勤岗备注"),
	;


	private static Map<String, CheckResult> nameMap = new HashMap<String, CheckResult>(
			100);
	private static Map<String, CheckResult> codeMap = new HashMap<String, CheckResult>(
			100);

	static {
		CheckResult[] allValues = CheckResult.values();
		for (CheckResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CheckResult(String code, String name) {
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

	public static CheckResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static CheckResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
