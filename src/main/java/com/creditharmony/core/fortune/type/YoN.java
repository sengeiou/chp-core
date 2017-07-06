package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 是否
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum YoN {
	SHI("1"), // 是
	FOU("2");// 否

	public static Map<String, String> yoNMap = new Hashtable<String, String>();

	static {
		yoNMap.put(YoN.SHI.value, "是");
		yoNMap.put(YoN.FOU.value, "否");
	}
	public final String value;

	private YoN(String value) {
		this.value = value;
	}

	public static String getYoN(String value) {
		return yoNMap.get(value);
	}
}