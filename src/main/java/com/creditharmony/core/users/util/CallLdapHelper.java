package com.creditharmony.core.users.util;

import org.slf4j.Logger;

import com.creditharmony.core.common.type.SymbolConstant;
import com.creditharmony.core.exception.LdapException;
import com.creditharmony.core.exception.code.LdapExceptionCode;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.ldap.handler.LdapDataHandlerFactory;
import com.creditharmony.ldap.vo.VoSyncPosition;
import com.creditharmony.ldap.vo.VoSyncUser;

/**
 * 调用ldap的帮助类
 * @Class Name CallLdapHelper
 * @author 张永生
 * @Create In 2015年11月23日
 */
public class CallLdapHelper {

	/**
	 * 调用远端的ldap-角色服务
	 * 2015年11月23日
	 * By 张永生
	 * @param logger
	 * @param role
	 * @param syncOrg
	 * @param operatorId
	 * @param extMsg
	 * @param methodName
	 * @param actionName
	 * @param exceptionCode
	 */
	public static void callRemoteRoleLdap(Logger logger, Role role, VoSyncPosition syncPosition,
			String operatorId, String extMsg, String methodName,
			String actionName, int exceptionCode) {
		try {
			 LdapDataHandlerFactory.dealLdap(syncPosition);
			 LdapLoggerHelper.writeLog(logger, methodName, actionName,
						operatorId, role.getId(), role.getName(), role.getEnName(),
						LdapExceptionCode.getSuccessDesc(exceptionCode));
		} catch (Exception e) {
			//e.printStackTrace();
			LdapLoggerHelper.writeLog(logger, methodName, actionName,
					operatorId, role.getId(), role.getName(), role.getEnName(),
					LdapExceptionCode.getFailDesc(exceptionCode));
			throw new LdapException(
					LdapExceptionCode.getFailDesc(exceptionCode)
							+ (extMsg==null?"":(SymbolConstant.COMMA + extMsg)));
		}
	}
	
	/**
	 * 调用远端的ldap-用户服务
	 * 2015年11月23日
	 * By 张永生
	 * @param logger
	 * @param user
	 * @param syncUser
	 * @param operatorId
	 * @param methodName
	 * @param actionName
	 * @param exceptionCode
	 * @param extMsg
	 */
	public static void callRemoteUserLdap(Logger logger, User user,
			VoSyncUser syncUser, String operatorId, String methodName,
			String actionName, int exceptionCode, String extMsg) {
		try {
			LdapDataHandlerFactory.dealLdap(syncUser);
			LdapLoggerHelper.writeLog(logger, methodName, actionName,
					operatorId, user.getUserCode(),
					LdapExceptionCode.getSuccessDesc(exceptionCode));
		} catch (Exception e) {
			LdapLoggerHelper.writeLog(logger, methodName, actionName,
					operatorId, user.getUserCode(),
					LdapExceptionCode.getFailDesc(exceptionCode));
			throw new LdapException(
					LdapExceptionCode.getFailDesc(exceptionCode)
							+ (extMsg == null ? "" : (SymbolConstant.COMMA + extMsg)));
		}
	}

}
