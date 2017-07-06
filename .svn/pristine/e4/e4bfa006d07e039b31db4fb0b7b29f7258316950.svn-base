package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 回款类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum BackType {
	DQHK("1"), // 到期回款
	TQSH("2"), // 提前赎回
	//QBNBZZ("3"), // 全部内部转账
	BFBJNBZZ("4"), // 部分本金内部转账
	//BFBXNBZZ("5"), // 部分本息内部转账
	QBBJNBZZ("6"), // 全部本金内部转账
//	MHX12("7"), // 12月回息
//	MHX24("8"), // 24月回息
	MSZHHK("9"), // 模式转换回款
	CJSB("10"), // 出借失败
	CGBFNBZZ("12"),// 成功部分内部转账
	SHNZ("13"),// 赎回内转
	QBBJZZ("14");// 全部本金自转
	public static Map<String, String> backTypeMap = new Hashtable<String, String>();
	static{
		backTypeMap.put(BackType.DQHK.value, "到期回款");
		backTypeMap.put(BackType.TQSH.value, "提前赎回");
		//backTypeMap.put(BackType.QBNBZZ.value, "全部内部转账");
		backTypeMap.put(BackType.BFBJNBZZ.value, "部分本金内部转账");
		//backTypeMap.put(BackType.BFBXNBZZ.value, "部分本息内部转账");
		backTypeMap.put(BackType.QBBJNBZZ.value, "全部本金内部转账");
		//backTypeMap.put(BackType.MHX12.value, "12月回息");
		//backTypeMap.put(BackType.MHX24.value, "24月回息");
		backTypeMap.put(BackType.MSZHHK.value, "模式转换回款");
		backTypeMap.put(BackType.CJSB.value, "出借失败");
		backTypeMap.put(BackType.CGBFNBZZ.value, "成功部分内部转账");
		backTypeMap.put(BackType.SHNZ.value, "赎回内转");
		backTypeMap.put(BackType.QBBJZZ.value, "全部本金自转");
	}

	public final String value;

	private BackType(String value) {
		this.value = value;
	}

	public static String getBackType(String value) {
		return backTypeMap.get(value);
	}

}