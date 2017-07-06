package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 回息退回原因
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BacksmsReason {
	HXJEYW("1"), // 回息金额有误
	KHXMYW("2"), // 客户姓名有误
	CJRQYW("3"), // 出借日期有误
	CPLXYW("4"), // 产品类型有误
	HKZHYW("5"), // 回款账号有误
	QT("6");// 其他

	public static Map<String, String> backsmsReasonMap = new Hashtable<String, String>();
	static{
		backsmsReasonMap.put(BacksmsReason.HXJEYW.value, "回息金额有误");
		backsmsReasonMap.put(BacksmsReason.KHXMYW.value, "客户姓名有误");
		backsmsReasonMap.put(BacksmsReason.CJRQYW.value, "出借日期有误");
		backsmsReasonMap.put(BacksmsReason.CPLXYW.value, "产品类型有误");
		backsmsReasonMap.put(BacksmsReason.HKZHYW.value, "回款账号有误");
		backsmsReasonMap.put(BacksmsReason.QT.value, "其他");
	}
	public final String value;

	private BacksmsReason(String value) {
		this.value = value;
	}

	public static String getBacksmsReason(String value) {
		return backsmsReasonMap.get(value);
	}

}