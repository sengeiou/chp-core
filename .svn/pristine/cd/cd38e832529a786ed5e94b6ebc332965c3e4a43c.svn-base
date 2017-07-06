/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.loan.typeIndustry.java
 * @Create By 王彬彬
 * @Create In 2015年12月19日 上午10:05:21
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class Name Industry（行业）
 * @author 王彬彬
 * @Create In 2015年12月19日
 */
public enum Industry {
	IT("0", "IT|通信|电子|互联网"),

	FINANCE("1", "金融业（非P2P）"),

	BUILDING("2", "房地产|建筑业"),

	BUSSINESS("3", "商业服务"),

	TRADE("4", "贸易|批发|零售|租赁业"),

	SPORT("5", "文体教育|工艺美术"),

	PRODUCTION("6", "生产|加工|制造"),

	TRAFFIC("7", "交通|运输|物流|仓储"),

	SERVICE("8", "服务业"),

	RESOURCE("9", "能源|矿产|环保"),

	FARMING("10", "农|林|牧|渔|其他"),

	INDIVIDUAL("11", "个体经营"),

	CULTURE("12", "文化|传媒|娱乐|体育"),

	MARKET("13", "市场/广告/设计/医疗/制药/法律"),

	OTHER_INDUS("14", "其他行业");

	private static Map<String, Industry> nameMap = new HashMap<String, Industry>(
			50);
	private static Map<String, Industry> codeMap = new HashMap<String, Industry>(
			50);

	static {
		Industry[] allValues = Industry.values();
		for (Industry obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private Industry(String code, String name) {
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

	public static Industry parseByName(String name) {
		return nameMap.get(name);
	}

	public static Industry parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
