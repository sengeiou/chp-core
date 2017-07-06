package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核退回原因
 * @Class Name ContractVerifyReturn
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum ContractVerifyReturn {
	RISK_CUSTOMER("0","风险客户"),
	
	CUSTOMER_GIVEUP("1","客户主动放弃"),
	
	INDO_ERROR("2","资料错误或少资料"),
	
	PRE_UPLOAD("3","提前上传签约资料"),
	
	SIGN_ERROR("4","签字潦草");

	private static Map<String, ContractVerifyReturn> nameMap = new HashMap<String, ContractVerifyReturn>(
			10);
	private static Map<String, ContractVerifyReturn> codeMap = new HashMap<String, ContractVerifyReturn>(
			10);

	static {
		ContractVerifyReturn[] allValues = ContractVerifyReturn.values();
		for (ContractVerifyReturn obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ContractVerifyReturn(String code, String name) {
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

	public static ContractVerifyReturn parseByName(String name) {
		return nameMap.get(name);
	}

	public static ContractVerifyReturn parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
