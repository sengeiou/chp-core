/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeReconsideReason.java
 * @Create By 王彬彬
 * @Create In 2015年12月24日 下午3:30:33
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 复议类型
 * 
 * @Class Name ReconsideReason
 * @author 王彬彬
 * @Create In 2015年12月24日
 */
public enum ReconsideReason {
	REJECTED("0", "被拒客户"),

	LIMIT_UP("1", "提高额度"),

	TERM_CHANGE("2", "修改期限"),

	OTHER("3", "其他");

	private static Map<String, ReconsideReason> nameMap = new HashMap<String, ReconsideReason>(
			10);
	private static Map<String, ReconsideReason> codeMap = new HashMap<String, ReconsideReason>(
			10);

	static {
		ReconsideReason[] allValues = ReconsideReason.values();
		for (ReconsideReason obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ReconsideReason(String code, String name) {
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

	public static ReconsideReason parseByName(String name) {
		return nameMap.get(name);
	}

	public static ReconsideReason parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
