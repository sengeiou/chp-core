package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

public enum MatchingFlag {

	QXJ("0"), // 全信借
	QCJ("1"), // 全车借
	HH("2"); // 混合
	
	public static Map<String, String> matchingFlagMap = new Hashtable<String, String>();
	static{
		matchingFlagMap.put(MatchingFlag.QXJ.value, "全信借");
		matchingFlagMap.put(MatchingFlag.QCJ.value, "全车借");
		matchingFlagMap.put(MatchingFlag.HH.value, "混合");
	}
	
	public final String value;

	private MatchingFlag(String value) {
		this.value = value;
	}

	public static String getMatchingFlag(String value) {
		return matchingFlagMap.get(value);
	}
}
