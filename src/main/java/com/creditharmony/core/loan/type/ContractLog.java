/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeContractLog.java
 * @Create By 王彬彬
 * @Create In 2016年3月21日 下午12:07:53
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 合同状态变更历史
 * @Class Name ContractLog
 * @author 王彬彬
 * @Create In 2016年3月21日
 */
public enum ContractLog {
	RATE_TO_VERIFY(LoanApplyStatus.RATE_TO_VERIFY.getCode(),"审核利率"),
	
	SIGN_CONFIRM(LoanApplyStatus.SIGN_CONFIRM.getCode(),"确认签署"),
	
	CONTRACT_MAKE(LoanApplyStatus.CONTRACT_MAKE.getCode(),"合同制作"),
	
	CONTRACT_MAKING(LoanApplyStatus.CONTRACT_MAKING.getCode(),"合同制作中"),
	
	CONTRACT_UPLOAD(LoanApplyStatus.CONTRACT_UPLOAD.getCode(),"签订合同"),
	
	CONTRACT_AUDIFY(LoanApplyStatus.CONTRACT_AUDIFY.getCode(),"合同审核"),
	
	REPAYMENT(LoanApplyStatus.REPAYMENT.getCode(),"还款中");
	
	private static Map<String, ContractLog> nameMap = new HashMap<String, ContractLog>(
			50);
	private static Map<String, ContractLog> codeMap = new HashMap<String, ContractLog>(
			50);

	static {
		ContractLog[] allValues = ContractLog.values();
		for (ContractLog obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ContractLog(String code, String name) {
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

	public static ContractLog parseByName(String name) {
		return nameMap.get(name);
	}

	public static ContractLog parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
