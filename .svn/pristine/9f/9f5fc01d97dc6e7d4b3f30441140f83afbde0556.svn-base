/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeSystemFromFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月25日 下午1:59:54
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统来源表示（CHP1.0，CHP2.0，CHP3.0）
 * @Class Name SystemFromFlag
 * @author 王彬彬
 * @Create In 2015年12月25日
 */
public enum SystemFromFlag {
	ONE("1","CHP1.0"),
	
	TWO("2","CHP2.0"),
	
	THREE("3","CHP3.0");
	private static Map<String, SystemFromFlag> nameMap = new HashMap<String, SystemFromFlag>(
			10);
	private static Map<String, SystemFromFlag> codeMap = new HashMap<String, SystemFromFlag>(
			10);

	static {
		SystemFromFlag[] allValues = SystemFromFlag.values();
		for (SystemFromFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private SystemFromFlag(String code, String name) {
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

	public static SystemFromFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static SystemFromFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
