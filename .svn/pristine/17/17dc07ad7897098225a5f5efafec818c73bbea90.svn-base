package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 出借状态
 * @Create In 2017年4月26日
 */
public enum ApplyStatus {
	CJZ("1"),	//出借中
	TQSH("2"), 	// 提前赎回
	YDQ("3");	//已到期
	public static Map<String, String> applyStatusMap = new Hashtable<String, String>();
	static{
		applyStatusMap.put(ApplyStatus.CJZ.value, "出借中");
		applyStatusMap.put(ApplyStatus.TQSH.value, "提前赎回");
		applyStatusMap.put(ApplyStatus.YDQ.value, "已到期");
		
	}

	public final String value;

	private ApplyStatus(String value) {
		this.value = value;
	}

	public static String getBackType(String value) {
		return applyStatusMap.get(value);
	}

}