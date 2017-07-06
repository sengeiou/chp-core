package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 收取方式
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum TakenMode {
	XJ("1"), // 信件
	DZYJ("2"), // 电子邮件
	EZDS("3");// 二者都收

	public static Map<String, String> takenModeMap = new Hashtable<String, String>();

	static {
		takenModeMap.put(TakenMode.XJ.value, "信件");
		takenModeMap.put(TakenMode.DZYJ.value, "电子邮件");
		takenModeMap.put(TakenMode.EZDS.value, "二者都收");
	}
	public final String value;

	private TakenMode(String value) {
		this.value = value;
	}

	public static String getTakenMode(String value) {
		return takenModeMap.get(value);
	}
}