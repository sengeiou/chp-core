package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/***
 * 报表类型
 * @Class Name ReportType
 * @author 朱杰
 * @Create In 2016年3月28日
 */
public enum ReportType {
	KHSQ("khsq","开户申请书"), // 开户申请书
	CJ_SQ("cjsq","出借合同"), // 出借合同-非月满盈，年年金
	CJ_SQ_YMY("cjsq_ymy","出借合同-月满盈"), // 出借合同-月满盈
	CJ_SQ_NNJ("cjsq_nnj","出借合同-年年金"), // 出借合同-年年金
	CJ_BG("cjbg","出借变更"), // 出借变更
	SKQRS_HK("skqrs_hk","收款确认书-划扣、资金托管、成功部分内转"), // 收款确认书-划扣、资金托管、成功部分内转
	SKQRS_NBZZ("skqrs_nbzz","收款确认书-内转"), // 收款确认书-内转
	YMY_CJ("ymycj","月满盈-车借-债权文件"), // 月满盈-车借-债权文件
	YMY_FJ("ymyfj","月满盈-房借-债权文件"), // 月满盈-房借-债权文件
	FYMY_SQ("fymysq","非月满盈-首期-债权文件"), // 非月满盈-首期-债权文件
	FYMY_FSQ("fymyfsq","非月满盈-非首期-债权文件"), // 非月满盈-非首期-债权文件
	TQSH_BEFORE4("tqshsq_before4","提前赎回_4月前"), // 提前赎回_4月前
	TQSH_AFTER4("tqshsq_after4","提前赎回_4月后"), // 提前赎回_4月后
	TQSH161_BEFORE4("tqshsq161_before4","提前赎回申请表1.6.1版本专用_4月前"), // 提前赎回申请表1.6.1版本专用_4月前
	TQSH161_AFTER4("tqshsq161_after4","提前赎回申请表1.6.1版本专用_4月后"), // 提前赎回申请表1.6.1版本专用_4月后
	CJR_BG("cjrbg","出借人变更"), // 出借人变更
	FYXY("fyxy","金账户富友协议"), // 金账户富友协议
	JZH_XH("jzh_xh","金账户用户注销申请"); // 金账户用户注销申请

	private static Map<String, ReportType> nameMap = new HashMap<String, ReportType>(
			10);
	private static Map<String, ReportType> codeMap = new HashMap<String, ReportType>(
			10);

	static {
		ReportType[] allValues = ReportType.values();
		for (ReportType obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private ReportType(String code, String name) {
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

	public static ReportType parseByName(String name) {
		return nameMap.get(name);
	}

	public static ReportType parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
}