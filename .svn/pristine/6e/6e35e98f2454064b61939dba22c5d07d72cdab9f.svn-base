/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeCardType.java
 * @Create By 王彬彬
 * @Create In 2016年1月12日 下午6:12:53
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 合同类型
 * 
 * @Class Name ContractType
 * @author 王彬彬
 * @Create In 2016年1月12日
 */
public enum ContractType {
	CONTRACT_PROTOCOL_ASSURER("0", "借款协议（带保证人）", YESNO.NO.getCode()),

	CONTRACT_PROTOCOL("11", "借款协议", YESNO.NO.getCode()),

	CONTRACT_MANAGE("12", "信用咨询及管理服务协议（借款人）", YESNO.NO.getCode()),

	CONTRACT_RETURN_MANAGE("13", "还款管理服务说明确认书", YESNO.NO.getCode()),

	CONTRACT_DELEGATE("14", "委托扣款授权书", YESNO.YES.getCode()),

	CONTRACT_CA("15", "CA免责声明", YESNO.YES.getCode()),

	CONTRACT_CA_ASSURER("16", "CA免责声明（保证人）", YESNO.YES.getCode()),
	
	CONTRACT_CA_NOTE_ASSURER("17", "特别说明（保证人）", YESNO.YES.getCode()),
	
	CONTRACT_CA_NOTE("18", "特别说明", YESNO.YES.getCode()),
	
	CONTRACT_MANAGE_JX("1", "信用咨询及管理服务协议-金信", YESNO.YES.getCode()),

	CONTRACT_DELEGATE_JX("3", "委托扣款授权书-金信", YESNO.YES.getCode()),

	CONTRACT_CA_JX("4", "CA免责声明-金信", YESNO.YES.getCode()),

	CONTRACT_CA_ASSURER_JX("4", "CA免责声明-金信（保证人）", YESNO.YES.getCode()),
	
	CONTRACT_TG("113", "富友-信和财富专用账户服务协议", YESNO.NO.getCode()),
	
	CONTRACT_XX_MZSM("122", "免责声明", YESNO.YES.getCode()),

	CONTRACT_XX_DELEGATE("121", "委托扣款授权书", YESNO.YES.getCode()),
	
	CONTRACT_XX_MANAGE("114", "信用咨询及管理服务协议", YESNO.NO.getCode()),
	
	CONTRACT_ZCJ_PROTOCOL("120","借款协议",YESNO.NO.getCode()),
	
	CONTRACT_ZCJ_RETURN_MANAGE("115","还款管理服务说明确认书",YESNO.NO.getCode()),
	
	CONTRACT_ZCJ_RETURN_MANAGE_1("115","还款管理服务说明确认书-1",YESNO.NO.getCode()),
	
	CONTRACT_ZCJ_NOTE("123","特别说明",YESNO.YES.getCode()),
	
	CONTRACT_ZCJ_GUARANTEE("116","最高额担保函",YESNO.YES.getCode()),	
	
	CONTRACT_ZCJ_RETURN_MANAGE_2("124","还款管理服务说明确认书-2",YESNO.NO.getCode()),
	
    CONTRACT_PROTOCOL2_ASSURER("0", "借款协议（保证人）", YESNO.NO.getCode()),
	
	CONTRACT_MANAGE2_ASSURER("12", "信用咨询及管理服务协议(保证人)", YESNO.NO.getCode()),
	
	CONTRACT_RETURN_MANAGE2_ASSURER("13", "还款管理服务说明确认书(保证人)", YESNO.NO.getCode()),

	CONTRACT_DELEGATE2_ASSURER("14", "委托扣款授权书(保证人)", YESNO.YES.getCode()),
	
	CONTRACT_MZSM_ASSURER("15", "免责声明(保证人)", YESNO.YES.getCode()),

	CONTRACT_MZSM_JX2_ASSURER("4", "免责声明（保证人）-金信", YESNO.YES.getCode()),
	
	CONTRACT_DELEGATE_JX2_ASSURER("3", "委托扣款授权书(保证人)-金信", YESNO.YES.getCode()),
	
	CONTRACT_MANAGE_JX2_ASSURER("1", "信用咨询及管理服务协议(保证人)-金信", YESNO.YES.getCode()),
	
	CONTRACT_JX2_RETURN_MANAGE("2","还款管理服务说明确认书（保证人）-金信",YESNO.YES.getCode()),
	
	CONTRACT_RETURN_MANAGE_JX("2","还款管理服务说明确认书-金信",YESNO.YES.getCode()),
	
	CONTRACT_JKXY_MANAGE("113", "借款协议", YESNO.NO.getCode()),
	
	CONTRACT_JKXY_JX_MANAGE("0", "借款协议-金信", YESNO.NO.getCode()),
	
	CONTRACT_JKXY_JX_BZ_MANAGE("0", "借款协议(保证人)-金信", YESNO.NO.getCode()),
	
	//买金网
	CONTRACT_MJW_JX_XYZXJGLFWXY("1", "信用咨询及管理服务协议-金信", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_HKGLFWSMQRS_1("3", "还款管理服务说明确认书-金信-1", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_WTKKSQS("5", "委托扣款授权书-金信", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_MZSM("6", "免责声明-金信", YESNO.YES.getCode()),
	CONTRACT_MJW_WTKKSQS("7", "委托扣款授权书", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_TBSM("8", "特别说明", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_HKGLFWSMQRS_2("9", "还款管理服务说明确认书-金信-2", YESNO.YES.getCode()),
	
	CONTRACT_MJW_JX_XYZXJGLFWXY_BZR("1", "信用咨询及管理服务协议(保证人)-金信", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_HKGLFWSMQRS_BZR_1("3", "还款管理服务说明确认书(保证人)-金信-1", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_WTKKSQS_BZR("5", "委托扣款授权书(保证人)-金信", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_MZSM_BZR("6", "免责声明(保证人)-金信", YESNO.YES.getCode()),
	CONTRACT_MJW_WTKKSQS_BZR("7", "委托扣款授权书(保证人)", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_TBSM_BZR("8", "特别说明(保证人)", YESNO.YES.getCode()),
	CONTRACT_MJW_JX_HKGLFWSMQRS_BZR_2("9", "还款管理服务说明确认书(保证人)-金信-2", YESNO.YES.getCode());
	
	
	private static Map<String, ContractType> nameMap = new HashMap<String, ContractType>(
			20);
	private static Map<String, ContractType> codeMap = new HashMap<String, ContractType>(
			20);
	private static Map<String, ContractType> flagMap = new HashMap<String, ContractType>(
			20);

	static {
		ContractType[] allValues = ContractType.values();
		for (ContractType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
			flagMap.put(obj.getFlag(), obj);
		}
	}

	private String name;
	private String code;
	private String flag;

	private ContractType(String code, String name, String flag) {
		this.name = name;
		this.code = code;
		this.flag = flag;

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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public static ContractType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ContractType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
