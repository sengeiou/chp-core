/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeDelinquent.java
 * @Create By 王彬彬
 * @Create In 2016年2月25日 下午6:09:47
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 催收方式
 * @Class Name Delinquent
 * @author 王彬彬
 * @Create In 2016年2月25日
 */
public enum Delinquent {
	ELECTIC("0","电催"),
	
	POS("1","POS催收");
	
	private static Map<String, Delinquent> nameMap = new HashMap<String, Delinquent>(
			10);
	private static Map<String, Delinquent> codeMap = new HashMap<String, Delinquent>(
			10);

	static {
		Delinquent[] allValues = Delinquent.values();
		for (Delinquent obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private Delinquent(String code, String name) {
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

	public static Delinquent parseByName(String name) {
		return nameMap.get(name);
	}

	public static Delinquent parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
