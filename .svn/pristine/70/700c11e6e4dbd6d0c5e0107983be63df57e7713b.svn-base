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
 * @Class Name WorkUnitNameSrc(单位名称来源)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum WorkUnitNameSrc {
	UNIT_NAME_SOURCE_APPLICATION_FORM("01","申请人提供"),
	UNIT_NAME_SOURCE_114_QUERIES("02","114查询"),
	UNIT_NAME_SOURCE_NET_CHECK("03","网查"),
	UNIT_NAME_SOURCE_PEDESTRIAN("04","人行"),
	UNIT_NAME_SOURCE_HISTORY_RECHECKING("05","历史查重"),
	UNIT_NAME_SOURCE_OTHER("06","其他");


	private static Map<String, WorkUnitNameSrc> nameMap = new HashMap<String, WorkUnitNameSrc>(
			100);
	private static Map<String, WorkUnitNameSrc> codeMap = new HashMap<String, WorkUnitNameSrc>(
			100);

	static {
		WorkUnitNameSrc[] allValues = WorkUnitNameSrc.values();
		for (WorkUnitNameSrc obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private WorkUnitNameSrc(String code, String name) {
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

	public static WorkUnitNameSrc parseByName(String name) {
		return nameMap.get(name);
	}

	public static WorkUnitNameSrc parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
