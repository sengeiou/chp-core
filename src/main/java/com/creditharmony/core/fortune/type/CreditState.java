package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 债权状态（是否可用）
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CreditState {
	BKY("0"), // 不可用
	KY("1"), // 可用
	DJ("2");// 冻结

	public static Map<String, String> creditStateMap = new Hashtable<String, String>();

	static {
		creditStateMap.put(CreditState.BKY.value, "不可用");
		creditStateMap.put(CreditState.KY.value, "可用");
		creditStateMap.put(CreditState.DJ.value, "冻结");
	}

	public final String value;

	private CreditState(String value) {
		this.value = value;
	}

	public static String getCreditState(String value) {
		return creditStateMap.get(value);
	}
}