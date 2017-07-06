package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 操作类型
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum OperateType {
	PPTJ("1"), // 匹配提交
	ZQGL("2"), // 订购撤消(撤销重匹)
	PLSFZQ("3"),// 批量债权释放撤消
	TQSHZQSF("4"), // 提前赎回债权释放
	ZQZRZQSF("5"), // 债权转让债权释放
	TQJQSFZQRPPJE("6"), // 提前结清释放债权人匹配金额
	JSSFDQYHB("7"), // 结算释放当期月还本
	ZQCF("8"), // 债权拆分
	ZQHC("9"), // 债权回池
	ZQFP("10"),// 债权分配
	YMYDQZQSF("11"), // 月满盈到期债权释放
	HKSBZQSF("12"),// 划扣失败债权释放	
	MSDQZQSP("13"),// 模式转换债权释放
	CX("14"), // 出借撤销债权释放
	CJDQZQSF("15"); // 出借到期债权释放

	public final String value;

	private OperateType(String value) {
		this.value = value;
	}

	public static String getOperateType(String value) {
		return operateTypeMap.get(value);
	}

	public static Map<String, String> operateTypeMap = new Hashtable<String, String>();

	public static void initOperateType() {
		if (operateTypeMap.isEmpty()) {
			operateTypeMap.put(OperateType.PPTJ.value, "匹配提交");
			operateTypeMap.put(OperateType.ZQGL.value, "订购撤消(撤消重匹)");
			operateTypeMap.put(OperateType.PLSFZQ.value, "批量债权释放撤消");
			
			operateTypeMap.put(OperateType.TQSHZQSF.value, "提前赎回债权释放");
			operateTypeMap.put(OperateType.ZQZRZQSF.value, "债权转让债权释放");
			operateTypeMap.put(OperateType.TQJQSFZQRPPJE.value, "提前结清释放债权人匹配金额");
			
			operateTypeMap.put(OperateType.JSSFDQYHB.value, "结算释放当期月还本");
			operateTypeMap.put(OperateType.ZQCF.value, "债权拆分");
			operateTypeMap.put(OperateType.ZQHC.value, "债权回池");
			operateTypeMap.put(OperateType.ZQFP.value, "债权分配");
			operateTypeMap.put(OperateType.YMYDQZQSF.value, "月满盈到期债权释放");
			operateTypeMap.put(OperateType.HKSBZQSF.value, "划扣失败债权释放");
			operateTypeMap.put(OperateType.MSDQZQSP.value, "模式转换债权释放");
			operateTypeMap.put(OperateType.CX.value, "出借撤销债权释放");
			operateTypeMap.put(OperateType.CJDQZQSF.value, "出借到期债权释放");
		}
	}
}