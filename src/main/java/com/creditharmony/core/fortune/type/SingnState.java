package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 签收状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum SingnState {
	WQS("0"), // 未签收
	YQS("1"); // 已签收

	public static Map<String, String> singnStateMap = new Hashtable<String, String>();

	static {
		singnStateMap.put(SingnState.WQS.value, "未签收");
		singnStateMap.put(SingnState.YQS.value, "已签收");
	}
	public final String value;

	private SingnState(String value) {
		this.value = value;
	}

	public static String getSingnState(String value) {
		return singnStateMap.get(value);
	}
}