/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeIntoAccount.java
 * @Create By 王彬彬
 * @Create In 2016年1月19日 下午3:58:02
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 存入账户
 * @Class Name IntoAccount
 * @author 王彬彬
 * @Create In 2016年1月19日
 */
public enum IntoAccount {
	
	YIBAO("0","易宝POS");
	
	private static Map<String, IntoAccount> nameMap = new HashMap<String, IntoAccount>(
			10);
	private static Map<String, IntoAccount> codeMap = new HashMap<String, IntoAccount>(
			10);

	static {
		IntoAccount[] allValues = IntoAccount.values();
		for (IntoAccount obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private IntoAccount(String code, String name) {
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

	public static IntoAccount parseByName(String name) {
		return nameMap.get(name);
	}

	public static IntoAccount parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
