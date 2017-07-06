package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 期限产品回款期限(新)
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum TermproPaytimeNew {
	N30HK("1"), // 30日内(含当日)回款，收取成功转让金额的4%的转让服务费
	T3060RHK("2"), // 30日后、60日内回款，收取成功转让金额的3%的转让服务费
	H60HK("3");// 60日后回款，收取成功转让金额的2%的转让服务费

	public static Map<String, String> termproPaytimeNewMap = new Hashtable<String, String>();

	static {
		termproPaytimeNewMap.put(TermproPaytimeNew.N30HK.value,
				"30日内(含当日)回款，收取成功转让金额的4%的转让服务费");
		termproPaytimeNewMap.put(TermproPaytimeNew.T3060RHK.value,
				"30日后、60日内回款，收取成功转让金额的3%的转让服务费");
		termproPaytimeNewMap.put(TermproPaytimeNew.H60HK.value,
				"60日后回款，收取成功转让金额的2%的转让服务费");
	}
	public final String value;

	private TermproPaytimeNew(String value) {
		this.value = value;
	}

	public static String getTermproPaytimeNew(String value) {
		return termproPaytimeNewMap.get(value);
	}
}