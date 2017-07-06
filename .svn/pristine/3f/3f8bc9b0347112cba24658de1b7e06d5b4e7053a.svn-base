/**
 * 
 */
package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 划扣平台类型
 * @Name Name DeductPlatType 
 * @author 施大勇
 * @Create In 2016年01月27日
 */
public enum DeductPlatType {
	
	FY("0", "富友"),
	HYL("1", "好易联"),
	ZJ("2", "中金"),
	TL("3", "通联"),
	ZCJ("4", "ZCJ金账户"),
	KL("6", "卡联"),
	CJT("7", "畅捷通");
	private static Map<String, DeductPlatType> nameMap = new HashMap<String, DeductPlatType>();
	private static Map<String, DeductPlatType> codeMap = new HashMap<String, DeductPlatType>();
	static {
		DeductPlatType[] allValues = DeductPlatType.values();
		for (DeductPlatType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}
	/**
	 * 代码
	 */
	private String name;
	/**
	 * 含意
	 */
	private String code;

	private DeductPlatType(String code, String name) {
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

	public static DeductPlatType parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductPlatType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
