package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 废弃状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ScrapState {
	BFQ("0"), // 不废弃
	FQ("1");// 废弃

	public static Map<String, String> scrapStateMap = new Hashtable<String, String>();

	static {
		scrapStateMap.put(ScrapState.BFQ.value, "不废弃");
		scrapStateMap.put(ScrapState.FQ.value, "废弃");
	}
	public final String value;

	private ScrapState(String value) {
		this.value = value;
	}

	public static String getScrapState(String value) {
		return scrapStateMap.get(value);
	}
}