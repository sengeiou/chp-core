package com.creditharmony.core.users.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.creditharmony.core.sync.data.entity.SyncUser;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.ldap.constants.LdapConstants;
import com.creditharmony.ldap.vo.VoSyncUser;



/**
 * 同步用户到ldap的工具类
 * @Class Name SyncLdapUserHelper
 * @author 张永生
 * @Create In 2015年12月4日
 */
public class SyncLdapUserHelper {

	/**
	 * 包装同步到ldap的VoSyncUser对象
	 * 2015年12月18日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param password
	 * @return
	 */
	public static VoSyncUser wrapperSyncUser(User user, String syncType,
			String password) {
		VoSyncUser syncUser = new VoSyncUser();
		syncUser.setUid(user.getId());
		syncUser.setCn(user.getId());
		syncUser.setSn(user.getId());
		syncUser.setActionType(syncType);
		syncUser.setDisplayName(user.getName());
		if (LdapConstants.FLAG_USER_INSERT.equals(syncType)
				|| LdapConstants.FLAG_USER_UPDATE.equals(syncType)) {
			if(StringUtils.isNotBlank(password)){
				syncUser.setUserPassword(password);
			}
			List<String> departmentNumbers = new ArrayList<String>();
			syncUser.setDepartmentNumbers(departmentNumbers);
		}
		return syncUser;
	}
	/**
	 *  包装同步到ldap的VoSyncUser对象 for ldap
	 *  2015年12月29日
	 *  By 何军
	 */
	public static VoSyncUser wrapperSyncUser(SyncUser user, String syncType,
			String password) {
		VoSyncUser syncUser = new VoSyncUser();
		syncUser.setUid(user.getId());
		syncUser.setCn(user.getId());
		syncUser.setSn(user.getId());
		syncUser.setActionType(syncType);
		syncUser.setDisplayName(user.getName());
		if (LdapConstants.FLAG_USER_INSERT.equals(syncType)
				|| LdapConstants.FLAG_USER_UPDATE.equals(syncType)) {
			if(StringUtils.isNotBlank(password)){
				syncUser.setUserPassword(password);
			}
			List<String> departmentNumbers = new ArrayList<String>();
			syncUser.setDepartmentNumbers(departmentNumbers);
		}
		return syncUser;
	}
	

    /**
     * 包装ldap用户对象
     * 2016年3月2日
     * By 张永生
     * @param user
     * @param oldPassword
     * @return
     */
	public static VoSyncUser wrapperLdapUser(User user, String oldPassword) {
        VoSyncUser voSyncData = new VoSyncUser();
        voSyncData.setUid(user.getId());
        voSyncData.setCn(user.getId());
        voSyncData.setSn(user.getId());
        voSyncData.setUserPassword(oldPassword);  
        voSyncData.setDisplayName(user.getName());
        List<String> departmentNumbers = new ArrayList<String>();
        voSyncData.setDepartmentNumbers(departmentNumbers);
        voSyncData.setActionType(LdapConstants.FLAG_USER_AUTH);
        return voSyncData;
    }
	
}
