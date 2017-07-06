package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 还款日
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum RepayDay {
	THREE("3"), // 3
	SEVEN("7"), // 7
	TEEN("10"), // 10
	FIFTEEN("15"), // 15
	EIGHTEEN("18"), // 18
	TWENTYTHREE("23"), // 23
	TWENTYFIVE("25"), // 25
	THIRTY("30");// 30

	public static Map<String, String> repayDayMap = new Hashtable<String, String>();
	static {
		repayDayMap.put(RepayDay.THREE.value, "3");
		repayDayMap.put(RepayDay.SEVEN.value, "7");
		repayDayMap.put(RepayDay.TEEN.value, "10");
		repayDayMap.put(RepayDay.FIFTEEN.value, "15");
		repayDayMap.put(RepayDay.EIGHTEEN.value, "18");
		repayDayMap.put(RepayDay.TWENTYTHREE.value, "23");
		repayDayMap.put(RepayDay.TWENTYFIVE.value, "25");
		repayDayMap.put(RepayDay.THIRTY.value, "30");
	}
	public final String value;

	private RepayDay(String value) {
		this.value = value;
	}

	public static String getRepayDay(String value) {
		return repayDayMap.get(value);
	}
}