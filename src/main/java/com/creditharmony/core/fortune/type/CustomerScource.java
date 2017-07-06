package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 客户来源
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CustomerScource {
	SC("1"), // 商超
	LKHJS("2"), // 老客户介绍
	MCALL("3"), // 陌CALL
	CHFWJ("4"), // 客户服务节
	QT("5"), // 其他
	HJZX("6"); // 呼叫中心

	public static Map<String, String> customerScourceMap = new Hashtable<String, String>();

	static {
		customerScourceMap.put(CustomerScource.SC.value, "商超");
		customerScourceMap.put(CustomerScource.LKHJS.value, "老客户介绍");
		customerScourceMap.put(CustomerScource.MCALL.value, "陌CALL");
		customerScourceMap.put(CustomerScource.CHFWJ.value, "客户服务节");
		customerScourceMap.put(CustomerScource.QT.value, "其他");
		customerScourceMap.put(CustomerScource.HJZX.value, "呼叫中心");
	}
	public final String value;

	private CustomerScource(String value) {
		this.value = value;
	}

	public static String getCustomerScource(String value) {
		return customerScourceMap.get(value);
	}
}