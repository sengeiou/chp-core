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
 * 【币种】：人民币/美元/日元/港元/欧远/英镑/澳大利亚元/加拿大元/其他
 * @Class Name CurrencyFlag  币种
 * @author 李静辉
 * @Create In 2016年1月13日
 */
public enum CurrencyFlag {
		/**
		* 
		1	人民币
		2	其他
		3	美元
		4	日元
		5	港元
		6	欧元
		7	英镑
		8	澳大利亚元
		9	加拿大元
		 */
	
	YUAN("1", "人民币"),
	OTHER("2", "其他"),
	DOLLARS("3", "美元"),
	YEN("4", "日元"),
	HK("5", "港元"),
	EUROS("6", "欧元"),
	POUNDS("7", "英镑"),
	AUSTRALIAN_DOLLARS("8", "澳大利亚元"),
	CANADIAN_DOLLARS("9", "加拿大元");


	private static Map<String, CurrencyFlag> nameMap = new HashMap<String, CurrencyFlag>(
			100);
	private static Map<String, CurrencyFlag> codeMap = new HashMap<String, CurrencyFlag>(
			100);

	static {
		CurrencyFlag[] allValues = CurrencyFlag.values();
		for (CurrencyFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CurrencyFlag(String code, String name) {
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

	public static CurrencyFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static CurrencyFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
