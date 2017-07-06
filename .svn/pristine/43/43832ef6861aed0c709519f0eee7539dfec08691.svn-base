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
 * （借款申请状态）
 * 
 * @Class Name LoanApplyStatus
 * @author 王彬彬
 * @Create In 2015年12月17日
 */
public enum LoanApplyStatus {
	INFORMATION_UPLOAD("0", "待上传资料",""),

	STORE_REVERIFY("1", "待门店复核",""),

	RULE_ENGINE("2", "待汇诚审核",""),

	ANTIFRAUD_ENGINE("3", "反欺诈引擎待处理",""),

	ANTIFRAUD_PENDING("4", "反欺诈审核中",""),

	SYS_FILTER_REJECT_ANTIFRAUD("5", "系统过滤（拒）待反欺诈",""),

	SYS_FILTER_GIVEUP_ANTIFRAUD("812", "系统过滤（弃）待反欺诈",""),

	SYS_FILTER_PASS_ANTIFRAUD("6", "系统过滤（过）待反欺诈",""),

	FRAUD_AFFIRMED_BLACK("7", "欺诈认定黑名单",""),

	FRAUD_AFFIRMED_GRAY("8", "欺诈认定灰名单",""),

	CHECK_SUBMIT_ANTIFRAUD("9", "初审提报待反欺诈",""),

	AUDIT_SUBMIT_ANTIFRAUD("10", "稽核提报待反欺诈",""),

	RECONSIDER_SUBMIT_ANTIFRAUD("11", "复议提报待反欺诈",""),

	ANTIFRAUD_BACK_CHECK("12", "反欺诈退回待初审",""),

	ANTIFRAUD_BACK_RECONSIDER_CHECK("13", "反欺诈退回待复议初审",""),

	PRELIMINARY_CHECK("14", "待初审",""),

	CHECK_PENDING("15", "初审审核中",""),

	RECHECK_CONSULT_CHECK("16", "复审协商待初审",""),

	STORE_ALLOT_VISIT("17", "待门店分配外访",""),

	STORE_VISIT("18", "待门店外访",""),

	BACK_FINISH_CHECK("19", "退回完成待初审",""),

	VISIT_FINISH_CHECK("20", "外访完成待初审",""),

	BACK_STORE("21", "退回门店",""),

	CUSTOMER_GIVEUP_CHECK("22", "客户放弃待初审",""),

	STORE_REJECT_CHECK("23", "门店拒绝待初审",""),

	CHECK_PASS_RECHECK("24", "初审通过待复审",""),

	CHECK_REJECT_RECHECK("25", "初审拟拒借待复审",""),

	GROUP_CHECK_COUSULT_RECHECK("26", "终审协商待复审",""),

	RECHECK_PENDING("27", "复审审核中",""),

	RECHECK_PASS_GROUP_CHECK("28", "复审通过待终审",""),

	FINAL_CHECK_COUSULT_GROUP_CHECK("29", "高级终审协商待终审",""),

	GROUP_CHECK_PENDING("30", "终审审核中",""),

	GROUP_CHECK_PASS_FINAL_CHECK("31", "终审通过待高级终审",""),

	FINAL_CHECK_PENDING("32", "高级终审审核中",""),

	CHECK_REJECT("33", "初审拒借",""),

	RECHECK_REJECT("34", "复审拒借",""),

	GROUP_CHECK_REJECT("35", "终审拒借",""),

	FINAL_CHECK_REJECT("36", "高级终审拒借",""),

	RECONSIDER_CHECK("37", "复议待初审",""),

	RECONSIDER_CHECK_PENDING("38", "复议初审审核中",""),

	RECONSIDER_STORE_VISIT("39", "复议待门店外访",""),

	RECONSIDER_VISIT_FINISH_CHECK("40", "复议外访完成待初审",""),

	RECONSIDER_BACK_STORE("41", "复议退回门店",""),

	RECONSIDER_BACK_FINISH_CHECK("42", "复议退回完成待初审",""),

	CUSTOMER_GIVEUP_RECONSIDER_CHECK("43", "客户放弃待复议初审",""),

	STORE_REJECT_RECONSIDER_CHECK("44", "门店拒绝待复议初审",""),

	RECONSIDER_CHECK_PASS_RECHECK("45", "复议初审通过待复审",""),

	RECONSIDER_CHECK_REJECT_RECHECK("46", "复议初审拟拒借待复审",""),

	RECONSIDER_RECHECK_PENDING("47", "复议复审协商待初审",""),

	RECONSIDER_FINAL_CHECK_COUSULT_RECHECK("48", "复议终审协商待复审",""),

	RECONSIDER_RECHECK_COUSULT_FINAL_CHECK("49", "复议复审通过待终审",""),

	RECONSIDER_FINAL_CHECK_PENDING("50", "复议终审审核中",""),

	RECONSIDER_CHECK_REJECT("51", "复议初审拒借",""),

	RECONSIDER_RECHECK_REJECT("52", "复议复审拒借",""),

	RECONSIDER_FINAL_CHECK_REJECT("53", "复议终审拒借",""),

	STORE_VISIT_TIMEOUT("54", "门店外访超时",""),

	BACK_TIMEOUT("55", "退回超时",""),

	RECONSIDER_STORE_VISIT_TIMEOUT("56", "复议门店外访超时",""),

	RECONSIDER_BACK_TIMEOUT("57", "复议退回超时",""),

	RATE_TO_VERIFY("58", "待审核费率",""),

	CONTRACT_NULLIFY("59", "合同作废",""),

	SIGN_CONFIRM("60", "待确认签署",""),

	CONTRACT_MAKE("61", "待制作合同",""),

	CONTRACT_MAKING("62", "合同制作中","1"),

	CONTRACT_UPLOAD("63", "待上传合同","1"),

	CONTRACT_AUDIFY("64", "待审核合同","1"),

	LOAN_SEND_CONFIRM("65", "待款项确认","1"),

	LOAN_CARD_DISTRIBUTE("66", "待分配卡号","1"),

	LOAN_TO_SEND("67", "待放款","1"),
	
	LOAN_DEALED("68", "已处理",""),

	LOAN_SEND_AUDITY("69", "放款中","1"),

	LOAN_SENDED("70", "已放款","1"),

	LOAN_SEND_AUDITYRETURN("71", "放款失败",""),

	LOAN_SEND_RETURN("72", "放款退回",""),

	STORE_REJECT("73", "门店拒绝",""),

	CUSTOMER_GIVEUP("74", "客户放弃",""),

	PAYMENT_BACK("75", "待款项确认退回","1"),
	// ---利率审核退回节点状态值START---
	FINAL_JUDG_TEAM("76", "退回信审终审",""),

	LETTER_REVIEW("77", "退回信审复审",""),

	FINAL_JUDG("78", "退回信审高级终审",""),

	RECONSIDER_REVIEW("79", "退回复议复审",""),

	RECONSIDER_FINAL_JUDG("80", "退回复议终审",""),
	// ---利率审核退回节点状态值END---
	APPLY_ENGINE_REFUSE("81", "规则引擎拒借",""),
	
	APPLY_ENGINE_ABANDON("811", "规则引擎放弃",""),

	APPLY_ENGINE_BACK("82", "规则引擎退回",""),

	CONTRACT_BACK("83", "合同审核退回",""),

	RARE_BACK("84", "审核费率退回",""),

	MAKE_BACK("85", "合同制作退回",""),

	SIGN_BACK("86", "合同签订退回",""),
	
	REPAYMENT("87","还款中","1"),
	
	OVERDUE("88","逾期","1"),
	
	SETTLE("89","结清","1"),
	
	EARLY_SETTLE("90","提前结清","1"),
	
	EARLY_SETTLE_VERIFY("91","提前结清待审核","1"),
	
	SETTLE_CONFIRM("92","结清待确认","1"),
	
	KING_RETURN("93","金账户退回","1"),
	
	GOLDCREDIT_REJECT("94","金信拒绝",""),
	
	GOLDCREDIT_RETURN("95","金信退回",""),
	
	BIGFINANCE_REJECT("104","大金融拒绝","1"),
	
	BIGFINANCE_TO_SNED("107","大金融待放款","1"),
	
	BIGFINANCE_GRANTING("109","大金融放款中","1"),
	
	BIGFINANCE_RETURN("105","大金融退回","1"),
	
	KING_TO_OPEN("96","金账户待开户","1"),
	
	SIGN_TIMEOUT("97","签约超时",""),
	
	GOLDCREDIT_RIGHT_RETURN("98","金信债权退回","1"),
	
	GOLDCREDIT_FIRST_REJECT("99","金信初审拒绝","1"),
	
	GOLDCREDIT_REVIEW_REJECT("100","金信复审拒绝","1"),
	
	LANUCH("900","信借申请",""),
	
	LANUCH_RE("901","发起复议",""),
	
	REMARK("800", "综合内勤岗备注",""),
	
	DECSISON_ENGINE_REJECT("101", "决策引擎拒借",""),
	
	PROPOSE_OUT("111", "放弃待初审","1"),
	
	PROPOSE_REFUSE("112", "拒绝待初审","1");

	private static Map<String, LoanApplyStatus> nameMap = new HashMap<String, LoanApplyStatus>(
			200);
	private static Map<String, LoanApplyStatus> codeMap = new HashMap<String, LoanApplyStatus>(
			200);
	private static Map<String, LoanApplyStatus> sysFlagMap = new HashMap<String, LoanApplyStatus>(
			200);


	static {
		LoanApplyStatus[] allValues = LoanApplyStatus.values();
		for (LoanApplyStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
			sysFlagMap.put(obj.getSysFlag(), obj);
		}
	}

	private String name;
	private String code;
	private String sysFlag;

	private LoanApplyStatus(String code, String name,String sysFlag) {
		this.name = name;
		this.code = code;
		this.sysFlag = sysFlag;
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
	
	public String getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}

	public static LoanApplyStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanApplyStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
