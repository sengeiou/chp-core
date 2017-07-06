package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 代办提醒类型
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum AgencyRemindType {
	CJDQ10R("1");// 10日内出借到期

	public final String value;
	
	public static Map<String, String> agencyRemindTypeMap = new Hashtable<String, String>();
	
	static {
		agencyRemindTypeMap.put(AgencyRemindType.CJDQ10R.value, "10日内出借到期");
	}

	private AgencyRemindType(String value) {
		this.value = value;
	}

	public static String getAgencyRemindType(String value) {
		return agencyRemindTypeMap.get(value);
	}
}