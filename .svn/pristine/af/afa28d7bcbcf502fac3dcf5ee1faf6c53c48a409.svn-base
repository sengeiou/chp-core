package com.creditharmony.core.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.UserDao;
import com.creditharmony.core.users.entity.User;

/**
 * 同步用户服务类
 * @Class Name UserSyncManager
 * @author 张永生
 * @Create In 2015年12月7日
 */
@Service
public class UserSyncManager extends CoreManager<UserDao, User> {
	
	public User getUser(String id) {
		return dao.get(id);
	}

	@Transactional(readOnly = false)
	public void saveUser(User user) {
		dao.insert(user);
	}
	
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		dao.update(user);
	}
	
	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		dao.delete(user);
	}
}
