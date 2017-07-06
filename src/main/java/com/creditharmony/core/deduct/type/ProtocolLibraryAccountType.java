/**
 * 
 */
package com.creditharmony.core.deduct.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 协议库对接账户类型
 * 
 * @Class Name ProtocolLibraryAccountType
 * @author 朱杰
 * @Create In 2016年2月29日
 */
public enum ProtocolLibraryAccountType {
	JJK("01", "借记卡"),
	DJK("02", "贷记卡"),
	ZDJK("03", "准贷记卡");
	private static Map<String, ProtocolLibraryAccountType> nameMap = new HashMap<String, ProtocolLibraryAccountType>(10);
	private static Map<String, ProtocolLibraryAccountType> codeMap = new HashMap<String, ProtocolLibraryAccountType>(10);
	static {
		ProtocolLibraryAccountType[] allValues = ProtocolLibraryAccountType.values();
		for (ProtocolLibraryAccountType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ProtocolLibraryAccountType(String code, String name) {
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

	public static ProtocolLibraryAccountType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ProtocolLibraryAccountType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
