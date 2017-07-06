package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 财富事业部类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum UnitType {
	CFGLBFZC("9"), // 财富管理部副总裁
	CFGLBZC("10"), // 财富管理部总裁
	ZBRY("99");// 总部人员

	public static Map<String, String> unitTypeMap = new Hashtable<String, String>();

	static {
		unitTypeMap.put(UnitType.CFGLBFZC.value, "财富管理部副总裁");
		unitTypeMap.put(UnitType.CFGLBZC.value, "财富管理部总裁");
		unitTypeMap.put(UnitType.ZBRY.value, "总部人员");
	}
	public final String value;

	private UnitType(String value) {
		this.value = value;
	}

	public static String getUnitType(String value) {
		return unitTypeMap.get(value);
	}
}