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
 * 【卡类型】：贷记卡/准贷记卡
 * @Class Name CardType 卡类型
 * @author 李静辉
 * @Create In 2016年1月13日
 */
public enum CardType {
	CREDIT_CARD("1","贷记卡"),
	SEMI_CREDIT_CARD("2","准贷记卡");


	private static Map<String, CardType> nameMap = new HashMap<String, CardType>(
			100);
	private static Map<String, CardType> codeMap = new HashMap<String, CardType>(
			100);

	static {
		CardType[] allValues = CardType.values();
		for (CardType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CardType(String code, String name) {
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

	public static CardType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CardType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
