package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 资金托管标识
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ZjtrMark {
	TG("0"), // 托管
	FTG("1");// 非托管

	public static Map<String, String> zjtrMarkMap = new Hashtable<String, String>();

	static {
		zjtrMarkMap.put(ZjtrMark.TG.value, "托管");
		zjtrMarkMap.put(ZjtrMark.FTG.value, "非托管");
	}
	public final String value;

	private ZjtrMark(String value) {
		this.value = value;
	}

	public static String getZjtrMark(String value) {
		return zjtrMarkMap.get(value);
	}
}