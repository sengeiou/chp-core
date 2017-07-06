package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 产品Code
 * @Class Name ProductCode
 * @author 陈广鹏
 * @Create In 2016年1月28日
 */
public enum ProductCode {

	YYY("80", "月邮赢"), 
	YMY("86", "月满盈"),
	JDY("83", "季度盈"),
	NNY("85", "年年盈"),
	SJY("84", "双季盈"),
	YXT("82", "月息通"),
	XHT("81", "信和通"),
	XHB("87", "信和宝"),
	NNJ("88", "年年金"),
	JXY("89", "金信盈"),
	JXB("90", "金信宝"),
	XHBA("91", "信和宝A"),
	XHBB("92", "信和宝B"),
	XHBC("93", "信和宝C"),
	XHYZ("66", "信和月增"),
	XHNJ("67", "信和年聚");

	public final String value;
	public final String name;

	private ProductCode(String value, String name) {
		this.value = value;
		this.name = name;
	}
	
	private static Map<String, ProductCode> valueMap = new HashMap<String, ProductCode>(14);
	private static Map<String, ProductCode> nameMap = new HashMap<String, ProductCode>(14);
	
	static{
		ProductCode[] values = ProductCode.values();
		for (ProductCode code : values) {
			valueMap.put(code.getValue(), code);
			nameMap.put(code.getName(), code);
		}
	}
	
	public static ProductCode parseByValue(String value) {
		return valueMap.get(value);
	}

	public static ProductCode parseByCode(String name) {
		return nameMap.get(name);
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

}
