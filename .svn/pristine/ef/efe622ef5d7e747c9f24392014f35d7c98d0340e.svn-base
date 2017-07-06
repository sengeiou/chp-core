package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 错误类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum ErrorType {
	FJZLBQ("1"), // 附件资料不全
	FJFGKHZLFJ("2"), // 附件非该客户材料附件
	XYZGCDCHYL("3"), // 协议中勾叉打错或遗漏
	FJBQX("4"), // 附件不清晰
	FJXXTCHYL("5"), // 附件资料信息漏填或错填
	FJMMGSCW("6"), // 附件命名格式错误
	XTKHJBXXCW("7"), // 系统客户基本信息错误
	XTJJLXRXXCW("8"), // 系统紧急联系人基本信息错误
	XTKHJBXXBQ("9"), // 系统客户基本信息不全
	XTCJHHKRQCW("10"), // 系统出借和划扣日期错误
	XTCJFSCW("11"), // 系统出借方式错误
	XTCJJECW("12"), // 系统出借金额错误
	XTHTBHCW("13"), // 系统合同编号错误
	XTXYBBCW("14"), // 系统协议版本错误
	XTFKFSCW("15"), // 系统付款方式错误
	XTKHHCW("16"), // 系统开户行错误
	XTYHKHZZHCW("17"), // 系统银行卡（或存折）帐号错误
	XTYHKSZCSCW("18"), // 系统银行卡所在城市错误
	XTYHKHZHKPTBZC("19"), // 系统银行卡（或存折）平台划扣不支持
	HKPTCW("20"), // 划扣平台错误
	CJSQLRCF("21"), // 出借申请录入重复
	FJYTGYHDG("22");// 附件有涂改液或刀刮

	public final String value;

	private ErrorType(String value) {
		this.value = value;
	}

	public static String getErrorType(String value) {
		return errorTypeMap.get(value);
	}

	public static Map<String, String> errorTypeMap = new Hashtable<String, String>();

	public static void initErrorType() {
		if (errorTypeMap.isEmpty()) {
			errorTypeMap.put(ErrorType.FJZLBQ.value, "附件资料不全");
			errorTypeMap.put(ErrorType.FJFGKHZLFJ.value, "附件非该客户材料附件");
			errorTypeMap.put(ErrorType.XYZGCDCHYL.value, "协议中勾叉打错或遗漏");
			errorTypeMap.put(ErrorType.FJBQX.value, "附件不清晰");
			errorTypeMap.put(ErrorType.FJXXTCHYL.value, "附件资料信息漏填或错填");
			errorTypeMap.put(ErrorType.FJMMGSCW.value, "附件命名格式错误");
			errorTypeMap.put(ErrorType.XTKHJBXXCW.value, "系统客户基本信息错误");
			errorTypeMap.put(ErrorType.XTJJLXRXXCW.value, "系统紧急联系人基本信息错误");
			errorTypeMap.put(ErrorType.XTKHJBXXBQ.value, "系统客户基本信息不全");
			errorTypeMap.put(ErrorType.XTCJHHKRQCW.value, "系统出借和划扣日期错误");
			errorTypeMap.put(ErrorType.XTCJFSCW.value, "系统出借方式错误");
			errorTypeMap.put(ErrorType.XTCJJECW.value, "系统出借金额错误");
			errorTypeMap.put(ErrorType.XTHTBHCW.value, "系统合同编号错误");
			errorTypeMap.put(ErrorType.XTXYBBCW.value, "系统协议版本错误");
			errorTypeMap.put(ErrorType.XTFKFSCW.value, "系统付款方式错误");
			errorTypeMap.put(ErrorType.XTKHHCW.value, "系统开户行错误");
			errorTypeMap.put(ErrorType.XTYHKHZZHCW.value, "系统银行卡（或存折）帐号错误");
			errorTypeMap.put(ErrorType.XTYHKSZCSCW.value, "系统银行卡所在城市错误");
			errorTypeMap.put(ErrorType.XTYHKHZHKPTBZC.value,
					"系统银行卡（或存折）平台划扣不支持");
			errorTypeMap.put(ErrorType.HKPTCW.value, "划扣平台错误");
			errorTypeMap.put(ErrorType.CJSQLRCF.value, "出借申请录入重复");
			errorTypeMap.put(ErrorType.FJYTGYHDG.value, "附件有涂改液或刀刮");
		}
	}
}