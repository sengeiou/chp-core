package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 替换状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ReplaceStatus {
	DTH("1"), // 待替换
	YTH("2");// 已替换

	public static Map<String, String> replaceStatusMap = new Hashtable<String, String>();

	static {
		replaceStatusMap.put(ReplaceStatus.DTH.value, "待替换");
		replaceStatusMap.put(ReplaceStatus.YTH.value, "已替换");
	}
	public final String value;

	private ReplaceStatus(String value) {
		this.value = value;
	}

	public static String getReplaceStatus(String value) {
		return replaceStatusMap.get(value);
	}
}