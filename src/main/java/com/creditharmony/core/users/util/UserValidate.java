package com.creditharmony.core.users.util;

import org.apache.shiro.authc.AuthenticationException;

import com.creditharmony.core.config.Global;
import com.creditharmony.core.users.entity.User;

public class UserValidate {
	
	public static void validateUser(User user) {
		if (Global.NO.equals(user.getHasLogin())) {
			throw new AuthenticationException("msg:该用户是普通员工,不允许登录");
		}
		if (Global.NO.equals(user.getStatus())) {
			throw new AuthenticationException("msg:该用户已离职,不允许登录");
		} else if (Global.IS_FROZEN.equals(user.getStatus())) {
			throw new AuthenticationException("msg:该帐号被冻结，请与系统管理员联系");
		} else if (Global.NO.equalsIgnoreCase(user.getHasLogin())) {
			throw new AuthenticationException("msg:该用户不允许登录，请与系统管理员联系");
		}
	}

}
