/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeChkBackReason.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:33:15
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核退回原因
 * @Class Name ChkBackReason 
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum ChkBackReason {
	ACCOUNT_ERROR("0","户名与账号不符"),
	
	ACCOUNT_BANK_ERROR("1","开户银行错误"),
	
	BRANCH_NAME_ERROR("2","支行名称错误"),
	
	CARD_NUM_ERROR("3","账号位数不符"),
	
	NETBANK_NOTSUPPORT("4","账户不支持银行转账"),
	
	BANK_NOT_FUND("5","网银特殊银行无法找到"),
	
	CUSTOMER_GIVEUP("6","客户主动放弃"),
	
	RISIK_CUSTOMER("7","风险客户"),
	
	OWNERSHIP_ERROR("8","银行卡归属地有误"),
	
	OTHER_REASON("9","其他"),
	
	SYSTEM_ERROR("10","平台系统导致失败");
	
	private static Map<String, ChkBackReason> nameMap = new HashMap<String, ChkBackReason>(
			10);
	private static Map<String, ChkBackReason> codeMap = new HashMap<String, ChkBackReason>(
			10);

	static {
		ChkBackReason[] allValues = ChkBackReason.values();
		for (ChkBackReason obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ChkBackReason(String code, String name) {
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

	public static ChkBackReason parseByName(String name) {
		return nameMap.get(name);
	}

	public static ChkBackReason parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
