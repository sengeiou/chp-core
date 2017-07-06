package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 债权交易状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CreditTradestate {
	ZCWKS("0"), // 暂存未开始
	KSHKZ("1"), // 开始还款中
	CJZCDQGB("2"), // 出借正常到期关闭
	JKZCDQGB("3"), // 借款正常到期关闭
	CJTQDQGB("4"), // 出借提前到期关闭
	JKTQDQGB("5"), // 借款提前到期关闭
	WKSBGB("6");// 未开始被关闭

	public static Map<String, String> creditTradestateMap = new Hashtable<String, String>();

	static {
		creditTradestateMap.put(CreditTradestate.ZCWKS.value, "暂存未开始");
		creditTradestateMap.put(CreditTradestate.KSHKZ.value, "开始还款中");
		creditTradestateMap.put(CreditTradestate.CJZCDQGB.value, "出借正常到期关闭");
		creditTradestateMap.put(CreditTradestate.JKZCDQGB.value, "借款正常到期关闭");
		creditTradestateMap.put(CreditTradestate.CJTQDQGB.value, "出借提前到期关闭");
		creditTradestateMap.put(CreditTradestate.JKTQDQGB.value, "借款提前到期关闭");
		creditTradestateMap.put(CreditTradestate.WKSBGB.value, "未开始被关闭");
	}
	public final String value;

	private CreditTradestate(String value) {
		this.value = value;
	}

	public static String getCreditTradestate(String value) {
		return creditTradestateMap.get(value);
	}
}