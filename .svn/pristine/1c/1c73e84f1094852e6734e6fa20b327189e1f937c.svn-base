package com.creditharmony.core.loan.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 金账户状态
 * @Class Name LoanTrustState
 * @author 朱杰
 * @Create In 2016年3月7日
 */
public enum LoanTrustState {
	WKH("0"), // 未开户
	SQZ("1"), // 申请中
	KHCG("2"), // 开户成功
	KHSB("3"),// 开户失败
	XHZ("4"), // 销户中
	YXH("5"); // 已销户

	public final String value;

	private LoanTrustState(String value) {
		this.value = value;
	}

	public static String getTrustState(String value) {
		return loanTrustStateMap.get(value);
	}

	public static Map<String, String> loanTrustStateMap = new Hashtable<String, String>();

	public static void initTrustState() {
		if (loanTrustStateMap.isEmpty()) {
			loanTrustStateMap.put(LoanTrustState.WKH.value, "未开户");
			loanTrustStateMap.put(LoanTrustState.SQZ.value, "申请中");
			loanTrustStateMap.put(LoanTrustState.KHCG.value, "开户成功");
			loanTrustStateMap.put(LoanTrustState.KHSB.value, "开户失败");
		}
	}
}