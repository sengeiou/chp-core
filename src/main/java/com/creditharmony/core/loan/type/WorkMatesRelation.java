/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeWorkMatesRelation.java
 * @Create By 王彬彬
 * @Create In 2016年2月2日 下午2:36:28
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 和工作证明人关系
 * @Class Name WorkMatesRelation
 * @author 王彬彬
 * @Create In 2016年2月2日
 */
public enum WorkMatesRelation {
	WORKMATE("0", "同事"),

	OTHER("2", "其他");

	private static Map<String, WorkMatesRelation> nameMap = new HashMap<String, WorkMatesRelation>(
			10);
	private static Map<String, WorkMatesRelation> codeMap = new HashMap<String, WorkMatesRelation>(
			10);

	static {
		WorkMatesRelation[] allValues = WorkMatesRelation.values();
		for (WorkMatesRelation obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private WorkMatesRelation(String code, String name) {
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

	public static WorkMatesRelation parseByName(String name) {
		return nameMap.get(name);
	}

	public static WorkMatesRelation parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
