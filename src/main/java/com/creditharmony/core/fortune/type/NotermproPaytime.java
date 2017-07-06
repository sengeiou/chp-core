package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 非期限产品回款期限
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum NotermproPaytime {
	R7NHK("7"), // 7日内(含当日)回款，收取成功转让金额的5%的转让服务费
	T730RHK("8"), // 7日后、30日内回款，收取成功转让金额的4%的转让服务费
	T3060RHK("9"), // 30日后、60日内回款，收取成功转让金额的3%的转让服务费
	R60HHK("10");// 60日后回款，收取成功转让金额的2%的转让服务费

	public final String value;

	private NotermproPaytime(String value) {
		this.value = value;
	}

	public static String getNotermproPaytime(String value) {
		return notermproPaytimeMap.get(value);
	}

	public static Map<String, String> notermproPaytimeMap = new Hashtable<String, String>();

	public static void initNotermproPaytime() {
		if (notermproPaytimeMap.isEmpty()) {
			notermproPaytimeMap.put(NotermproPaytime.R7NHK.value,
					"7日内(含当日)回款，收取成功转让金额的5%的转让服务费");
			notermproPaytimeMap.put(NotermproPaytime.T730RHK.value,
					"7日后、30日内回款，收取成功转让金额的4%的转让服务费");
			notermproPaytimeMap.put(NotermproPaytime.T3060RHK.value,
					"30日后、60日内回款，收取成功转让金额的3%的转让服务费");
			notermproPaytimeMap.put(NotermproPaytime.R60HHK.value,
					"60日后回款，收取成功转让金额的2%的转让服务费");
		}
	}
}