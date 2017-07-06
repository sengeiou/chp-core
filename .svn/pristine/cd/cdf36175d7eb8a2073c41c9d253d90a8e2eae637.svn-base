package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 账单收取方式
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BilltakenMode {
	XJ("1"), // 信件
	DZYJ("2");// 电子邮件

	public static Map<String, String> billtakenModeMap = new Hashtable<String, String>();

	static {
		billtakenModeMap.put(BilltakenMode.XJ.value, "信件");
		billtakenModeMap.put(BilltakenMode.DZYJ.value, "电子邮件");
	}

	public final String value;

	private BilltakenMode(String value) {
		this.value = value;
	}

	public static String getBilltakenMode(String value) {
		return billtakenModeMap.get(value);
	}
}