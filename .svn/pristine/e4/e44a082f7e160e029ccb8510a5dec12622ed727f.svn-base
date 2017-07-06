package com.creditharmony.core.pay.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name Name DictDealTypeResultType （富友平台响应码）
 * @author 施大勇
 * @Create In 2016年1月11日
 */
public enum FyDictDealResultType {
	DICT_0000("0000", "操作成功（扣款或付款成功）"),
	DICT_100011("100011", "姓名错误"),
	DICT_100012("100012", "证件错误"),
	DICT_100013("100013", "无效卡号（无此号）"),
	DICT_100014("100014", "协议号不存在 "),
	DICT_100016("100016", "超出取款/转账金额限制 "),
	DICT_100017("100017", "资金不足 "),
	DICT_200001("200001", "接收的响应已过时"),
	DICT_999999("999999", "超时"),
	DICT_1001("1001", "查交易接收方"),
	DICT_1002("1002", "查交易接收方的特殊条件"),
	DICT_1003("1003", "无效商户"),
	DICT_1004("1004", "没收卡 "),
	DICT_1005("1005", "不予承兑"),
	DICT_1006("1006", "出错 "),
	DICT_1007("1007", "特定条件下没收卡 "),
	DICT_1009("1009", "请求正在处理中"),
	DICT_1012("1012", "无效交易"),
	DICT_1013("1013", "无效金额"),
	DICT_1014("1014", "无效卡号（无此号）"),
	DICT_1015("1015", "无此交易接收方 "),
	DICT_1017("1017", "客户取消 "),
	DICT_1019("1019", "重新送入交易 "),
	DICT_1020("1020", "无效响应  "),
	DICT_1021("1021", "不能采取行动"),
	DICT_1022("1022", "故障怀疑 "),
	DICT_1023("1023", "不可接受的交易费"),
	DICT_1025("1025", "找不到原始交易 "),
	DICT_1030("1030", "格式错误"),
	DICT_1031("1031", "交换中心不支持的银行"),
	DICT_1033("1033", "过期的卡"),
	DICT_1034("1034", "作弊嫌疑"),
	DICT_1035("1035", "受卡方与代理方联系"),
	DICT_1036("1036", "受限制的卡"),
	DICT_1037("1037", "受卡方电话通知代理方安全部门 "),
	DICT_1038("1038", "超过允许的PIN试输入"),
	DICT_1039("1039", "无贷记账户"),
	DICT_1040("1040", "请求的功能尚不支持 "),
	DICT_1041("1041", "挂失卡 "),
	DICT_1042("1042", "无此账户"),
	DICT_1043("1043", "被窃卡 "),
	DICT_1044("1044", "无此投资账户"),
	DICT_1051("1051", "资金不足 "),
	DICT_1052("1052", "无此支票账户"),
	DICT_1053("1053", "无此储蓄卡账户"),
	DICT_1054 ("1054 ", "过期的卡"),
	DICT_1055("1055", "不正确的PIN"),
	DICT_1056("1056", "无此卡记录 "),
	DICT_1057("1057", "不允许持卡人进行的交易 "),
	DICT_1058("1058", "不允许终端进行的交易 "),
	DICT_1059("1059", "有作弊嫌疑"),
	DICT_1060("1060", "受卡方与代理方联系"),
	DICT_1061("1061", "超出取款/转账金额限制 "),
	DICT_1062("1062", "受限制的卡"),
	DICT_1063("1063", "侵犯安全"),
	DICT_1064("1064", "原始金额错误 "),
	DICT_1065("1065", "超出取款次数限制"),
	DICT_1066("1066", "受卡方通知受理方安全部门 "),
	DICT_1067("1067", "强行受理（要求在自动会员机上没收此卡）"),
	DICT_1068("1068", "接收的响应已过时 "),
	DICT_1075("1075", "允许的输入PIN次数超限"),
	DICT_1076("1076 ", "无效账户"),
	DICT_1090("1090", "正在日终处理（系统终止一天的活动，开始第二天的活动，交易在几分钟后可再次发送"),
	DICT_1091("1091", "交易接收方或交换中心不能操作"),
	DICT_1092("1092", "金融机构或中间网络设施找不到或无法达到、金融机构签退"),
	DICT_1093("1093", "交易违法、不能完成 "),
	DICT_1094("1094", "重复交易 "),
	DICT_1095("1095", "核对差错 "),
	DICT_1096("1096", "系统异常、失效"),
	DICT_1098("1098", "交换中心收不到交易接收方应答"),
	DICT_1099("1099", "PIN格式错 "),
	DICT_10A0("10A0", "MAC鉴别失败 ");
	private static Map<String, FyDictDealResultType> nameMap = 
			new HashMap<String, FyDictDealResultType>();
	private static Map<String, FyDictDealResultType> codeMap = 
			new HashMap<String, FyDictDealResultType>();
	static {
		FyDictDealResultType[] allValues = FyDictDealResultType.values();
		for (FyDictDealResultType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FyDictDealResultType(String code, String name) {
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

	public static FyDictDealResultType parseByName(String name) {
		return nameMap.get(name);
	}

	public static FyDictDealResultType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
