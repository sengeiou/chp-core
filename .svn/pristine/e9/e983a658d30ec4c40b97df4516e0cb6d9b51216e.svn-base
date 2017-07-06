package com.creditharmony.core.system.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.cache.OrgCache;
import com.creditharmony.core.cache.RoleCache;
import com.creditharmony.core.users.dao.UserRoleOrgDao;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.UserRoleOrg;
import com.google.common.collect.Lists;

public class UserRoleOrgUtil {
	
	/**
	 * 根据用户id，机构id获取所需要的角色，如根据理财经理用户id，获取团队经理，营业部经理等。
	 * 2016年1月26日
	 * By 何军
	 * @param userId
	 * @param orgId
	 * @param roleIds
	 * @return
	 */
	public static List<UserRoleOrg> getUserRoleOrg(String orgId,List<String> roleIds){
		List<Map<String,String>> mapList = Lists.newArrayList();
		getOrgParent(OrgCache.getInstance().get(orgId), roleIds, roleIds.size(), mapList);
		UserRoleOrgDao userRoleOrgDao = SpringContextHolder.getBean(UserRoleOrgDao.class);
		List<UserRoleOrg> userRoleOrgList = null;
		if(mapList.size()>0){
			userRoleOrgList = userRoleOrgDao.findUsersByRidAndOid(mapList);
			for(UserRoleOrg userRoleOrg:userRoleOrgList){
				userRoleOrg.setRoleName(RoleCache.getInstance().get(userRoleOrg.getRoleId()).getName());
				userRoleOrg.setOrgName(OrgCache.getInstance().get(userRoleOrg.getOrgId()).getName());
			}
		}
		return userRoleOrgList;
	}
	
	private static void getOrgParent(Org org, List<String> roleIds, int length, List<Map<String,String>> mapList){
		if(length > 0 && !"-1".equals(org.getParentId())){
			List<Role> roleList = RoleCache.getInstance().getListByOrgType(org.getType());
			for(Role role:roleList){
				if(roleIds.contains(role.getId())){
					Map<String,String> map = new HashMap<String,String>();
					map.put("orgId", org.getId());
					map.put("roleId", role.getId());
					mapList.add(map);
					length--;
				}
			}
			getOrgParent(OrgCache.getInstance().get(org.getParentId()), roleIds, length, mapList);
		}
	}

}
