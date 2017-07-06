package com.creditharmony.core.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.core.cms.dao.CmsPushDao;
import com.creditharmony.core.cms.dao.CmsPushHisDao;
import com.creditharmony.core.cms.entity.CmsPush;
import com.creditharmony.core.cms.entity.CmsPushHis;
import com.creditharmony.core.service.CoreManager;

@Service
public class CmsPushService extends CoreManager<CmsPushDao, CmsPush> {
	
	@Autowired
	private CmsPushHisDao cmsPushHisDao;
	
	public void deleteCmsPush(String id){
		CmsPush cp=dao.selectByPrimaryKey(id);
		if(cp!=null){
			CmsPushHis cph=cmsPushToHis(cp,"1");
			cmsPushHisDao.insertSelective(cph);
			dao.deleteByPrimaryKey(id);	
		}
	}

	
	public void deleteOverdueList(){
		List<CmsPush> cpl=dao.findOverdueList();
		CmsPushHis cph;
		for(int i=0;i<cpl.size();i++){
			cph=cmsPushToHis(cpl.get(i),"2");
			cmsPushHisDao.insertSelective(cph);
			dao.deleteByPrimaryKey(cpl.get(i).getId());			
		}
	}
	
	private CmsPushHis cmsPushToHis(CmsPush cp,String type){
		CmsPushHis cph=new CmsPushHis();
		cph.setArticleId(cp.getArticleId());
		cph.setChannel(cp.getChannel());
		cph.setUserId(cp.getUserId());
		cph.setTitle(cp.getTitle());
		cph.setKeywords("");
		cph.setDescription(cp.getContent());
		cph.setPushTime(new Date());
		cph.setUrl(cp.getUrl());
		cph.setStatus(type);
		cph.preInsert();
		return cph;
	}
}
