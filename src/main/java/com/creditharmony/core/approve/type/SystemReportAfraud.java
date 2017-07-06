package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;


/**
 * (系统提报反欺诈)
 * @Class Name SystemReportAfraud
 * @author 李静辉
 * @Create In 2016年1月27日
 */
public enum SystemReportAfraud {
	
	SYSTEM_REPORT_AFRAUD("2", "系统提报反欺诈");


	private static Map<String, SystemReportAfraud> nameMap = new HashMap<String, SystemReportAfraud>(
			100);
	private static Map<String, SystemReportAfraud> codeMap = new HashMap<String, SystemReportAfraud>(
			100);

	static {
		SystemReportAfraud[] allValues = SystemReportAfraud.values();
		for (SystemReportAfraud obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SystemReportAfraud(String code, String name) {
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

	public static SystemReportAfraud parseByName(String name) {
		return nameMap.get(name);
	}

	public static SystemReportAfraud parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
