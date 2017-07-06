package com.creditharmony.core.fortune.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 组织机构类型包含范围
 * 
 * @Class Name OrgTypeRange
 * @author 朱杰
 * @Create In 2016年1月7日
 */
public enum OrgTypeRange {
	//财富事业部包含：财富中心,分公司,支公司,营业部,团队,网点
	BUSINESS_DEPT("6400000001", new String[]{"6400000007","6400000002","6400000003","6400000004","6400000005","6400000006"}),
	//分公司包含:支公司,营业部,团队,网点
	DISTRICT("6400000002", new String[]{"6400000003","6400000004","6400000005","6400000006"}),
	//支公司包含:营业部,团队,网点
	CITY("6400000003", new String[]{"6400000004","6400000005","6400000006"}),
	//营业部包含:团队,网点
	STORE("6400000004", new String[]{"6400000005","6400000006"}),
	//团队包含:
	TEAM("6400000005", new String[]{}),
	//网点包含
	DOT("6400000006", new String[]{}),
	//财富中心包含:分公司,支公司,营业部,团队,网点
	CENTER("6400000007", new String[]{"6400000002","6400000003","6400000004","6400000005","6400000006"});


	private static Map<String, OrgTypeRange> codeMap = new HashMap<String, OrgTypeRange>(
			10);

	static {
		OrgTypeRange[] allValues = OrgTypeRange.values();
		for (OrgTypeRange obj : allValues) {
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String code;
	private String[] range;

	private OrgTypeRange(String code, String[] range) {
		this.code = code;
		this.range = range;

	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String[] getRange() {
		return range;
	}

	public void setRange(String[] range) {
		this.range = range;
	}
	
	public static OrgTypeRange parseByCode(String code) {
		return codeMap.get(code);
	}

}

