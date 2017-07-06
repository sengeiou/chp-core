package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 账单日
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BillDay {
	FOUR("4"), // 4
	SEVEN("7"), // 7
	ELVEN("11"), // 11
	FIFTEEN("15"), // 15
	NINETEEN("19"), // 19
	TWENTYTHREE("23"), // 23
	TWENTYSIX("26"), // 26
	THIRTY("30");// 30

	public static Map<String, String> billDayMap = new Hashtable<String, String>();

	static {
		billDayMap.put(BillDay.FOUR.value, "4");
		billDayMap.put(BillDay.SEVEN.value, "7");
		billDayMap.put(BillDay.ELVEN.value, "11");
		billDayMap.put(BillDay.FIFTEEN.value, "15");
		billDayMap.put(BillDay.NINETEEN.value, "19");
		billDayMap.put(BillDay.TWENTYTHREE.value, "23");
		billDayMap.put(BillDay.TWENTYSIX.value, "26");
		billDayMap.put(BillDay.THIRTY.value, "30");
	}

	public final String value;

	private BillDay(String value) {
		this.value = value;
	}

	public static String getBillDay(String value) {
		return billDayMap.get(value);
	}
}