package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 成单状态
 * @Class Name AreaType
 * @author 赵红江
 * @Create In 2015年12月30日
 */
public enum OrderStatus {
	WCD("0"),// 未成单
	YCD("1");// 已成单

	public final String value;

	private OrderStatus(String value) {
		this.value = value;
	}

	public static String getOrderStatus(String value) {
		return orderStatusMap.get(value);
	}

	public static Map<String, String> orderStatusMap = new Hashtable<String, String>();

	public static void initOrderStatus() {
		if (orderStatusMap.isEmpty()) {
			orderStatusMap.put(OrderStatus.WCD.value, "未成单");
			orderStatusMap.put(OrderStatus.YCD.value, "已成单");
		}
	}
}