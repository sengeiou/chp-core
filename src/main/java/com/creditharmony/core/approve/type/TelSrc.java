/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name TelSrc(电话号码来源)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum TelSrc {
	TEL_SOURCE_APPLICATION_FORM("01","申请人提供"),
	TEL_SOURCE_114_QUERIES("02","114查询"),
	TEL_SOURCE_NET_CHECK("03","网查"),
	TEL_SOURCE_PEDESTRIAN("04","人行"),
	TEL_SOURCE_HISTORY_RECHECKING("05","历史查重"),
	TEL_SOURCE_OTHER("06","其他");
	
	private static Map<String, TelSrc> nameMap = new HashMap<String, TelSrc>(
			100);
	private static Map<String, TelSrc> codeMap = new HashMap<String, TelSrc>(
			100);

	static {
		TelSrc[] allValues = TelSrc.values();
		for (TelSrc obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TelSrc(String code, String name) {
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

	public static TelSrc parseByName(String name) {
		return nameMap.get(name);
	}

	public static TelSrc parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
