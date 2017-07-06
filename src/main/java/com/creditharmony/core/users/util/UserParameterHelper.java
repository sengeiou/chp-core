package com.creditharmony.core.users.util;

import com.creditharmony.core.common.type.ActionType;
import com.creditharmony.core.common.type.HandleType;
import com.creditharmony.core.exception.code.LdapExceptionCode;
import com.creditharmony.core.sync.data.type.SyncType;
import com.creditharmony.core.users.type.ParameterSupport;
import com.creditharmony.ldap.constants.LdapConstants;

/**
 * 用户管理参数帮助类
 * @Class Name UserParameterHelper
 * @author 张永生
 * @Create In 2015年12月4日
 */
public class UserParameterHelper {

	/**
	 * 根据操作数据库的类型来获取参数支持对象
	 * 2015年12月4日
	 * By 张永生
	 * @param handleType
	 * @return
	 */
	public static ParameterSupport getParameterSupport(int handleType) {
		ParameterSupport paramSupport = null;
		switch(handleType){
			case HandleType.INSERT:
			   paramSupport = new ParameterSupport();
			   paramSupport.setSyncLdapType(LdapConstants.FLAG_USER_INSERT);
			   paramSupport.setActionType(ActionType.INSERT);
			   paramSupport.setExceptionCode(LdapExceptionCode.USER_ADD_FAIL);
			   paramSupport.setSyncBizType(SyncType.TYPE_ADD.value);
			   break;
			case HandleType.UPDATE:
			   paramSupport = new ParameterSupport();
			   paramSupport.setSyncLdapType(LdapConstants.FLAG_USER_UPDATE);
			   paramSupport.setActionType(ActionType.UPDATE);
			   paramSupport.setExceptionCode(LdapExceptionCode.USER_UPDATE_FAIL);
			   paramSupport.setSyncBizType(SyncType.TYPE_MODIFY.value);
			   break;
			case HandleType.QUERY:
			   paramSupport = new ParameterSupport();
			   paramSupport.setSyncLdapType(LdapConstants.FLAG_USER_ISEXIST);
			   paramSupport.setActionType(ActionType.QUERY);
			   paramSupport.setExceptionCode(LdapExceptionCode.USER_IS_EXIST);
			   break;
		}
		return paramSupport;
	}
	
}
