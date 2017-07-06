
package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 全程留痕类型
 * 
 * @Class Name TracesType
 * @author 朱杰
 * @Create In 2016年3月24日
 */
public enum TracesType {
	/* 开户 */
	KH_SQ("0", "开户申请"),
	KH_CG("1", "开户成功"),
	KH_SB("2", "开户失败"),
	KH_JZH_CG("3", "金账户开户成功"),
	KH_JZH_SB("4", "金账户开户失败"),
	/* 出借申请 */
	CJ_SQ("5", "出借申请"),
	CJ_TH("6", "出借-退回"),
	CJ_SPTG("7", "出借-审批通过"),
	/* 出借变更 */
	CJBG_SQ("8", "出借变更申请"),
	CJBG_CS_SPTG("9", "出借变更-初审-审批通过"),
	CJBG_FS_SPTG("10", "出借变更-复审-审批通过"),
	CJBG_JZH_SPTG("11", "出借变更-金账户-审批通过"),
	CJBG_SPTH("12", "出借变更-审批退回"),
	/* 出借人变更 */
	CJRBG_SQ("13", "出借人变更申请"),
	CJRBG_CS_SPTG("14", "出借人变更-初审-审批通过"),
	CJRBG_FS_SPTG("15", "出借人变更-复审-审批通过"),
	CJRBG_JZH_SPTG("16", "出借人变更-金账户-审批通过"),
	CJRBG_JZH_SPTH("17", "出借人变更-审批退回"),
	/* 债权 */
	ZQ_PP("18", "债权匹配"),
	ZQ_CX("19", "债权撤销"),
	ZQPP_CXCJ("35", "债权匹配-出借撤销"),
	/* 划扣 */
	DEDUCT_SQ("20", "划扣申请"),
	DEDUCT_SP_TG("21", "划扣审批通过"),
	DEDUCT_SP_TH("22", "划扣审批退回"),
	DEDUCT_CG("23", "划扣成功"),
	DEDUCT_SB("24", "划扣失败"),
	/* 回款 */
	HK_SQ("25", "回款申请"),
	HK_SP_TG("26", "回款审批通过"),
	HK_SP_TH("27", "回款审批退回"),
	HK_CG("28", "回款成功"),
	HK_SB("29", "回款失败"),
	/* 回息 */
	HX_SQ("30", "回息申请"),
	HX_SP_TG("31", "回息审批通过"),
	HX_SP_TH("32", "回息审批退回"),
	HX_CG("33", "回息成功"),
	HX_SB("34", "回息失败");


	private static Map<String, TracesType> nameMap = new HashMap<String, TracesType>(
			10);
	private static Map<String, TracesType> codeMap = new HashMap<String, TracesType>(
			10);

	static {
		TracesType[] allValues = TracesType.values();
		for (TracesType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private TracesType(String code, String name) {
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

	public static TracesType parseByName(String name) {
		return nameMap.get(name);
	}

	public static TracesType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
