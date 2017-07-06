package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 期限产品回款期限
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum TermproPaytime {
	R30NHK("4"), // 30日内(含当日)回款，收取成功转让金额的2%的转让服务费
	T3060RHK("5"), // 30日后、60日内回款，收取成功转让金额的1%的转让服务费
	R60HHK("6");// 60日后回款，不收转让服务费

	public static Map<String, String> termproPaytimeMap = new Hashtable<String, String>();

	static {
		termproPaytimeMap.put(TermproPaytime.R30NHK.value,
				"30日内(含当日)回款，收取成功转让金额的2%的转让服务费");
		termproPaytimeMap.put(TermproPaytime.T3060RHK.value,
				"30日后、60日内回款，收取成功转让金额的1%的转让服务费");
		termproPaytimeMap.put(TermproPaytime.R60HHK.value, "60日后回款，不收转让服务费");
	}

	public final String value;

	private TermproPaytime(String value) {
		this.value = value;
	}

	public static String getTermproPaytime(String value) {
		return termproPaytimeMap.get(value);
	}
}