package com.creditharmony.core.pay.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name Name ZjDictDealResultType （中金平台响应码）
 * @author 施大勇
 * @Create In 2016年1月11日
 */
public enum ZjDictDealResultType {
	DICT_0000("0000", "成功受理了请求。"),
	DICT_2001("2001", "系统内部错误。"),
	DICT_2002("2002", "验证签名失败。"),
	DICT_2003("2003", "解析报文错误。"),
	DICT_2004("2004", "报文格式错误。"),
	DICT_2005("2005", "不支持的版本。"),
	DICT_2006("2006", "无效交易类型。"),
	DICT_2007("2007", "无此操作的权限。"),
	DICT_2008("2008", "重复交易请求。"),
	DICT_2009("2009", "无效日期。"),
	DICT_2010("2010", "无效日期范围。"),
	DICT_2011("2011", "数据库存取异常。"),
	DICT_2012("2012", "会话不存在。"),
	DICT_2013("2013", "系统不支持GET方法。"),
	DICT_2016("2016", "参数不正确。"),
	DICT_2017("2017", "交易证书过期。"),
	DICT_240001("240001", "请求中不存在message参数或者signature参数。"),
	DICT_240002("240002", "不存在此交易代码，请查看参数TxCode"),
	DICT_240003("240003", "不存此机构，请查看参数InstitutionID"),
	DICT_240004("240004", "不存在此订单，请查看参数OrderNo"),
	DICT_240005("240005", "不存在此支付交易，请查看参数PaymentNo"),
	DICT_240006("240006", "不存在此结算交易，请查看参数SerialNumber"),
	DICT_240007("240007", "订单号长度不正确，请查看参数OrderNo"),
	DICT_240008("240008", "支付交易流水号长度不正确，请查看参数PaymentNo"),
	DICT_240009("240009", "交易流水号长度不正确，请查看参数SerialNumber"),
	DICT_240010("240010", "订单号重复，请查看参数OrderNo"),
	DICT_240011("240011", "支付交易流水号重复，请查看参数PaymentNo"),
	DICT_240012("240012", "交易流水号重复，请查看参数SerialNumber"),
	DICT_240013("240013", "账户类型错误，请查看参数AccountType"),
	DICT_240014("240014", "金额格式不对。"),
	DICT_240015("240015", "结算金额大于可结算金额。"),
	DICT_240016("240016", "备注信息太多。"),
	DICT_240017("240017", "该笔订单没有支付，不能退款。"),
	DICT_240018("240018", "退款（累计）金额大于订单金额。"),
	DICT_240019("240019", "账户名称与账户号码不匹配。"),
	DICT_240020("240020", "不存在此退款交易，请查看参数SerialNumber"),
	DICT_240021("240021", "金额必须大于0"),
	DICT_240022("240022", "银行账户信息不完整。"),
	DICT_240023("240023", "该笔订单已经退款，只能退款一次。"),
	DICT_240024("240024", "（支付平台）账户不存在。"),
	DICT_240025("240025", "无结算对账记录。"),
	DICT_240026("240026", "金额长度太大。"),
	DICT_240027("240027", "日期格式错误"),
	DICT_240028("240028", "保证金退息标志不得为空,并且只能为0或1"),
	DICT_240029("240029", "该笔订单的退款正在处理，请等待后续通知。"),
	DICT_240030("240030", "开始时间大于结束时间"),
	DICT_240031("240031", "监管银行为空，请联系支付平台工作人员配置监管银行。"),
	DICT_240032("240032", "每日15点之后，不可以做保证金退款。"),
	DICT_240033("240033", "交易流水号为空，请查看参数SerialNumber"),
	DICT_250001("250001", "未找到对应批次号的代付"),
	DICT_250002("250002", "未找到对应批次号的代付明细"),
	DICT_250003("250003", "批次号重复"),
	DICT_250008("250008", "批备注过长"),
	DICT_250009("250009", "请查看参数BatchNo"),
	DICT_250015("250015", "总笔数格式不对"),
	DICT_250016("250016", "总笔数必须大于0"),
	DICT_250017("250017", "总笔数不一致"),
	DICT_250018("250018", "总金额不一致"),
	DICT_250020("250020", "批量付款明细记录为空"),
	DICT_250021("250021", "明细号重复"),
	DICT_250022("250022", "第X行明细号为空或长度不正确"),
	DICT_250023("250023", "第X行明细金额为空"),
	DICT_250024("250024", "第X行明细金额格式不对"),
	DICT_250025("250025", "第X行银行ID为空"),
	DICT_250026("250026", "代付不支持该ID银行"),
	DICT_250029("250029", "批量付款明细超过1000笔"),
	DICT_250030("250030", "第X行账户类型为空或值错误"),
	DICT_250031("250031", "第X行账户名称为空或长度不正确"),
	DICT_250032("250032", "第X行账户号码为空或长度不正确"),
	DICT_250033("250033", "第X行分支行为空或长度不正确"),
	DICT_250034("250034", "第X行分支行省份为空或长度不正确"),
	DICT_250035("250035", "第X行分支行城市为空或长度不正确"),
	DICT_250036("250036", "协议用户编号为空或长度不正确"),
	DICT_250037("250037", "协议号为空或长度不正确"),
	DICT_250039("250039", "批量付款明细记录格式不正确"),
	DICT_250050("250050", "未找到对应日期的对账信息"),
	DICT_260001("260001", "银行ID为空,请查看参数BankID"),
	DICT_260002("260002", "账户类型为空或值错误,请查看参数AccountType"),
	DICT_260003("260003", "信用卡有效期不正确,请查看参数ValidDate"),
	DICT_260004("260004", "信用卡校验码不正确,请查看参数CVN2"),
	DICT_260005("260005", "账户名称为空或长度不正确,请查看参数AccountName"),
	DICT_260006("260006", "账户号码为空或长度不正确,请查看参数AccountNumber"),
	DICT_260007("260007", "分支行长度不正确,请查看参数BranchName"),
	DICT_260008("260008", "分支行省份长度不正确,请查看参数Province"),
	DICT_260009("260009", "分支行城市长度不正确,请查看参数City"),
	DICT_260010("260010", "开户证件类型长度不正确,请查看参数IdentificationType"),
	DICT_260011("260011", "证件号码长度不正确,请查看参数IdentificationNumber"),
	DICT_260012("260012", "备注长度不正确,请查看参数Note"),
	DICT_260013("260013", "协议用户编号长度不正确,请查看参数ContractUserID"),
	DICT_260014("260014", "手机号长度不正确,请查看参数PhoneNumber"),
	DICT_260015("260015", "电子邮箱长度不正确,请查看参数Email"),
	DICT_260016("260016", "结算标识为空或长度不正确,请查看参数SettlementFlag"),
	DICT_270001("270001", "支付交易流水号长度不正确，请查看参数PaymentNo"),
	DICT_270002("270002", "支付交易流水号包含特殊字符，请查看参数PaymentNo"),
	DICT_270003("270003", "金额长度错误。最大值：999999999999999999"),
	DICT_270004("270004", "金额格式不对"),
	DICT_270005("270005", "金额必须大于0"),
	DICT_270006("270006", "手续费金额长度错误。最大值：999999999"),
	DICT_270007("270007", "手续费格式不对"),
	DICT_270008("270008", "手续费必须大于等于零"),
	DICT_270009("270009", "付款人注册ID太长，请查看参数PayerID"),
	DICT_270010("270010", "付款人注册ID包含特殊字符，请查看参数PayerID"),
	DICT_270011("270011", "付款方名称太长，请查看参数PayerName"),
	DICT_270012("270012", "付款方名称包含特殊字符，请查看参数PayerName"),
	DICT_270013("270013", "代付客户ID长度不正确，请查看参数CustomerID"),
	DICT_270014("270014", "代付客户ID格式不对，请查看参数CustomerID"),
	DICT_270015("270015", "代付客户交易授权码太长，请查看参数CustomerTxCode"),
	DICT_270016("270016", "代付客户交易授权码包含特殊字符，请查看参数CustomerTxCode"),
	DICT_270017("270017", "资金用途信息太多"),
	DICT_270018("270018", "资金用途信息包含特殊字符，请查看参数Usage"),
	DICT_270019("270019", "备注信息太多"),
	DICT_270020("270020", "备注信息包含特殊字符，请查看参数Remark"),
	DICT_270021("270021", "结算标识信息长度不正确，请查看参数SettlementFlag"),
	DICT_270022("270022", "结算标识信息包含特殊字符，请查看参数SettlementFlag"),
	DICT_270023("270023", "付款人金科信安平台账号不正确或授权码输入不正确"),
	DICT_270024("270024", "支付交易流水号重复，请查看参数PaymentNo"),
	DICT_270025("270025", "支付交易流水号长度不正确，请查看参数PaymentNo"),
	DICT_270026("270026", "支付交易流水号包含特殊字符，请查看参数PaymentNo"),
	DICT_270027("270027", "不存在此支付交易，请查看参数PaymentNo"),
	DICT_270028("270028", "退款交易流水号长度不正确，请查看参数TxSN"),
	DICT_270029("270029", "退款交易流水号包含特殊字符，请查看参数TxSN"),
	DICT_270030("270030", "原支付交易流水号长度不正确，请查看参数PaymentNo"),
	DICT_270031("270031", "原支付交易流水号包含特殊字符，请查看参数PaymentNo"),
	DICT_270032("270032", "金额长度错误。最大值：999999999999999999"),
	DICT_270033("270033", "金额格式不对"),
	DICT_270034("270034", "金额必须大于0"),
	DICT_270035("270035", "备注信息太多"),
	DICT_270036("270036", "备注信息包含特殊字符，请查看参数Remark"),
	DICT_270037("270037", "银行代码长度不正确，请查看参数BankID"),
	DICT_270038("270038", "银行代码包含特殊字符，请查看参数BankID"),
	DICT_270039("270039", "账户名称长度不正确，请查看参数AccountName"),
	DICT_270040("270040", "账户名称包含特殊字符，请查看参数AccountName"),
	DICT_270041("270041", "账户号码长度不正确，请查看参数AccountNumber"),
	DICT_270042("270042", "账户号码包含特殊字符，请查看参数AccountNumber"),
	DICT_270043("270043", "省份信息长度不正确，请查看参数Province"),
	DICT_270044("270044", "省份信息包含特殊字符，请查看参数Province"),
	DICT_270045("270045", "城市信息长度不正确，请查看参数City"),
	DICT_270046("270046", "城市信息包含特殊字符，请查看参数City"),
	DICT_270047("270047", "分支行名称长度不正确，请查看参数BranchName"),
	DICT_270048("270048", "分支行名称包含特殊字符，请查看参数BranchName"),
	DICT_270049("270049", "账户类型错误，请查看参数AccountType"),
	DICT_270050("270050", "付款人金科信安平台账号已冻结，请恢复后再下单"),
	DICT_270051("270051", "不存在此支付交易，请查看参数PaymentNo"),
	DICT_270052("270052", "该笔订单没有支付，不能退款"),
	DICT_270053("270053", "退款金额大于支付金额"),
	DICT_270054("270054", "退款交易流水号重复，请查看参数TxSN"),
	DICT_270055("270055", "该笔订单已经存在退款交易，只能退款一次"),
	DICT_270056("270056", "退款交易流水号长度不正确，请查看参数TxSN"),
	DICT_270057("270057", "退款交易流水号包含特殊字符，请查看参数TxSN"),
	DICT_270058("270058", "不存在此退款交易，请查看参数TxSN");
	
	private static Map<String, ZjDictDealResultType> nameMap = 
			new HashMap<String, ZjDictDealResultType>();
	private static Map<String, ZjDictDealResultType> codeMap = 
			new HashMap<String, ZjDictDealResultType>();
	static {
		ZjDictDealResultType[] allValues = ZjDictDealResultType.values();
		for (ZjDictDealResultType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ZjDictDealResultType(String code, String name) {
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

	public static ZjDictDealResultType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ZjDictDealResultType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
