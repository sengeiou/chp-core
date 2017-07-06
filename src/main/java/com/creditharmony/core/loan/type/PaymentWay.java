/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typePaymentWay.java
 * @Create By 王彬彬
 * @Create In 2015年12月25日 上午11:53:24
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 放款方式
 * 
 * @Class Name PaymentWay
 * @author 王彬彬
 * @Create In 2015年12月25日
 */
public enum PaymentWay {
	NET_BANK("0", "网银"),

	ZHONGJIN("1", "中金"),
	
	TONG_LIAN("2", "通联"),
	
	KING_ACCOUNT("9", "金账户");

	private static Map<String, PaymentWay> nameMap = new HashMap<String, PaymentWay>(
			10);
	private static Map<String, PaymentWay> codeMap = new HashMap<String, PaymentWay>(
			10);

	static {
		PaymentWay[] allValues = PaymentWay.values();
		for (PaymentWay obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PaymentWay(String code, String name) {
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

	public static PaymentWay parseByName(String name) {
		return nameMap.get(name);
	}

	public static PaymentWay parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
