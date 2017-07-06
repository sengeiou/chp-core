package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 交割状态
 * @Class Name AreaType
 * @author 赵红江
 * @Create In 2015年12月30日
 */
public enum DeliveryStatus {
	DJG("0"),// 待交割
	JGWC("1"),// 交割完成
	WJGG("2");// 未交割过

	public final String value;

	private DeliveryStatus(String value) {
		this.value = value;
	}

	public static String getDeliveryStatus(String value) {
		return deliveryStatusMap.get(value);
	}

	public static Map<String, String> deliveryStatusMap = new Hashtable<String, String>();

	public static void initOrderStatus() {
		if (deliveryStatusMap.isEmpty()) {
			deliveryStatusMap.put(DeliveryStatus.DJG.value, "待交割");
			deliveryStatusMap.put(DeliveryStatus.JGWC.value, "交割完成");
			deliveryStatusMap.put(DeliveryStatus.WJGG.value, "未交割过");
		}
	}
}