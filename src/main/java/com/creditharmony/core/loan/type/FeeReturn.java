/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeFeeReturn.java
 * @Create By 王彬彬
 * @Create In 2016年1月21日 下午6:26:13
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 催收服务费退款状态 
 * @Class Name FeeReturn
 * @author 王彬彬
 * @Create In 2016年1月21日
 */
public enum FeeReturn {
	RETURNING("0","待退款"),
	
	RETURNED("1","已退款");
	
	private static Map<String, FeeReturn> nameMap = new HashMap<String, FeeReturn>(
			50);
	private static Map<String, FeeReturn> codeMap = new HashMap<String, FeeReturn>(
			50);

	static {
		FeeReturn[] allValues = FeeReturn.values();
		for (FeeReturn obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FeeReturn(String code, String name) {
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

	public static FeeReturn parseByName(String name) {
		return nameMap.get(name);
	}

	public static FeeReturn parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
