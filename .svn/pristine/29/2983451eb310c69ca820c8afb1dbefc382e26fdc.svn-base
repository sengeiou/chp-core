package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 门店类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum StoreType {
	MDJL("3"), // 门店经理
	MDFJL("5"), // 门店副经理
	JS("6"), // 讲师
	ZHNQ("11");// 综合内勤

	public static Map<String, String> storeTypeMap = new Hashtable<String, String>();

	static {
		storeTypeMap.put(StoreType.MDJL.value, "门店经理");
		storeTypeMap.put(StoreType.MDFJL.value, "门店副经理");
		storeTypeMap.put(StoreType.JS.value, "讲师");
		storeTypeMap.put(StoreType.ZHNQ.value, "综合内勤");
	}
	public final String value;

	private StoreType(String value) {
		this.value = value;
	}

	public static String getStoreType(String value) {
		return storeTypeMap.get(value);
	}
}