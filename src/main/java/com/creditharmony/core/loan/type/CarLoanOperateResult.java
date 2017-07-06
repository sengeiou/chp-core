package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 历史记录操作结果
 * @Class Name Consult
 * @author ganquan
 * @Create In 2016年4月21日
 */
public enum CarLoanOperateResult {
	CONSULTATION_CUSTOMER_GIVE_UP         ("1","咨询客户放弃"),
	CONSULTATION_CONTINUE_TRACKING       ("2","咨询继续跟踪"),
	CONSULTATION_STORE__GIVE_UP       	 ("3","咨询门店放弃"),
	APPRAISER_STORE__GIVE_UP            ("4","评估师录入不符合进件条件"),
	APPRAISER_CUSTOMER__GIVE_UP          ("5","评估师录入客户放弃"),
	APPRAISER_TO_APPLICATION          ("6","评估师录入到上传资料"),
	APPLICATION_CUSTOMER_GIVE_UP          ("7","申请客户放弃"),
	APPLICATION_STORE_GIVE_UP          ("8","申请门店放弃"),
	APPLICATION_TO_UPLOADED          ("9","申请到上传资料"),
	UPLOADED_CUSTOMER_GIVE_UP          ("10","上传资料客户放弃"),
	UPLOADED_STORE_GIVE_UP          ("11","上传资料门店放弃"),
	UPLOADED_TO_FIRST_INSTANCE        ("12","上传资料到初审"),
	UPLOADED_BACK_ASSESS_ENTER       ("13","上传资料退回评估师录入"),
	UPLOADED_BACK_APPLICATION          ("14","上传资料退回申请"),
	FIRST_INSTANCE_CUSTOMER__GIVE_UP       ("15","初审客户放弃"),
	FIRST_INSTANCE_STORE__GIVE_UP       ("16","初审拒绝"),
	FIRST_INSTANCE_TO_REVIEW       ("17","初审到复审"),
	FIRST_INSTANCE_BACK_ASSESS_ENTER       ("18","初审退回评估师录入"),
	FIRST_INSTANCE_BACK_APPLICATION       ("19","初审退回申请"),
	INTEREST_RATE_PASS      ("20","审核费率通过"),
	INTEREST_RATE_BACK      ("21","审核费率退回"),
	CONFIRMED_SIGN_CUSTOMER__GIVE_UP     ("22","签署客户放弃"),
	CONFIRMED_SIGN_SUCCESS      ("23","签署成功"),
	CONFIRMED_SIGN_BACK      ("24","签署退回"),
	PRODUCED_CONTRACT_SUCCESS  ("25","合同制作成功"),
	PRODUCED_CONTRACT_BACK_CONFIRMED      ("26","合同制作退回签署"),
	PRODUCED_CONTRACT_BACK_INTEREST_RATE      ("27","合同制作退回审核费率"),
	SIGNED_CONTRACT_PASS      ("28","签订上传合同通过"),
	SIGNED_CONTRACT_PASS_SUPPLY_PENDING_REVIEW       ("29","签订上传合同通过到补传资料待复审"),
	SIGNED_CONTRACT_BACK      ("30","签订上传合同退回到待确认签署"),
	SIGNED_CONTRACT_CUSTOMER_GIVE_UP      ("31","签订上传合同客户放弃"),
	CONTRACT_REVIEW_PASS      ("32","合同审核通过"),
	CONTRACT_REVIEW_BACK_CONFIRMED_SIGN      ("33","合同审核退回到待确认签署"),
	CONTRACT_REVIEW_BACK_SIGNED_CONTRACT      ("34","合同审核退回到合同签约上传"),
	CONTRACT_MAKE_DEFEATED      ("35","制作合同失败"),
	LOAN_CONFIRMATION_PASS      ("36","款项确认通过"),
	LOAN_CONFIRMATION_BACK      ("37","款项确认退回"),
	PROCESS                     ("38","划扣处理中"),
	PAST_DRAW_SUCCESS           ("39","以往划扣成功"),
	PAST_DRAW_DEFEATED          ("40","以往划扣失败"),
	SUCCESS                    ("41","成功"),
	GRANT_AUDIT_SUCCESS        ("42","放款审核通过"),
	EXTEND_APPRAISER_CUSTOMER_GIVEUP ("43","展期评估师录入客户放弃"),
	EXTEND_APPRAISER_UPLOADED_FILE ("44","展期到上传资料"),
	EXTEND_UPLOADED_CUSTOMER_GIVEUP ("45","展期上传资料放弃"),
	EXTEND_UPLOADED_TO_FRIST_AUDIT ("46","展期到初审"),
	EXTEND_UPLOADED_BACK_APPRAISER ("47","展期上传资料到评估师录入"),
	EXTEND_FIRST_INSTANCE_BACK_APPRAISER("48","展期初审退回到评估师录入"),
	EXTEND_FIRST_INSTANCE_BACK_UPLOADED("49","展期初审退回到上传资料"),
	EXTEND_FIRST_INSTANCE_CUSTOMER_GIVEUP("50","展期初审客户放弃"),
	EXTEND_FIRST_INSTANCE_REFUSED("51","展期初审拒绝"),
	EXTEND_FIRST_INSTANCE_PASS("52","展期初审通过"),
	EXTEND_INTEREST_RATE_PASS("53","展期审核费率通过"),
	EXTEND_INTEREST_RATE_BACK("54","展期审核费率退回"),
	EXTEND_SIGN_CUSTOMER_GIVEUP("55","展期签署客户放弃"),
	EXTEND_SIGN_BACK("56","展期签署退回"),
	EXTEND_SIGN_PASS("57","展期签署通过"),
	EXTEND_PRODUCED_CONTRACT_SUCCESS  ("58","展期合同制作成功"),
	EXTEND_PRODUCED_CONTRACT_BACK_SIGN      ("59","展期合同制作退回签署"),
	EXTEND_PRODUCED_CONTRACT_BACK_INTEREST_RATE      ("60","展期合同制作退回审核费率"),
	EXTEND_SIGNED_CONTRACT_PASS      ("61","展期签订上传合同通过"),
	EXTEND_CONTRACT_REVIEW_PASS      ("62","展期合同审核通过"),
	EXTEND_CONTRACT_REVIEW_BACK_CONFIRMED_SIGN      ("63","展期合同审核退回到待确认签署"),
	EXTEND_CONTRACT_REVIEW_BACK_SIGNED_CONTRACT      ("64","展期合同审核退回到合同签约上传"),
	DAY_DRAW_SUCCESS           ("65","当日划扣成功"),
	DAY_DRAW_DEFEATED          ("66","当日划扣失败"),
	RECHECK_BACK_FIRSTCHECK	 ("67", "复审退回到待初审"),
	SUPPLY_RECHECK_BACK_SIGNED_CONTRACT	 ("68", "补传复审退回到待签订合同"),
	TO_SUPPLY_FINALCHECK	 ("69", "补传复审通过到补传终审"),
	TO_FINALCHECK	 ("70", "复审通过到待终审"),
	TO_CONDITION_FINALCHECK	 ("71", "复审附条件通过到待终审"),
	RECHECK_REFUSE	 ("72", "复审拒绝"),
	RECHECK_GIVEUP	 ("73", "复审客户放弃"),
	SUPPLY_FINALCHECK_BACK_SUPPLY_RECHECK	("74", "补传资料待终审退回到补传资料待复审"),
	FINALCHECK_BACK_RECHECK	 ("75", "终审退回到待复审"),
	TO_INTEREST_RATE	 ("76", "终审通过到待审核费率"),
	SUPPLY_FINALCHECK_TO_CONTRACT_REVIEW	("77", "补传终审通过到待合同审核"),
	FINALCHECK_CONDITION_TO_INTEREST_RATE	("78", "终审附条件通过到待审核费率"),
	FINALCHECK_REFUSE	 ("79", "终审拒绝"),
	FINALCHECK_GIVEUP	 ("80", "终审客户放弃"), 
	TO_APPRAISER	 ("81", "到评估师录入"),
	RECHECK_DETERMINED	 ("82", "复审待定"),
	FINALCHECK_DETERMINED	 ("83", "终审待定"),
	RECHECK_DELAY	 ("84", "复审延时处理"),
	FINALCHECK_DELAY	 ("85", "终审延时处理"),
	CONTRACT_TIMEOUT	 ("86", "合同签约超时作废"),
	DISCART_FAIL	 ("87", "分配卡号失败"),
	BACK_TO_LOAN_CONFIRMATION	 ("88", "退回到待款项确认"),
	APPLY_SUCCESS	 ("89", "门店还款申请成功"),
	JKFUB_AUDIT_PASS ("90","借款服务部审核通过"),
	JKFUB_AUDIT_BACK ("91","借款服务部审核退回"),
	AUTHENTICATION_PASS ("92","主借人身份手动验证通过"),
	GET_AUTHENTICATION_PASS ("93","共借人身份手动验证通过"),
	LOAN_BEFORE_REVISIT_SUCCEED ("94","放款前回访推送成功"),
	LOAN_BEFORE_REVISIT_FAIL ("95","放款前回访推送失败"),
	LOAN_REVISIT_SUCCEED ("96","放款前回访成功"),
	LOAN_REVISIT_FAIL ("97","放款前回访失败"),
	CAR_EMAIL_VERIFY_SUCCESS("98","邮箱验证成功"),
	CAR_EMAIL_VERIFY_FAIL("99","邮箱验证失败");
	
	private static Map<String, CarLoanOperateResult> nameMap = new HashMap<String, CarLoanOperateResult>(
			100);
	private static Map<String, CarLoanOperateResult> codeMap = new HashMap<String, CarLoanOperateResult>(
			100);

	static {
		CarLoanOperateResult[] allValues = CarLoanOperateResult.values();
		for (CarLoanOperateResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanOperateResult(String code, String name) {
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

	public static CarLoanOperateResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanOperateResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
