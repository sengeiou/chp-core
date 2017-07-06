package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 归档状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum PigeonholeState {
	WGD("0"), // 未归档
	YGD("1");// 已归档

	public final String value;

	private PigeonholeState(String value) {
		this.value = value;
	}

	public static String getPigeonholeState(String value) {
		return pigeonholeStateMap.get(value);
	}

	public static Map<String, String> pigeonholeStateMap = new Hashtable<String, String>();

	public static void initSingnState() {
		if (pigeonholeStateMap.isEmpty()) {
			pigeonholeStateMap.put(PigeonholeState.WGD.value, "未归档");
			pigeonholeStateMap.put(PigeonholeState.YGD.value, "已归档");
		}
	}
}