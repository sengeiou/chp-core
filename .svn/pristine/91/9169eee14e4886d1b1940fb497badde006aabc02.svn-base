package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 配置状态
 * 
 * @Class Name ConfigStatus
 * @author 朱杰
 * @Create In 2015年12月28日
 */
public enum ConfigStatus {
	TY("0"), // 停用
	QY("1"); // 启用

	public static Map<String, String> configStatusMap = new Hashtable<String, String>();

	static {
		configStatusMap.put(ConfigStatus.TY.value, "停用");
		configStatusMap.put(ConfigStatus.QY.value, "启用");
	}
	public final String value;

	private ConfigStatus(String value) {
		this.value = value;
	}

	public static String getConfigStatus(String value) {
		return configStatusMap.get(value);
	}
}