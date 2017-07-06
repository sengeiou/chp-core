package com.creditharmony.core.users.service;

import org.springframework.stereotype.Service;

import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.UserGesturePsswordDao;
import com.creditharmony.core.users.entity.UserGesturePssword;

/**
 * 手势密码服务类
 * @Class Name UserGesturePsswordManager
 * @author 高原
 * @Create In 2016年06月05日
 */
@Service
public class UserGesturePsswordManager extends CoreManager<UserGesturePsswordDao, UserGesturePssword> {

	public UserGesturePssword login(UserGesturePssword userGesturePssword){
		return dao.login(userGesturePssword);
	}
	
	public void insert(UserGesturePssword userGesturePssword){
		dao.insert(userGesturePssword);
	}
	
	public void update(UserGesturePssword userGesturePssword){
		dao.update(userGesturePssword);
	}
	
}
