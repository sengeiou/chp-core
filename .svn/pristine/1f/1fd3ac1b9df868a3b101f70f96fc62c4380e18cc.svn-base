package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 回款状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BackState {
	DHKSQ("1"), // 待回款申请
	DHKSQQR("2"), // 待回款申请确认
	DHKSP("3"), // 待回款审批
	DHK("4"), // 待回款
	BFHKCG("5"), // 部分回款成功
	DHKQR("6"), // 待回款确认
	YHK("7"), // 已回款
	DHKSQQRTH("8"), // 待回款申请确认退回
	DHKSPTH("9"), // 待回款审批退回（显示：审批不通过）
	DHKTH("10"), // 待回款退回（显示：回款退回）
	DHKQRTH("11"), // 待回款确认退回（显示：回款失败）
	YHKTH("12"), // 已回款退回
	HKBX("13"), // 回款补息
	HKBXTH("14"), // 回款补息退回
	QDFP("15"), // 待渠道分配
	QDFPTH("16"), // 渠道分配退回
	THZQDFP("17"); // 回款失败(退到渠道分配)
	public static Map<String, String> backStateMap = new Hashtable<String, String>();
	static{
		backStateMap.put(BackState.DHKSQ.value, "待回款申请");
		backStateMap.put(BackState.DHKSQQR.value, "待回款申请确认");
		backStateMap.put(BackState.DHKSP.value, "待回款审批");
		backStateMap.put(BackState.DHK.value, "待回款");
		backStateMap.put(BackState.BFHKCG.value, "部分回款成功");
		backStateMap.put(BackState.DHKQR.value, "待回款确认");
		backStateMap.put(BackState.YHK.value, "已回款");
		backStateMap.put(BackState.DHKSQQRTH.value, "待回款申请确认退回");
		backStateMap.put(BackState.DHKSPTH.value, "审批不通过");
		backStateMap.put(BackState.DHKTH.value, "回款退回");
		backStateMap.put(BackState.DHKQRTH.value, "回款失败");
		backStateMap.put(BackState.YHKTH.value, "已回款退回");
		backStateMap.put(BackState.HKBX.value, "回款补息");
		backStateMap.put(BackState.HKBXTH.value, "回款补息退回");
		backStateMap.put(BackState.QDFP.value, "待渠道分配");
		backStateMap.put(BackState.QDFPTH.value, "渠道分配退回");
		backStateMap.put(BackState.THZQDFP.value, "回款失败(退到渠道分配)");
	}

	public final String value;

	private BackState(String value) {
		this.value = value;
	}

	public static String getBackState(String value) {
		return backStateMap.get(value);
	}
}