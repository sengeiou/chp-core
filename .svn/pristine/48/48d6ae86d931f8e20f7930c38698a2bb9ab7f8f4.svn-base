package com.creditharmony.core.users.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.service.OrgManager;


/**
 * 组织机构转换类
 * @Class Name OrgFacade
 * @author 张永生
 * @Create In 2015年12月15日
 */
@Service
public class OrgFacade {
	
	public static final int FIRST_LEVEL = 0;

	@Autowired
	private OrgManager orgManager;

	/**
	 * 加载组织机构
	 * 2015年12月17日
	 * By 张永生
	 * @param parentId
	 * @param level
	 * @return
	 */
	public String loadOrg(String parentId,int level,String defaultIds){
		List<Org> orgList = null;
//		if(level==FIRST_LEVEL){//2015-12-21 by 何军 一次加载组织菜单
//			orgList = orgManager.loadOrg(OrgConstants.ORG_ROOT_ID);
//		}else{
//			orgList = orgManager.loadOrg(parentId);
//		}
		String[] ids = defaultIds.split(",");
		List<String> idList = new ArrayList<String>();
		for(String id:ids){
			idList.add(id);
		}
		orgList = orgManager.loadOrg(null);
		StringBuffer result = new StringBuffer();
		String childJson = "";
		if(ArrayHelper.isNotEmpty(orgList)){
			result.append("[");
			for(Org item : orgList){
//				List<Org> childList = orgManager.loadOrg(item.getId());
				result.append("{");
				result.append("id:'");
				result.append(item.getId());
				result.append("',");
				result.append("pId:'");
				result.append(item.getParentId());
				result.append("',");
				result.append("name:'");
				result.append(item.getName());
				result.append("',");
				if(idList.contains(item.getId())){
					result.append("checked:true");
				}
				result.append("}");
				result.append(",");
			}
			childJson = result.toString();
			childJson = childJson.substring(0, childJson.toString().length()-1);
			childJson += "]";
		}else{
			result.append("[]");
			childJson = result.toString();
		}
		return childJson;
	}

}
