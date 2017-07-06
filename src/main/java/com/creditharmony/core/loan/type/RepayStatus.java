/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeRepayStatus.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:45:44
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name RepayStatus 还款标识(状态)
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum RepayStatus {
	PEND_REPAYMENT("0","还款中"),
	
	OVERDUE("1","逾期"),
	
	SETTLE("2","结清"),
	
	PRE_SETTLE("3","提前结清"),
	
	PRE_SETTLE_VERIFY("4","提前结清待审核"),//借款人服务部用
	
	SETTLE_CONFIRM("5","结清待确认"),
	
	PRE_SETTLE_CONFIRM("6","提前结清待确认"),//风控用
	
	NORMAL_PAYMENT("7","已还款"),
	
	
	SETTLE_FAILED("10","结清失败"),
	
	PAYBACK_RETURN("11","还款退回");


	private static Map<String, RepayStatus> nameMap = new HashMap<String, RepayStatus>(
			20);
	private static Map<String, RepayStatus> codeMap = new HashMap<String, RepayStatus>(
			20);

	static {
		RepayStatus[] allValues = RepayStatus.values();
		for (RepayStatus obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private RepayStatus(String code, String name) {
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

	public static RepayStatus parseByName(String name) {
		return nameMap.get(name);
	}

	public static RepayStatus parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
