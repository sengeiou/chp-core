package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 出借人变更状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum LenderchgState {
	DMDSH("1"), // 待门店审核
	DDJRSH("2"), // 待对接人审核
	DZS("3"), // 待终审
	SHTG("4"), // 审核通过
	SHBTG("5"), // 审核不通过
	DJZHBG("6"),// 待金账户变更
    DJZHTH("7"),// 金账户退回
    WJHCZ("8"),// 文件合成中
    WJHCSB("9");// 文件合成失败
	
	public static Map<String, String> lenderchgStateMap = new Hashtable<String, String>();
	static{
		lenderchgStateMap.put(LenderchgState.DMDSH.value, "待门店审核");
		lenderchgStateMap.put(LenderchgState.DDJRSH.value, "待对接人审核");
		lenderchgStateMap.put(LenderchgState.DZS.value, "待终审");
		lenderchgStateMap.put(LenderchgState.SHTG.value, "审核通过");
		lenderchgStateMap.put(LenderchgState.SHBTG.value, "审核不通过");
		lenderchgStateMap.put(LenderchgState.DJZHBG.value, "待金账户变更");
		lenderchgStateMap.put(LenderchgState.DJZHTH.value, "金账户退回");
		lenderchgStateMap.put(LenderchgState.WJHCZ.value, "文件合成中");
		lenderchgStateMap.put(LenderchgState.WJHCSB.value, "文件合成失败");
	}
	public final String value;

	private LenderchgState(String value) {
		this.value = value;
	}

	public static String getLenderchgState(String value) {
		return lenderchgStateMap.get(value);
	}
}