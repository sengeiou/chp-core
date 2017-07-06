package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 产品类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ProductType {
	QXLCP("1"), // 期限类产品
	FQXLCP("2");// 非期限类产品

	public static Map<String, String> productTypeMap = new Hashtable<String, String>();

	static {
		productTypeMap.put(ProductType.QXLCP.value, "期限类产品");
		productTypeMap.put(ProductType.FQXLCP.value, "非期限类产品");
	}
	public final String value;

	private ProductType(String value) {
		this.value = value;
	}

	public static String getProductType(String value) {
		return productTypeMap.get(value);
	}
}