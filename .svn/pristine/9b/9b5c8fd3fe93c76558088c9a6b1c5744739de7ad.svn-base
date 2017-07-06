package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 是否回息标识
 * 
 * @Class Name
 * @author 高旭
 * @Create In 2017-3-24 17:49:12
 */
public enum BackIsInterest {
	YES("0"), // 是
	NO("1"); // 否
	
	public static Map<String,String> backIsInterestMap = new Hashtable<String, String>();
	static{
		backIsInterestMap.put(BackIsInterest.YES.value, "是");
		backIsInterestMap.put(BackIsInterest.NO.value, "否");
	}

	public final String value;

	private BackIsInterest(String value) {
		this.value = value;
	}

	public static String getBackIsInterest(String value) {
		return backIsInterestMap.get(value);
	}
	
}