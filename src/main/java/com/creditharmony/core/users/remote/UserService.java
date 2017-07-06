package com.creditharmony.core.users.remote;

import com.creditharmony.core.users.entity.User;

public interface UserService {

	/**
	 * 根据用户ID获取用户信息
	 * 2015年11月24日
	 * By 张永生
	 * @param id
	 * @return
	 */
	 public User getUser(String id);
	 
	 /**
	  * 保存用户
	  * 2015年12月7日
	  * By 张永生
	  * @param user
	  */
	 public void saveUser(User user);
	 
	 /**
	  * 更新用户
	  * 2015年12月7日
	  * By 张永生
	  * @param user
	  */
	 public void updateUser(User user);
	 /**
	  * 删除用户
	  * 2015年12月7日
	  * By 张永生
	  * @param user
	  */
	 public void deleteUser(User user);
}
