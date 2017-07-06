/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRspSource.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 下午12:10:54
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 电销来源
 * 
 * @Class Name RspSource
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RspSource {
	BUSINESS_CENTER("0", "业务中心"),

	AGENT_CENTER("1", "客服中心"),

	JINXIN_NET("2", "金信网"),

	JINXIN_FINANCE("3", "信和大金融"),

	PHONE_APP("4", "手机APP"),

	OUT_BUY("5", "外部采购");

	private static Map<String, RspSource> nameMap = new HashMap<String, RspSource>(
			10);
	private static Map<String, RspSource> codeMap = new HashMap<String, RspSource>(
			10);

	static {
		RspSource[] allValues = RspSource.values();
		for (RspSource obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RspSource(String code, String name) {
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

	public static RspSource parseByName(String name) {
		return nameMap.get(name);
	}

	public static RspSource parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
