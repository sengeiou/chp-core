package com.creditharmony.core.users.util;

import com.creditharmony.core.sync.data.entity.SyncRole;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.ldap.vo.VoSyncPosition;

/**
 * 同步角色到ldap的工具类
 * @Class Name SyncLdapPositionHelper
 * @author 张永生
 * @Create In 2015年12月18日
 */
public class SyncLdapPositionHelper {

	/**
	 * 包装同步到ldap的VoSyncPosition对象
	 * 2015年12月18日
	 * By 张永生
	 * @param role
	 * @param syncType
	 * @return
	 */
	public static VoSyncPosition wrapperSyncPosition(Role role, String syncType) {
		VoSyncPosition syncPosition = new VoSyncPosition();
		syncPosition.setActionType(syncType);
		syncPosition.setPositionCn(role.getEnName());
		syncPosition.setParentPosition("");
		syncPosition.setDescription(role.getName()); 
		syncPosition.setBusinessCategory(role.getRemarks());
		return syncPosition;
	}
	/**
	 * 包装同步到ldap的VoSyncPosition对象 for ldap
	 * 2015年12月29日
	 * By 何军
	 */
	public static VoSyncPosition wrapperSyncPosition(SyncRole role, String syncType) {
		VoSyncPosition syncPosition = new VoSyncPosition();
		syncPosition.setActionType(syncType);
		syncPosition.setPositionCn(role.getEnName());
		syncPosition.setParentPosition("");
		syncPosition.setDescription(role.getName()); 
		syncPosition.setBusinessCategory(role.getRemarks());
		return syncPosition;
	}
}
