package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 账单类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BillState {
	SQ("1"), // 首期
	FSQ("2");// 非首期

	public static Map<String, String> billStateMap = new Hashtable<String, String>();

	static {
		billStateMap.put(BillState.SQ.value, "首期");
		billStateMap.put(BillState.FSQ.value, "非首期");
	}
	public final String value;

	private BillState(String value) {
		this.value = value;
	}

	public static String getBillState(String value) {
		return billStateMap.get(value);
	}
}