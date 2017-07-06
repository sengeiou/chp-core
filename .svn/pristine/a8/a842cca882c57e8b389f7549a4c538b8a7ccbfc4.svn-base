/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeYESON.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:29:32
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 工号类型
 * @Class Name PersonType
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum PersonType {

	TEAM_MANAGER("0","团队经理"),
	
	CUSTOMER_MANAGER("1","客户经理");

	private static Map<String, PersonType> nameMap = new HashMap<String, PersonType>(10);
	private static Map<String, PersonType> codeMap = new HashMap<String, PersonType>(10);

	static {
		PersonType[] allValues = PersonType.values();
		for (PersonType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PersonType(String code, String name) {
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

	public static PersonType parseByName(String name) {
		return nameMap.get(name);
	}

	public static PersonType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
