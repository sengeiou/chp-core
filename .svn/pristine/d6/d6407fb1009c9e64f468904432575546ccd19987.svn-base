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
 * 车借合同类型
 * 
 * @Class Name ContractType
 * @author 葛志超
 * @Create In 2016年5月12日
 */
public enum CarContractType {
	CARCONTRACT_PROTOCOL_GPS_YJ("0", "借款协议", YESNO.NO.getCode()),
	
	CAECONTRACT_MANAGE_GPS_YJ("1", "信用咨询及管理服务协议", YESNO.NO.getCode()),

	CARCONTRACT_RETURN_MANAGE_GPS_YJ("2", "还款管理服务说明书", YESNO.NO.getCode()),
	
	CARCONTRACT_DELEGATE_GPS_YJ("3", "委托扣款授权书", YESNO.YES.getCode()),
	
	CARCONTRACT_RECEIPT_GPS_YJ("4", "借款收条", YESNO.YES.getCode()),
	
	CARCONTRACT_TRANSACTION_GPS_YJ("5", "车辆交易授权委托书", YESNO.YES.getCode()),
	
	CARCONTRACT_BILL_GPS_YJ("6", "抵押物清单", YESNO.YES.getCode()),
	
	CARCONTRACT_PROTOCOL_ZY("7", "借款协议", YESNO.NO.getCode()),
	
	CAECONTRACT_MANAGE_ZY("8", "信用咨询及管理服务协议", YESNO.NO.getCode()),

	CARCONTRACT_RETURN_MANAGE_ZY("9", "还款管理服务说明书", YESNO.NO.getCode()),
	
	CARCONTRACT_DELEGATE_ZY("10", "委托扣款授权书", YESNO.YES.getCode()),
	
	CARCONTRACT_RECEIPT_ZY("11", "借款收条", YESNO.YES.getCode()),
	
	CARCONTRACT_TRANSACTION_ZY("12", "车辆交易授权委托书", YESNO.YES.getCode()),
	
	CARCONTRACT_BILL_ZY("13", "二手车买卖协议", YESNO.YES.getCode()),
	
	CARCONTRACT_CAR_ZY("14", "汽车质押合同", YESNO.NO.getCode()),

	CONTRACT_BILL_ZY("15", "质押物清单", YESNO.YES.getCode()),
	
	CARCONTRACT_MFSM("16", "免责声明", YESNO.YES.getCode()),
	
	CARCONTRACT_TBSM("17", "特别说明", YESNO.YES.getCode());

	private static Map<String, CarContractType> nameMap = new HashMap<String, CarContractType>(
			20);
	private static Map<String, CarContractType> codeMap = new HashMap<String, CarContractType>(
			20);
	private static Map<String, CarContractType> flagMap = new HashMap<String, CarContractType>(
			20);

	static {
		CarContractType[] allValues = CarContractType.values();
		for (CarContractType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
			flagMap.put(obj.getFlag(), obj);
		}
	}

	private String name;
	private String code;
	private String flag;

	private CarContractType(String code, String name, String flag) {
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

	public static CarContractType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarContractType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
