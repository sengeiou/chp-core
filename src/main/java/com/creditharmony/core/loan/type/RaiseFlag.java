/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRaiseFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月24日 下午3:50:44
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 是否上调标记
 * @Class Name RaiseFlag
 * @author 王彬彬
 * @Create In 2015年12月24日
 */
public enum RaiseFlag {
	NO_UP("0", "未上调"),

	HAS_UP("1", "已上调");

	private static Map<String, RaiseFlag> nameMap = new HashMap<String, RaiseFlag>(
			2);
	private static Map<String, RaiseFlag> codeMap = new HashMap<String, RaiseFlag>(
			2);

	static {
		RaiseFlag[] allValues = RaiseFlag.values();
		for (RaiseFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RaiseFlag(String code, String name) {
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

	public static RaiseFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static RaiseFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
