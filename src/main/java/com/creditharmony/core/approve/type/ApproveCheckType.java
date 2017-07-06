package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @Class Name ApproveCheckType(信审审核类型)
 * @author 李静辉
 * @Create In 2015年12月24日
 */
public enum ApproveCheckType {
	XS_APPROVE_CHECK_TYPE("0","信审"),
	FY_APPROVE_CHECK_TYPE("1","复议"),
	FQZ_APPROVE_CHECK_TYPE("2","反欺诈")
	;


	private static Map<String, ApproveCheckType> nameMap = new HashMap<String, ApproveCheckType>(
			100);
	private static Map<String, ApproveCheckType> codeMap = new HashMap<String, ApproveCheckType>(
			100);

	static {
		ApproveCheckType[] allValues = ApproveCheckType.values();
		for (ApproveCheckType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ApproveCheckType(String code, String name) {
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

	public static ApproveCheckType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ApproveCheckType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
