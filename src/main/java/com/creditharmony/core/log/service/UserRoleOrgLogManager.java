package com.creditharmony.core.log.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creditharmony.core.log.dao.UserRoleOrgLogDao;
import com.creditharmony.core.log.entity.UserRoleOrgLog;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.type.SystemFlag;
import com.creditharmony.core.users.entity.UserRoleOrg;

@Service
public class UserRoleOrgLogManager extends
		CoreManager<UserRoleOrgLogDao, UserRoleOrgLog> {

	public void insertUserRoleOrgLog(final List<UserRoleOrg> oldUserRoleOrg,
			final List<UserRoleOrg> newUserRoleOrg, final String type) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				UserRoleOrgLog urol = new UserRoleOrgLog();
				StringBuffer oR = new StringBuffer();
				StringBuffer nR = new StringBuffer();
				StringBuffer oO = new StringBuffer();
				StringBuffer nO = new StringBuffer();
				String u="";
				for (UserRoleOrg o : oldUserRoleOrg) {
					oR.append(o.getRoleId() + "|");
					oO.append(o.getOrgId() + "|");
					u=o.getUserId();
				}
				for (UserRoleOrg n : newUserRoleOrg) {
					nR.append(n.getRoleId() + "|");
					nO.append(n.getOrgId() + "|");
					u=n.getUserId();
				}
				urol.setUserId(u);
				urol.setOrgId(oO.toString());
				urol.setOrgIdNew(nO.toString());
				urol.setRoleId(oR.toString());
				urol.setRoleIdNew(nR.toString());
				urol.setOperateType(type);
				urol.setSystemFlag(SystemFlag.SYS_MANAGE.value);
				urol.preInsert();
				dao.insertSelective(urol);
			}
		}).start();
	}
}
