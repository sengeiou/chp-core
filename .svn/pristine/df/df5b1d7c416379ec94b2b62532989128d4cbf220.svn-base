/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeChannelFlag.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午11:43:08
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name ChannelFlag(渠道标识)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum ChannelFlag {
	JINXIN("0","金信"),
	
	P2P("1","P2P"),
	
	CHP("2","财富"),
	
	TG("3","TG"),
	
	XT01("4","XT01"),
	
	ZCJ("5","ZCJ"),
	
	LIANHE("6","联合");
	
	private static Map<String, ChannelFlag> nameMap = new HashMap<String, ChannelFlag>(
			10);
	private static Map<String, ChannelFlag> codeMap = new HashMap<String, ChannelFlag>(
			10);

	static {
		ChannelFlag[] allValues = ChannelFlag.values();
		for (ChannelFlag obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ChannelFlag(String code, String name) {
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

	public static ChannelFlag parseByName(String name) {
		return nameMap.get(name);
	}

	public static ChannelFlag parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
