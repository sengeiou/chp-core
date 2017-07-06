package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 付款方式
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum PayMent {
	HK("1"), // 划扣
	NBZZ("2"), // 内部转账
	NBZZHHK("3"), // 内部转账和划扣
	ZJTG("4"), // 资金托管
	SHNZ("5"),// 赎回内转
	CGBFNZ("6"), // 成功部分内转
	ZZ("7"); // 自转

	public static Map<String, String> payMentMap = new Hashtable<String, String>();
	static{
		payMentMap.put(PayMent.HK.value, "划扣");
		payMentMap.put(PayMent.NBZZ.value, "内部转账");
		payMentMap.put(PayMent.NBZZHHK.value, "内部转账和划扣");
		payMentMap.put(PayMent.ZJTG.value, "资金托管");
		payMentMap.put(PayMent.SHNZ.value, "赎回内转");
		payMentMap.put(PayMent.CGBFNZ.value, "成功部分内转");
		payMentMap.put(PayMent.ZZ.value, "自转");
	}
	public final String value;

	private PayMent(String value) {
		this.value = value;
	}

	public static String getPayMent(String value) {
		return payMentMap.get(value);
	}
}