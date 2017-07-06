package com.creditharmony.core.users.util;

import org.slf4j.Logger;

/**
 * 调用ldap写日志的帮助类
 * @Class Name LdapLoggerHelper
 * @author 张永生
 * @Create In 2015年11月20日
 */
public class LdapLoggerHelper {

	
	public static void writeLog(Logger logger, String methodName, String actionName, 
			String operatorId,
			String userCode, String exceptionCode) {
		StringBuffer message = new StringBuffer();
		message.append(exceptionCode + ",");
		message.append("Method:");
		message.append(methodName);
		message.append(", daoAction:");
		message.append(actionName);
		message.append(", invoke LdapDataHandlerFactory.dealLdap() ");
		message.append(" happen exception,");
		message.append(",operator:currentUserId={}, params:userCode={}");
		logger.error(message.toString(), new Object[] { operatorId, userCode });
	}
	
	
	public static void writeLdapLog(Logger logger, String methodName, String actionName,
			String operatorId, String userId, String roleId, String roleName,
			String roleEnName, String exceptionCode) {
		StringBuffer message = new StringBuffer();
		message.append(exceptionCode+",");
		message.append("Method:");
		message.append(methodName);
		message.append(", daoAction:");
		message.append(actionName);
		message.append(", invoke LdapDataHandlerFactory.dealLdap() ");
		message.append(",operator:{currentUserId={}}, params:{userId={}, roleId={}, roleName={}, roleEnName={}}");
		logger.error(message.toString(), new Object[] { operatorId, userId, roleId, roleName, roleEnName });
	}
	
	public static void writeLog(Logger logger, String methodName, String actionName,
			String operatorId, String roleId, String roleName,
			String roleEnName, String exceptionCode) {
		StringBuffer message = new StringBuffer();
		message.append(exceptionCode+",");
		message.append("Method:");
		message.append(methodName);
		message.append(",daoAction:");
		message.append(actionName);
		message.append(", invoke LdapDataHandlerFactory.dealLdap() ");
		message.append(",operator:{currentUserId={}}, params:{roleId={}, roleName={}, roleEnName={}}");
		logger.error(message.toString(), new Object[] { operatorId, roleId, roleName, roleEnName});
	}
	
}
