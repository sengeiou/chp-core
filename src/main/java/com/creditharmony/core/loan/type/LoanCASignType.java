package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/***
 * 签名类型
 * 
 * @Class Name CASignType
 * @author wbb
 * @Create In 2016年4月21日
 */
public enum LoanCASignType {
	PERSONAL("0", "个人签名"), // 公司签名（夏总）
	
	COMPANY_HM("1", "惠民签章"), // 公司签名（惠民）
	
	COMPANY_HJ("2", "惠金签章"), // 公司签名（汇金）
	
	COMPANY_HC("3", "汇诚签章"), // 公司签名（汇诚）
	
	COMPANY_CF("4", "财富签章"), // 公司签名（财富）
	
	CUSTOMER("5", "客户代理签名"),// 客户代理签名
	
	PER_COM("6", "个人签名+客户代理签名"),// 个人签名+代理签名
	
	PER_COM_APPROVE("7", "个人签名+客户代理签名+保证人"),// 个人签名+代理签名 +保证人
	
	ALL_SIGN("8", "全部签名"),// 全部签名(甲：个人，乙:汇金，丙:汇诚，丁:惠民，戊:财富)
	
	CANCEL_SIGN("9", "作废"),// 作废
	
	TG_SIGN("10", "富有协议签名"),// 客户代理签名

	ALL_SIGN_APPROVE("11", "全部签名+保证人"),// 全部签名(甲：个人，乙:汇金，丙:汇诚，丁:惠民，戊:财富，己:己方保证人)
	
	PER_COM_ALL_SIGN_APPROVE("12", "全部签名+个人签名+客户代理签名");// 全部签名(个人签名+代理签名 甲：个人，乙:汇金，丙:汇诚，丁:惠民，戊:财富，己:己方保证人)
	
	private static Map<String, LoanCASignType> nameMap = new HashMap<String, LoanCASignType>(
			20);
	private static Map<String, LoanCASignType> codeMap = new HashMap<String, LoanCASignType>(
			20);

	static {
		LoanCASignType[] allValues = LoanCASignType.values();
		for (LoanCASignType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private LoanCASignType(String code, String name) {
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

	public static LoanCASignType parseByName(String name) {
		return nameMap.get(name);
	}

	public static LoanCASignType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}