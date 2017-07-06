/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeYESON.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:29:32
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 高危线标准
 * @Class Name DengerLine
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum DengerLine {

	PROVINCE_LINE("0","省份高危线"),
	
	CUSTOM_LINE("1","自定义高危线");

	private static Map<String, DengerLine> nameMap = new HashMap<String, DengerLine>(10);
	private static Map<String, DengerLine> codeMap = new HashMap<String, DengerLine>(10);

	static {
		DengerLine[] allValues = DengerLine.values();
		for (DengerLine obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DengerLine(String code, String name) {
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

	public static DengerLine parseByName(String name) {
		return nameMap.get(name);
	}

	public static DengerLine parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
