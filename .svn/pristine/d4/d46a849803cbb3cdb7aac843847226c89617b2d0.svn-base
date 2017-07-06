package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 申请状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum AppalyState {
	DSH("0"), // 待审核
	SHTG("1"), // 审核通过
	SHBTG("2"), // 审核不通过
	YPF("3"), // 已派发
	WWQPF("4");// 未完全派发

	public static Map<String, String> appalyStateMap = new Hashtable<String, String>();

	static {
		appalyStateMap.put(AppalyState.DSH.value, "待审核");
		appalyStateMap.put(AppalyState.SHTG.value, "审核通过");
		appalyStateMap.put(AppalyState.SHBTG.value, "审核不通过");
		appalyStateMap.put(AppalyState.YPF.value, "已派发");
		appalyStateMap.put(AppalyState.WWQPF.value, "未完全派发");
	}
	public final String value;

	private AppalyState(String value) {
		this.value = value;
	}

	public static String getAppalyState(String value) {
		return appalyStateMap.get(value);
	}
}