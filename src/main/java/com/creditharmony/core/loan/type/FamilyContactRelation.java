/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeFamilyRelation.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:12:09
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name FamilyRelation（家庭联系人关系）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum FamilyContactRelation {
	
	PARENTS("0","父母"),
	
	CHILDREN("1","子女"),

	OTHER_RELATION("2","其他");
	private static Map<String, FamilyContactRelation> nameMap = new HashMap<String, FamilyContactRelation>(
			10);
	private static Map<String, FamilyContactRelation> codeMap = new HashMap<String, FamilyContactRelation>(
			10);

	static {
		FamilyContactRelation[] allValues = FamilyContactRelation.values();
		for (FamilyContactRelation obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FamilyContactRelation(String code, String name) {
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

	public static FamilyContactRelation parseByName(String name) {
		return nameMap.get(name);
	}

	public static FamilyContactRelation parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
