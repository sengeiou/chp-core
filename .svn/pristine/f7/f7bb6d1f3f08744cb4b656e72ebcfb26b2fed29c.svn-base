package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 债权匹配状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum MatchingStatus {
	DTJ("100"), // 待推荐
	CX("101"), // 撤销
	CXCP("103"), // 撤销重匹
	HKSBZQSF("106"), // 划扣失败债权释放
	YTJ("160");// 已推荐

	public final String value;

	private MatchingStatus(String value) {
		this.value = value;
	}

	public static String getMatchingStatus(String value) {
		return matchingStatusMap.get(value);
	}

	public static Map<String, String> matchingStatusMap = new Hashtable<String, String>();

	public static void initMatchingStatus() {
		if (matchingStatusMap.isEmpty()) {
			matchingStatusMap.put(MatchingStatus.DTJ.value, "待推荐");
			matchingStatusMap.put(MatchingStatus.CX.value, "撤销");
			matchingStatusMap.put(MatchingStatus.CXCP.value, "撤销重匹");
			matchingStatusMap.put(MatchingStatus.HKSBZQSF.value, "划扣失败债权释放");
			matchingStatusMap.put(MatchingStatus.YTJ.value, "已推荐");
		}
	}
}