package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 回息状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BacksmsState { 
	DHXSQ("1"), // 待回息申请
	DHXSQQRTH("2"), // 待回息申请确认退回
	DHXSQQR("3"), // 待回息申请确认
	DHXSPTH("4"), // 待回息审批退回
	DHXTH("5"), // 待回息退回
	DHXQRTH("6"), // 待回息确认退回
	YHXTH("7"),// 已回息退回
	DHXSP("8"), // 待回息审批
	DHX("9"), // 待回息
	HXSB("10"),// 待回息确认退回至待回息（回息失败）
	DHXQR("11"), // 待回息确认
	YHX("12"), // 已回息
	DJ("13");// 冻结数据
	public static Map<String, String> backsmsStateMap = new Hashtable<String, String>();
	static {
		backsmsStateMap.put(BacksmsState.DHXSQ.value, "待回息申请");
		backsmsStateMap.put(BacksmsState.DHXSQQRTH.value, "待回息申请确认退回");
		backsmsStateMap.put(BacksmsState.DHXSQQR.value, "待回息申请确认");
		backsmsStateMap.put(BacksmsState.DHXSPTH.value, "待回息审批退回");
		backsmsStateMap.put(BacksmsState.DHXTH.value, "待回息退回");
		backsmsStateMap.put(BacksmsState.DHXQRTH.value, "待回息确认退回");
		backsmsStateMap.put(BacksmsState.YHXTH.value, "已回息退回");
		backsmsStateMap.put(BacksmsState.DHXSP.value, "待回息审批");
		backsmsStateMap.put(BacksmsState.DHX.value, "待回息");
		backsmsStateMap.put(BacksmsState.HXSB.value, "回息失败");
		backsmsStateMap.put(BacksmsState.DHXQR.value, "待回息确认");
		backsmsStateMap.put(BacksmsState.YHX.value, "已回息");
		backsmsStateMap.put(BacksmsState.DJ.value, "冻结");
	}
	public final String value;

	private BacksmsState(String value) {
		this.value = value;
	}

	public static String getBacksmsState(String value) {
		return backsmsStateMap.get(value);
	}

}