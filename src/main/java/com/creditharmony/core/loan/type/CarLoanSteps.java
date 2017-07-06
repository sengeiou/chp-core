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
 * (车借审核步骤)
 * @Class Name CarLoanSteps
 * @author 李静辉
 * @Create In 2016年2月2日
 */
public enum CarLoanSteps {

	FIRST_AUDIT("1","初审"),
	RECHECK_AUDIT("2","复审"),
	FINAL_AUDIT("3","终审"),
	CONSULTATION("4","客户咨询"),
	APPRAISER("5","评估报告录入"),
	FACE_AUDIT_APPLY("6","申请"), 
	UPLOAD_MATERIAL("7","上传资料"),
	RATE_CHECK("8","审核费率"),
	SIGN("9","签署"),
	CONTRACT_PRODUCT("10","合同制作"),
	CONTRACT_UPLOAD("11","合同签约上传"),
	CONTRACT_CHECK("12","合同审核"),
	GRANT_CONFIRMED("13","款项确认"),
	CARD_NUMBER("14","分配卡号"),
	GRANT("15","放款"),
	GRANT_AUDIT("16","放款审核"),
	CURRENT_DEDUCTS("17","当日划扣"),
	PAST_DEDUCTS("18","以往划扣"),
	STORE_DEDUCTS("19","门店划扣费追回"),
	DEDUCTS_MATCHING("20","划扣费匹配"),
	REFUND("21","退款"), //数据_退款
	REFUND_AUDIT("22","退款审核"), //风控_退款审核
	CREDITOR_RIGHT("23","车借债权推送"),
	
	REPAYMENT("24","正常还款申请"),
	AHEAD_REPAYMENT("25","正常提前结清申请"),
	OVERDUE_REPAYMENT("26","逾期还款申请"),
	OVERDUE_AHEAD_REPAYMENT("27","逾期提前结清申请"),
	PENAL_SUM("28","违约金罚息还款申请"),
	EXTEND_REPAYMENT("29","展期费用还款申请"),
	
	JKFUB_AUDIT("30","借款服务部审核");
	

	
	private static Map<String, CarLoanSteps> nameMap = new HashMap<String, CarLoanSteps>(
			100);
	private static Map<String, CarLoanSteps> codeMap = new HashMap<String, CarLoanSteps>(
			100);

	static {
		CarLoanSteps[] allValues = CarLoanSteps.values();
		for (CarLoanSteps obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanSteps(String code, String name) {
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

	public static CarLoanSteps parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanSteps parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
