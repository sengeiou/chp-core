package com.creditharmony.core.users.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.creditharmony.common.util.ListUtils;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.IpConfigDao;
import com.creditharmony.core.users.entity.IpConfig;
@Service
public class IpConfigManager  extends CoreManager<IpConfigDao, IpConfig> {
		
	public List<String> findIpList(IpConfig ic){		
		List<String> ipList=dao.findIpList(ic);
		return ipList;		
	}
	
	public Page<IpConfig> findIpConfig(Page<IpConfig> page, Map<String,Object> filter) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        PageList<IpConfig> pageList = (PageList<IpConfig>)dao.findByParams(filter, pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	//删除添加日志？
	public void deleteByPrimaryKey(String id){
		dao.deleteByPrimaryKey(id);
	}
	
	public void saveIpConfig(IpConfig ipConfig){
		ipConfig.setDelFlag("0");
		save(ipConfig);
	}
	/**
	 * 根据条件获取ip配置是否正确
	 * @param ipConfig
	 * @return
	 */
	public boolean getIpConfigByCondition(IpConfig ipConfig) {
		ipConfig.setDelFlag(DeleteFlagType.NORMAL);
		List<String> ipList = dao.findIpList(ipConfig);
		return ListUtils.isNotEmptyList(ipList) ? true : false;
	}
}
