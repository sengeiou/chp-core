package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/**
 * 优先回款
 * 2017年3月22日
 * @author 郭强
 */
public enum PriorityBack {
	FOU("0"), // 否
	SHI("1");// 是

	public static Map<String, String> PriorityBackMap = new Hashtable<String, String>();

	static {
		PriorityBackMap.put(PriorityBack.SHI.value, "是");
		PriorityBackMap.put(PriorityBack.FOU.value, "否");
	}
	public final String value;

	private PriorityBack(String value) {
		this.value = value;
	}

	public static String getPriorityBack(String value) {
		return PriorityBackMap.get(value);
	}
}
