package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 债权来源
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CreditSrc {
	XJ("0"), // 信借
	CJ("1"), // 车借
	FJ("2");// 房借

	public static Map<String, String> creditSrcMap = new Hashtable<String, String>();

	static {
		creditSrcMap.put(CreditSrc.XJ.value, "信借");
		creditSrcMap.put(CreditSrc.CJ.value, "车借");
		creditSrcMap.put(CreditSrc.FJ.value, "房借");
	}
	public final String value;

	private CreditSrc(String value) {
		this.value = value;
	}

	public static String getCreditSrc(String value) {
		return creditSrcMap.get(value);
	}
}