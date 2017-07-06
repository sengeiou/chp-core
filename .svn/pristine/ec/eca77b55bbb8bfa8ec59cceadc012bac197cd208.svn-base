package com.creditharmony.core.sync.data.util;

import java.util.Date;

import com.creditharmony.common.util.IdGen;
import com.creditharmony.core.dict.entity.Dict;
import com.creditharmony.core.sync.data.entity.SyncDataBatch;
import com.creditharmony.core.sync.data.entity.SyncDict;
import com.creditharmony.core.sync.data.entity.SyncOrg;
import com.creditharmony.core.sync.data.entity.SyncRole;
import com.creditharmony.core.sync.data.entity.SyncUser;
import com.creditharmony.core.sync.data.entity.SyncUserRoleOrg;
import com.creditharmony.core.sync.data.type.SyncStatus;
import com.creditharmony.core.sync.data.type.SyncType;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.util.UserUtils;


/**
 * 同步数据组装帮助类
 * @Class Name SyncAssembleHelper
 * @author 张永生
 * @Create In 2015年12月4日
 */
public class SyncAssembleHelper {

	/**
	 * 组装同步用户角色组织对象
	 * 2015年12月4日
	 * By 张永生
	 * @param userId
	 * @param orgId
	 * @param syncType
	 * @param moduleName
	 * @return
	 */
	public static SyncUserRoleOrg assembleSyncUserRoleOrg(String userId, String orgId,String roleId,
			String syncType, String moduleName, int batchNo) {
		SyncUserRoleOrg syncUserRoleOrg = new SyncUserRoleOrg();
		String syncUserOrgId = IdGen.uuid();
		syncUserRoleOrg.setId(syncUserOrgId);
		syncUserRoleOrg.setUserId(userId);
		syncUserRoleOrg.setOrgId(orgId);
		syncUserRoleOrg.setRoleId(roleId);
		syncUserRoleOrg.setSyncType(syncType);
		syncUserRoleOrg.setSyncModuleName(moduleName);
		syncUserRoleOrg.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncUserRoleOrg.setBatchNo(batchNo);
		syncUserRoleOrg.setCreateTime(new Date());
		syncUserRoleOrg.setCreateBy(UserUtils.getUser().getId());
		return syncUserRoleOrg;
	}
	
	/**
	 * 组装同步角色对象
	 * 2015年12月25日
	 * By 陈伟东
	 * @param role
	 * @param syncType
	 * @param moduleName
	 * @param batchNo
	 * @return
	 */
	public static SyncRole assembleSyncRole(Role role, String syncType, String moduleName, int batchNo){
		SyncRole syncRole = new SyncRole();
		syncRole.setId(IdGen.uuid());
		syncRole.setRoleId(role.getId());
		syncRole.setSyncModuleName(moduleName);
		syncRole.setSyncType(syncType);
		syncRole.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncRole.setBatchNo(batchNo);
		syncRole.setVersionTime(new Date());
		syncRole.setDelFlag(role.getDelFlag());
		syncRole.setEnName(role.getEnName());
		syncRole.setName(role.getName());
		syncRole.setRemarks(role.getRemarks());
		syncRole.setOrgType(role.getOrgType());
		syncRole.setRoleId(role.getId());
		syncRole.setRoleType(role.getRoleType());
		syncRole.setSysData(role.getSysData());
		syncRole.setUseable(role.getUseable());
		syncRole.setModifyBy(role.getModifyBy());
		syncRole.setModifyTime(role.getModifyTime());
		return syncRole;
	}
	
	
	/**
	 * 组装同步数据字典对象
	 * 2015年12月28日
	 * By 陈伟东
	 * @param dict
	 * @param syncType
	 * @param moduleName
	 * @param batchNo
	 * @return
	 */
	public static SyncDict assembleSyncDict(Dict dict, String syncType, String moduleName, int batchNo){
		SyncDict syncDict = new SyncDict();
		syncDict.setId(IdGen.uuid());
		syncDict.setDictId(dict.getId());
		syncDict.setSyncModuleName(moduleName);
		syncDict.setSyncType(syncType);
		syncDict.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncDict.setBatchNo(batchNo);
		syncDict.setVersionTime(new Date());
		syncDict.setDelFlag(dict.getDelFlag());
		syncDict.setDescription(dict.getDescription());
		syncDict.setLabel(dict.getLabel());
		syncDict.setModifyBy(dict.getModifyBy());
		syncDict.setModifyTime(dict.getModifyTime());
		syncDict.setParentId(dict.getParentId());
		syncDict.setRemarks(dict.getRemarks());
		syncDict.setSort(dict.getSort());
		syncDict.setType(dict.getType());
		syncDict.setValue(dict.getValue());
		syncDict.setSystemFlag(dict.getSystemFlag());
		return syncDict;
	}
	
	/**
	 * 组装同步用户对象
	 * 2015年12月7日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param moduleName
	 * @param batchNo
	 * @return
	 */
	public static SyncUser assembleSyncUser(User user, String syncType, String moduleName, int batchNo){
		SyncUser syncUser = new SyncUser();
		syncUser.setId(IdGen.uuid());
		syncUser.setUserId(user.getId());
		syncUser.setDepartmentId(user.getDepartment().getId());
		syncUser.setSyncModuleName(moduleName);
		syncUser.setSyncType(syncType);
		syncUser.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncUser.setBatchNo(batchNo);
		syncUser.setVersionTime(new Date());
		syncUser.setCallEmpCode(user.getCallEmpCode());
		syncUser.setCreateBy(user.getCreateBy());
		syncUser.setCreateTime(user.getCreateTime());
		syncUser.setDelFlag(user.getDelFlag());
		syncUser.setEmail(user.getEmail());
		syncUser.setEntryTime(user.getEntryTime());
		syncUser.setHasLogin(user.getHasLogin());
		syncUser.setLeaderId(user.getLeaderId());
		syncUser.setLevel(user.getLevel());
		syncUser.setLoginName(user.getLoginName());
		syncUser.setMobile(user.getMobile());
		syncUser.setModifyBy(user.getModifyBy());
		syncUser.setModifyTime(user.getModifyTime());
		syncUser.setName(user.getName());
		syncUser.setPhone(user.getPhone());
		if(SyncType.TYPE_ADD.value.equals(syncType)){
			syncUser.setPosPwd(user.getPosPwd());
		}
		syncUser.setRemarks(user.getRemarks());
		syncUser.setSex(user.getSex());
		syncUser.setStatus(user.getStatus());
		syncUser.setSystemFlag(user.getSystemFlag());
		syncUser.setUserCode(user.getUserCode());
		return syncUser;
	}
	
	/**
	 * 组装需要同步的组织机构对象
	 * 2015年12月4日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param moduleName
	 * @return
	 */
	public static SyncOrg assembleSyncOrg(Org org, String syncType,
			String moduleName, int batchNo) {
		SyncOrg syncOrg = new SyncOrg();
		syncOrg.setId(IdGen.uuid());
		syncOrg.setOrgId(org.getId());
		syncOrg.setParentId(org.getParent().getId());
		syncOrg.setAreaId(org.getArea()!=null ? org.getArea().getId() : "");
		syncOrg.setSyncModuleName(moduleName);
		syncOrg.setSyncType(syncType);
		syncOrg.setSyncStatus(SyncStatus.STATUS_UNDO);
		syncOrg.setVersionTime(new Date());
		syncOrg.setBatchNo(batchNo);
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
		syncOrg.setParentId(org.getParentId());
		syncOrg.setParentIds(org.getParentIds());
		syncOrg.setPartyType(org.getPartyType());
		syncOrg.setPhone(org.getPhone());
		syncOrg.setProvinceId(org.getProvinceId());
		syncOrg.setRemarks(org.getRemarks());
		syncOrg.setSystemFlag(org.getSystemFlag());
		syncOrg.setStoreCode(org.getStoreCode());
		syncOrg.setSort(org.getSort());
		syncOrg.setType(org.getType());
		syncOrg.setUseable(org.getUseable());
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
	public static SyncDataBatch assembleSyncDataBatch(String bizId,
			int batchNo, String moduleName, String tableName,
			String groupKeyDesc, int groupByCase) {
		SyncDataBatch syncBatch = new SyncDataBatch();
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
