package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 推送大金融债权状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum PushBorrowStatus {
	NEW("0"), // -
	SUCCESS("1"), // 成功
	FAIL("2"), // 失败
	RELEASE("3"),//释放债权
	EARLY("4");//提前结清
	
	
	public static Map<String, String> backStateMap = new Hashtable<String, String>();
	static{
		backStateMap.put(PushBorrowStatus.NEW.value, "-");
		backStateMap.put(PushBorrowStatus.SUCCESS.value, "成功");
		backStateMap.put(PushBorrowStatus.FAIL.value, "失败");
		backStateMap.put(PushBorrowStatus.RELEASE.value, "释放债权");
		backStateMap.put(PushBorrowStatus.EARLY.value, "提前结清");
		
	}

	public final String value;

	private PushBorrowStatus(String value) {
		this.value = value;
	}

	public static String getBackState(String value) {
		return backStateMap.get(value);
	}
}