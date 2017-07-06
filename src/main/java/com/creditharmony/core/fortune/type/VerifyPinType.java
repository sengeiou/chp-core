package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 验证码类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum VerifyPinType {
	SMS("1"), // 短信
	EMAIL("2"); // 电子邮件

	public static Map<String, String> verifyPinTypeMap = new Hashtable<String, String>();

	static {
		verifyPinTypeMap.put(VerifyPinType.SMS.value, "短信");
		verifyPinTypeMap.put(VerifyPinType.EMAIL.value, "电子邮件");
	}
	public final String value;

	private VerifyPinType(String value) {
		this.value = value;
	}
}