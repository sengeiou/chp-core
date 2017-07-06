/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDeliveryResult.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:13:21
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name DeliveryResult 交割结果
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum DeliveryResult {
	APPLY_TO("0", "待申请"),

	VERIFY_TO("1", "待审核"),

	PASSED("2", "通过"),

	REJECT("3", "驳回");

	private static Map<String, DeliveryResult> nameMap = new HashMap<String, DeliveryResult>(
			10);
	private static Map<String, DeliveryResult> codeMap = new HashMap<String, DeliveryResult>(
			10);

	static {
		DeliveryResult[] allValues = DeliveryResult.values();
		for (DeliveryResult obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DeliveryResult(String code, String name) {
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

	public static DeliveryResult parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeliveryResult parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
