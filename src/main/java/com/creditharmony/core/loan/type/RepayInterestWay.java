/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRepayInterestWay.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:53:06
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RepayInterestWay(还款付息方式)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RepayInterestWay {
	AVERAGE_CAPITAL("0", "等额本息"),

	AVERAGE_CAPITAL_INTEREST("1","按月结息一次性还本");
	
	private static Map<String, RepayInterestWay> nameMap = new HashMap<String, RepayInterestWay>(
			5);
	private static Map<String, RepayInterestWay> codeMap = new HashMap<String, RepayInterestWay>(
			5);

	static {
		RepayInterestWay[] allValues = RepayInterestWay.values();
		for (RepayInterestWay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RepayInterestWay(String code, String name) {
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

	public static RepayInterestWay parseByName(String name) {
		return nameMap.get(name);
	}

	public static RepayInterestWay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
