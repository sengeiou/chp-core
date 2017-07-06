package com.creditharmony.core.cache;

import com.creditharmony.core.dict.entity.Dict;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.ProvinceCity;
import com.creditharmony.core.users.entity.ResourceAuth;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.entity.WorkflowConfig;

public class CacheManager {
//	private static Logger logger = LoggerFactory.getLogger(CacheManager.class);

	public static BaseCache factory(String type) {
//		logger.info("调用缓存获取对象");
		if (Dict.class.getName().equals(type)) {
			return DictCache.getInstance();
		} else if (Role.class.getName().equals(type)) {
			return RoleCache.getInstance();
		} else if (ResourceAuth.class.getName().equals(type)) {
			return ResourceAuthCache.getInstance();
		} else if (Org.class.getName().equals(type)) {
			return OrgCache.getInstance();
		} else if (User.class.getName().equals(type)) {
			return UserCache.getInstance();
		} else if (ProvinceCity.class.getName().equals(type)) {
			return ProvinceCityCache.getInstance();
		} else if (WorkflowConfig.class.getName().equals(type)) {
			return WorkflowCache.getInstance();
		}
		return null;
	}

}
