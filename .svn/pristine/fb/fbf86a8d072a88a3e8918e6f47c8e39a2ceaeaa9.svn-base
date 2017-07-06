package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 维护状态
 * @Class Name MaintainStatus
 * @author 王彬彬
 * @Create In 2016年2月25日
 */
public enum MaintainStatus {
	
	TO_CHECK("0","待审核"),
	
	TO_REFUSE("1","拒绝"),
	
	TO_MAINTAIN("2","已维护"),
	
	TO_FIRST("3","待审核"),
	
	TO_WAITUPDATE("4","已变更待审核");

	private static Map<String, MaintainStatus> nameMap = new HashMap<String, MaintainStatus>(
			10);
	private static Map<String, MaintainStatus> codeMap = new HashMap<String, MaintainStatus>(
			10);

	static {
		MaintainStatus[] allValues = MaintainStatus.values();
		for (MaintainStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private MaintainStatus(String code, String name) {
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

	public static MaintainStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static MaintainStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
