package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 性别
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum Sex {
	MEN("1"), // 男
	WOMEN("2");// 女

	public static Map<String, String> sexMap = new Hashtable<String, String>();

	static {
		sexMap.put(Sex.MEN.value, "男");
		sexMap.put(Sex.WOMEN.value, "女");
	}
	public final String value;

	private Sex(String value) {
		this.value = value;
	}

	public static String getSex(String value) {
		return sexMap.get(value);
	}
}