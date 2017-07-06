package com.creditharmony.core.users.dao;

import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;
import com.creditharmony.core.users.entity.UserGesturePssword;

/**
 * 用户手势密码DAO接口
 * @Class Name UserGesturePsswordDao
 * @author 高原
 * @Create In 2017年06月05日
 */
@CoreBatisDao
public interface UserGesturePsswordDao extends CrudDao<UserGesturePssword> {

	UserGesturePssword login(UserGesturePssword userGesturePssword);
	
}
