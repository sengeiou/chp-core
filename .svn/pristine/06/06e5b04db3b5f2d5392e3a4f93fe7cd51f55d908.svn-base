package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 大债权类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CreditType {
	CJ("车借"), // 车借
	FJ("房借");// 房借

	public static Map<String, String> creditTypeMap = new Hashtable<String, String>();

	static {
		creditTypeMap.put(CreditType.CJ.value, "车借");
		creditTypeMap.put(CreditType.FJ.value, "房借");
	}
	public final String value;

	private CreditType(String value) {
		this.value = value;
	}

	public static String getCreditType(String value) {
		return creditTypeMap.get(value);
	}
}