/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCardBook.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:02:23
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 资金托管待放款文件导出状态
 * @Class Name TrustGrantOutputStatus
 * @author 朱杰
 * @Create In 2016年3月15日
 */
public enum TrustGrantOutputStatus {
	EXCEL1("1","EXCEL1"),	
	EXCEL2("2","EXCEL2"),
	THAW1("3","解冻1"),
	THAW2("4","解冻2");
	
	private static Map<String, TrustGrantOutputStatus> nameMap = new HashMap<String, TrustGrantOutputStatus>(
			5);
	private static Map<String, TrustGrantOutputStatus> codeMap = new HashMap<String, TrustGrantOutputStatus>(
			5);

	static {
		TrustGrantOutputStatus[] allValues = TrustGrantOutputStatus.values();
		for (TrustGrantOutputStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TrustGrantOutputStatus(String code, String name) {
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

	public static TrustGrantOutputStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static TrustGrantOutputStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
