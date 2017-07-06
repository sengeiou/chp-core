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
 * (车借借款状态)
 * @Class Name CarLoanStatus
 * @author 李静辉
 * @Create In 2016年2月1日
 */
public enum CarLoanStatus {
	CUSTOMER_GIVE_UP                   ("1","客户放弃"),
	CONTINUE_TRACKING                  ("2","继续跟踪"),
	PENDING_APPLICATION                ("3","待申请"),
	PENDING_UPLOADED_FILE              ("4","待上传资料"),
	FIRST_INSTANCE_BACK                ("5","初审退回"),
	FIRST_INSTANCE_REJECT              ("6","初审拒绝"),
	PENDING_FIRST_INSTANCE             ("7","待初审"),
	REVIEW_BACK                        ("8","复审退回"),
	REVIEW_REJECT                      ("9","复审拒绝"),
	PENDING_REVIEW                     ("10","待复审"),
	FINAL_AUDIT_BACK                   ("11","终审退回"),
	FINAL_AUDIT_REJECT                 ("12","终审拒绝"),
	PENDING_FINAL_AUDIT                ("13","待终审"),
	AUDIT_INTEREST_RATE                ("14","待审核利率"),
	PENDING_AUDIT_INTEREST_RATE_BACK   ("15","待审核利率退回"),
	PENDING_CONFIRMED_SIGN             ("16","待确认签署"),
	PENDING_PRODUCED_CONTRACT          ("17","待制作合同"),
	PRODUCTION_CONTRACT_FAILURE        ("18","制作合同失败"),
	PENDING_PRODUCED_CONTRACT_BACK     ("19","待制作合同退回"),
	PENDING_SIGNED_CONTRACT            ("20","待签订合同"),
	PENDING_SIGNED_CONTRAC_BACK        ("21","待签订合同退回"),
	PENDING_UPLOAD_CONTRACT            ("22","待上传合同"),
	PENDING_CONTRACT_REVIEW_BACK       ("23","待合同审核退回"),
	PENDING_CONTRACT_REVIEW            ("24","待合同审核"),
	PENDING_LOAN_CONFIRMATION_BACK     ("25","待款项确认退回"),
	PENDING_LOAN_CONFIRMATION          ("26","待款项确认"),
	PENDING_ASSIGNED_CARD_NUMBER       ("27","待分配卡号"),
	PENDING_LOAN                       ("28","待放款"),
	LOAN_BACK                          ("29","放款退回"),
	LENDING_FAILURE                    ("30","放款失败"),
	LOAN_AUDIT                         ("31","待放款确认"),
	LOAN_SUCCESS                       ("32","放款成功"),
	REPAYMENT_IN                       ("33","还款中"),
	LOANING                            ("34","已处理"),
	STORE__GIVE_UP                     ("35","门店放弃"),
	SETTLE						       ("36","结清"),
	SETTLE_EARLY				       ("37","提前结清"),
	SETTLE_TO_AUDIT				       ("38","结清待审核"),
	APPRAISER                          ("39","待评估师录入"),
	REPAYMENT_APPLICATION              ("40","待还款申请"),
	EXTENSION_FAILURE                  ("41","展期失败"),
	HAS_BEEN_EXTENDED                  ("42","已展期"),
	EXTENDED_GIVE_UP                   ("43","展期放弃"),
	CONTRACT_REVOKE          		   ("44","合同作废"),
	SIGNED_TIMEOUT        			   ("45","签约超时作废"),
	UPLOADED_FILE_BACK                 ("46","上传资料退回"),
	PENDING_CONFIRMED_SIGN_BACK        ("47","待确认签署退回"),
	SUPPLY_PENDING_REVIEW              ("48","补传资料待复审"),
	SUPPLY_PENDING_FINAL_AUDIT         ("49","补传资料待终审"),
	SUPPLY_BACK_PENDING_SIGNED_CONTRACT("50","补传资料复审退回"),
	OVERDUE	    ("51","逾期"),
	SUPPLY_BACK_PENDING_FINAL_AUDIT	   ("52","补传资料终审退回"),
	UPLOAD_CONTRACT_STORE_REFUSE	   ("53","签约上传门店拒绝"),
	EXTEND_CONTRACT_CHECK_BACK	  	   ("54","展期合同审核退回"),
	DELAY	    ("55","延时处理"),
	PENDING_EXTEND_CONFIRM             ("56","待展期确认"),
	WAIT_REPAYMENT                	   ("57","待结清"),
	WAIT_AHEAD_REPAYMENT               ("58","待提前结清");
	
	private static Map<String, CarLoanStatus> nameMap = new HashMap<String, CarLoanStatus>(
			100);
	private static Map<String, CarLoanStatus> codeMap = new HashMap<String, CarLoanStatus>(
			100);

	static {
		CarLoanStatus[] allValues = CarLoanStatus.values();
		for (CarLoanStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanStatus(String code, String name) {
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

	public static CarLoanStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
