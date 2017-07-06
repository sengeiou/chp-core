package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 富有划扣状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum FuYouDeductState {
	CZCG("0"), // 操作成功（扣款或付款成功）
	CCQKCSXZ100011("100011"), // 超出取款次数限制
	ZJCW("100012"), // 证件错误
	WXKH100013("100013"), // 无效卡号（无此号）
	XYHBCZ("100014"), // 协议号不存在
	CCQKHZZJEXZ100016("100016"), // 超出取款/转账金额限制
	ZJBZ100017("100017"), // 资金不足
	CJYJSF("1001"), // 查交易接收方
	CJYJSFDTSTJ("1002"), // 查交易接收方的特殊条件
	WXSH("1003"), // 无效商户
	MSK("1004"), // 没收卡
	BYCD("1005"), // 不予承兑
	CC("1006"), // 出错
	TDTJXMSK("1007"), // 特定条件下没收卡
	QQZZCLZ("1009"), // 请求正在处理中
	WXJY("1012"), // 无效交易
	WXJE("1013"), // 无效金额
	WXKH1014("1014"), // 无效卡号（无此号）
	WCJYJSF("1015"), // 无此交易接收方
	KHQX("1017"), // 客户取消
	CXSRJY("1019"), // 重新送入交易
	WXXY("1020"), // 无效响应
	BNCQXD("1021"), // 不能采取行动
	GZHY("1022"), // 故障怀疑
	BKJSDJYF("1023"), // 不可接受的交易费
	ZBDYSJY("1025"), // 找不到原始交易
	GSCW("1030"), // 格式错误
	JHZXBZCDYH("1031"), // 交换中心不支持的银行
	GQDK1033("1033"), // 过期的卡
	YZBXY1034("1034"), // 有作弊嫌疑
	SKFYDLFLX1035("1035"), // 受卡方与代理方联系
	SXZDK1036("1036"), // 受限制的卡
	SKFDHTZDLFAQBM("1037"), // 受卡方电话通知代理方安全部门
	CGYXDPINSSR("1038"), // 超过允许的PIN试输入
	WDJZH("1039"), // 无贷记账户
	QQDGNSBZC("1040"), // 请求的功能尚不支持
	GSK("1041"), // 挂失卡
	WCZH("1042"), // 无此账户
	BQK("1043"), // 被窃卡
	WCTZZH("1044"), // 无此投资账户
	ZJBZ1051("1051"), // 资金不足
	WCZPZH("1052"), // 无此支票账户
	WCCXKZH("1053"), // 无此储蓄卡账户
	GQDK1054("1054"), // 过期的卡
	BZQDPIN("1055"), // 不正确的PIN
	WCKJL("1056"), // 无此卡记录
	BYXCKRJXDJY("1057"), // 不允许持卡人进行的交易
	BYXZDJXDJY("1058"), // 不允许终端进行的交易
	YZBXY1059("1059"), // 有作弊嫌疑
	SKFYDLFLX1060("1060"), // 受卡方与代理方联系
	CCQKHZZJEXZ1061("1061"), // 超出取款/转账金额限制
	SXZDK1062("1062"), // 受限制的卡
	QFAQ("1063"), // 侵犯安全
	YSJECW("1064"), // 原始金额错误
	CCQKCSXZ1065("1065"), // 超出取款次数限制
	SKFTZSLFAQBM("1066"), // 受卡方通知受理方安全部门
	QXSL("1067"), // 强行受理（要求在自动会员机上没收此卡）
	JSDXYYGS1068("1068"), // 接收的响应已过时
	YXDSRPINCSCX("1075"), // 允许的输入PIN次数超限
	WXZH("1076"), // 无效账户
	ZZRZCL("1090"), // 正在日终处理（系统终止一天的活动，开始第二天的活动，交易在几分钟后可再次发送）
	JYJSFHJHZXBNCZ("1091"), // 交易接收方或交换中心不能操作
	JRJGHZJWLSSZBDHWFDD("1092"), // 金融机构或中间网络设施找不到或无法达到、金融机构签退
	JYWF("1093"), // 交易违法、不能完成
	CFJY("1094"), // 重复交易
	HDCC("1095"), // 核对差错
	XTYCSX("1096"), // 系统异常、失效
	JHZXSBDJYJSFYD("1098"), // 交换中心收不到交易接收方应答
	PINGSCC("1099"), // PIN格式错
	MACJBSB("10A0"), // MAC鉴别失败
	JSDXYYGS200001("200001"), // 接收的响应已过时
	CS("999999");// 超时

	public final String value;

	private FuYouDeductState(String value) {
		this.value = value;
	}

	public static String getFydeductState(String value) {
		return fydeductStateMap.get(value);
	}

	public static Map<String, String> fydeductStateMap = new Hashtable<String, String>();

	public static void initFydeductState() {
		if (fydeductStateMap.isEmpty()) {
			fydeductStateMap.put(FuYouDeductState.CZCG.value, "操作成功（扣款或付款成功）");
			fydeductStateMap
					.put(FuYouDeductState.CCQKCSXZ100011.value, "超出取款次数限制");
			fydeductStateMap.put(FuYouDeductState.ZJCW.value, "证件错误");
			fydeductStateMap.put(FuYouDeductState.WXKH100013.value, "无效卡号（无此号）");
			fydeductStateMap.put(FuYouDeductState.XYHBCZ.value, "协议号不存在");
			fydeductStateMap.put(FuYouDeductState.CCQKHZZJEXZ100016.value,
					"超出取款/转账金额限制");
			fydeductStateMap.put(FuYouDeductState.ZJBZ100017.value, "资金不足");
			fydeductStateMap.put(FuYouDeductState.CJYJSF.value, "查交易接收方");
			fydeductStateMap
					.put(FuYouDeductState.CJYJSFDTSTJ.value, "查交易接收方的特殊条件");
			fydeductStateMap.put(FuYouDeductState.WXSH.value, "无效商户");
			fydeductStateMap.put(FuYouDeductState.MSK.value, "没收卡");
			fydeductStateMap.put(FuYouDeductState.BYCD.value, "不予承兑");
			fydeductStateMap.put(FuYouDeductState.CC.value, "出错");
			fydeductStateMap.put(FuYouDeductState.TDTJXMSK.value, "特定条件下没收卡");
			fydeductStateMap.put(FuYouDeductState.QQZZCLZ.value, "请求正在处理中");
			fydeductStateMap.put(FuYouDeductState.WXJY.value, "无效交易");
			fydeductStateMap.put(FuYouDeductState.WXJE.value, "无效金额");
			fydeductStateMap.put(FuYouDeductState.WXKH1014.value, "无效卡号（无此号）");
			fydeductStateMap.put(FuYouDeductState.WCJYJSF.value, "无此交易接收方");
			fydeductStateMap.put(FuYouDeductState.KHQX.value, "客户取消");
			fydeductStateMap.put(FuYouDeductState.CXSRJY.value, "重新送入交易");
			fydeductStateMap.put(FuYouDeductState.WXXY.value, "无效响应");
			fydeductStateMap.put(FuYouDeductState.BNCQXD.value, "不能采取行动");
			fydeductStateMap.put(FuYouDeductState.GZHY.value, "故障怀疑");
			fydeductStateMap.put(FuYouDeductState.BKJSDJYF.value, "不可接受的交易费");
			fydeductStateMap.put(FuYouDeductState.ZBDYSJY.value, "找不到原始交易");
			fydeductStateMap.put(FuYouDeductState.GSCW.value, "格式错误");
			fydeductStateMap.put(FuYouDeductState.JHZXBZCDYH.value, "交换中心不支持的银行");
			fydeductStateMap.put(FuYouDeductState.GQDK1033.value, "过期的卡");
			fydeductStateMap.put(FuYouDeductState.YZBXY1034.value, "有作弊嫌疑");
			fydeductStateMap
					.put(FuYouDeductState.SKFYDLFLX1035.value, "受卡方与代理方联系");
			fydeductStateMap.put(FuYouDeductState.SXZDK1036.value, "受限制的卡");
			fydeductStateMap.put(FuYouDeductState.SKFDHTZDLFAQBM.value,
					"受卡方电话通知代理方安全部门");
			fydeductStateMap
					.put(FuYouDeductState.CGYXDPINSSR.value, "超过允许的PIN试输入");
			fydeductStateMap.put(FuYouDeductState.WDJZH.value, "无贷记账户");
			fydeductStateMap.put(FuYouDeductState.QQDGNSBZC.value, "请求的功能尚不支持");
			fydeductStateMap.put(FuYouDeductState.GSK.value, "挂失卡");
			fydeductStateMap.put(FuYouDeductState.WCZH.value, "无此账户");
			fydeductStateMap.put(FuYouDeductState.BQK.value, "被窃卡");
			fydeductStateMap.put(FuYouDeductState.WCTZZH.value, "无此投资账户");
			fydeductStateMap.put(FuYouDeductState.ZJBZ1051.value, "资金不足");
			fydeductStateMap.put(FuYouDeductState.WCZPZH.value, "无此支票账户");
			fydeductStateMap.put(FuYouDeductState.WCCXKZH.value, "无此储蓄卡账户");
			fydeductStateMap.put(FuYouDeductState.GQDK1054.value, "过期的卡");
			fydeductStateMap.put(FuYouDeductState.BZQDPIN.value, "不正确的PIN");
			fydeductStateMap.put(FuYouDeductState.WCKJL.value, "无此卡记录");
			fydeductStateMap
					.put(FuYouDeductState.BYXCKRJXDJY.value, "不允许持卡人进行的交易");
			fydeductStateMap.put(FuYouDeductState.BYXZDJXDJY.value, "不允许终端进行的交易");
			fydeductStateMap.put(FuYouDeductState.YZBXY1059.value, "有作弊嫌疑");
			fydeductStateMap
					.put(FuYouDeductState.SKFYDLFLX1060.value, "受卡方与代理方联系");
			fydeductStateMap.put(FuYouDeductState.CCQKHZZJEXZ1061.value,
					"超出取款/转账金额限制");
			fydeductStateMap.put(FuYouDeductState.SXZDK1062.value, "受限制的卡");
			fydeductStateMap.put(FuYouDeductState.QFAQ.value, "侵犯安全");
			fydeductStateMap.put(FuYouDeductState.YSJECW.value, "原始金额错误");
			fydeductStateMap.put(FuYouDeductState.CCQKCSXZ1065.value, "超出取款次数限制");
			fydeductStateMap.put(FuYouDeductState.SKFTZSLFAQBM.value,
					"受卡方通知受理方安全部门");
			fydeductStateMap.put(FuYouDeductState.QXSL.value,
					"强行受理（要求在自动会员机上没收此卡）");
			fydeductStateMap.put(FuYouDeductState.JSDXYYGS1068.value, "接收的响应已过时");
			fydeductStateMap.put(FuYouDeductState.YXDSRPINCSCX.value,
					"允许的输入PIN次数超限");
			fydeductStateMap.put(FuYouDeductState.WXZH.value, "无效账户");
			fydeductStateMap.put(FuYouDeductState.ZZRZCL.value,
					"正在日终处理（系统终止一天的活动，开始第二天的活动，交易在几分钟后可再次发送）");
			fydeductStateMap.put(FuYouDeductState.JYJSFHJHZXBNCZ.value,
					"交易接收方或交换中心不能操作");
			fydeductStateMap.put(FuYouDeductState.JRJGHZJWLSSZBDHWFDD.value,
					"金融机构或中间网络设施找不到或无法达到、金融机构签退");
			fydeductStateMap.put(FuYouDeductState.JYWF.value, "交易违法、不能完成");
			fydeductStateMap.put(FuYouDeductState.CFJY.value, "重复交易");
			fydeductStateMap.put(FuYouDeductState.HDCC.value, "核对差错");
			fydeductStateMap.put(FuYouDeductState.XTYCSX.value, "系统异常、失效");
			fydeductStateMap.put(FuYouDeductState.JHZXSBDJYJSFYD.value,
					"交换中心收不到交易接收方应答");
			fydeductStateMap.put(FuYouDeductState.PINGSCC.value, "PIN格式错");
			fydeductStateMap.put(FuYouDeductState.MACJBSB.value, "MAC鉴别失败");
			fydeductStateMap
					.put(FuYouDeductState.JSDXYYGS200001.value, "接收的响应已过时");
			fydeductStateMap.put(FuYouDeductState.CS.value, "超时");
		}
	}
}