package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 使用状态
 * 
 * @Class Name ProductStatus
 * @author 朱杰
 * @Create In 2015年12月29日
 */
public enum ProductStatus {
	SY("1"), // 使用
	TY("0"); // 停用

	public static Map<String, String> productStatusMap = new Hashtable<String, String>();

	static {
		productStatusMap.put(ProductStatus.SY.value, "使用");
		productStatusMap.put(ProductStatus.TY.value, "停用");
	}
	public final String value;

	private ProductStatus(String value) {
		this.value = value;
	}

	public static String getProductStatus(String value) {
		return productStatusMap.get(value);
	}
}