package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 婚姻状况
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum MaritalState {
	YH("1"), // 已婚
	WH("2"), // 未婚
	SO("3"), // 丧偶
	LY("4");// 离异

	public final String value;

	private MaritalState(String value) {
		this.value = value;
	}

	public static String getMaritalState(String value) {
		return maritalStateMap.get(value);
	}

	public static Map<String, String> maritalStateMap = new Hashtable<String, String>();

	public static void initMaritalState() {
		if (maritalStateMap.isEmpty()) {
			maritalStateMap.put(MaritalState.YH.value, "已婚");
			maritalStateMap.put(MaritalState.WH.value, "未婚");
			maritalStateMap.put(MaritalState.SO.value, "丧偶");
			maritalStateMap.put(MaritalState.LY.value, "离异");
		}
	}
}