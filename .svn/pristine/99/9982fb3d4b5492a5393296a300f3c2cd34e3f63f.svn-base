package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 状态（出借申请列表用）
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum LendState {
	JZHDKH("0"), // 金账户待开户
	DFJSC("1"), // 待附件上传
	DCJSP("2"), // 待出借审批
	SPTG("3"), // 审批通过
	SPBTG("4"), // 审批不通过
	CX("5"), // 撤销
	KHFQ("6"), // 客户放弃
	JZHKHSB("8"), // 金账户开户失败
	DHK("9"), // 待划扣
	HKCLZ("10"), // 划扣处理中
	HKCG("11"), // 划扣成功
	HKSB("12"),// 划扣失败
	JZHXH("13"), // 金账户销户
	WJHCZ("14"), // 文件合成中
	WJHCSB("15"); // 文件合成失败
	
	public static Map<String, String> lendStateMap = new Hashtable<String, String>();

	static{
			lendStateMap.put(LendState.JZHDKH.value, "金账户待开户");
			lendStateMap.put(LendState.DFJSC.value, "待附件上传");
			lendStateMap.put(LendState.DCJSP.value, "待出借审批");
			lendStateMap.put(LendState.SPTG.value, "审批通过");
			lendStateMap.put(LendState.SPBTG.value, "审批不通过");
			lendStateMap.put(LendState.CX.value, "撤销");
			lendStateMap.put(LendState.KHFQ.value, "客户放弃");
			lendStateMap.put(LendState.JZHKHSB.value, "金账户开户失败");
			lendStateMap.put(LendState.DHK.value, "待划扣");
			lendStateMap.put(LendState.HKCLZ.value, "划扣处理中");
			lendStateMap.put(LendState.HKCG.value, "划扣成功");
			lendStateMap.put(LendState.HKSB.value, "划扣失败");
			lendStateMap.put(LendState.JZHXH.value, "金账户销户");
			lendStateMap.put(LendState.WJHCZ.value, "文件合成中");
			lendStateMap.put(LendState.WJHCSB.value, "文件合成失败");
		}

	public final String value;

	private LendState(String value) {
		this.value = value;
	}

	public static String getLendState(String value) {
		return lendStateMap.get(value);
	}
}