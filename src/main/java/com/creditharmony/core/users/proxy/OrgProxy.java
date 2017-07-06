package com.creditharmony.core.users.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.remote.OrgService;
import com.creditharmony.core.users.service.OrgManager;


/**
 * 组织机构代理类
 * @Class Name OrgProxy
 * @author 张永生
 * @Create In 2016年1月15日
 */
@Component
public class OrgProxy implements OrgService {

	@Autowired
	private OrgManager orgManger;
	
	@Override
	public Org getOrg(String id) {
		return orgManger.get(id);
	}

}
