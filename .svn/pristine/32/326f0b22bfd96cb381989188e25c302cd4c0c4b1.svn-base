package com.creditharmony.core.lend.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name LoanAccountType(账户类型)
 * @author 李静辉
 * @Create In 2016年1月19日
 */
public enum LoanAccountType {
	/**
	 * 
		// 账户类型 首次借款
		// 账户类型 结清再贷
	*/
	
	            
    
    LOAN_TYPE_FIRST("0","首次借款"),
    LOAN_TYPE_AGAIN("1","结清再贷");


	private static Map<String, LoanAccountType> nameMap = new HashMap<String, LoanAccountType>(
			100);
	private static Map<String, LoanAccountType> codeMap = new HashMap<String, LoanAccountType>(
			100);

	static {
		LoanAccountType[] allValues = LoanAccountType.values();
		for (LoanAccountType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanAccountType(String code, String name) {
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

	public static LoanAccountType parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanAccountType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
