package com.creditharmony.core.users.view;

import java.io.Serializable;

/**
 * 类型VIEW
 * 用于在页面下拉列表中填充数据使用
 * @Class Name TypeView
 * @author 张永生
 * @Create In 2015年12月22日
 */
public class TypeView implements Serializable{

	private static final long serialVersionUID = 8307091410095537575L;
	private String key;
	private String name;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
