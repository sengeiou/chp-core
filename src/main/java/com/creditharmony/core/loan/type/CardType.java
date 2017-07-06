/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCardType.java
 * @Create By 王彬彬
 * @Create In 2016年1月12日 下午6:12:53
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 卡类型
 * @Class Name CardType
 * @author 王彬彬
 * @Create In 2016年1月12日
 */
public enum CardType {
	CREDIT_CARD("0","贷记卡"),
	
	SEMI_CREDIT_CARD("1","准贷记卡");
	
	private static Map<String, CardType> nameMap = new HashMap<String, CardType>(
			10);
	private static Map<String, CardType> codeMap = new HashMap<String, CardType>(
			10);

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
