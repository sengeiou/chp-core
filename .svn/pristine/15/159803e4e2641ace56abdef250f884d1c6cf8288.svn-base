/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeJobType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:28:19
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name JobType(职务)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum JobType {
	NORMAL_WORKER("0","普通员工"),
	
	MANAGER("1","管理人员"),
	
	CORPORATE ("2","法人代表"),
	
	SHAREHOLDER("3","股东");
	
	private static Map<String, JobType> nameMap = new HashMap<String, JobType>(
			10);
	private static Map<String, JobType> codeMap = new HashMap<String, JobType>(
			10);

	static {
		JobType[] allValues = JobType.values();
		for (JobType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private JobType(String code, String name) {
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

	public static JobType parseByName(String name) {
		return nameMap.get(name);
	}

	public static JobType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
