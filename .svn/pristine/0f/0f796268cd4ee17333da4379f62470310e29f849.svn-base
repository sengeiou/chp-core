package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 信和宝类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum XinhebaoType {
	XHB12("1"), // 满12个月转让一次收益
	XHB24("2");// 满12个月不转让收益，24个月后一起转让本息

	public static Map<String, String> xinhebaoTypeMap = new Hashtable<String, String>();

	static {
		xinhebaoTypeMap.put(XinhebaoType.XHB12.value, "满12个月转让一次收益");
		xinhebaoTypeMap.put(XinhebaoType.XHB24.value, "满12个月不转让收益，24个月后一起转让本息");
	}
	public final String value;

	private XinhebaoType(String value) {
		this.value = value;
	}

	public static String getXinhebaoType(String value) {
		return xinhebaoTypeMap.get(value);
	}
}