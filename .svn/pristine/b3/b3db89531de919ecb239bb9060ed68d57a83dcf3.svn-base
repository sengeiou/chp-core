/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeAccountStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:58:41
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 超时标识
 * @Class Name TimeOutFlag
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum TimeOutFlag {
	NORMAL("SYS_SIGN_TIME_OUT", "签约超时"),
	GOBACK("SYS_BACK_TIME_OUT", "回退超时"),
	SETTLE("SYS_VISIT_TIME_OUT", "外访超时");
	private static Map<String, TimeOutFlag> nameMap = new HashMap<String, TimeOutFlag>(
			10);
	private static Map<String, TimeOutFlag> codeMap = new HashMap<String, TimeOutFlag>(
			10);

	static {
		TimeOutFlag[] allValues = TimeOutFlag.values();
		for (TimeOutFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TimeOutFlag(String code, String name) {
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

	public static TimeOutFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static TimeOutFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
