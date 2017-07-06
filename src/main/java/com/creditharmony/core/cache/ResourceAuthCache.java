package com.creditharmony.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.users.dao.MenuDao;
import com.creditharmony.core.users.entity.ResourceAuth;
import com.google.common.collect.Lists;

public class ResourceAuthCache implements BaseCache {
	private static ResourceAuthCache self = new ResourceAuthCache();

	public static ResourceAuthCache getInstance() {
		return self;
	}

	@SuppressWarnings("unchecked")
	public Map<String,ResourceAuth> getMap() {
		Map<String,ResourceAuth> resourceAuthMap =  (Map<String,ResourceAuth>) RedisUtils.getMap(ResourceAuth.class.getName());
		if (resourceAuthMap == null) {
			MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
			List<ResourceAuth> resourceAuthList = menuDao.findResourceAuthByParams(new HashMap<String, String>());
			resourceAuthMap = new HashMap<String,ResourceAuth>();
			for(ResourceAuth resourceAuth:resourceAuthList){
				resourceAuthMap.put(resourceAuth.getId(), resourceAuth);
			}
			RedisUtils.saveMap(ResourceAuth.class.getName(), resourceAuthMap);
		}
		return resourceAuthMap;
	}

	public ResourceAuth get(String id) {
		Map<String,ResourceAuth> resourceAuthMap =  getMap();
		if ( null != resourceAuthMap && null != resourceAuthMap.get(id) && resourceAuthMap.get(id) instanceof ResourceAuth){
			return resourceAuthMap.get(id);
		}
		return null;
	}

	public List<ResourceAuth> getByRoleId(String roleId) {
		List<ResourceAuth> resourceAuthList = Lists.newArrayList();
		Map<String,ResourceAuth> resourceAuthMap =  getMap();
		if(null != resourceAuthMap){
			for (ResourceAuth resourceAuth : resourceAuthMap.values()) {
				if (StringUtils.isNotEmpty(resourceAuth.getRoleId())&& resourceAuth.getRoleId().equals(roleId)) {
					resourceAuthList.add(resourceAuth);
				}
		    }
		}
		return resourceAuthList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void save(BaseEntity obj) {
		Map<String,ResourceAuth> resourceAuthMap = getMap();
		if (null != obj && obj instanceof ResourceAuth && null != resourceAuthMap){
			resourceAuthMap.put(obj.getId(),(ResourceAuth)obj);
//			RedisUtils.remove(ResourceAuth.class.getName());
			RedisUtils.saveMap(ResourceAuth.class.getName(),resourceAuthMap);
		}
	}

	@Override
	public void remove(String id) {
		Map<String,ResourceAuth> resourceAuthMap = getMap();
		if (null != resourceAuthMap && null != resourceAuthMap.get(id) && resourceAuthMap.get(id) instanceof ResourceAuth){
			resourceAuthMap.remove(id);
//			RedisUtils.remove(ResourceAuth.class.getName());
			RedisUtils.saveMap(ResourceAuth.class.getName(),resourceAuthMap);
		}
	}

}
