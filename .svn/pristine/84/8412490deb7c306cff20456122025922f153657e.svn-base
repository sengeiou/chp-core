package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 还款流水操作状态
 * @Class Name RepaymentProcess
 * @author 王彬彬
 * @Create In 2015年12月21日
 */
public enum RepaymentProcess {
	
	REPAYMENT_APPLY("0", "申请还款"),

	DEDECT("1", "划扣"),

	VERIFY("2", "审核"),

	CONFIRM("3", "结清确认"),

	OVERDUE_CUT("4", "逾期减免"),

	SEND_ZHONGJIN("5", "发送中金"),

	SEND_HYL("6", "发送好易联"),

	SEND_FUYOU("7", "发送富友"),

	RETRIVE("8", "追回"),

	SEND_DEDUCT("9", "提交划扣"),
	
	EARLY_SETTLED("10","提前结清确认"),
	
	KEY_SEND("11","一键发送"),
	
	SEND_TONGLIAN("12","发送通联"),
	
	SEND_CHECK("13","提交查账"),
	
	MATCHING("14","匹配"),
	
	DATA_IMPORT("15","导入数据"),
	
	CHANGE_CHECK_STATUS("16","修改查账状态"),
	
	RETURN("17","退回"),

	LINE_EXPORT("18","线下导出"),
	
	GIVE_UP("19","客户放弃"),
	
	BANK_ORDER("20","预约银行一键发送"),
	
	ONLINE_TRANSFER("21","线上划拨"),
	
	LINE__TRANSFER("22","线下划拨"),
	
	LAST__SEND("23","最后发送"),
	
	SEND_KALIAN("24","发送卡联"),
	SEND_CHANGJIE("25","发送畅捷"),
	GOlDACCOUNT_ORDER("26","金账户委托充值预约"),
	GOlDACCOUNT_DEDUCT("27","金账户划拨预约"),
	AUTOMATIC_DEDUCT("28","非集中自动划扣");
	
	private static Map<String, RepaymentProcess> nameMap = new HashMap<String, RepaymentProcess>(
			30);
	private static Map<String, RepaymentProcess> codeMap = new HashMap<String, RepaymentProcess>(
			30);

	static {
		RepaymentProcess[] allValues = RepaymentProcess.values();
		for (RepaymentProcess obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RepaymentProcess(String code, String name) {
		this.name = name;
		this.code = code;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static RepaymentProcess parseByName(String name) {
		return nameMap.get(name);
	}

	public static RepaymentProcess parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
