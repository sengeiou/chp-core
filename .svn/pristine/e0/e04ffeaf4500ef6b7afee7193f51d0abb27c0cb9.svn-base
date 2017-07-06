package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 划扣处理状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum DealState {
	WCL("1"), // 未处理
	YCL("2"), // 已处理
	CLZ("3");// 处理中

	public static Map<String, String> dealStateMap = new Hashtable<String, String>();

	static {
		dealStateMap.put(DealState.WCL.value, "未处理");
		dealStateMap.put(DealState.YCL.value, "已处理");
		dealStateMap.put(DealState.CLZ.value, "处理中");
	}
	public final String value;

	private DealState(String value) {
		this.value = value;
	}

	public static String getDealState(String value) {
		return dealStateMap.get(value);
	}
}