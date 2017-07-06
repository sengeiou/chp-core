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
 * @Class Name GuaranteeType【担保方式】：信用/免担保、保证、质押（含保证金）、组合（含保证）、组合（不含保证）、抵押、其他
 * @author 李静辉
 * @Create In 2016年1月13日
 */
public enum GuaranteeType {
	/**
	 * 0	抵押
1	保证
2	信用\免担保
3	组合（不含保证）
4	组合（含保证）
5	质押（含保证金）
6	农户联保
7	其他
	 */
	MORTGAGE("0","抵押"),
	GUARANTEE("1","保证"),
	CREDIT_FREE_GUARANTEE("2","信用\\免担保"),
	COMBINATION_NOT_GUARANTEED("3","组合(不含保证)"),
	COMPOSITION_INCLUDING_GUARANTEES("4","组合(含保证)"),
	PLEDGE_INCLUDING_MARGIN("5","质押（含保证金）"),
	OFGUARANTEED("6","农户联保"),
	OTHER("7","其他");

	private static Map<String, GuaranteeType> nameMap = new HashMap<String, GuaranteeType>(
			100);
	private static Map<String, GuaranteeType> codeMap = new HashMap<String, GuaranteeType>(
			100);

	static {
		GuaranteeType[] allValues = GuaranteeType.values();
		for (GuaranteeType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private GuaranteeType(String code, String name) {
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

	public static GuaranteeType parseByName(String name) {
		return nameMap.get(name);
	}

	public static GuaranteeType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
