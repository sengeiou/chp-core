/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeOperateType.java
 * @Create By 王彬彬
 * @Create In 2015年12月22日 下午2:29:08
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 匹配操作
 * @Class Name OperateMatching
 * @author zhangfeng
 * @Create In 2015年12月23日
 */
public enum OperateMatching {
	SUCCESS_MATCHING("0", "匹配成功"),

	BACK_MATCHING("1", "匹配退回");

	private static Map<String, OperateMatching> nameMap = new HashMap<String, OperateMatching>(
			2);
	private static Map<String, OperateMatching> codeMap = new HashMap<String, OperateMatching>(
			2);

	static {
		OperateMatching[] allValues = OperateMatching.values();
		for (OperateMatching obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private OperateMatching(String code, String name) {
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

	public static OperateMatching parseByName(String name) {
		return nameMap.get(name);
	}

	public static OperateMatching parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
