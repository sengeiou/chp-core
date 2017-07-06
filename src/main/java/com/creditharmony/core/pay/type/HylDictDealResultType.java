package com.creditharmony.core.pay.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name Name HylDictDealResultType （好易联平台响应码）
 * @author 施大勇
 * @Create In 2016年1月11日
 */
public enum HylDictDealResultType {
	DICT_0000("0000", "处理成功"),
	DICT_397("397", "渠道不支持，交易无法进行"),
	DICT_3001("3001", "查开户方原因"),
	DICT_3002("3002", "没收卡"),
	DICT_3003("3003", "不予承兑"),
	DICT_3004("3004", "无效卡号"),
	DICT_3005("3005", "受卡方与安全保密部门联系"),
	DICT_3006("3006", "已挂失卡"),
	DICT_3007("3007", "被窃卡"),
	DICT_3008("3008", "余额不足"),
	DICT_3009("3009", "无此账户"),
	DICT_3010("3010", "过期卡"),
	DICT_3011("3011", "密码错"),
	DICT_3012("3012", "不允许持卡人进行的交易"),
	DICT_3013("3013", "超出提款限额"),
	DICT_3014("3014", "原始金额不正确"),
	DICT_3015("3015", "超出取款次数限制"),
	DICT_3016("3016", "已挂失折"),
	DICT_3017("3017", "账户已冻结"),
	DICT_3018("3018", "已清户"),
	DICT_3019("3019", "原交易已被取消或冲正"),
	DICT_3020("3020", "账户被临时锁定"),
	DICT_3021("3021", "未登折行数超限"),
	DICT_3022("3022", "存折号码有误"),
	DICT_3023("3023", "当日存入的金额当日不能支取"),
	DICT_3024("3024", "日期切换正在处理"),
	DICT_3025("3025", "PIN格式出错"),
	DICT_3026("3026", "发卡方保密子系统失败"),
	DICT_3027("3027", "原始交易不成功"),
	DICT_3028("3028", "系统忙，请稍后再提交"),
	DICT_3029("3029", "交易已被冲正"),
	DICT_3030("3030", "账号错误"),
	DICT_3031("3031", "账号户名不符"),
	DICT_3032("3032", "账号货币不符"),
	DICT_3033("3033", "无此原交易"),
	DICT_3034("3034", "非活期账号"),
	DICT_3035("3035", "找不到原记录"),
	DICT_3036("3036", "货币错误"),
	DICT_3037("3037", "磁卡未生效"),
	DICT_3038("3038", "非通兑户"),
	DICT_3039("3039", "账户已关户"),
	DICT_3040("3040", "金额错误"),
	DICT_3041("3041", "非存折户"),
	DICT_3042("3042", "交易金额小于该储种的最低支取金额"),
	DICT_3043("3043", "未与银行签约"),
	DICT_3044("3044", "超时拒付"),
	DICT_3045("3045", "合同（协议）号在协议库里不存在"),
	DICT_3046("3046", "合同（协议）号还没有生效"),
	DICT_3047("3047", "合同（协议）号已撤销"),
	DICT_3048("3048", "业务已经清算，不能撤销"),
	DICT_3049("3049", "业务已被拒绝，不能撤销"),
	DICT_3050("3050", "业务已撤销"),
	DICT_3051("3051", "重复业务"),
	DICT_3052("3052", "找不到原业务"),
	DICT_3053("3053", "批量回执包未到规定最短回执期限（M日）"),
	DICT_3054("3054", "批量回执包超过规定最长回执期限（N日）"),
	DICT_3055("3055", "当日通兑业务累计金额超过规定金额"),
	DICT_3056("3056", "退票"),
	DICT_3057("3057", "账户状态错误"),
	DICT_3058("3058", "数字签名或证书错"),
	DICT_3097("3097", "系统不能对该账号进行处理"),
	DICT_3999("3999", "其它错误（含义见中文）");
	private static Map<String, HylDictDealResultType> nameMap = 
			new HashMap<String, HylDictDealResultType>();
	private static Map<String, HylDictDealResultType> codeMap = 
			new HashMap<String, HylDictDealResultType>();
	static {
		HylDictDealResultType[] allValues = HylDictDealResultType.values();
		for (HylDictDealResultType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private HylDictDealResultType(String code, String name) {
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

	public static HylDictDealResultType parseByName(String name) {
		return nameMap.get(name);
	}

	public static HylDictDealResultType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
