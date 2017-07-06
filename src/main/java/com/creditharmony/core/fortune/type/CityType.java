package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 城市类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CityType {
	CSJL("3"), // 城市经理
	CSFJL("5"), // 城市副经理
	SJZY("11");// 数据专员

	public static Map<String, String> cityTypeMap = new Hashtable<String, String>();

	static {
		cityTypeMap.put(CityType.CSJL.value, "城市经理");
		cityTypeMap.put(CityType.CSFJL.value, "城市副经理");
		cityTypeMap.put(CityType.SJZY.value, "数据专员");
	}

	public final String value;

	private CityType(String value) {
		this.value = value;
	}

	public static String getCityType(String value) {
		return cityTypeMap.get(value);
	}
}