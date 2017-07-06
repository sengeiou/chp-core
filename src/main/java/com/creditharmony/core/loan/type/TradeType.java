/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeTradeType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:00:23
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name TradeType（交易类型）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum TradeType {
	
	TRANSFERRED("0", "转入"),

	TURN_OUT("1", "转出");

	private static Map<String, TradeType> nameMap = new HashMap<String, TradeType>(
			10);
	private static Map<String, TradeType> codeMap = new HashMap<String, TradeType>(
			10);

	static {
		TradeType[] allValues = TradeType.values();
		for (TradeType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TradeType(String code, String name) {
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

	public static TradeType parseByName(String name) {
		return nameMap.get(name);
	}

	public static TradeType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
