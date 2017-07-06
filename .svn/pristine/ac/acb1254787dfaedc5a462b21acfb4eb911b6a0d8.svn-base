package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 划扣方式类型
 * @Name Name DeductType 
 * @author 施大勇
 * @Create In 2016年01月27日
 */
public enum DeductType {

	REALTIME("0", "实时"),
	BATCH("1", "批量");
	
	private static Map<String, DeductType> nameMap = new HashMap<String, DeductType>();
	private static Map<String, DeductType> codeMap = new HashMap<String, DeductType>();
	static {
		DeductType[] allValues = DeductType.values();
		for (DeductType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}
	private String name;
	private String code;

	private DeductType(String code, String name) {
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

	public static DeductType parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
