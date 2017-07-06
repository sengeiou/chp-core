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
 * @Class Name AfraudListType(提报反欺诈类型)
 * @author 李静辉
 * @Create In 2016年1月7日
 */
public enum AfraudReportType {
	VERIFY_REPORT("0","信审提报反欺诈"),
	RECONSIDER_REPORT("1","复议提报反欺诈"),
	AUDIT_REPORT("2","稽核提报反欺诈"),
	SYS_REPORT("3","系统提报反欺诈");

	private static Map<String, AfraudReportType> nameMap = new HashMap<String, AfraudReportType>(
			100);
	private static Map<String, AfraudReportType> codeMap = new HashMap<String, AfraudReportType>(
			100);

	static {
		AfraudReportType[] allValues = AfraudReportType.values();
		for (AfraudReportType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private AfraudReportType(String code, String name) {
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

	public static AfraudReportType parseByName(String name) {
		return nameMap.get(name);
	}

	public static AfraudReportType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
