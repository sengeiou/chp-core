package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 系统来源
 * 
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum SysSrc {
	LCHPXT("1"), // 老CHP系统
	CFGLXT("2");// 财富管理系统

	public static Map<String, String> sysSrcMap = new Hashtable<String, String>();

	static {
		sysSrcMap.put(SysSrc.LCHPXT.value, "老CHP系统");
		sysSrcMap.put(SysSrc.CFGLXT.value, "财富管理系统");
	}
	public final String value;

	private SysSrc(String value) {
		this.value = value;
	}

	public static String getSysSrc(String value) {
		return sysSrcMap.get(value);
	}
}