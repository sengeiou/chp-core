/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeProfType.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:37:51
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户职业类型
 * @Class Name ProfType 
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum ProfType {
	NORMAL_OFFICER("0", "一般职员"),

	SALARY_OFFICER("1", "高薪职员"),

	SELF_OPERATE("2", "业主"),

	MIDDLE_COMPANY_OPERATER("3", "中小业主"),

	BIG_COMPANY_OPERATER("4", "大企业主"),
	
	SMAL_COMPANY_OPERATER("5","微企业主"),
	
	PLEDGE_RES("6","抵押物"),
	
	PLEDGE("7","质押"),
	
	PLEDGE_HOUSE("8","抵押房"),
	
	PLEDGE_CAR("9","抵押车");

	private static Map<String, ProfType> nameMap = new HashMap<String, ProfType>(
			10);
	private static Map<String, ProfType> codeMap = new HashMap<String, ProfType>(
			10);

	static {
		ProfType[] allValues = ProfType.values();
		for (ProfType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ProfType(String code, String name) {
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

	public static ProfType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ProfType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
