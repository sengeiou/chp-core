package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/***
 * 交割类型
 * @Class Name AreaType
 * @author 赵红江
 * @Create In 2015年12月30日
 */
public enum DeliveryType {
	KHJG("1"), // 客户交割
	YWJG("2"),// 业务交割
	LZZDJG("3"),// 离职自动交割
	SB("4"), // 失败
	KHXZ("5"), // 客户新增
	KHRZ("6"), // 客户认证
	SJHBG("7"), // 手机号变更
	ZZ("8"), // 转赠
	XFLJ("9");// 修复链接

	public final String value;

	private DeliveryType(String value) {
		this.value = value;
	}

	public static Map<String, String> deliveryTypeMap = null;
	public static String getDeliveryType(String value) {
		if(null==deliveryTypeMap){
			initOrderStatus();
		}
		return deliveryTypeMap.get(value);
	}

	public static void initOrderStatus() {
		deliveryTypeMap = new HashMap<String, String>();
		deliveryTypeMap.put(DeliveryType.KHJG.value, "客户交割");
		deliveryTypeMap.put(DeliveryType.YWJG.value, "业务交割");
		deliveryTypeMap.put(DeliveryType.LZZDJG.value, "离职自动交割");
		deliveryTypeMap.put(DeliveryType.SB.value, "失败");
		deliveryTypeMap.put(DeliveryType.KHXZ.value, "客户新增");
		deliveryTypeMap.put(DeliveryType.KHRZ.value, "客户认证");
		deliveryTypeMap.put(DeliveryType.SJHBG.value, "手机号变更");
		deliveryTypeMap.put(DeliveryType.ZZ.value, "转赠");
		deliveryTypeMap.put(DeliveryType.XFLJ.value, "修复链接");
	}
}