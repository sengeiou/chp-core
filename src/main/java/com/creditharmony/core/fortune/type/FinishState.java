package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 完结状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum FinishState {
	WWJ("1"), // 未完结
	YWJ("2"), // 已完结
	KHFQ("3");// 客户放弃

	public final String value;

	private FinishState(String value) {
		this.value = value;
	}

	public static String getFinishState(String value) {
		return finishStateMap.get(value);
	}

	public static Map<String, String> finishStateMap = new Hashtable<String, String>();

	public static void initFinishState() {
		if (finishStateMap.isEmpty()) {
			finishStateMap.put(FinishState.WWJ.value, "未完结");
			finishStateMap.put(FinishState.YWJ.value, "已完结");
			finishStateMap.put(FinishState.KHFQ.value, "客户放弃");
		}
	}
}