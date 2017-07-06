package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 短信模板类型
 * 
 * @Class Name SmsType
 * @author 朱杰
 * @Create In 2016年1月21日
 */
public enum SmsType {
	TSTX("0"), 		// 特殊提醒短信
	HKTX("1"), // 划扣提醒
	HKCG("2"), // 划扣成功
	HKSB("3"), // 划扣失败
	QX_DQTX("4"), // 期限类到期提醒
	FQX_DQTX("5"), // 非期限类到期提醒
	YXT_SYHK("6"), // 月息通收益回款提醒
	DQHK("7"), // 正常到期回款提醒
	TQSH("8"), // 提前赎回回款提醒
	XHB_SYTX("9"), // 信和宝分次返收益提醒
	JZH_KH("10"), // 金账户开户
	SMS_VERIFY("11"),// 手机验证
	KHSRTX("12"),	// 客户生日提醒短信
	NZCJ("13"),	// 内转出借
	BF_HKSB("14"),	// 部分划扣失败
	LEND_APPROVAL("15"),	// 出借申请审批
	XHYZ_FXTX("16");	// 信和月增返息提醒

	public static Map<String, String> smsTypeMap = new Hashtable<String, String>();

	static {
		smsTypeMap.put(SmsType.TSTX.value, "特殊提醒短信");
		smsTypeMap.put(SmsType.HKTX.value, "划扣提醒");
		smsTypeMap.put(SmsType.HKCG.value, "划扣成功");
		smsTypeMap.put(SmsType.HKSB.value, "划扣失败");
		smsTypeMap.put(SmsType.QX_DQTX.value, "期限类到期提醒");
		smsTypeMap.put(SmsType.FQX_DQTX.value, "非期限类到期提醒");
		smsTypeMap.put(SmsType.YXT_SYHK.value, "月息通收益回款提醒 ");
		smsTypeMap.put(SmsType.DQHK.value, "正常到期回款提醒");
		smsTypeMap.put(SmsType.TQSH.value, "提前赎回回款提醒");
		smsTypeMap.put(SmsType.XHB_SYTX.value, "信和宝分次返收益提醒");
		smsTypeMap.put(SmsType.JZH_KH.value, "金账户开户");
		smsTypeMap.put(SmsType.SMS_VERIFY.value, "手机验证");
		smsTypeMap.put(SmsType.KHSRTX.value, "客户生日提醒短信");
		smsTypeMap.put(SmsType.NZCJ.value, "内转出借");
		smsTypeMap.put(SmsType.BF_HKSB.value, "部分划扣失败");
		smsTypeMap.put(SmsType.LEND_APPROVAL.value, "出借申请审批");
		smsTypeMap.put(SmsType.XHYZ_FXTX.value, "信和月增返息提醒");
	}
	public final String value;

	private SmsType(String value) {
		this.value = value;
	}

	public static String getAppalyState(String value) {
		return smsTypeMap.get(value);
	}
}