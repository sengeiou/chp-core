/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRejectDepartment.java
 * @Create By 王彬彬
 * @Create In 2016年3月12日 下午7:04:54
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 门店绝决，放弃标识
 * @Class Name RejectDepartment
 * @author 王彬彬
 * @Create In 2016年3月12日
 */
public enum RejectDepartment {
	LOAN_GIVE("0","客户放弃"),
	
	LOAN_REJECT("1","门店拒绝"),
	
	APPROVE_CHECK("2","拒绝放弃审批");
	
	private static Map<String, RejectDepartment> nameMap = new HashMap<String, RejectDepartment>(
			10);
	private static Map<String, RejectDepartment> codeMap = new HashMap<String, RejectDepartment>(
			10);

	static {
		RejectDepartment[] allValues = RejectDepartment.values();
		for (RejectDepartment obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RejectDepartment(String code, String name) {
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

	public static RejectDepartment parseByName(String name) {
		return nameMap.get(name);
	}

	public static RejectDepartment parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
