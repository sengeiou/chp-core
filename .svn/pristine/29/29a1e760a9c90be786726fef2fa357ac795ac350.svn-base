package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 日志等级 
 * 
 * 数值越小越紧急
 * 最紧急：调第三方划扣接口成功，但是数据库更新操作失败。或者是事务回滚都无法避免结果的情况
 * 紧急：与金钱相关的
 * 一般：影响流程的
 * 非紧急：其他
 * 
 * @Class Name
 * @author 朱杰
 * @Create In 2016年5月3日
 */
public enum FortuneLogLevel {
	RED("0"), // 最紧急
	ORANGE("1"), // 紧急
	YELLOW("2"), // 一般
	BLUE("3"); //非紧急

	public static Map<String, String> appalyStateMap = new Hashtable<String, String>();

	static {
		appalyStateMap.put(FortuneLogLevel.RED.value, "最紧急");
		appalyStateMap.put(FortuneLogLevel.ORANGE.value, "紧急");
		appalyStateMap.put(FortuneLogLevel.YELLOW.value, "一般");
		appalyStateMap.put(FortuneLogLevel.BLUE.value, "非紧急");
	}
	public final String value;

	private FortuneLogLevel(String value) {
		this.value = value;
	}

	public static String getAppalyState(String value) {
		return appalyStateMap.get(value);
	}
}