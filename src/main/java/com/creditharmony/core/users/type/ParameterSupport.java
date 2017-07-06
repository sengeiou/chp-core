package com.creditharmony.core.users.type;



/**
 * 参数支持类
 * 用途：用来封装方法的参数
 * @Class Name ParameterSupport
 * @author 张永生
 * @Create In 2015年12月4日
 */
public class ParameterSupport {

	private String methodName;      // 方法名称
	private String syncLdapType;    // 同步到ldap的数据类型
	private String actionType;      // 执行的数据库操作名称:insert,update,query,delete
	private int exceptionCode;      // 异常码
	private String syncBizType;     // 同步到业务模块（汇金汇诚、财富）的数据类型
	private String extMsg;          // 扩展信息
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getSyncLdapType() {
		return syncLdapType;
	}
	public void setSyncLdapType(String syncLdapType) {
		this.syncLdapType = syncLdapType;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public int getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(int exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public String getSyncBizType() {
		return syncBizType;
	}
	public void setSyncBizType(String syncBizType) {
		this.syncBizType = syncBizType;
	}
	public String getExtMsg() {
		return extMsg;
	}
	public void setExtMsg(String extMsg) {
		this.extMsg = extMsg;
	}
	
}
