package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/**
 * 渠道标识
 * @Class Name FortuneChannelFlag
 * @author 陈广鹏
 * @Create In 2016年6月20日
 */
public enum FortuneChannelFlag {
	
	XX("1","xx"),
	DJR("2","djr"),
	//金信
	JX("3","jx");
	
	public final String value;
	
	public final String name;

	private FortuneChannelFlag(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public static Map<String, FortuneChannelFlag> channalFlagMap ;
	
	static {
		channalFlagMap = new Hashtable<String, FortuneChannelFlag>();
		channalFlagMap.put(FortuneChannelFlag.XX.value, XX);
		channalFlagMap.put(FortuneChannelFlag.DJR.value, DJR);
		channalFlagMap.put(FortuneChannelFlag.JX.value, JX);
	}
	
	public static FortuneChannelFlag getChannalFlag(String value) {
		return channalFlagMap.get(value);
	}

}
