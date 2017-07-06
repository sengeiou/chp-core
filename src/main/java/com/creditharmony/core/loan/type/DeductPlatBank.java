/**
 * @Probject Name: chp-core
 * @Path: com.creditharmony.core.fortune.typeDeductPlatBankBank.java
 * @Create By 王彬彬
 * @Create In 2015年12月21日 下午12:12:44
 */
package com.creditharmony.core.loan.type;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.creditharmony.common.util.StringUtils;

/**
 * 银行名称
 * @Class Name DeductPlatBankBank 
 * @author 王彬彬
 * @Create In 2015年12月21日
 */
public enum DeductPlatBank {
	ICBC("102","中国工商银行"),
	
	ABC("103","中国农业银行"),
	
	BOC("104","中国银行"),
	
	CCB("105","中国建设银行"),
	
	ECITIC("302","中信银行"),
	
	CEB("303","中国光大银行"),
	
	HXB("304","华夏银行"),
	
	CMBC("305","中国民生银行"),
	
	GDB("306","广发银行"),
	
	PAB("307","平安银行"),
	
	CMB("308","招商银行"),
	
	CIB("309","兴业银行"),
	
	SPDB("310","上海浦东发展银行"),
	
	PSBC("403","国家邮政局邮政储汇局"),
	
	JTYH("666","交通银行");

	private static Map<String, DeductPlatBank> nameMap = new HashMap<String, DeductPlatBank>(
			50);
	private static Map<String, DeductPlatBank> codeMap = new HashMap<String, DeductPlatBank>(
			50);

	public static Map<String, String> statusMap = new Hashtable<String, String>();
	static {
		DeductPlatBank[] allValues = DeductPlatBank.values();
		for (DeductPlatBank obj : allValues) {
			nameMap.put(obj.getName(), obj);
			codeMap.put(obj.getCode(), obj);
		}
	}

	private String name;
	private String code;

	private DeductPlatBank(String code, String name) {
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

	public static DeductPlatBank parseByName(String name) {
		return nameMap.get(name);
	}

	public static DeductPlatBank parseByCode(String code) {
		return codeMap.get(code);
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public static String getNameByCode(String code) {
		if (statusMap.isEmpty()) {
			statusMap.put(DeductPlatBank.ICBC.code, DeductPlatBank.ICBC.name);
			statusMap.put(DeductPlatBank.ABC.code, DeductPlatBank.ABC.name);
			statusMap.put(DeductPlatBank.BOC.code, DeductPlatBank.BOC.name);
			statusMap.put(DeductPlatBank.CCB.code, DeductPlatBank.CCB.name);
			statusMap.put(DeductPlatBank.ECITIC.code, DeductPlatBank.ECITIC.name);
			statusMap.put(DeductPlatBank.CEB.code, DeductPlatBank.CEB.name);
			statusMap.put(DeductPlatBank.HXB.code, DeductPlatBank.HXB.name);
			statusMap.put(DeductPlatBank.CMBC.code, DeductPlatBank.CMBC.name);
			statusMap.put(DeductPlatBank.GDB.code, DeductPlatBank.GDB.name);
			statusMap.put(DeductPlatBank.PAB.code, DeductPlatBank.PAB.name);
			statusMap.put(DeductPlatBank.CMB.code, DeductPlatBank.CMB.name);
			statusMap.put(DeductPlatBank.CIB.code, DeductPlatBank.CIB.name);
			statusMap.put(DeductPlatBank.SPDB.code, DeductPlatBank.SPDB.name);
			statusMap.put(DeductPlatBank.PSBC.code, DeductPlatBank.PSBC.name);
			statusMap.put(DeductPlatBank.JTYH.code, DeductPlatBank.JTYH.name);
		}
		return statusMap.get(code);
	}
	
	public static String getCodeByName(String name) {
		String code = null;
		if (statusMap.isEmpty()) {
			statusMap.put(DeductPlatBank.ICBC.code, DeductPlatBank.ICBC.name);
			statusMap.put(DeductPlatBank.ABC.code, DeductPlatBank.ABC.name);
			statusMap.put(DeductPlatBank.BOC.code, DeductPlatBank.BOC.name);
			statusMap.put(DeductPlatBank.CCB.code, DeductPlatBank.CCB.name);
			statusMap.put(DeductPlatBank.ECITIC.code, DeductPlatBank.ECITIC.name);
			statusMap.put(DeductPlatBank.CEB.code, DeductPlatBank.CEB.name);
			statusMap.put(DeductPlatBank.HXB.code, DeductPlatBank.HXB.name);
			statusMap.put(DeductPlatBank.CMBC.code, DeductPlatBank.CMBC.name);
			statusMap.put(DeductPlatBank.GDB.code, DeductPlatBank.GDB.name);
			statusMap.put(DeductPlatBank.PAB.code, DeductPlatBank.PAB.name);
			statusMap.put(DeductPlatBank.CMB.code, DeductPlatBank.CMB.name);
			statusMap.put(DeductPlatBank.CIB.code, DeductPlatBank.CIB.name);
			statusMap.put(DeductPlatBank.SPDB.code, DeductPlatBank.SPDB.name);
			statusMap.put(DeductPlatBank.PSBC.code, DeductPlatBank.PSBC.name);
			statusMap.put(DeductPlatBank.JTYH.code, DeductPlatBank.JTYH.name);
		}
		for(String key:statusMap.keySet()){
			if(StringUtils.equals(name, statusMap.get(key))){
				code = key;
			}
		}
		return code;
	}
}
