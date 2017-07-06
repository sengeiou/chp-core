package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 派发状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum DistributeState {
	WPF("1"), // 未派发
	YPF("2"), // 已派发
	BFPF("3");// 部分派发

	public final String value;

	private DistributeState(String value) {
		this.value = value;
	}

	public static String getDistributeState(String value) {
		return distributeStateMap.get(value);
	}

	public static Map<String, String> distributeStateMap = new Hashtable<String, String>();

	public static void initDistributeStateNew() {
		if (distributeStateMap.isEmpty()) {
			distributeStateMap.put(DistributeState.WPF.value, "未派发");
			distributeStateMap.put(DistributeState.YPF.value, "已派发");
			distributeStateMap.put(DistributeState.BFPF.value, "部分派发");
		}
	}
}