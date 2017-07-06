package com.creditharmony.core.log.service;

import org.springframework.stereotype.Service;

import com.creditharmony.core.log.dao.OrgLogDao;
import com.creditharmony.core.log.entity.OrgLog;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.type.SystemFlag;
import com.creditharmony.core.users.entity.Org;


@Service
public class OrgLogManager extends CoreManager<OrgLogDao, OrgLog>  {
	
	public void insertOrgLog(final Org oldOrg,final Org newOrg,final String type) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				OrgLog ol=new OrgLog();		
				try {
					ol=(OrgLog) setValue(ol, oldOrg, newOrg);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(type.equals("1")){
					ol.setOrgId(newOrg.getId());
					ol.setParentId(newOrg.getParentId());
					ol.setParentIdNew(newOrg.getParentId());
				}else{
					ol.setOrgId(oldOrg.getId());
					ol.setParentId(oldOrg.getParentId());
					ol.setParentIdNew(oldOrg.getParentId());
				}
			
				ol.setOperateType(type);
				ol.setSystemFlag(SystemFlag.SYS_MANAGE.value);
				ol.preInsert();
				dao.insertSelective(ol);
			}
		}).start();
		
	}	
}
