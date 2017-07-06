/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.JkHaveOrNoHave.java
 * @Create By 张进
 * @Create In 2016年1月6日 
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 汇金有无
 * @Class Name JkHaveOrNoHave
 * @author 张进
 * @Create In 2016年1月6日
 */
public enum JkHaveOrNoHave {
	
	YHAVE("0","无"),
	
	NOHAVE("1","有");

	private static Map<String, JkHaveOrNoHave> nameMap = new HashMap<String, JkHaveOrNoHave>(
			10);
	private static Map<String, JkHaveOrNoHave> codeMap = new HashMap<String, JkHaveOrNoHave>(
			10);

	static {
		JkHaveOrNoHave[] allValues = JkHaveOrNoHave.values();
		for (JkHaveOrNoHave obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private JkHaveOrNoHave(String code, String name) {
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

	public static JkHaveOrNoHave parseByName(String name) {
		return nameMap.get(name);
	}

	public static JkHaveOrNoHave parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
