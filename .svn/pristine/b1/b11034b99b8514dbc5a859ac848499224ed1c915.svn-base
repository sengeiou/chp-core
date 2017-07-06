package com.creditharmony.core.log.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creditharmony.core.log.dao.RoleMenuResLogDao;
import com.creditharmony.core.log.entity.RoleMenuResLog;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.type.SystemFlag;
import com.creditharmony.core.users.entity.ResourceAuth;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.RoleModuleMenu;

@Service
public class RoleMenuResLogManager extends
		CoreManager<RoleMenuResLogDao, RoleMenuResLog> {

	public void insertRoleMenuResLog(final Role roleR,final List<RoleModuleMenu> oldMenu,
			final List<RoleModuleMenu> newMenu,
			final List<ResourceAuth> oldResource,
			final List<ResourceAuth> newResource, final String type) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				RoleMenuResLog rmrl = new RoleMenuResLog();
				StringBuffer oR = new StringBuffer();
				StringBuffer nR = new StringBuffer();
				StringBuffer oM = new StringBuffer();
				StringBuffer nM = new StringBuffer();
				String role = roleR.getId();
				for (RoleModuleMenu m : oldMenu) {
					oM.append(m.getMenuId() + "|");
				}
				for (RoleModuleMenu m : newMenu) {
					nM.append(m.getMenuId() + "|");
				}
				for (ResourceAuth r : oldResource) {
					oR.append(r.getResId() + "|");
				}
				for (ResourceAuth r : newResource) {
					nR.append(r.getResId() + "|");
				}
				rmrl.setRoleId(role);
				rmrl.setMenuId(oM.toString());
				rmrl.setMenuIdNew(nM.toString());
				rmrl.setResId(oR.toString());
				rmrl.setResIdNew(nR.toString());
				rmrl.setOperateType(type);
				rmrl.setSystemFlag(SystemFlag.SYS_MANAGE.value);
				rmrl.preInsert();
				dao.insertSelective(rmrl);
			}
		}).start();
	}
}
