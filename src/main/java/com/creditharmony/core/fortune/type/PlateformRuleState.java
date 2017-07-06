package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 平台规则审核状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2016年2月16日
 */
public enum PlateformRuleState {
	DSH("1"), // 待审核
	QY("2"), // 启用
	TY("3"), // 停用
	SHBTG("4");// 审核不通过

	public static Map<String, String> plateformRuleStateMap = new Hashtable<String, String>();

	static {
		plateformRuleStateMap.put(PlateformRuleState.DSH.value, "待审核");
		plateformRuleStateMap.put(PlateformRuleState.QY.value, "启用");
		plateformRuleStateMap.put(PlateformRuleState.TY.value, "停用");
		plateformRuleStateMap.put(PlateformRuleState.SHBTG.value, "审核不通过");
	}
	public final String value;

	private PlateformRuleState(String value) {
		this.value = value;
	}

	public static String getPlateformRuleState(String value) {
		return plateformRuleStateMap.get(value);
	}
}