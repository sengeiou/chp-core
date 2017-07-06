package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 投资状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum InvestState {
	WT("1"), // 未投
	ZT("2"), // 在投
	YT("3");// 已投

	public final String value;

	private InvestState(String value) {
		this.value = value;
	}

	public static String getInvestState(String value) {
		return investStateMap.get(value);
	}

	public static Map<String, String> investStateMap = new Hashtable<String, String>();

	public static void initInvestState() {
		if (investStateMap.isEmpty()) {
			investStateMap.put(InvestState.WT.value, "未投");
			investStateMap.put(InvestState.ZT.value, "在投");
			investStateMap.put(InvestState.YT.value, "已投");
		}
	}
}