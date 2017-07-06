package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 协议版本
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ProtocolVersion {
	D11BB("0"), // 1.1
	D12BB("1"), // 1.2
	D161BB("2"); // 1.6.1
	//D13BB("1.3"), // 1.3
	//D13BBXT("1.3续投"), // 1.3续投
	//D14BB("1.4"), // 1.4
	//D14D1("1.4.1"), // 1.4.1
	//D21("2.1"), // 2.1
	//D22("2.2");// 2.2

	public static Map<String, String> protocolVersionMap = new Hashtable<String, String>();

	static {
		protocolVersionMap.put(ProtocolVersion.D11BB.value, "1.1");
		protocolVersionMap.put(ProtocolVersion.D12BB.value, "1.2");
		protocolVersionMap.put(ProtocolVersion.D161BB.value, "1.6.1");
		/*protocolVersionMap.put(ProtocolVersion.D13BB.value, "1.3");
		protocolVersionMap.put(ProtocolVersion.D13BBXT.value, "1.3续投");
		protocolVersionMap.put(ProtocolVersion.D14BB.value, "1.4");
		protocolVersionMap.put(ProtocolVersion.D14D1.value, "1.4.1");
		protocolVersionMap.put(ProtocolVersion.D21.value, "2.1");
		protocolVersionMap.put(ProtocolVersion.D22.value, "2.2");*/
	}
	public final String value;

	private ProtocolVersion(String value) {
		this.value = value;
	}

	public static String getProtocolVersion(String value) {
		return protocolVersionMap.get(value);
	}
}