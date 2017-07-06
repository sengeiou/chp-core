package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志节点
 * @Class Name LogNode
 * @author 周俊
 * @Create In 2016年5月3日
 */
public enum FortuneLogNode {

	CUSTOMER_LIST("101","我的客户"),
	CUSTOMER_ADD("102","新增客户"),
	LEND_APPLY("201","出借申请"),
	LEND_APPROVE("202","出借申请审批"),
	LEND_APPLY_FINISH("203","出借申请已办"),
	LEND__APPROVE_FINISH("204","出借申请审批已办"),
	LEND_REJECT("205","出借申请退回"),
	LEND_APPLY_LOOK("206","出借申请查看"),
	LEND_APPROVE_LOOK("202","出借申请审批查看"),
	REDEMPTION_APPLY("301","可提前赎回申请"),
	REDEMPTION_APPROVAL("302","可提前赎回审批"),
	REDEMPTION_REAPPLY("303","提前赎回申请失败"),
	REDEMPTION_PUSH("304","特殊提前赎回管理"),
	REDEMPTION_APPLY_FINISH("305","提前赎回已申请"),
	REDEMPTION_APPROVE_FINISH("306","提前赎回已审批"),
	REDEMPTION_APPROVE_LOOK("307","提前赎回审批查看"),
	REDEMPTION_APPLY_LOOK("308","提前赎回申请查看"),
	MONEY_APPLY("401","回款申请"),
	MONEY_APPLYCONFIRM("402","回款申请确认"),
	MONEY_APPROVE("403","回款审批"),
	MONEY_CONFIRM("404","回款确认"),
	MONEY_EXCUTE("405","执行回款"),
	MONEY_HISTORY("406","回款已办"),
	MONEY_SUPPLEMENT("407","回款补息"),
	MONEY_ALLOCATION("408","渠道分配"),
	INTEREST_APPLY("501","回息申请"),
	INTEREST_APPLYCONFRIM("502","回息申请确认"),
	INTEREST_APPROVAL("503","回息审批"),
	INTEREST_CONFRIM("504","回息确认"),
	INTEREST_EXCUTE("505","执行回息"),
	INTEREST_FINISH("506","已回息"),
	//gaoxu 2017-3-24 11:53:52
	RETURN_INTEREST_APPLY("507","到期回息申请"),
	RETURN_INTEREST_APPLYCONFRIM("508","回息申请确认"),
	
	
	LEND_CHANGE_APPLY("601","出借信息变更申请"),
	LEND_CHANGE_APPROVE("602","出借信息变更初审"),
	LEND_CHANGE_REVIEW("603","出借信息变更复审"),
	LEND_CHANGE_FINISH("604","出借信息变更已办"),
	LEND_CHANGE_REJECT("605","出借信息变更被退回"),
	LEND_CHANGE_LOOK("606","出借信息变更查看"),
	LENDER_CHANGE_APPLY("701","出借人信息变更申请"),
	LENDER_CHANGE_APPROVE("702","出借人信息变更初审"),
	LENDER_CHANGE_REVIEW("703","出借人信息变更复审"),
	LENDER_CHANGE_FINISH("704","出借人信息变更已办"),
	LENDER_CHANGE_REJECT("705","出借人信息变更被退回"),
	LENDER_CHANGE_LOOK("706","出借人信息变更查看"),
	CONTRACT_APPLY("801","合同申请"),
	CONTRACT_APPLY_APPROVAL("802","合同申请审核"),
	CONTRACT_DISTRIBUTE("803","合同派发"),
	CONTRACT_APPLY_ALREADY("804","合同申请已办"),
	CONTRACT_CHANGE_APPROVAL("805","合同状态变更审核"),
	CONTRACT_CHANGE_ALREADYL("806","合同状态变更已办"),
	CONTRACT_CHANGE_APPLY("807","合同查询及状态变更查看"),
	CONTRACT_STATISTICS("808","合同统计查看"),
	DEDUCT_APPLY("901","划扣申请"),
	DEDUCT_APPROVE("902","划扣审批"),
	DEDUCT_BALANCE("903","划扣结算"),
	DEDUCT_FAIL("904","划扣失败"),
	DEDUCT_THEDAY("905","多天划扣"),
	DEDUCT_THEDAYFAIL("906","多天划扣已处理"),
	DEDUCT_SUCCESS("907","已划扣"),
	DEDUCT_PLATFORM_RULE("908","划扣限额配置"),
	PLATFORM_GOTO_RULE("909","平台跳转规则配置"),
	REMIND_DAYS("1001","到期提醒"),
	REMIND_BEFORE_30DAYS("1002","前30天封闭期提醒"),
	REMIND_BEFORE_10DAYS("1003","前10天到期提醒"),
	REMIND_CUSTOMER("1004","客户生日提醒"),
	DISTRIBUTE_CONFIG("1005","文件制作人员配置"),
	BORROW_MONTHABLE("1101","月满盈可用债权"),
	BORROW_MONTH("1102","月满盈债权"),
	BORROW("1103","可用债权"),
	BORROW_FREEZE("1104","冻结债权"),
	BORROW_CANCEL("1105","撤销债权"),
	CREDITORPER_UPPER_CONFIG("1201","债权人借款匹配上线配置"),
	CREDIT_LOCATION_CONFIG("1202","可用债权配置"),
	PRODUCT_MATCHING_RATE_CONFIG("1203","产品匹配利率配置"),
	CREDITOR_CONFIG("1204","错期匹配"),
	MATCHING_RULE_CONFIG("1205","匹配规则配置"),
	CREDITOR_SEND("1301","债权发送"),
	MATCHING_CREDITOR("1302","待债权推荐信息"),
	MATCHING_CREDITOR_HISTORY("1303","已推荐债权查看"),
	DISTRIBUTE_RECOMMENDATION("1304","分派待推荐债权"),
	AUTO_MATCHING("1305","债权自动匹配配置"),
	TRIPLE_CUSTOMER_DELIVERY("1401","三网客户交割"),
	TRIPLE_MANAGER_DELIVERY("1402","三网理财经理交割"),
	CUSTOMER_DELIVERY_HISTORY("1403","客户交割历史"),
	ACHIEVEMENT_DELIVERY_HISTORY("1404","业绩交割历史查询"),
	TRIPLE_SEARCH_EXCEL_INFO_ERROR("1405","三网客户交割失败查询"),
	TRUSTEESHIP_ACCOUNT("1501","金账户开户"),
	GOLD_ACCOUNT_DEDUCT("1502","待资金托管结算"),
	GOLD_ACCOUNT_DEDUCT_FALI("1503","资金托管失败"),
	TRUSTEESHIP_CHANGE("1504","金账户信息变更"),
	CUSTOMER_POOL("1601","公共池"),
	Distribute_Customer("1602","电销客户咨询"),
	CALL_CENTER_CUSTOMER("1701","呼叫中心客户列表"),
	CALL_CENTER_LIST_4STORE("1702","分配理财经理列表"),
	CALL_CENTER_LIST_4CITY("1703","分配门店经理列表"),
	CUTOFF("1801","截单");
	
	private static Map<String, FortuneLogNode> nameMap = new HashMap<String, FortuneLogNode>(
			5);
	private static Map<String, FortuneLogNode> codeMap = new HashMap<String, FortuneLogNode>(
			5);

	static {
		FortuneLogNode[] allValues = FortuneLogNode.values();
		for (FortuneLogNode obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private FortuneLogNode(String code, String name) {
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

	public static FortuneLogNode parseByName(String name) {
		return nameMap.get(name);
	}

	public static FortuneLogNode parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
	
	
	
}
