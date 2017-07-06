package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 产品转换状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ProtranState {
	DSP("0"), // 待审批
	SPTG("1"), // 审批通过
	SPBTG("2"), // 审批不通过
	YWJ("3"), // 已完结
	WSX("4"), // 未生效
	YSX("5");// 已生效

	public static Map<String, String> protranStateMap = new Hashtable<String, String>();

	static {
		protranStateMap.put(ProtranState.DSP.value, "待审批");
		protranStateMap.put(ProtranState.SPTG.value, "审批通过");
		protranStateMap.put(ProtranState.SPBTG.value, "审批不通过");
		protranStateMap.put(ProtranState.YWJ.value, "已完结");
		protranStateMap.put(ProtranState.WSX.value, "未生效");
		protranStateMap.put(ProtranState.YSX.value, "已生效");
	}
	public final String value;

	private ProtranState(String value) {
		this.value = value;
	}

	public static String getProtranState(String value) {
		return protranStateMap.get(value);
	}
}