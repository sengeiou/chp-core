package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 调用划扣接口状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum DeductDataSendState {
	DFSHK("0"), // 待发送划扣
	FSCG("1"), // 发送成功
	FSSB("2"), // 发送失败
	COMMITCG("3"), // commit成功
	COMMITSB("4"), // commit失败
	HKCG("5"), // 划扣成功
	HKSB("6"); // 划扣失败
	public static Map<String, String> deductDataSendStateMap = new Hashtable<String, String>();
	static{
		deductDataSendStateMap.put(DeductDataSendState.DFSHK.value, "待发送划扣");
		deductDataSendStateMap.put(DeductDataSendState.FSCG.value, "发送成功");
		deductDataSendStateMap.put(DeductDataSendState.FSSB.value, "发送失败");
		deductDataSendStateMap.put(DeductDataSendState.COMMITCG.value, "commit成功");
		deductDataSendStateMap.put(DeductDataSendState.COMMITSB.value, "commit失败");
		deductDataSendStateMap.put(DeductDataSendState.HKCG.value, "划扣成功");
		deductDataSendStateMap.put(DeductDataSendState.HKSB.value, "划扣失败");
	}

	public final String value;

	private DeductDataSendState(String value) {
		this.value = value;
	}

	public static String getDeductDataSendState(String value) {
		return deductDataSendStateMap.get(value);
	}

}