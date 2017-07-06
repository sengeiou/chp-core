package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 财富客户状态
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum CustomerState {
	ZXGT("1"), // 咨询沟通
	// ZC("2"), // 暂存
	DKHSP("3"), // 待开户审批
	YKH("4"), // 已开户
	KHJJ("5"),// 开户拒绝
	WJHCZ("6"),// 文件合成中
	WJHCSB("7");// 文件合成失败

	public static Map<String, String> customerStateMap = new Hashtable<String, String>();

	static {
		customerStateMap.put(CustomerState.ZXGT.value, "咨询沟通");
		// customerStateMap.put(CustomerState.ZC.value, "暂存");
		customerStateMap.put(CustomerState.DKHSP.value, "待开户审批");
		customerStateMap.put(CustomerState.YKH.value, "已开户");
		customerStateMap.put(CustomerState.KHJJ.value, "开户拒绝");
		customerStateMap.put(CustomerState.WJHCZ.value, "文件合成中");
		customerStateMap.put(CustomerState.WJHCSB.value, "文件合成失败");
	}
	public final String value;

	private CustomerState(String value) {
		this.value = value;
	}

	public static String getCustomerState(String value) {
		return customerStateMap.get(value);
	}
}