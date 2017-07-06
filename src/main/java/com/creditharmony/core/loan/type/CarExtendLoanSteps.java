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
 * (车借展期审核步骤)
 * @Class Name CarExtendLoanSteps
 * @author 葛志超
 * @Create In 2016年6月12日
 */
public enum CarExtendLoanSteps {

     REVIEW_APPLY ("1", "申请"),
     RECHECK_AUDIT("2","复审"),
 	 FINAL_AUDIT("3","终审"),
	 UPLOAD_DATA ("4", "上传资料"),

	 APPRAISER_ENTRY ("5", "评估报告录入"),
	
	 FIRST_AUDIT ("6", "初审"),
	
	 RATE_CHECK ("7", "审核费率"),
	
	 CONFIRM_SIGNING ("8", "签署"),
	
	 CONTRACT_PRODUCTION ("30", "合同制作"),
	
	 CONTRACT_SIGNING_UPLOAD ("31", "合同签约上传"),
	
	 CONTRACT_CHECK ("32", "合同审核");
	
	
	private static Map<String, CarExtendLoanSteps> nameMap = new HashMap<String, CarExtendLoanSteps>(
			100);
	private static Map<String, CarExtendLoanSteps> codeMap = new HashMap<String, CarExtendLoanSteps>(
			100);

	static {
		CarExtendLoanSteps[] allValues = CarExtendLoanSteps.values();
		for (CarExtendLoanSteps obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarExtendLoanSteps(String code, String name) {
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

	public static CarExtendLoanSteps parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarExtendLoanSteps parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
