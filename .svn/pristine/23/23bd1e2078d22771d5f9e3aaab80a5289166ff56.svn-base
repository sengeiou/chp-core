package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 单位规模
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum UnitSize {
	RYX100("1"), // 100人以下
	T100150R("2"), // 100-150人
	T1501000R("3"), // 150-1000人
	T10003000R("4"), // 1000-3000人
	RYS3000("5");// 3000人以上

	public static Map<String, String> unitSizeMap = new Hashtable<String, String>();

	static {
		unitSizeMap.put(UnitSize.RYX100.value, "100人以下");
		unitSizeMap.put(UnitSize.T100150R.value, "100-150人");
		unitSizeMap.put(UnitSize.T1501000R.value, "150-1000人");
		unitSizeMap.put(UnitSize.T10003000R.value, "1000-3000人");
		unitSizeMap.put(UnitSize.RYS3000.value, "3000人以上");
	}
	public final String value;

	private UnitSize(String value) {
		this.value = value;
	}

	public static String getUnitSize(String value) {
		return unitSizeMap.get(value);
	}
}