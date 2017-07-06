package com.creditharmony.core.log.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.creditharmony.common.util.IdGen;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.common.util.RemoteAddrUtils;
import com.creditharmony.core.log.dao.LoginLogDao;
import com.creditharmony.core.log.entity.LoginLog;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.servlet.Servlets;
import com.creditharmony.core.type.SystemFlag;
import com.creditharmony.core.users.entity.User;

@Service
public class LoginLogManager extends CoreManager<LoginLogDao, LoginLog> {

	public void insertLoginLog(final User user, final String type,final HttpServletRequest getRequest,final String systemFlag) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				LoginLog ll = new LoginLog();
				ll.setId(IdGen.uuid());
				ll.setLoginName(user.getLoginName());
				ll.setLoginIp(getRequest!=null?RemoteAddrUtils.getRemoteAddr(getRequest):"");
				ll.setLoginTime(new Date());
				ll.setSystemFlag(systemFlag);
				ll.setType(type);
				ll.setUserCode(user.getUserCode());
				ll.setUserName(user.getName());
				dao.insertSelective(ll);
			}
		}).start();

	}
}
