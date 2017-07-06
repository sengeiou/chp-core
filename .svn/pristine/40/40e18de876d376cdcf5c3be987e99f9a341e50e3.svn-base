package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 区域类型
 * 
 * @Class Name AreaType
 * @author 朱杰
 * @Create In 2015年12月30日
 */
public enum AreaType {
	COUNTRY("0"), // 国家
	PROVINCE("1"), // 省
	CITY("2"), // 市
	DISTRICT("3");// 区

	public static Map<String, String> areaTypeMap = new Hashtable<String, String>();

	static {
		areaTypeMap.put(AreaType.COUNTRY.value, "国家");
		areaTypeMap.put(AreaType.PROVINCE.value, "省");
		areaTypeMap.put(AreaType.CITY.value, "市");
		areaTypeMap.put(AreaType.DISTRICT.value, "区");
	}
	public final String value;

	private AreaType(String value) {
		this.value = value;
	}

	public static String getAreaType(String value) {
		return areaTypeMap.get(value);
	}
}