package com.creditharmony.core.single.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.core.common.dao.DataDomainDao;
import com.creditharmony.core.common.entity.DataDomain;
import com.creditharmony.core.common.entity.ex.DataDomainEx;
import com.creditharmony.core.common.entity.ex.StoresGroupMemberEx;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.single.view.StoresGroupMemberView;

/**
 * 门店和组分配关系Manager
 * @Class Name StoresGroupManager
 * @author 陈伟东
 * @Create In 2015年12月23日
 */
@Service
public class StoresGroupManager extends CoreManager<DataDomainDao, DataDomain> {
	
	@Autowired
	private DataDomainDao dataDomainDao;
	
	@Transactional(readOnly=false)
	public void savaAll(List<DataDomain> list){
		if(list != null && list.size() > 0){
			for(DataDomain entity:list){
				entity.preInsert();
				dataDomainDao.insert(entity);
			}
		}
	}
	
	public List<StoresGroupMemberEx> findStoresGroups(StoresGroupMemberView storesGroupView){
		DataDomain dataDomain = new DataDomain();
		dataDomain.setSourceId(storesGroupView.getGroupLeader());
		dataDomain.setDomainId(storesGroupView.getStoresId());
		List<StoresGroupMemberEx> storesGroups = dataDomainDao.findStoresGroups(dataDomain);
		return storesGroups;
	}
	
	/**
	 * 查找给合同审核小组分配的汇金门店
	 * 2016年1月14日
	 * By 陈伟东
	 * @param page
	 * @param storesGroupView
	 * @param domainType DataDomain的sourceType,参见DomainType
	 * @return
	 * @throws ParseException 
	 */
	public Page<StoresGroupMemberEx> findStoresGroupsPage(
			Page<StoresGroupMemberEx> page,
			StoresGroupMemberView storesGroupView, String domainType)
			throws ParseException {
		
		DataDomainEx dataDomain = new DataDomainEx();
		dataDomain.setSourceId(storesGroupView.getGroupId());
		dataDomain.setDomainId(storesGroupView.getStoresId());
		dataDomain.setSourceType(domainType);
		Date assignTimeStart = storesGroupView.getAssignTimeStart();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(assignTimeStart != null){
			assignTimeStart = sdf.parse(sdf.format(assignTimeStart));
			dataDomain.setAssignTimeStart(assignTimeStart);
		}
		Date assignTimeEnd = storesGroupView.getAssignTimeEnd();
		if(assignTimeEnd != null){
			assignTimeEnd = sdf.parse(sdf.format(assignTimeEnd));
			dataDomain.setAssignTimeEnd(DateUtils.getNextday(assignTimeEnd));
		}
		
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
		PageList<StoresGroupMemberEx> pageList = (PageList<StoresGroupMemberEx>)dataDomainDao.findStoresGroups(dataDomain,pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	@Transactional(readOnly=false)
	public void deleteById(String id){
		dataDomainDao.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void deleteAll(String ids,String singleType) {
		if(!StringUtils.isEmpty(ids)){
			String[] idArr = ids.split(",");
			for(String id:idArr){
				dataDomainDao.deleteById(id);
			}
		}
	}
	
	
}
