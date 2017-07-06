package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 协议种类
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ProtocolType {
	DT("1"), // 定投
	FDT("2");// 非定投

	public static Map<String, String> protocolTypeMap = new Hashtable<String, String>();

	static {
		protocolTypeMap.put(ProtocolType.DT.value, "定投");
		protocolTypeMap.put(ProtocolType.FDT.value, "非定投");
	}
	public final String value;

	private ProtocolType(String value) {
		this.value = value;
	}

	public static String getProtocolType(String value) {
		return protocolTypeMap.get(value);
	}
}