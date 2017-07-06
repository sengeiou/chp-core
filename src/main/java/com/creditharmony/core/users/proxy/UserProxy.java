package com.creditharmony.core.users.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.remote.UserService;
import com.creditharmony.core.users.service.UserSyncManager;


/**
 * 用户服务代理类
 * @Class Name UserProxy
 * @author 张永生
 * @Create In 2015年11月24日
 */
@Component
public class UserProxy implements UserService{

	@Autowired
	private UserSyncManager userSyncManger;
	 
	@Override
	public User getUser(String id) {
		return userSyncManger.getUser(id);
	}

	@Override
	public void saveUser(User user) {
		userSyncManger.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		userSyncManger.updateUser(user);
	}
	
	public void deleteUser(User user) {
		userSyncManger.deleteUser(user);
	}

}
