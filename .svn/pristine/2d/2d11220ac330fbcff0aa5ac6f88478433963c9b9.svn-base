package com.creditharmony.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.users.dao.RoleDao;
import com.creditharmony.core.users.entity.Role;
import com.google.common.collect.Lists;

/**
 * 角色缓存
 * @Class Name RoleCache
 * @author 何军
 * @Create In 2016年1月25日
 */
public class RoleCache implements BaseCache {
	
	private static RoleCache self = new RoleCache();
	
	public static RoleCache getInstance(){
		return self;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Role> getMap() {
		Map<String,Role> roleMap =  (Map<String,Role>) RedisUtils.getMap(Role.class.getName());
		if (roleMap == null){
			RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
			List<Role> roleList = roleDao.findAllList(new Role());
			roleMap = new HashMap<String,Role>();
			for(Role role:roleList){
				roleMap.put(role.getId(), role);
			}
			RedisUtils.saveMap(Role.class.getName(), roleMap);
		}
		return roleMap;
	}
	
	/**
	 * id获取角色信息
	 * @param uid
	 * @return
	 */
	public Role get(String id){
		Map<String,Role> roleMap = getMap();
		if ( null != roleMap && null != roleMap.get(id) && roleMap.get(id) instanceof Role){
			return (Role)roleMap.get(id);
		}
		return null;
	}
	
	public List<Role> getList(){
		Map<String,Role> roleMap = getMap();
		List<Role> roleList = Lists.newArrayList();
		if(null != roleMap){
			for (Role role : roleMap.values()) {
					roleList.add(role);
		    }
		}
		return roleList;
	}
	
	/**
	 * 根据orgType获取角色
	 */
	public List<Role> getListByOrgType(String orgType){
		Map<String,Role> roleMap = getMap();
		List<Role> roleList = Lists.newArrayList();
		if(null != roleMap){
			for (Role role : roleMap.values()) {
				if(StringUtils.isNotEmpty(orgType) && orgType.equals(role.getOrgType()) && !"0".equals(role.getUseable())){
					roleList.add(role);
				}
		    }
		}
		return roleList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void save(BaseEntity obj) {
		Map<String,Role> roleMap = getMap();
		if (null != obj && obj instanceof Role && null != roleMap){
			roleMap.put(obj.getId(),(Role)obj);
//			RedisUtils.remove(Role.class.getName());
			RedisUtils.saveMap(Role.class.getName(),roleMap);
		}
	}

	@Override
	public void remove(String id) {
		Map<String,Role> roleMap = getMap();
		if (null != roleMap && null != roleMap.get(id) && roleMap.get(id) instanceof Role){
			roleMap.remove(id);
//			RedisUtils.remove(Role.class.getName());
			RedisUtils.saveMap(Role.class.getName(),roleMap);
		}
	}
}
