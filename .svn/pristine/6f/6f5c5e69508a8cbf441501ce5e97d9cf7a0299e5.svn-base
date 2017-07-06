/**
 * 
 */
package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 划扣种类类型
 * @Name Name DeductFlagType 
 * @author 施大勇
 * @Create In 2016年01月27日
 */
public enum DeductFlagType {

	COLLECTION("0", "代收"),
	PAY("1", "代付");
	
	
	private static Map<String, DeductFlagType> nameMap = new HashMap<String, DeductFlagType>();
	private static Map<String, DeductFlagType> codeMap = new HashMap<String, DeductFlagType>();
	static {
		DeductFlagType[] allValues = DeductFlagType.values();
		for (DeductFlagType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}
	private String name;
	private String code;

	private DeductFlagType(String code, String name) {
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

	public static DeductFlagType parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductFlagType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
