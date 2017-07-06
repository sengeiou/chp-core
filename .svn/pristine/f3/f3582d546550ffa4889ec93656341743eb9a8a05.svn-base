package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name OffendInfo(反欺诈触发规则类型)
 * @author 李静辉
 * @Create In 2016年1月21日
 */
public enum OffendInfo {
	/**
	 *  1	销售人员信息匹配
		2	黑名单数据库信息匹配
		3	查重规则匹配
		4	欺诈案件数据库信息匹配
	 */
	SALES_STAFF_INFORMATION_MATCHING("1","销售人员信息匹配"),
	BLACK_LIST_DATABASE_INFORMATION_MATCHING("2","黑名单数据库信息匹配"),
	SEARCH_RULES_MATCHING("3","查重规则匹配"),
	FRAUD_CASE_DATABASE_INFORMATION_MATCHING("4","欺诈案件数据库信息匹配");


	private static Map<String, OffendInfo> nameMap = new HashMap<String, OffendInfo>(
			100);
	private static Map<String, OffendInfo> codeMap = new HashMap<String, OffendInfo>(
			100);

	static {
		OffendInfo[] allValues = OffendInfo.values();
		for (OffendInfo obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private OffendInfo(String code, String name) {
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

	public static OffendInfo parseByName(String name) {
		return nameMap.get(name);
	}

	public static OffendInfo parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
