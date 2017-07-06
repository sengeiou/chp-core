package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 债权是否已经释放
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CreditRelease {
	MSF("0"), // 没释放
	YSF("1");// 已释放

	public static Map<String, String> creditReleaseMap = new Hashtable<String, String>();

	static {
		creditReleaseMap.put(CreditRelease.MSF.value, "没释放");
		creditReleaseMap.put(CreditRelease.YSF.value, "已释放");
	}
	public final String value;

	private CreditRelease(String value) {
		this.value = value;
	}

	public static String getCreditRelease(String value) {
		return creditReleaseMap.get(value);
	}
}