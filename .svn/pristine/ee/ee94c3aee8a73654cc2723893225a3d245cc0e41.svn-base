package com.creditharmony.core.users.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.creditharmony.core.common.dao.ForbiddenDao;
import com.creditharmony.core.common.entity.Forbidden;
import com.creditharmony.core.service.CoreManager;

/**
 * 工作流配置
 * 
 * @Class Name ForbiddenManager
 * @author 罗俊平
 * @Create In 2016年11月30日
 */
@Service
public class ForbiddenManager extends CoreManager<ForbiddenDao, Forbidden> {

	public List<Forbidden> findByUserCode(Map<String, Object> param) {
		List<Forbidden> forbiddenList = dao.findByUserCode(param);
		if (forbiddenList != null && forbiddenList.size() > 0) {
			return forbiddenList;
		} else {
			return null;
		}
	}

}