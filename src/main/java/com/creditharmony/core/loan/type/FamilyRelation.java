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
public enum FamilyRelation {
	
	PARENTS("0","父母"),
	
	CHILDREN("1","子女"),
	
	MATES("2","配偶"),
	
	OTHER_RELATION("3","其他"),
	
	RELATIVES("5","亲属");
	private static Map<String, FamilyRelation> nameMap = new HashMap<String, FamilyRelation>(
			10);
	private static Map<String, FamilyRelation> codeMap = new HashMap<String, FamilyRelation>(
			10);

	static {
		FamilyRelation[] allValues = FamilyRelation.values();
		for (FamilyRelation obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FamilyRelation(String code, String name) {
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

	public static FamilyRelation parseByName(String name) {
		return nameMap.get(name);
	}

	public static FamilyRelation parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
