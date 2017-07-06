/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCpcnStatus.java
 * @Create By 王彬彬
 * @Create In 2016年3月8日 下午1:47:59
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 中金线下预约状态
 * @Class Name CpcnStatus
 * @author 王彬彬
 * @Create In 2016年3月8日
 */
public enum CpcnStatus {
	TO_PROCESS("0","待处理"),
	
	REALTIME("1","实时"),
	
	BATCH("2","批量"),
	
	GIVEUP("3","放弃"),
	
	ORDER("4","预约"),
	
	CANNCEL_ORDER("5","取消预约");
	
	private static Map<String, CpcnStatus> nameMap = new HashMap<String, CpcnStatus>(
			10);
	private static Map<String, CpcnStatus> codeMap = new HashMap<String, CpcnStatus>(
			10);

	static {
		CpcnStatus[] allValues = CpcnStatus.values();
		for (CpcnStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CpcnStatus(String code, String name) {
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

	public static CpcnStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static CpcnStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
