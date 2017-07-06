/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeChannelFlag.java
 * @Create By wangj
 * @Create In 2016年5月18日 上午11:43:08
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name ChannelFlag(渠道标识)
 * @author wangj
 * @Create In 2016年5月18日
 */
public enum CarChannelFlag {

	P2P("0","P2P"),
	
	CHP("1","CHP");
	
	private static Map<String, CarChannelFlag> nameMap = new HashMap<String, CarChannelFlag>(
			10);
	private static Map<String, CarChannelFlag> codeMap = new HashMap<String, CarChannelFlag>(
			10);

	static {
		CarChannelFlag[] allValues = CarChannelFlag.values();
		for (CarChannelFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private CarChannelFlag(String code, String name) {
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

	public static CarChannelFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarChannelFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
