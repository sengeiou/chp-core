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
 * 车借展期合同类型
 * 
 * @Class Name ContractType
 * @author 葛志超
 * @Create In 2016年5月12日
 */
public enum CarExtendType {
	CAREXTENDTYPE_PROTOCOL_GPS_YJ("0", "车借展期协议", YESNO.NO.getCode()),
	
	CAREXTENDTYPE_MANAGE_GPS_YJ("1", "还款管理服务说明书", YESNO.NO.getCode()),

	CAREXTENDTYPE_RETURN_MANAGE_GPS_YJ("2", "委托扣款授权书", YESNO.YES.getCode()),
	
	CAREXTENDTYPE_RETURN_MFSM_GPS_YJ("3", "免责声明", YESNO.YES.getCode()),
	
	CAREXTENDTYPE_PROTOCOL_ZY("3", "车借展期协议", YESNO.NO.getCode()),
	
	CAREXTENDTYPE_MANAGE_ZY("4", "还款管理服务说明书", YESNO.NO.getCode()),

	CAREXTENDTYPE_RETURN_MANAGE_ZY("5", "委托扣款授权书", YESNO.YES.getCode()),
	
	CAREXTENDTYPE_TBSM("6", "特别说明", YESNO.YES.getCode());
	

	private static Map<String, CarExtendType> nameMap = new HashMap<String, CarExtendType>(
			10);
	private static Map<String, CarExtendType> codeMap = new HashMap<String, CarExtendType>(
			10);
	private static Map<String, CarExtendType> flagMap = new HashMap<String, CarExtendType>(
			10);

	static {
		CarExtendType[] allValues = CarExtendType.values();
		for (CarExtendType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
			flagMap.put(obj.getFlag(), obj);
		}
	}

	private String name;
	private String code;
	private String flag;

	private CarExtendType(String code, String name, String flag) {
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

	public static CarExtendType parseByName(String name) {
		return nameMap.get(name);
	}

	public static CarExtendType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
