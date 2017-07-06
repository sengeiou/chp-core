package com.creditharmony.core.users.util;

import com.creditharmony.core.sync.data.entity.SyncRole;
import com.creditharmony.core.sync.data.entity.SyncUser;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.ldap.vo.VoSyncPosition;
import com.creditharmony.ldap.vo.VoSyncUser;
import com.creditharmony.ldap.vo.VoSyncUserPosition;



/**
 * 同步用户角色关系到ldap的工具类
 * @Class Name SyncLdapUserPositionHelper
 * @author 张永生
 * @Create In 2015年12月4日
 */
public class SyncLdapUserPositionHelper {

	/**
	 * 包装同步到ldap的UserPosition对象
	 * 2015年12月18日
	 * By 张永生
	 * @param user
	 * @param item
	 * @param syncType
	 * @return
	 */
	public static VoSyncUserPosition wrapperSyncUserPosition(User user,Role item, String syncType) {
		VoSyncUser syncUser = new VoSyncUser();
		syncUser.setUid(user.getLoginName());
		syncUser.setCn(user.getLoginName());
		syncUser.setSn(user.getLoginName());
		syncUser.setDisplayName(user.getName());
		VoSyncPosition syncPosition = new VoSyncPosition();
		syncPosition.setPositionCn(item.getEnName());
		syncPosition.setParentPosition("");
		VoSyncUserPosition synUserPosition = new VoSyncUserPosition();
		synUserPosition.setActionType(syncType);
		synUserPosition.setVoSyncUser(syncUser);
		synUserPosition.setVoSyncPosition(syncPosition);
		return synUserPosition;
	}
	
	/**
	 *
	 *  包装同步到ldap的UserPosition对象 for ldap
	 *  2015年12月29日
	 *  By 何军
	 */
	public static VoSyncUserPosition wrapperSyncUserPosition(SyncUser user, SyncRole item, String syncType) {
		VoSyncUser syncUser = new VoSyncUser();
		syncUser.setUid(user.getLoginName());
		syncUser.setCn(user.getLoginName());
		syncUser.setSn(user.getLoginName());
		syncUser.setDisplayName(user.getName());
		VoSyncPosition syncPosition = new VoSyncPosition();
		syncPosition.setPositionCn(item.getEnName());
		syncPosition.setParentPosition("");
		VoSyncUserPosition synUserPosition = new VoSyncUserPosition();
		synUserPosition.setActionType(syncType);
		synUserPosition.setVoSyncUser(syncUser);
		synUserPosition.setVoSyncPosition(syncPosition);
		return synUserPosition;
	}
	
}
