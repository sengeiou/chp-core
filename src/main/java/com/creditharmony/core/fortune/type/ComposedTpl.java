package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 合成模板
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ComposedTpl {
	ZQZRXYSQBHX("100"), // 债权转让及受让协议（首期,不回息）
	ZQZRXYSQHX("101"), // 债权转让及受让协议（首期，回息）
	ZQZRXYYMY("102"), // 债权转让及受让协议（月满盈）
	ZQZRXYCYBHX("103"), // 债权转让及受让协议（次月,不回息）
	ZQZRXYCYHX("104"), // 债权转让及受让协议（次月,回息）
	ZJCJBGSQBHX("105"), // 资金出借报告（首期，不回息）
	ZJCJBGSQHX("106"), // 资金出借报告（首期，回息)
	ZJCJBGCYBHX("107"), // 资金出借报告（次月，不回息）
	ZJCJBGCQHX("108"), // 资金出借报告（次月，回息）
	SKQRSHK("109"), // 收款确认书-划扣
	SKQRSNBZZ("110"), // 收款确认书-内部转账
	SKQRSNBZZHHK("111");// 收款确认书-内部转账和划扣

	public static Map<String, String> composedTplMap = new Hashtable<String, String>();

	static {
		composedTplMap.put(ComposedTpl.ZQZRXYSQBHX.value, "债权转让及受让协议（首期,不回息）");
		composedTplMap.put(ComposedTpl.ZQZRXYSQHX.value, "债权转让及受让协议（首期，回息）");
		composedTplMap.put(ComposedTpl.ZQZRXYYMY.value, "债权转让及受让协议（月满盈）");
		composedTplMap.put(ComposedTpl.ZQZRXYCYBHX.value, "债权转让及受让协议（次月,不回息）");
		composedTplMap.put(ComposedTpl.ZQZRXYCYHX.value, "债权转让及受让协议（次月,回息）");
		composedTplMap.put(ComposedTpl.ZJCJBGSQBHX.value, "资金出借报告（首期，不回息）");
		composedTplMap.put(ComposedTpl.ZJCJBGSQHX.value, "资金出借报告（首期，回息)");
		composedTplMap.put(ComposedTpl.ZJCJBGCYBHX.value, "资金出借报告（次月，不回息）");
		composedTplMap.put(ComposedTpl.ZJCJBGCQHX.value, "资金出借报告（次月，回息）");
		composedTplMap.put(ComposedTpl.SKQRSHK.value, "收款确认书-划扣");
		composedTplMap.put(ComposedTpl.SKQRSNBZZ.value, "收款确认书-内部转账");
		composedTplMap.put(ComposedTpl.SKQRSNBZZHHK.value, "收款确认书-内部转账和划扣");
	}

	public final String value;

	private ComposedTpl(String value) {
		this.value = value;
	}

	public static String getComposedTpl(String value) {
		return composedTplMap.get(value);
	}
}