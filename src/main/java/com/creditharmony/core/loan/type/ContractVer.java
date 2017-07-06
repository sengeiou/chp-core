/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeContractVer.java
 * @Create By 王彬彬
 * @Create In 2016年3月12日 下午12:50:35
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 合同版本
 * @Class Name ContractVer
 * @author 王彬彬
 * @Create In 2016年3月12日
 */
public enum ContractVer {
	VER_ONE_ZERO("0","1.0"),
	
	VER_ONE_ONE("1","1.1"),
	
	VER_ONE_TWO("2","1.2"),
	
	VER_ONE_THREE("3","1.3"),
	
	VER_ONE_FOUR("4","1.4"),
	
	VER_ONE_FIVE("5","1.5"),
	
	VER_ONE_SIX("6","1.6"),
	
	VER_ONE_SEVEN("7","1.7"),
	
	VER_ONE_EIGHT("8","1.8"),
	
	VER_ONE_TWO_ZCJ("97","1.2XYJ"),
	
	VER_ONE_ONE_ZCJ("98","1.1XYJ"),
	
	VER_ONE_ZERO_ZCJ("99","1.0ZCJ"),
	
	VER_ONE_ZERO_NXD("90","1.0NXD");
	//VER_ONE_LAST("5","1.5");
	
	private static Map<String, ContractVer> nameMap = new HashMap<String, ContractVer>(
			50);
	private static Map<String, ContractVer> codeMap = new HashMap<String, ContractVer>(
			50);

	static {
		ContractVer[] allValues = ContractVer.values();
		for (ContractVer obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ContractVer(String code, String name) {
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

	public static ContractVer parseByName(String name) {
		return nameMap.get(name);
	}

	public static ContractVer parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
