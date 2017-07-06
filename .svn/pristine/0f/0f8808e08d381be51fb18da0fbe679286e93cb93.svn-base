/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeWorkemateRelation.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:17:26
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name WorkemateRelation（其他联系人与本人关系）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum OtherRelation {
	FAMILY("0","亲属"),
	
	FRIENDS("1","朋友"),
	
	WORKMATE("2","同事");
	
	private static Map<String, OtherRelation> nameMap = new HashMap<String, OtherRelation>(
			10);
	private static Map<String, OtherRelation> codeMap = new HashMap<String, OtherRelation>(
			10);

	static {
		OtherRelation[] allValues = OtherRelation.values();
		for (OtherRelation obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private OtherRelation(String code, String name) {
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

	public static OtherRelation parseByName(String name) {
		return nameMap.get(name);
	}

	public static OtherRelation parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
