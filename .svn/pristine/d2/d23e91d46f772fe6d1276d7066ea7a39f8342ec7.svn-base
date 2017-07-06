/**
 * @Probject Name: chp-loan
 * @Path: com.creditharmony.loan.common.utilsLoanStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月17日 下午2:31:17
 */
package com.creditharmony.core.approve.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Class Name TelRecSrc(电话录音来源)
 * @author 李静辉
 * @Create In 2015年12月23日
 */
public enum TelRecSrc {OUTSIDE_NETWORK_INSPECTION_UNIT("01","外网核查单位表"),
	PHONE_INSPECTION_UNIT("02","电话核查单位表"),
	PHONE_RELATIONSHIP_INSPECTION("03","电话关系核查表"),
	PERSONAL_INSPECTION("04","本人核实表"),
	FRAUD_PERSONAL_INSPECTION("05","反欺诈-本人核实表"),
	PERSONAL_INSPECTION_NEW_PHONE("06","本人核实新增号码"),
	PURCHASE_SALE_CONTRACT_NUMBER("07","购销合同号码")
	;


	private static Map<String, TelRecSrc> nameMap = new HashMap<String, TelRecSrc>(
			100);
	private static Map<String, TelRecSrc> codeMap = new HashMap<String, TelRecSrc>(
			100);

	static {
		TelRecSrc[] allValues = TelRecSrc.values();
		for (TelRecSrc obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TelRecSrc(String code, String name) {
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

	public static TelRecSrc parseByName(String name) {
		return nameMap.get(name);
	}

	public static TelRecSrc parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
