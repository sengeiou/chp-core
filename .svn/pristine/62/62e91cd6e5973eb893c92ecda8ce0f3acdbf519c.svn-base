/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDegree.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:42:51
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name Degree(学历)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum Degree {
	MASTER("0", "硕士及以上"),

	COURSE("1", "本科"),

	JUNIOR_COLLEGE("2", "大专"),

	SENIOR("3", "高中专"),

	JUNIOR("4", "初中及以下");
	private static Map<String, Degree> nameMap = new HashMap<String, Degree>(
			10);
	private static Map<String, Degree> codeMap = new HashMap<String, Degree>(
			10);

	static {
		Degree[] allValues = Degree.values();
		for (Degree obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private Degree(String code, String name) {
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

	public static Degree parseByName(String name) {
		return nameMap.get(name);
	}

	public static Degree parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
