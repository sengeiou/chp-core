package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 状态（出借申请列表用）
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ForApplyStatus {
	CJZ("1"), // 出借中
	TQSH("2"), // 提前赎回
	YDQ("3");// 已到期

	public final String value;

	private ForApplyStatus(String value) {
		this.value = value;
	}

	public static String getForApplyStatus(String value) {
		return forApplyStatusMap.get(value);
	}

	public static Map<String, String> forApplyStatusMap = new Hashtable<String, String>();

	public static void initForApplyStatus() {
		if (forApplyStatusMap.isEmpty()) {
			forApplyStatusMap.put(ForApplyStatus.CJZ.value, "出借中");
			forApplyStatusMap.put(ForApplyStatus.TQSH.value, "提前赎回");
			forApplyStatusMap.put(ForApplyStatus.YDQ.value, "已到期");
		}
	}
}