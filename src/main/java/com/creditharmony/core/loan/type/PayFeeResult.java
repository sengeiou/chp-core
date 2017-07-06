/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typePayFeeResult.java
 * @Create By 王彬彬
 * @Create In 2016年1月4日 下午5:07:18
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 返款结果
 * @Class Name PayFeeResult
 * @author 王彬彬
 * @Create In 2016年1月4日
 */
public enum PayFeeResult {
	SUCCESS("0","成功"),
	
	FAILED("1","失败");
	
	private static Map<String, PayFeeResult> nameMap = new HashMap<String, PayFeeResult>(
			10);
	private static Map<String, PayFeeResult> codeMap = new HashMap<String, PayFeeResult>(
			10);

	static {
		PayFeeResult[] allValues = PayFeeResult.values();
		for (PayFeeResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PayFeeResult(String code, String name) {
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

	public static PayFeeResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static PayFeeResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
