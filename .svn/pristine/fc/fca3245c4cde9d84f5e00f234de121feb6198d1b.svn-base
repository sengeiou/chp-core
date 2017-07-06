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
 * 
 * @Class Name CarLoanImageFileType
 * @author zqa
 * @Create In 2017年3月16日
 */
public enum CarLoanImageFileType {

	/**
	 * 生产影像参数配置
	 */
	ADD_CONTRACT_FILE("400201","合同材料"),
	ADD_MORTGAGE_FILE("400202","抵押及质押材料"),
	ADD_TRUST_DEBIT_FILE("400203","委托扣款授权书"),
	ADD_OTHER_FILE("400204","其他材料"),
	
	EXTEND_CONTRACT_FILE1("400501","展期合同资料"),
	EXTEND_TRUST_DEBIT_FILE1("400502","委托扣款授权书"), 
	EXTEND_OTHER_FILE1("400503","其他相关资料"),
	
	EXTEND_CONTRACT_FILE2("400601","展期合同资料"),
	EXTEND_TRUST_DEBIT_FILE2("400602","委托扣款授权书"), 
	EXTEND_OTHER_FILE2("400603","其他相关资料"),
	
	EXTEND_CONTRACT_FILE3("400701","展期合同资料"),
	EXTEND_TRUST_DEBIT_FILE3("400702","委托扣款授权书"), 
	EXTEND_OTHER_FILE3("400703","其他相关资料"),

	EXTEND_CONTRACT_FILE4("400801","展期合同资料"),
	EXTEND_TRUST_DEBIT_FILE4("400802","委托扣款授权书"), 
	EXTEND_OTHER_FILE4("400803","其他相关资料"),
	
	EXTEND_CONTRACT_FILE5("400901","展期合同资料"),
	EXTEND_TRUST_DEBIT_FILE5("400902","委托扣款授权书"), 
	EXTEND_OTHER_FILE5("400903","其他相关资料");

	
	private static Map<String, CarLoanImageFileType> nameMap = new HashMap<String, CarLoanImageFileType>(
			100);
	private static Map<String, CarLoanImageFileType> codeMap = new HashMap<String, CarLoanImageFileType>(
			100);

	static {
		CarLoanImageFileType[] allValues = CarLoanImageFileType.values();
		for (CarLoanImageFileType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarLoanImageFileType(String code, String name) {
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

	public static CarLoanImageFileType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarLoanImageFileType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
