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
 * 
 * @Class Name ChkReason  查询原因
 * @author 李静辉
 * @Create In 2016年1月13日
 */
public enum ChkReason {
	
	/**
	 * 
1	信用卡审批
2	贷后管理
3	担保资格审批
4	贷款审批
5	异议核查
6	特约商户实名审查
7	本人查询
8	公积金提取复核
9	招商投标
10	身份信息在线更新
11	股指期货开户
12	保前审查
13	保后管理
14	业务审批
15	本人查询-临柜
16	本人查询-互联网
17	其他

	 */
	
	CREDIT_CARD_APPROVAL("1","信用卡审批"),
	POST_LOAN_MANAGEMENT("2","贷后管理"),
	GUARANTEE_QUALIFICATION_APPROVAL("3","担保资格审批"),
	LOAN_APPROVAL("4","贷款审批"),
	OBJECTION_VERIFICATION("5","异议核查"),
	SPECIAL_MERCHANTS_REAL_NAME_REVIEW("6","特约商户实名审查"),
	I_QUERY("7","本人查询"),
	PROVIDENT_FUND_EXTRACTION_AND_REVIEW("8","公积金提取复核"),
	INVITATION_TO_BID("9","招商投标"),
	IDENTITY_INFORMATION_ONLINE_UPDATE("10","身份信息在线更新"),
	STOCK_INDEX_FUTURES("11","股指期货开户"),
	PRE_INSURANCE_REVIEW("12","保前审查"),
	POST_INSURANCE_MANAGEMENT("13","保后管理"),
	BUSINESS_APPROVAL("14","业务审批"),
	I_QUERY_PRO("15","本人查询-临柜"),
	I_QUERY_THE_INTERNET("16","本人查询-互联网"),
	OTHER("17","其他");
	


	private static Map<String, ChkReason> nameMap = new HashMap<String, ChkReason>(
			100);
	private static Map<String, ChkReason> codeMap = new HashMap<String, ChkReason>(
			100);

	static {
		ChkReason[] allValues = ChkReason.values();
		for (ChkReason obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ChkReason(String code, String name) {
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

	public static ChkReason parseByName(String name) {
		return nameMap.get(name);
	}

	public static ChkReason parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
