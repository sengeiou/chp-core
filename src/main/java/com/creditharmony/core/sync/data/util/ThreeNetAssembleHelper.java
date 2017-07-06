package com.creditharmony.core.sync.data.util;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.creditharmony.common.util.IdGen;
import com.creditharmony.common.util.ObjectHelper;
import com.creditharmony.core.cache.OrgCache;
import com.creditharmony.core.cache.ProvinceCityCache;
import com.creditharmony.core.cache.UserCache;
import com.creditharmony.core.common.type.UseableType;
import com.creditharmony.core.sync.data.type.SyncStatus;
import com.creditharmony.core.sync.data.type.SyncType;
import com.creditharmony.core.threenet.entity.ThreeNetDataBatch;
import com.creditharmony.core.threenet.entity.ThreeNetOrg;
import com.creditharmony.core.threenet.entity.ThreeNetUser;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.ProvinceCity;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.type.UserStatus;
import com.creditharmony.core.users.util.UserUtils;


/**
 * 三网融合,同步数据组装帮助类
 * @Class Name ThreeNetAssembleHelper
 * @author 张永生
 * @Create In 2015年12月4日
 */
public class ThreeNetAssembleHelper {
	
	/**
	 * 组装同步用户对象
	 * 2016年3月1日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param moduleName
	 * @param batchNo
	 * @return
	 */
	public static ThreeNetUser assembleSyncUser(User user, String syncType, String moduleName, int batchNo){
		ThreeNetUser syncUser = new ThreeNetUser();
		syncUser.setId(IdGen.uuid());
		syncUser.setUserId(user.getId());
		String leaderId = user.getLeaderId();
		if(StringUtils.isNotEmpty(leaderId)){
			User leader = UserCache.getInstance().get(leaderId);
			leaderId = leader != null ? leader.getUserCode() : "";
			syncUser.setLeaderId(leaderId);
		}
		Org org = OrgCache.getInstance().get(user.getDepartment()!=null ? user.getDepartment().getId() : "");
		syncUser.setDepartmentId(org!=null ? org.getCode() : "");
		syncUser.setSyncModuleName(moduleName);
		syncUser.setSyncType(syncType);
		syncUser.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncUser.setBatchNo(batchNo);
		syncUser.setVersionTime(new Date());
		String parentId = org != null ? org.getParentId() : "";
		Org parentOrg = null;
		if(StringUtils.isNotEmpty(parentId)){
			parentOrg = OrgCache.getInstance().get(parentId);
		}
		syncUser.setTeamId(org!=null ? org.getCode() : "");
		syncUser.setBusinessId(parentOrg!=null ? parentOrg.getCode() : "");
		if(SyncType.TYPE_DELETE.value.equals(syncType)){  //删除用户对应于三网系统状态是离职
			syncUser.setStatus(UserStatus.OFF);
		}
		syncUser.setCreateBy(user.getCreateBy());
		syncUser.setCreateTime(user.getCreateTime());
		syncUser.setDelFlag(user.getDelFlag());
		syncUser.setEmail(user.getEmail());
		syncUser.setEntryTime(user.getEntryTime());
		syncUser.setHasLogin(user.getHasLogin());
		syncUser.setLevel(user.getLevel());
		syncUser.setLoginName(user.getLoginName());
		syncUser.setMobile(user.getMobile());
		syncUser.setModifyBy(user.getModifyBy());
		syncUser.setModifyTime(user.getModifyTime());
		syncUser.setName(user.getName());
		syncUser.setPhone(user.getPhone());
		syncUser.setRemarks(user.getRemarks());
		syncUser.setSex(user.getSex());
		syncUser.setStatus(user.getStatus());
		syncUser.setUserCode(user.getUserCode());
		return syncUser;
	}
	
	/**
	 * 组织三网同步用户对象
	 * 2016年3月30日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param moduleName
	 * @param batchNo
	 * @param org 财富的组织机构
	 * @return
	 */
	public static ThreeNetUser assembleSyncUser(User user, String syncType,
			String moduleName, int batchNo, Org org) {
		ThreeNetUser syncUser = new ThreeNetUser();
		syncUser.setId(IdGen.uuid());
		syncUser.setUserId(user.getId());
		syncUser.setDepartmentId(org!=null ? org.getId() : "");
		syncUser.setSyncModuleName(moduleName);
		syncUser.setSyncType(syncType);
		syncUser.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncUser.setBatchNo(batchNo);
		syncUser.setVersionTime(new Date());
		syncUser.setTeamId(org!=null ? org.getId() : "");
		syncUser.setBusinessId(org!=null ? org.getParentId() : "");
		return syncUser;
	}


	/**
	 * 组装需要同步的组织机构对象
	 * 2016年3月1日
	 * By 张永生
	 * @param org
	 * @param syncType
	 * @param moduleName
	 * @param batchNo
	 * @return
	 */
	public static ThreeNetOrg assembleSyncOrg(Org org, String syncType,
			String moduleName, int batchNo) {
		ThreeNetOrg syncOrg = new ThreeNetOrg();
		syncOrg.setId(IdGen.uuid());
		syncOrg.setOrgId(org.getId());
		syncOrg.setUseable(org.getUseable());
		if(SyncType.TYPE_DELETE.value.equals(syncType)){
			syncOrg.setUseable(UseableType.NO);
		}
		Org parentOrg = null;
		if (!ObjectHelper.isEmpty(org.getParent())) {
			parentOrg = OrgCache.getInstance().get(org.getParent().getId());
		}
		syncOrg.setParentId(parentOrg != null ? parentOrg.getId() : "");
		syncOrg.setAreaId(org.getArea()!=null ? org.getArea().getId() : "");
		syncOrg.setSyncModuleName(moduleName);
		syncOrg.setSyncType(syncType);
		syncOrg.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncOrg.setVersionTime(new Date());
		syncOrg.setBatchNo(batchNo);
		if(StringUtils.isNotEmpty(syncOrg.getProvinceId())){
			ProvinceCity provinceCity = ProvinceCityCache.getInstance().get(syncOrg.getProvinceId());
			syncOrg.setProvinceName(provinceCity !=null ? provinceCity.getAreaName() : "");
		}
		if(StringUtils.isNotEmpty(syncOrg.getCityId())){
			ProvinceCity provinceCity = ProvinceCityCache.getInstance().get(syncOrg.getProvinceId());
			syncOrg.setCityName(provinceCity !=null ? provinceCity.getAreaName() : "");
		}
		syncOrg.setAddress(org.getAddress());
		syncOrg.setCarLoanCode(org.getCarLoanCode());
		syncOrg.setCarPaperless(org.getCarPaperless());
		syncOrg.setCityId(org.getCityId());
		syncOrg.setCode(org.getCode());
		syncOrg.setCreateBy(org.getCreateBy());
		syncOrg.setCreateTime(org.getCreateTime());
		syncOrg.setCreditPaperless(org.getCreditPaperless());
		syncOrg.setDelFlag(org.getDelFlag());
		syncOrg.setDistrictId(org.getDistrictId());
		syncOrg.setEmail(org.getEmail());
		syncOrg.setFax(org.getFax());
		syncOrg.setGrade(org.getGrade());
		syncOrg.setMaster(org.getMaster());
		syncOrg.setModifyBy(org.getModifyBy());
		syncOrg.setModifyTime(org.getModifyTime());
		syncOrg.setName(org.getName());
		syncOrg.setPartyType(org.getPartyType());
		syncOrg.setPhone(org.getPhone());
		syncOrg.setProvinceId(org.getProvinceId());
		syncOrg.setRemarks(org.getRemarks());
		syncOrg.setSystemFlag(org.getSystemFlag());
		syncOrg.setStoreCode(org.getStoreCode());
		syncOrg.setSort(org.getSort());
		syncOrg.setType(org.getType());
		return syncOrg;
	}
	
	/**
	 * 组装同步数据批次对象
	 * 2015年12月17日
	 * By 张永生
	 * @param bizId
	 * @param batchNo
	 * @param moduleName
	 * @param tableName
	 * @param groupKeyDesc
	 * @param groupByCase
	 * @return
	 */
	public static ThreeNetDataBatch assembleSyncDataBatch(String bizId,
			int batchNo, String moduleName, String tableName,
			String groupKeyDesc, int groupByCase) {
		ThreeNetDataBatch syncBatch = new ThreeNetDataBatch();
		syncBatch.setId(IdGen.uuid());
		syncBatch.setBatchNo(batchNo);
		syncBatch.setGroupKey(GroupKeyUtil.getGroupKey(bizId, moduleName,
				groupByCase));
		syncBatch.setGroupKeyDesc(groupKeyDesc);
		syncBatch.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncBatch.setSyncTableName(tableName);
		syncBatch.setSyncModuleName(moduleName);
		syncBatch.setCreateBy(UserUtils.getUser().getId());
		syncBatch.setCreateTime(new Date());
		return syncBatch;
	}
	
}
