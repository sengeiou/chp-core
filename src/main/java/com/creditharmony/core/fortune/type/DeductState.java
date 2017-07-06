package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 *划扣状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum DeductState {
	DHKSQ("1"), // 待划扣申请
	DHKSP("2"), // 待划扣审批
	DHKJS("3"), // 待划扣结算
	HKCLZ("4"), // 划扣处理中
	HKCG("5"), // 划扣成功
	HKSB("6"), // 划扣失败
	HKBFCG("7"), // 划扣部分成功
	CX("8"), // 撤销
	HKSPTH("9"), // 划扣审批退回
	HKJSTH("10"),// 划扣结算退回
	DFTHK("11"),// 待分天划扣
	XSHK("12"),// 线上划扣
	YYHK("13"),// 预约划扣
	YYY("14"),// 划扣已预约
	QXYY("15"),// 划扣取消预约
	ECYYHK("16"),// 二次预约划扣
	ECXSHK("17"),// 二次线上划扣
	FTQRSB("18"),// 分天确认失败
	HKJSQCX("19");// 划扣结算前撤销
	
	public static Map<String, String> deductStateMap = new Hashtable<String, String>();
	static{
		deductStateMap.put(DeductState.DHKSQ.value, "待划扣申请");
		deductStateMap.put(DeductState.DHKSP.value, "待划扣审批");
		deductStateMap.put(DeductState.DHKJS.value, "待划扣结算");
		deductStateMap.put(DeductState.HKCLZ.value, "划扣处理中");
		deductStateMap.put(DeductState.HKCG.value, "划扣成功");
		deductStateMap.put(DeductState.HKSB.value, "划扣失败");
		deductStateMap.put(DeductState.HKBFCG.value, "划扣部分成功");
		deductStateMap.put(DeductState.CX.value, "撤销");
		deductStateMap.put(DeductState.HKSPTH.value, "划扣审批退回");
		deductStateMap.put(DeductState.HKJSTH.value, "划扣结算退回");
		deductStateMap.put(DeductState.DFTHK.value, "待分天划扣");
		deductStateMap.put(DeductState.XSHK.value, "线上划扣");
		deductStateMap.put(DeductState.YYHK.value, "预约划扣");
		deductStateMap.put(DeductState.YYY.value, "划扣已预约");
		deductStateMap.put(DeductState.QXYY.value, "划扣取消预约");
		deductStateMap.put(DeductState.ECYYHK.value, "二次预约划扣");
		deductStateMap.put(DeductState.ECXSHK.value, "二次线上划扣");
		deductStateMap.put(DeductState.FTQRSB.value, "分天确认失败");
		deductStateMap.put(DeductState.HKJSQCX.value, "划扣结算前撤销");
	}
	public final String value;

	private DeductState(String value) {
		this.value = value;
	}

	public static String getDeductState(String value) {
		return deductStateMap.get(value);
	}
}