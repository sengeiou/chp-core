package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 回款退回原因
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BackReason {
	HKJEYW("31"), // 回款金额有误
	KHXMYW("32"), // 客户姓名有误
	CJRQYW("33"), // 出借日期有误
	CPLXYW("34"), // 产品类型有误
	HKZHYW("35"), // 回款账号有误
	KHHSSYW("36"), // 开户行省市有误
	QT("37");// 其它

	public static Map<String, String> backReasonMap = new Hashtable<String, String>();

	static {
		backReasonMap.put(BackReason.HKJEYW.value, "回款金额有误");
		backReasonMap.put(BackReason.KHXMYW.value, "客户姓名有误");
		backReasonMap.put(BackReason.CJRQYW.value, "出借日期有误");
		backReasonMap.put(BackReason.CPLXYW.value, "产品类型有误");
		backReasonMap.put(BackReason.HKZHYW.value, "回款账号有误");
		backReasonMap.put(BackReason.KHHSSYW.value, "开户行省市有误");
		backReasonMap.put(BackReason.QT.value, "其它");
	}
	public final String value;

	private BackReason(String value) {
		this.value = value;
	}

	public static String getBackReason(String value) {
		return backReasonMap.get(value);
	}
}