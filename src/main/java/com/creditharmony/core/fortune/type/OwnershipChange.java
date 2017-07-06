package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/**
 * 转投标识
 * @Class Name FortuneChannelFlag
 * @author 陈晓强
 * @Create In 2016年11月5日
 */
public enum OwnershipChange {
	
	DX("400801", "电销"), 
	YK("66011006", "杨昆");
	
	public final String value;
	
	public final String name;

	private OwnershipChange(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public static Map<String, OwnershipChange> ownershipChangeMap ;
	
	static {
		ownershipChangeMap = new Hashtable<String, OwnershipChange>();
		ownershipChangeMap.put(OwnershipChange.DX.value, DX);
		ownershipChangeMap.put(OwnershipChange.YK.value, YK);
	}
	
	public static OwnershipChange getOwnershipChange(String value) {
		return ownershipChangeMap.get(value);
	}
}