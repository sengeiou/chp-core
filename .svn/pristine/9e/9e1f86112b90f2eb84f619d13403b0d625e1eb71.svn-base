package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 好易联划扣状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum HyldeductState {
	CLCG("0000"), // 处理成功
	QDBUZCJYWFJX("397"), // 渠道不支持，交易无法进行
	CKHFYY("3001"), // 查开户方原因
	MSK("3002"), // 没收卡
	BYCN("3003"), // 不予承兑
	WXKH("3004"), // 无效卡号
	SKFYAQBMBMLX("3005"), // 受卡方与安全保密部门联系
	YGSK("3006"), // 已挂失卡
	BQK("3007"), // 被窃卡
	YEBZ("3008"), // 余额不足
	WCZH("3009"), // 无此账户
	GQK("3010"), // 过期卡
	MMCW("3011"), // 密码错
	BYXCKRJXJY("3012"), // 不允许持卡人进行的交易
	CCTKXE("3013"), // 超出提款限额
	YSJEBZQ("3014"), // 原始金额不正确
	CCQKCSXZ("3015"), // 超出取款次数限制
	YGSZ("3016"), // 已挂失折
	ZHYDJ("3017"), // 账户已冻结
	YQH("3018"), // 已清户
	YJYYBQXHCZ("3019"), // 原交易已被取消或冲正
	ZHBLSSD("3020"), // 账户被临时锁定
	WDZHSCX("3021"), // 未登折行数超限
	CZHMYW("3022"), // 存折号码有误
	DRCRDJEDRBNZQ("3023"), // 当日存入的金额当日不能支取
	RQQHZZCL("3024"), // 日期切换正在处理
	PINGSCC("3025"), // PIN格式出错
	FKFBMZXTSB("3026"), // 发卡方保密子系统失败
	YSJYBCG("3027"), // 原始交易不成功
	XTMQSHZTJ("3028"), // 系统忙，请稍后再提交
	JYYBCZ("3029"), // 交易已被冲正
	ZHCW("3030"), // 账号错误
	ZHHMBF("3031"), // 账号户名不符
	ZHHBBF("3032"), // 账号货币不符
	WCYJY("3033"), // 无此原交易
	FHQZH("3034"), // 非活期账号
	ZBDYJL("3035"), // 找不到原记录
	HBCW("3036"), // 货币错误
	CKWSX("3037"), // 磁卡未生效
	FTDH("3038"), // 非通兑户
	ZHYGB("3039"), // 账户已关户
	JECW("3040"), // 金额错误
	FCZH("3041"), // 非存折户
	JYJEXYGCZDZDZQJE("3042"), // 交易金额小于该储种的最低支取金额
	WYYHQY("3043"), // 未与银行签约
	CSJF("3044"), // 超时拒付
	HTHZXYKLBCZ("3045"), // 合同（协议）号在协议库里不存在
	HTHHMSX("3046"), // 合同（协议）号还没有生效
	HTHYCX("3047"), // 合同（协议）号已撤销
	YWYJQSBNCX("3048"), // 业务已经清算，不能撤销
	YWYBJJBNCX("3049"), // 业务已被拒绝，不能撤销
	YWYCX("3050"), // 业务已撤销
	CFYW("3051"), // 重复业务
	ZBDYYW("3052"), // 找不到原业务
	PLHZBWDGDZDHZRQ("3053"), // 批量回执包未到规定最短回执期限（M日）
	PLHZBCGGDZCHZQX("3054"), // 批量回执包超过规定最长回执期限（N日）
	DRTDYWLJJECGGDJE("3055"), // 当日通兑业务累计金额超过规定金额
	TP("3056"), // 退票
	ZHZTCW("3057"), // 账户状态错误
	SZQMHZSCW("3058"), // 数字签名或证书错
	XTBNDGZHJXCL("3097"), // 系统不能对该账号进行处理
	QTCW("3999");// 其它错误（含义见中文）

	public final String value;

	private HyldeductState(String value) {
		this.value = value;
	}

	public static String getHyldeductState(String value) {
		return hyldeductStateMap.get(value);
	}

	public static Map<String, String> hyldeductStateMap = new Hashtable<String, String>();

	public static void initHyldeductState() {
		if (hyldeductStateMap.isEmpty()) {
			hyldeductStateMap.put(HyldeductState.CLCG.value, "处理成功");
			hyldeductStateMap.put(HyldeductState.QDBUZCJYWFJX.value,
					"渠道不支持，交易无法进行");
			hyldeductStateMap.put(HyldeductState.CKHFYY.value, "查开户方原因");
			hyldeductStateMap.put(HyldeductState.MSK.value, "没收卡");
			hyldeductStateMap.put(HyldeductState.BYCN.value, "不予承兑");
			hyldeductStateMap.put(HyldeductState.WXKH.value, "无效卡号");
			hyldeductStateMap.put(HyldeductState.SKFYAQBMBMLX.value,
					"受卡方与安全保密部门联系");
			hyldeductStateMap.put(HyldeductState.YGSK.value, "已挂失卡");
			hyldeductStateMap.put(HyldeductState.BQK.value, "被窃卡");
			hyldeductStateMap.put(HyldeductState.YEBZ.value, "余额不足");
			hyldeductStateMap.put(HyldeductState.WCZH.value, "无此账户");
			hyldeductStateMap.put(HyldeductState.GQK.value, "过期卡");
			hyldeductStateMap.put(HyldeductState.MMCW.value, "密码错");
			hyldeductStateMap.put(HyldeductState.BYXCKRJXJY.value,
					"不允许持卡人进行的交易");
			hyldeductStateMap.put(HyldeductState.CCTKXE.value, "超出提款限额");
			hyldeductStateMap.put(HyldeductState.YSJEBZQ.value, "原始金额不正确");
			hyldeductStateMap.put(HyldeductState.CCQKCSXZ.value, "超出取款次数限制");
			hyldeductStateMap.put(HyldeductState.YGSZ.value, "已挂失折");
			hyldeductStateMap.put(HyldeductState.ZHYDJ.value, "账户已冻结");
			hyldeductStateMap.put(HyldeductState.YQH.value, "已清户");
			hyldeductStateMap
					.put(HyldeductState.YJYYBQXHCZ.value, "原交易已被取消或冲正");
			hyldeductStateMap.put(HyldeductState.ZHBLSSD.value, "账户被临时锁定");
			hyldeductStateMap.put(HyldeductState.WDZHSCX.value, "未登折行数超限");
			hyldeductStateMap.put(HyldeductState.CZHMYW.value, "存折号码有误");
			hyldeductStateMap.put(HyldeductState.DRCRDJEDRBNZQ.value,
					"当日存入的金额当日不能支取");
			hyldeductStateMap.put(HyldeductState.RQQHZZCL.value, "日期切换正在处理");
			hyldeductStateMap.put(HyldeductState.PINGSCC.value, "PIN格式出错");
			hyldeductStateMap
					.put(HyldeductState.FKFBMZXTSB.value, "发卡方保密子系统失败");
			hyldeductStateMap.put(HyldeductState.YSJYBCG.value, "原始交易不成功");
			hyldeductStateMap.put(HyldeductState.XTMQSHZTJ.value, "系统忙，请稍后再提交");
			hyldeductStateMap.put(HyldeductState.JYYBCZ.value, "交易已被冲正");
			hyldeductStateMap.put(HyldeductState.ZHCW.value, "账号错误");
			hyldeductStateMap.put(HyldeductState.ZHHMBF.value, "账号户名不符");
			hyldeductStateMap.put(HyldeductState.ZHHBBF.value, "账号货币不符");
			hyldeductStateMap.put(HyldeductState.WCYJY.value, "无此原交易");
			hyldeductStateMap.put(HyldeductState.FHQZH.value, "非活期账号");
			hyldeductStateMap.put(HyldeductState.ZBDYJL.value, "找不到原记录");
			hyldeductStateMap.put(HyldeductState.HBCW.value, "货币错误");
			hyldeductStateMap.put(HyldeductState.CKWSX.value, "磁卡未生效");
			hyldeductStateMap.put(HyldeductState.FTDH.value, "非通兑户");
			hyldeductStateMap.put(HyldeductState.ZHYGB.value, "账户已关户");
			hyldeductStateMap.put(HyldeductState.JECW.value, "金额错误");
			hyldeductStateMap.put(HyldeductState.FCZH.value, "非存折户");
			hyldeductStateMap.put(HyldeductState.JYJEXYGCZDZDZQJE.value,
					"交易金额小于该储种的最低支取金额");
			hyldeductStateMap.put(HyldeductState.WYYHQY.value, "未与银行签约");
			hyldeductStateMap.put(HyldeductState.CSJF.value, "超时拒付");
			hyldeductStateMap.put(HyldeductState.HTHZXYKLBCZ.value,
					"合同（协议）号在协议库里不存在");
			hyldeductStateMap.put(HyldeductState.HTHHMSX.value, "合同（协议）号还没有生效");
			hyldeductStateMap.put(HyldeductState.HTHYCX.value, "合同（协议）号已撤销");
			hyldeductStateMap.put(HyldeductState.YWYJQSBNCX.value,
					"业务已经清算，不能撤销");
			hyldeductStateMap.put(HyldeductState.YWYBJJBNCX.value,
					"业务已被拒绝，不能撤销");
			hyldeductStateMap.put(HyldeductState.YWYCX.value, "业务已撤销");
			hyldeductStateMap.put(HyldeductState.CFYW.value, "重复业务");
			hyldeductStateMap.put(HyldeductState.ZBDYYW.value, "找不到原业务");
			hyldeductStateMap.put(HyldeductState.PLHZBWDGDZDHZRQ.value,
					"批量回执包未到规定最短回执期限（M日）");
			hyldeductStateMap.put(HyldeductState.PLHZBCGGDZCHZQX.value,
					"批量回执包超过规定最长回执期限（N日）");
			hyldeductStateMap.put(HyldeductState.DRTDYWLJJECGGDJE.value,
					"当日通兑业务累计金额超过规定金额");
			hyldeductStateMap.put(HyldeductState.TP.value, "退票");
			hyldeductStateMap.put(HyldeductState.ZHZTCW.value, "账户状态错误");
			hyldeductStateMap.put(HyldeductState.SZQMHZSCW.value, "数字签名或证书错");
			hyldeductStateMap.put(HyldeductState.XTBNDGZHJXCL.value,
					"系统不能对该账号进行处理");
			hyldeductStateMap.put(HyldeductState.QTCW.value, "其它错误（含义见中文）");
		}
	}
}