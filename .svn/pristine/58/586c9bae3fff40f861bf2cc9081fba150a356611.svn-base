/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typePayWay.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:30:06
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name PayWay(支付方式)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum PayWay {
	CASH("0","现金"),
	
	NETBANK("1","网银"),
	
	CASH_NETBANK("2","现金+网银");
	
	private static Map<String, PayWay> nameMap = new HashMap<String, PayWay>(
			10);
	private static Map<String, PayWay> codeMap = new HashMap<String, PayWay>(
			10);

	static {
		PayWay[] allValues = PayWay.values();
		for (PayWay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PayWay(String code, String name) {
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

	public static PayWay parseByName(String name) {
		return nameMap.get(name);
	}

	public static PayWay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
