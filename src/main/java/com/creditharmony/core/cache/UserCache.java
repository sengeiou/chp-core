package com.creditharmony.core.cache;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.users.dao.UserDao;
import com.creditharmony.core.users.entity.User;

/**
 * 用户缓存
 * @Class Name UserCache
 * @author 张永生
 * @Create In 2016年1月25日
 */
public class UserCache implements BaseCache {
	
	private static UserCache cache = new UserCache();
	private static String key = User.class.getName();
	
	private UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	
	public static final String SPLIT_CHAR = ":";
	
	public static UserCache getInstance(){
		return cache;
	}
	
	public User getObject(String id) {
		User user = (User) RedisUtils.getObject(key + SPLIT_CHAR +id);
		return user;
	}

	@Override
	public User get(String id) {
		User user = getObject(id);
		if (null == user){
			user = userDao.get(id);
			if (user != null) {
				user.setDepartment(OrgCache.getInstance().get(user.getDepartment().getId()));
				RedisUtils.saveObject(key + SPLIT_CHAR + user.getId(), user);
			}
		}
		return user;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void save(BaseEntity obj) {
		if (null != obj && obj instanceof User){
			User user = (User)obj;
			user.setDepartment(OrgCache.getInstance().get(user.getDepartment().getId()));
			RedisUtils.saveObject(key + SPLIT_CHAR + obj.getId(), user);
		}
	}

	@Override
	public void remove(String id) {
		RedisUtils.remove(key + SPLIT_CHAR + id);
	}
	
}
