package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 行业
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum Industry {
	NLMY("1"), // 农、林、牧、渔业
	CKY("2"), // 采矿业
	ZZY("3"), // 制造业
	DLRLMQY("4"), // 电力、热力、燃气及水生产和供应业
	JZY("5"), // 建筑业
	PFLSY("6"), // 批发和零售业
	YTYSCCYZY("7"), // 交通运输、仓储和邮政业
	ZSCYY("8"), // 住宿和餐饮业
	XXCSY("9"), // 信息传输、软件和信息技术服务业
	JRY("10"), // 金融业
	FDCY("11"), // 房地产业
	ZPHSWFWY("12"), // 租赁和商务服务业
	KXYJJSFWY("13"), // 科学研究和技术服务业
	SLHJGGSSGLY("14"), // 水利、环境和公共设施管理业
	JMFWXLFWY("15"), // 居民服务、修理和其他服务业
	JY("16"), // 教育
	WSHSHGZ("17"), // 卫生和社会工作
	WHTYYLY("18"), // 文化、体育和娱乐业
	GGGLY("19"), // 公共管理、社会保障和社会组织
	GJZZ("20");// 国际组织

	public final String value;

	private Industry(String value) {
		this.value = value;
	}

	public static String getIndustry(String value) {
		return industryMap.get(value);
	}

	public static Map<String, String> industryMap = new Hashtable<String, String>();

	public static void initIndustry() {
		if (industryMap.isEmpty()) {
			industryMap.put(Industry.NLMY.value, "农、林、牧、渔业");
			industryMap.put(Industry.CKY.value, "采矿业");
			industryMap.put(Industry.ZZY.value, "制造业");
			industryMap.put(Industry.DLRLMQY.value, "电力、热力、燃气及水生产和供应业");
			industryMap.put(Industry.JZY.value, "建筑业");
			industryMap.put(Industry.PFLSY.value, "批发和零售业");
			industryMap.put(Industry.YTYSCCYZY.value, "交通运输、仓储和邮政业");
			industryMap.put(Industry.ZSCYY.value, "住宿和餐饮业");
			industryMap.put(Industry.XXCSY.value, "信息传输、软件和信息技术服务业");
			industryMap.put(Industry.JRY.value, "金融业");
			industryMap.put(Industry.FDCY.value, "房地产业");
			industryMap.put(Industry.ZPHSWFWY.value, "租赁和商务服务业");
			industryMap.put(Industry.KXYJJSFWY.value, "科学研究和技术服务业");
			industryMap.put(Industry.SLHJGGSSGLY.value, "水利、环境和公共设施管理业");
			industryMap.put(Industry.JMFWXLFWY.value, "居民服务、修理和其他服务业");
			industryMap.put(Industry.JY.value, "教育");
			industryMap.put(Industry.WSHSHGZ.value, "卫生和社会工作");
			industryMap.put(Industry.WHTYYLY.value, "文化、体育和娱乐业");
			industryMap.put(Industry.GGGLY.value, "公共管理、社会保障和社会组织");
			industryMap.put(Industry.GJZZ.value, "国际组织");
		}
	}
}