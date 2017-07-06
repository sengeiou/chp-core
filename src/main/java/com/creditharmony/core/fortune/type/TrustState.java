package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 托管状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum TrustState {
	WKH("0"), // 未开户
	SQZ("1"), // 申请中
	KHCG("2"), // 开户成功
	KHSB("3"), // 开户失败
	XHZ("4"), // 销户中
	YXH("5"); // 已销户

	public static Map<String, String> trustStateMap = new Hashtable<String, String>();

	static {
		trustStateMap.put(TrustState.WKH.value, "未开户");
		trustStateMap.put(TrustState.SQZ.value, "申请中");
		trustStateMap.put(TrustState.KHCG.value, "开户成功");
		trustStateMap.put(TrustState.KHSB.value, "开户失败");
		trustStateMap.put(TrustState.XHZ.value, "销户中");
		trustStateMap.put(TrustState.YXH.value, "已销户");
	}
	public final String value;

	private TrustState(String value) {
		this.value = value;
	}

	public static String getTrustState(String value) {
		return trustStateMap.get(value);
	}
}