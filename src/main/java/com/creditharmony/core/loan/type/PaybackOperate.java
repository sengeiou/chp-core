package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 还款操作流水状态
 * @Class Name PaybackOperate
 * @author 王彬彬
 * @Create In 2015年12月28日
 */
public enum PaybackOperate {
	
	APPLY_SUCEED("0","申请成功"),
	
	APPLY_FAILED("1","申请失败"),
	
	DEDECT_SUCCEED("2","划扣成功"),
	
	DEDECT_FAILED("3","划扣失败"),
	
	MATCH_SUCCEED("4","匹配成功"),
	
	MATCH_FAILED("5","匹配失败"),
	
	CHECK_SUCCEED("6","成功"),
	
	CHECK_FAILED("7","退回"),
	
	CONFIRM_SUCCEED("8","确认成功"),
	
	CONFIRM_FAILED("9","确认失败"),
	
	DERATE_SUCCEED("10","减免成功"),
	
	DERATE_FAILED("11","减免成功"),
	
	REBACK("12","退回"),
	
	SEND_SUCCESS("13","发送成功"),
	
	SEND_FAILED("14","发送失败"),

	IMPORT_SUCCESS("15","导入成功"),
	
	CHANGE_SUCCESS("16","修改成功"),
	
	IMPORT_FAILED("17","修改失败"),
	
	RETURN_SUCCESS("18","退回成功"),
	
	RETURN_FAILED("19","退回失败"),
	
	EXPORT_SUCCESS("20","导出成功"),
	
	GIVE_UP_SUCCESS("21","放弃成功"),
	
	GIVE_UP_FAILED("22","放弃失败"),
	
	ONLINE_TRANSFER_SUCCESS("23","划拨成功"),
	
	ONLINE_TRANSFER_FAILED("24","划拨失败"),
	
	GOLD_CHECK_FAILED("25","委托充值失败"),
	
	GOLD_CHECK_SUCCESS("26","委托充值成功");
	
	
	private static Map<String, PaybackOperate> nameMap = new HashMap<String, PaybackOperate>(
			30);
	private static Map<String, PaybackOperate> codeMap = new HashMap<String, PaybackOperate>(
			30);

	static {
		PaybackOperate[] allValues = PaybackOperate.values();
		for (PaybackOperate obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private PaybackOperate(String code, String name) {
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

	public static PaybackOperate parseByName(String name) {
		return nameMap.get(name);
	}

	public static PaybackOperate parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
