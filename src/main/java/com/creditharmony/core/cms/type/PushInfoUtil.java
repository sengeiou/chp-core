package com.creditharmony.core.cms.type;


public class PushInfoUtil{
	/*
	public static String pushUrl;
	
	static{
		ResourceBundle resource = ResourceBundle.getBundle("main/resources/application");//test为属性文件名，放在包com.mmq下，如果是放在src下，直接用test即可  
		pushUrl = resource.getString("pushUrl"); 
	}*/
	private String initPushUrl;

	public void setInitPushUrl(String initPushUrl) {
		this.initPushUrl = initPushUrl;
	}
	public String getInitPushUrl() {
		return initPushUrl;
	}
}
