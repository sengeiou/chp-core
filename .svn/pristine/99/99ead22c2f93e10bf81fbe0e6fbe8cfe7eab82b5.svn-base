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
 * @Class Name AfraudListStatus(反欺诈解除状态)
 * @author 李静辉
 * @Create In 2016年1月7日
 */
public enum AfraudListStatus {
	NOT_LIFTED("0","未解除"),
	IS_LIFTED("1","已解除")
;
	
	private static Map<String, AfraudListStatus> nameMap = new HashMap<String, AfraudListStatus>(
			100);
	private static Map<String, AfraudListStatus> codeMap = new HashMap<String, AfraudListStatus>(
			100);

	static {
		AfraudListStatus[] allValues = AfraudListStatus.values();
		for (AfraudListStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AfraudListStatus(String code, String name) {
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

	public static AfraudListStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static AfraudListStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
