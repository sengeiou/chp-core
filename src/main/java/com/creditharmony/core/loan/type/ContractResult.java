/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeContractResult.java
 * @Create By 王彬彬
 * @Create In 2016年3月21日 下午3:53:36
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 合同审核结果状态
 * @Class Name ContractResult
 * @author 王彬彬
 * @Create In 2016年3月21日
 */
public enum ContractResult {
	CONTRACT_REBACK("0", "退回"),

	CONTRACT_REJECT("1", "拒绝"),
	CONTRACT_REJECT1("11", "建议拒绝"),

	CONTRACT_SUCCEED("2", "成功"),

	CONTRACT_GIVEUP("3", "客户放弃"),
	CONTRACT_GIVEUP1("13", "建议放弃");

	private static Map<String, ContractResult> nameMap = new HashMap<String, ContractResult>(
			100);
	private static Map<String, ContractResult> codeMap = new HashMap<String, ContractResult>(
			100);

	static {
		ContractResult[] allValues = ContractResult.values();
		for (ContractResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ContractResult(String code, String name) {
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

	public static ContractResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static ContractResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
