package com.creditharmony.core.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.IpLocalConfigDao;
import com.creditharmony.core.users.entity.IpLocalConfig;

@Service
public class IpLocalConfigManager  extends CoreManager<IpLocalConfigDao, IpLocalConfig> {		
	public List<String> findIpList(IpLocalConfig ic){		
		List<String> ipList=dao.findIpList(ic);
		return ipList;		
	}
}
