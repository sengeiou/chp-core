/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeLiveWith.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:26:09
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name LiveWith
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum LiveWith {
	BROTHER_SISTER("0","兄弟姐妹"),
	
	SELF_LIVE("1","独居"),
	
	PARENT("2","父母"),
	
	WORKMATE("3","同事"),
	
	MATES("4","配偶"),
	
	CHILDREN("5","子女"),
	
	OTHER("6","其它");
	private static Map<String, LiveWith> nameMap = new HashMap<String, LiveWith>(
			10);
	private static Map<String, LiveWith> codeMap = new HashMap<String, LiveWith>(
			10);

	static {
		LiveWith[] allValues = LiveWith.values();
		for (LiveWith obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LiveWith(String code, String name) {
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

	public static LiveWith parseByName(String name) {
		return nameMap.get(name);
	}

	public static LiveWith parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
