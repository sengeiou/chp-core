package com.creditharmony.core.loan.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 开户行
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum OpenBank {
	ZGGSYH("102"), // 中国工商银行
	ZGNYTH("103"), // 中国农业银行
	ZGYH("104"), // 中国银行
	ZGJSYH("105"), // 中国建设银行
	ZXYH("302"), // 中信银行
	GDYH("303"), // 光大银行
	HXYH("304"), // 华夏银行
	ZGMSYH("305"), // 中国民生银行
	GFYH("306"), // 广发银行
	PAYH("307"), // 平安银行股份有限公司
	ZSYH("308"), // 招商银行
	XYYH("309"), // 兴业银行
	SHPDFZYH("310"), // 上海浦东发展银行
	ZGYZCXYH("403"), // 中国邮政储蓄银行
	JTYH("666");// 交通银行
	public static Map<String, String> openBankMap = new Hashtable<String, String>();
	public static Map<String, String> openBankCodeMap = new Hashtable<String, String>();

	static{
		openBankMap.put(OpenBank.ZGGSYH.value, "中国工商银行");
		openBankMap.put(OpenBank.ZGNYTH.value, "中国农业银行");
		openBankMap.put(OpenBank.ZGYH.value, "中国银行");
		openBankMap.put(OpenBank.ZGJSYH.value, "中国建设银行");
		openBankMap.put(OpenBank.ZXYH.value, "中信银行");
		openBankMap.put(OpenBank.GDYH.value, "中国光大银行");
		openBankMap.put(OpenBank.HXYH.value, "华夏银行");
		openBankMap.put(OpenBank.ZGMSYH.value, "中国民生银行");
		openBankMap.put(OpenBank.GFYH.value, "广东发展银行");
		openBankMap.put(OpenBank.PAYH.value, "平安银行股份有限公司");
		openBankMap.put(OpenBank.ZSYH.value, "招商银行");
		openBankMap.put(OpenBank.XYYH.value, "兴业银行");
		openBankMap.put(OpenBank.SHPDFZYH.value, "上海浦东发展银行");
		openBankMap.put(OpenBank.ZGYZCXYH.value, "中国邮政储蓄银行股份有限公司");
		openBankMap.put(OpenBank.JTYH.value, "交通银行");
		
		openBankCodeMap.put("中国工商银行",OpenBank.ZGGSYH.value);
		openBankCodeMap.put("中国农业银行",OpenBank.ZGNYTH.value );
		openBankCodeMap.put("中国银行",OpenBank.ZGYH.value);
		openBankCodeMap.put("中国建设银行",OpenBank.ZGJSYH.value);
		openBankCodeMap.put("中信银行",OpenBank.ZXYH.value);
		openBankCodeMap.put("中国光大银行",OpenBank.GDYH.value);
		openBankCodeMap.put("华夏银行",OpenBank.HXYH.value);
		openBankCodeMap.put("中国民生银行",OpenBank.ZGMSYH.value);
		openBankCodeMap.put("广东发展银行",OpenBank.GFYH.value);
		openBankCodeMap.put("平安银行股份有限公司",OpenBank.PAYH.value);
		openBankCodeMap.put("招商银行",OpenBank.ZSYH.value);
		openBankCodeMap.put("兴业银行",OpenBank.XYYH.value);
		openBankCodeMap.put("上海浦东发展银行",OpenBank.SHPDFZYH.value);
		openBankCodeMap.put("中国邮政储蓄银行股份有限公司",OpenBank.ZGYZCXYH.value);
		openBankCodeMap.put("交通银行",OpenBank.JTYH.value);
	}

	public final String value;

	private OpenBank(String value) {
		this.value = value;
	}

	public static String getOpenBank(String value) {
		return openBankMap.get(value);
	}
	
	public static String getOpenBankByName(String name) {
		return openBankCodeMap.get(name);
	}
}