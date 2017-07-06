package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 富有金账户自动开户返回状态
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月18日
 */
public enum FuYouAccountBackState {
	JYCG("0000"), // 交易成功
	XTYC1000("1000"), // 系统异常
	WCYH("1001"), // 无此用户
	YHWJH("1002"), // 用户未激活
	YHYSD("1003"), // 用户已锁定
	YHZTYC1004("1004"), // 用户状态异常
//	YHZTYC1005("1005"), // 用户状态异常
//	YHZTYC1006("1006"), // 用户状态异常
	WZYH("1007"), // 未知用户
	SMXXBZQ("1008"), // 实名信息不正确
//	XTYC1009("1009"), // 系统异常
	WXKH("1014"), // 无效卡号(无此卡号)
	WCZH1042("1042"), // 无此账户
	ZJBZ("1051"), // 资金不足
	WCSH("1101"), // 无此商户
	SHYGB("1102"), // 商户已关闭
	SHYSD("1103"), // 商户已锁定
	ZCZH("2000"), // 正常账户
	WCZH2001("2001"), // 无此账户
	ZHWJH("2002"), // 账户未激活
//	ZHYSD("2003"), // 账户已锁定
//	ZHYDJ("2004"), // 账户已冻结
	ZHZTYC2005("2005"), // 账户状态异常
//	ZHZTYC2006("2006"), // 账户状态异常
//	ZHZTYC2007("2007"), // 账户状态异常
//	ZHZTYC2008("2008"), // 账户状态异常
//	ZHZTYC2010("2010"), // 账户状态异常
//	ZHZTYC2011("2011"), // 账户状态异常
//	ZHZTYC2012("2012"), // 账户状态异常
//	ZHZTYC2013("2013"), // 账户状态异常
//	ZHZTYC2014("2014"), // 账户状态异常
//	ZHZTYC2015("2015"), // 账户状态异常
//	ZHZTYC2016("2016"), // 账户状态异常
//	ZHZTYC2017("2017"), // 账户状态异常
	JYBZBF("2019"), // 交易币种不符
	ZBZC("2020"), // 暂不支持
	DJZHZTYC("2030"), // 贷记账户状态正常
	WCDJZH("2031"), // 无此贷记账户
	DJZHWJH("2032"), // 贷记账户未激活
	DJZHYSD("2033"), // 贷记账户已锁定
	DJZHYDJ("2034"), // 贷记账户已冻结
	DJZHYXH("2035"), // 贷记账户已销户
	DJZHYGQ("2036"), // 贷记账户已过期
	DJZHYGS("2037"), // 贷记账户已挂失
	DJZHZTBZC("2038"), // 贷记账户状态不正常
	JDJZJBSYTYGJG("2039"), // 借贷记账记不属于同一个机构
	HYZB2040("2040"), // 怀疑作弊
//	HYZB2041("2041"), // 怀疑作弊
//	HYZB2101("2101"), // 怀疑作弊
//	HYZB2102("2102"), // 怀疑作弊
	AQYZCW2103("2103"), // 安全验证错误
//	AQYZCW2104("2104"), // 安全验证错误
	CXMMCW("2105"), // 查询密码错误
	ZFMMCW("2106"), // 支付密码错误
	CXMMCWCSCX("2107"), // 查询密码错误次数超限
	ZFMMCWCSCX("2108"), // 支付密码错误次数超限
	GSC2109("2109"), // 格式错
	GNZBZC3001("3001"), // 功能暂不支持
//	GNZBZC3002("3002"), // 功能暂不支持
	AQYZCW("3003"), // 安全验证错误
//	GNZBZC3004("3004"), // 功能暂不支持
//	GNZBZC3005("3005"), // 功能暂不支持
//	GNZBZC3006("3006"), // 功能暂不支持
//	GNZBZC3007("3007"), // 功能暂不支持
	JYJETD("3011"), // 交易金额太大
	JEWX("3012"), // 金额无效
	YEBZ3013("3013"), // 余额不足
//	YEBZ3014("3014"), // 余额不足
//	YEBZ3015("3015"), // 余额不足
//	YEBZ3016("3016"), // 余额不足
//	YEBZ3017("3017"), // 余额不足
//	YEBZ3018("3018"), // 余额不足
	JYJETX3019("3019"), // 交易金额太小
//	YEBZ3020("3020"), // 余额不足
//	YEBZ3021("3021"), // 余额不足
//	JYJETX3022("3022"), // 交易金额太小
//	YEBZ3023("3023"), // 余额不足
	JETD("3024"), // 金额太大
	ZBDYJY3101("3101"), // 找不到原交易
	YJYBCG("3102"), // 原交易不成功
	YJYYCZ("3103"), // 原交易已冲正
	YJYYCX("3104"), // 原交易已撤消
	YJYYWC("3105"), // 原交易已完成
	YJYYDJ("3106"), // 原交易已冻结
	YJYYJD("3107"), // 原交易已解冻
	YJYJEBF("3108"), // 原交易金额不符
//	YJYZHBF("3109"), // 原交易账号不符
	ZBDYSSQJY("3110"), // 找不到原始授权交易
	YJYZTYC3111("3111"), // 原交易状态异常
//	YJYZTYC3112("3112"), // 原交易状态异常
	XTYC3120("3120"), // 系统异常
	SHBPP("3121"), // 商户不匹配
	JYYWC("3122"), // 交易已完成
	KHBPP("3123"), // 卡号不匹配
	JECX3124("3124"), // 金额超限
	JEBYZ("3125"), // 金额不一致
	ZDHBYZ("3126"), // 终端号不一致
	GRJYWFWC("3127"), // 隔日交易，无法完成
	JZSB("3201"), // 记账失败
	TXZHWZD("3251"), // 提现账户未指定
	SHXXBWZ("3252"), // 商户信息不完整
	GSC("3253"), // 格式错
	JYCS3271("3271"), // 交易超时
//	JYCS3272("3272"), // 交易超时
	BYXKCZH4001("4001"), // 不允许开此账户
//	BYXKCZH4002("4002"), // 不允许开此账户
//	XTYC4003("4003"), // 系统异常
//	BYXKCZH4004("4004"), // 不允许开此账户
//	BYXKCZH4005("4005"), // 不允许开此账户
	XTYC4006("4006"), // 系统异常
//	XTYC4007("4007"), // 系统异常
//	XTYC4008("4008"), // 系统异常
	BZCDKHFS4009("4009"), // 不支持的开户方式
//	BZCDKHFS4010("4010"), // 不支持的开户方式
//	BZCDKHFS4011("4011"), // 不支持的开户方式
//	XTYC4012("4012"), // 系统异常
	BKCFKH("4013"), // 不可重复开户
	SSCH("5001"), // session超时
	YQSB("5002"), // 验签失败
	WZRHXG("5017"), // 未做任何修改
	GJDQDMHHBZBDDYZH("5018"), // 根据地区代码和行别找不到对应支行
	SJJYSB("5019"), // 数据校验失败
	DYJYCXJKGYPF("5029"), // 调用交易查询接口过于频繁
	YHMHMMCW("5110"), // 用户名或密码错误
	ZHXXBNXG("5137"), // 账户信息不能修改
//	XTYC5138("5138"), // 系统异常
	SHBCZ5239("5239"), // 商户不存在
	YHYKH5343("5343"), // 用户已开户
	CWXTKHSB("5344"), // 账务系统开户失败
	SHLSHCF("5345"), // 商户流水号重复
	SHLSHBCZ("5346"), // 商户流水号不存在
	YSHXTRQBYZ("5347"), // 与商户系统日期不一致
	JYYHBCZ("5348"), // 交易用户不存在
	ZBDYJY("5349"), // 找不到原交易
	ZLTJMSZZCFYYEZF("5350"), // 指令提交模式只支持富友余额支付
	SHTXLSHCF("5351"), // 商户提现流水号重复
	WZDGSHJYJL("5352"), // 未找到该商户交易记录
	JSFASBWCXYC("5353"), // 接收FAS报文出现异常
	FASBWYQSB("5354"), // FAS报文验签失败
	FSFASTXCXYC("5355"), // 发送FAS通讯出现异常
	GKHYRZ("5356"), // 该卡号已认证
	GKHYJSLQRZTG("5357"), // 该卡号已经受理且认证通过
	GKHYJSLDSWRZTG("5358"), // 该卡号已经受理,但尚未认证通过
	GKHSWQY("5359"), // 该卡号尚未签约
	FSRQTZSB("5460"), // 发送日切通知失败
	JYQDCS5555("5555"), // 交易确定超时
	YHXXXGQJBNDKCZHTX("5556"), // 用户信息修改期间不能代扣充值或提现
	JYQDCS5557("5557"), // 用户未授权
	BYXXYKZC("5836"), // 不允许信用卡注册
	KHHHHBYZ("5837"), // 卡号和行别不一致
	YJCZXTYHKHZCDYH5850("5850"), // 已经存在相同银行卡号注册的用户
//	YJCZXTYHKHZCDYH5851("5851"), // 已经存在相同银行卡号注册的用户
	SMYZSB("5852"), // 实名验证失败
	SHIPBYXFW("5853"), // 商户IP不允许访问
	XYKYZRQCGQT("5854"), // 协议库验证日期超过7天
	GSJHBDKHCGLZ("5855"), // 该手机号绑定卡号超过2张(在代收付系统解约)
	WQXFWGJK("5856"), // 无权限访问该接口
	YZCSCX("5857"), // 验证次数超限
//	YHYKH5891("5891"), // 用户已开户
//	XTYC9000("9000"), // 系统异常
//	XTYC9001("9001"), // 系统异常
//	XTYC9002("9002"), // 系统异常
	JGYGB("9003"), // 机构已关闭
	JGZTYC("9004"), // 机构状态异常
//	XTYC9005("9005"), // 系统异常
//	XTYC9006("9006"), // 系统异常
//	XTYC9007("9007"), // 系统异常
//	XTYC9008("9008"), // 系统异常
//	XTYC9009("9009"), // 系统异常
//	XTYC9010("9010"), // 系统异常
//	XTYC9011("9011"), // 系统异常
//	XTYC9012("9012"), // 系统异常
//	XTYC9013("9013"), // 系统异常
//	XTYC9014("9014"), // 系统异常
//	XTYC9015("9015"), // 系统异常
//	XTYC9016("9016"), // 系统异常
//	XTYC9701("9701"), // 系统异常
//	XTYC9801("9801"), // 系统异常
//	XTYC9802("9802"), // 系统异常
//	XTYC9803("9803"), // 系统异常
//	XTYC9804("9804"), // 系统异常
//	XTYC9805("9805"), // 系统异常
//	XTYC9806("9806"), // 系统异常
//	XTYC9901("9901"), // 系统异常
//	XTYC9902("9902"), // 系统异常
	JECX10029("10029"), // 金额超限
	YHHZHMBF100011("100011"); // 卡号或者户名不符
//	XTYC210001("210001"), // 系统异常
//	XTYC210002("210002");// 系统异常

	public final String value;

	private FuYouAccountBackState(String value) {
		this.value = value;
	}

	public static String getFyjopenbackState(String value) {
		return fyjopenbackStateMap.get(value);
	}

	public static Map<String, String> fyjopenbackStateMap = new Hashtable<String, String>();

	public static void initFyjopenbackState() {
		if (fyjopenbackStateMap.isEmpty()) {
			fyjopenbackStateMap.put(FuYouAccountBackState.JYCG.value, "交易成功");
			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC1000.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.WCYH.value, "无此用户");
			fyjopenbackStateMap.put(FuYouAccountBackState.YHWJH.value, "用户未激活");
			fyjopenbackStateMap.put(FuYouAccountBackState.YHYSD.value, "用户已锁定");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.YHZTYC1004.value, "用户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.YHZTYC1005.value, "用户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.YHZTYC1006.value, "用户状态异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.WZYH.value, "未知用户");
			fyjopenbackStateMap.put(FuYouAccountBackState.SMXXBZQ.value, "实名信息不正确");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC1009.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.WXKH.value, "无效卡号(无此卡号)");
			fyjopenbackStateMap.put(FuYouAccountBackState.WCZH1042.value, "无此账户");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZJBZ.value, "资金不足");
			fyjopenbackStateMap.put(FuYouAccountBackState.WCSH.value, "无此商户");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHYGB.value, "商户已关闭");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHYSD.value, "商户已锁定");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZCZH.value, "正常账户");
			fyjopenbackStateMap.put(FuYouAccountBackState.WCZH2001.value, "无此账户");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZHWJH.value, "账户未激活");
//			fyjopenbackStateMap.put(FuYouAccountBackState.ZHYSD.value, "账户已锁定");
//			fyjopenbackStateMap.put(FuYouAccountBackState.ZHYDJ.value, "账户已冻结");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.ZHZTYC2005.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2006.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2007.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2008.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2010.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2011.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2012.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2013.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2014.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2015.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2016.value, "账户状态异常");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.ZHZTYC2017.value, "账户状态异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.JYBZBF.value, "交易币种不符");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZBZC.value, "暂不支持");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.DJZHZTYC.value, "贷记账户状态正常");
			fyjopenbackStateMap.put(FuYouAccountBackState.WCDJZH.value, "无此贷记账户");
			fyjopenbackStateMap.put(FuYouAccountBackState.DJZHWJH.value, "贷记账户未激活");
			fyjopenbackStateMap.put(FuYouAccountBackState.DJZHYSD.value, "贷记账户已锁定");
			fyjopenbackStateMap.put(FuYouAccountBackState.DJZHYDJ.value, "贷记账户已冻结");
			fyjopenbackStateMap.put(FuYouAccountBackState.DJZHYXH.value, "贷记账户已销户");
			fyjopenbackStateMap.put(FuYouAccountBackState.DJZHYGQ.value, "贷记账户已过期");
			fyjopenbackStateMap.put(FuYouAccountBackState.DJZHYGS.value, "贷记账户已挂失");
			fyjopenbackStateMap.put(FuYouAccountBackState.DJZHZTBZC.value,
					"贷记账户状态不正常");
			fyjopenbackStateMap.put(FuYouAccountBackState.JDJZJBSYTYGJG.value,
					"借贷记账记不属于同一个机构");
			fyjopenbackStateMap.put(FuYouAccountBackState.HYZB2040.value, "怀疑作弊");
//			fyjopenbackStateMap.put(FuYouAccountBackState.HYZB2041.value, "怀疑作弊");
//			fyjopenbackStateMap.put(FuYouAccountBackState.HYZB2101.value, "怀疑作弊");
//			fyjopenbackStateMap.put(FuYouAccountBackState.HYZB2102.value, "怀疑作弊");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.AQYZCW2103.value, "安全验证错误");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.AQYZCW2104.value, "安全验证错误");
			fyjopenbackStateMap.put(FuYouAccountBackState.CXMMCW.value, "查询密码错误");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZFMMCW.value, "支付密码错误");
			fyjopenbackStateMap.put(FuYouAccountBackState.CXMMCWCSCX.value,
					"查询密码错误次数超限");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZFMMCWCSCX.value,
					"支付密码错误次数超限");
			fyjopenbackStateMap.put(FuYouAccountBackState.GSC2109.value, "格式错");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.GNZBZC3001.value, "功能暂不支持");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.GNZBZC3002.value, "功能暂不支持");
			fyjopenbackStateMap.put(FuYouAccountBackState.AQYZCW.value, "安全验证错误");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.GNZBZC3004.value, "功能暂不支持");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.GNZBZC3005.value, "功能暂不支持");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.GNZBZC3006.value, "功能暂不支持");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.GNZBZC3007.value, "功能暂不支持");
			fyjopenbackStateMap.put(FuYouAccountBackState.JYJETD.value, "交易金额太大");
			fyjopenbackStateMap.put(FuYouAccountBackState.JEWX.value, "金额无效");
			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3013.value, "余额不足");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3014.value, "余额不足");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3015.value, "余额不足");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3016.value, "余额不足");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3017.value, "余额不足");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3018.value, "余额不足");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.JYJETX3019.value, "交易金额太小");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3020.value, "余额不足");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3021.value, "余额不足");
//			fyjopenbackStateMap
//					.put(FuYouAccountBackState.JYJETX3022.value, "交易金额太小");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YEBZ3023.value, "余额不足");
			fyjopenbackStateMap.put(FuYouAccountBackState.JETD.value, "金额太大");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.ZBDYJY3101.value, "找不到原交易");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYBCG.value, "原交易不成功");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYYCZ.value, "原交易已冲正");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYYCX.value, "原交易已撤消");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYYWC.value, "原交易已完成");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYYDJ.value, "原交易已冻结");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYYJD.value, "原交易已解冻");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYJEBF.value, "原交易金额不符");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YJYZHBF.value, "原交易账号不符");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZBDYSSQJY.value,
					"找不到原始授权交易");
			fyjopenbackStateMap.put(FuYouAccountBackState.YJYZTYC3111.value,
					"原交易状态异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YJYZTYC3112.value,
//					"原交易状态异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC3120.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHBPP.value, "商户不匹配");
			fyjopenbackStateMap.put(FuYouAccountBackState.JYYWC.value, "交易已完成");
			fyjopenbackStateMap.put(FuYouAccountBackState.KHBPP.value, "卡号不匹配");
			fyjopenbackStateMap.put(FuYouAccountBackState.JECX3124.value, "金额超限");
			fyjopenbackStateMap.put(FuYouAccountBackState.JEBYZ.value, "金额不一致");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZDHBYZ.value, "终端号不一致");
			fyjopenbackStateMap.put(FuYouAccountBackState.GRJYWFWC.value,
					"隔日交易，无法完成");
			fyjopenbackStateMap.put(FuYouAccountBackState.JZSB.value, "记账失败");
			fyjopenbackStateMap.put(FuYouAccountBackState.TXZHWZD.value, "提现账户未指定");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHXXBWZ.value, "商户信息不完整");
			fyjopenbackStateMap.put(FuYouAccountBackState.GSC.value, "格式错");
			fyjopenbackStateMap.put(FuYouAccountBackState.JYCS3271.value, "交易超时");
//			fyjopenbackStateMap.put(FuYouAccountBackState.JYCS3272.value, "交易超时");
			fyjopenbackStateMap.put(FuYouAccountBackState.BYXKCZH4001.value,
					"不允许开此账户");
//			fyjopenbackStateMap.put(FuYouAccountBackState.BYXKCZH4002.value,
//					"不允许开此账户");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC4003.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.BYXKCZH4004.value,
//					"不允许开此账户");
//			fyjopenbackStateMap.put(FuYouAccountBackState.BYXKCZH4005.value,
//					"不允许开此账户");
			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC4006.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC4007.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC4008.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.BZCDKHFS4009.value,
					"不支持的开户方式");
//			fyjopenbackStateMap.put(FuYouAccountBackState.BZCDKHFS4010.value,
//					"不支持的开户方式");
//			fyjopenbackStateMap.put(FuYouAccountBackState.BZCDKHFS4011.value,
//					"不支持的开户方式");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC4012.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.BKCFKH.value, "不可重复开户");
			fyjopenbackStateMap.put(FuYouAccountBackState.SSCH.value, "session超时");
			fyjopenbackStateMap.put(FuYouAccountBackState.YQSB.value, "验签失败");
			fyjopenbackStateMap.put(FuYouAccountBackState.WZRHXG.value, "未做任何修改");
			fyjopenbackStateMap.put(FuYouAccountBackState.GJDQDMHHBZBDDYZH.value,
					"根据地区代码和行别找不到对应支行");
			fyjopenbackStateMap.put(FuYouAccountBackState.SJJYSB.value, "数据校验失败");
			fyjopenbackStateMap.put(FuYouAccountBackState.DYJYCXJKGYPF.value,
					"调用交易查询接口过于频繁");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.YHMHMMCW.value, "用户名或密码错误");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.ZHXXBNXG.value, "账户信息不能修改");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC5138.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHBCZ5239.value, "商户不存在");
			fyjopenbackStateMap.put(FuYouAccountBackState.YHYKH5343.value, "用户已开户");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.CWXTKHSB.value, "账务系统开户失败");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHLSHCF.value, "商户流水号重复");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.SHLSHBCZ.value, "商户流水号不存在");
			fyjopenbackStateMap.put(FuYouAccountBackState.YSHXTRQBYZ.value,
					"与商户系统日期不一致");
			fyjopenbackStateMap.put(FuYouAccountBackState.JYYHBCZ.value, "交易用户不存在");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZBDYJY.value, "找不到原交易");
			fyjopenbackStateMap.put(FuYouAccountBackState.ZLTJMSZZCFYYEZF.value,
					"指令提交模式只支持富友余额支付");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHTXLSHCF.value,
					"商户提现流水号重复");
			fyjopenbackStateMap.put(FuYouAccountBackState.WZDGSHJYJL.value,
					"未找到该商户交易记录");
			fyjopenbackStateMap.put(FuYouAccountBackState.JSFASBWCXYC.value,
					"接收FAS报文出现异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.FASBWYQSB.value,
					"FAS报文验签失败");
			fyjopenbackStateMap.put(FuYouAccountBackState.FSFASTXCXYC.value,
					"发送FAS通讯出现异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.GKHYRZ.value, "该卡号已认证");
			fyjopenbackStateMap.put(FuYouAccountBackState.GKHYJSLQRZTG.value,
					"该卡号已经受理且认证通过");
			fyjopenbackStateMap.put(FuYouAccountBackState.GKHYJSLDSWRZTG.value,
					"该卡号已经受理,但尚未认证通过");
			fyjopenbackStateMap.put(FuYouAccountBackState.GKHSWQY.value, "该卡号尚未签约");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.FSRQTZSB.value, "发送日切通知失败");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.JYQDCS5555.value, "交易确定超时");
			fyjopenbackStateMap.put(FuYouAccountBackState.YHXXXGQJBNDKCZHTX.value,
					"用户信息修改期间不能代扣充值或提现");
			fyjopenbackStateMap.put(FuYouAccountBackState.JYQDCS5557.value, "用户未授权");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.BYXXYKZC.value, "不允许信用卡注册");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.KHHHHBYZ.value, "卡号和行别不一致");
			fyjopenbackStateMap.put(FuYouAccountBackState.BYXXYKZC.value,
					"已经存在相同银行卡号注册的用户");
			fyjopenbackStateMap.put(FuYouAccountBackState.BYXXYKZC.value,
					"已经存在相同银行卡号注册的用户");
			fyjopenbackStateMap.put(FuYouAccountBackState.SMYZSB.value, "实名验证失败");
			fyjopenbackStateMap.put(FuYouAccountBackState.SHIPBYXFW.value,
					"商户IP不允许访问");
			fyjopenbackStateMap.put(FuYouAccountBackState.XYKYZRQCGQT.value,
					"协议库验证日期超过7天");
			fyjopenbackStateMap.put(FuYouAccountBackState.GSJHBDKHCGLZ.value,
					"该手机号绑定卡号超过2张(在代收付系统解约)");
			fyjopenbackStateMap
					.put(FuYouAccountBackState.WQXFWGJK.value, "无权限访问该接口");
			fyjopenbackStateMap.put(FuYouAccountBackState.YZCSCX.value, "验证次数超限");
//			fyjopenbackStateMap.put(FuYouAccountBackState.YHYKH5891.value, "用户已开户");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9000.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9001.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9002.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.JGYGB.value, "机构已关闭");
			fyjopenbackStateMap.put(FuYouAccountBackState.JGZTYC.value, "机构状态异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9005.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9006.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9007.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9008.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9009.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9010.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9011.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9012.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9013.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9014.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9015.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9016.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9701.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9801.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9802.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9803.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9804.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9805.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9806.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9901.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC9902.value, "系统异常");
			fyjopenbackStateMap.put(FuYouAccountBackState.JECX10029.value, "金额超限");
			fyjopenbackStateMap.put(FuYouAccountBackState.YHHZHMBF100011.value,
					"卡号或者户名不符");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC210001.value, "系统异常");
//			fyjopenbackStateMap.put(FuYouAccountBackState.XTYC210002.value, "系统异常");
		}
	}
}