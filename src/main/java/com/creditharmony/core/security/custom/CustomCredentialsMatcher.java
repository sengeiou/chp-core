package com.creditharmony.core.security.custom;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Service;


/**
 * 自定义的密码校验器
 * @Class Name CustomCredentialsMatcher
 * @author 张永生
 * @Create In 2015年11月27日
 */
@Service
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken,
			AuthenticationInfo info) {
		//密码不做任何校验，通过工作流或者ldap来校验
		return true;
	}

}
