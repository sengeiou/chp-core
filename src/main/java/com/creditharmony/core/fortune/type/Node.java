package com.creditharmony.core.fortune.type;

import java.util.Hashtable;
import java.util.Map;

/***
 * 节点
 * @Class Name
 * @author 赵红江
 * @Create In 2015年12月16日
 */
public enum Node {
	KYZQ("0"), // 可用债权
	YMY("1"), // 月满盈
	YMYKY("2");// 月满盈可用

	public final String value;

	private Node(String value) {
		this.value = value;
	}

	public static String getNode(String value) {
		return nodeMap.get(value);
	}

	public static Map<String, String> nodeMap = new Hashtable<String, String>();

	public static void initNode() {
		if (nodeMap.isEmpty()) {
			nodeMap.put(Node.KYZQ.value, "可用债权");
			nodeMap.put(Node.YMY.value, "月满盈");
			nodeMap.put(Node.YMYKY.value, "月满盈可用");
		}
	}
}