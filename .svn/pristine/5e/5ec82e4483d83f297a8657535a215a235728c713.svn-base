package com.creditharmony.core.users.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.ListUtils;
import com.creditharmony.common.util.ObjectHelper;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cache.OrgCache;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.type.DictTypeIndex;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.common.util.RunningNumberHelper;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.dict.util.DictUtils;
import com.creditharmony.core.log.service.OrgLogManager;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.role.type.BaseRole;
import com.creditharmony.core.service.TreeManager;
import com.creditharmony.core.sync.data.dao.SyncDataBatchDao;
import com.creditharmony.core.sync.data.dao.SyncOrgDao;
import com.creditharmony.core.sync.data.entity.SyncDataBatch;
import com.creditharmony.core.sync.data.entity.SyncOrg;
import com.creditharmony.core.sync.data.type.NeedSyncTableName;
import com.creditharmony.core.sync.data.type.SyncBizConstants;
import com.creditharmony.core.sync.data.type.SyncGroupKeyType;
import com.creditharmony.core.sync.data.type.SyncSupportModule;
import com.creditharmony.core.sync.data.type.SyncType;
import com.creditharmony.core.sync.data.util.GroupByCaseType;
import com.creditharmony.core.sync.data.util.SyncAssembleHelper;
import com.creditharmony.core.sync.data.util.ThreeNetAssembleHelper;
import com.creditharmony.core.threenet.dao.ThreeNetDataBatchDao;
import com.creditharmony.core.threenet.dao.ThreeNetOrgDao;
import com.creditharmony.core.threenet.entity.ThreeNetDataBatch;
import com.creditharmony.core.threenet.entity.ThreeNetOrg;
import com.creditharmony.core.type.ModuleName;
import com.creditharmony.core.users.constants.OrgConstants;
import com.creditharmony.core.users.dao.OrgDao;
import com.creditharmony.core.users.dao.UserDao;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.type.BaseDeptOrgType;
import com.creditharmony.core.users.type.LoanOrgType;
import com.creditharmony.core.users.util.UserUtils;

/**
 * 组织机构管理manager
 * @Class Name OrgManager
 * @author 张永生
 * @Create In 2015年12月4日
 */
@Service
public class OrgManager extends TreeManager<OrgDao, Org> {
	
	@Autowired
	private SyncOrgDao syncOrgDao;
	
	@Autowired
	private SyncDataBatchDao syncDataBatchDao;
	
	@Autowired
	private ThreeNetOrgDao threeNetOrgDao;
	
	@Autowired
	private ThreeNetDataBatchDao threeNetDataBatchDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrgLogManager orgLogManager;

	/**
	 * 检索机构
	 * @param org
	 * @return List<Org>
	 */
	public List<Org> selOrg(Org key) {
		return dao.selOrg(key);
	}
	
	/**
	 * 检索机构-下拉列表用
	 * @param key
	 * @param emptyRowFlag
	 * @return Map<String, String>
	 */
	public Map<String, String> getOrgKV(Org key, boolean emptyRowFlag) {
		HashMap<String, String> mapOrg = new LinkedHashMap<String, String>();
		// 取得机构列表
		List<Org> lsOrg = dao.selOrg(key);
		if (ListUtils.isNotEmptyList(lsOrg)) {
			if (emptyRowFlag) {
				mapOrg.put("", "请选择");
			}
			for (int i = 0; i < lsOrg.size(); i++) {
				Org rec = lsOrg.get(i);
				mapOrg.put(rec.getId(), rec.getName());
			}
		}
		return mapOrg;
	}
	
	/**
	 * 取得机构名称
	 * 
	 * @param storeId
	 * @return Map<String, String>
	 */
	public String getOrgNm(String storeId) {
		String orgNm = "";
		
		Org key = new Org();
		key.setId(storeId);
		
		// 取得机构列表
		List<Org> lsOrg = dao.selOrg(key);
		
		if (ListUtils.isNotEmptyList(lsOrg)) {
			orgNm = lsOrg.get(0).getName();
		}
		
		return orgNm;
	}
	
	public List<Org> findAll(){
		return UserUtils.getOrgList();
	}

	public List<Org> findList(Boolean isAll){
		if (isAll != null && isAll){
			return UserUtils.getOrgAllList();
		}else{
			return UserUtils.getOrgList();
		}
	}
	
	public List<Org> findList(Org org){
		if(org==null){
			org = new Org();
			org.setParentIds("0,");
		}else{
			org.setParentIds(org.getParentIds()+org.getId()+",");
		}
		return dao.findByParentIdsLike(org);
	}
	
	public List<Org> queryAll(){
		return dao.queryAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Org> findListPage(Page<Org> page, Org org) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
		PageList<Org> pageList = (PageList<Org>)dao.findByParentIdsLike(org,pageBounds);
		for(Org orgItem : pageList){
			orgItem.setTypeName(DictUtils.getDict(orgItem.getType(), DictTypeIndex.COM_ORG_TYPE).getLabel());
		}
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	/**
	 * 获取所有未被分派的汇金门店，这些门店可以继续分派给合同。
	 * 
	 * 2015年12月24日
	 * By 陈伟东
	 * @return
	 */
	public Page<Org> findStoresNotAssigned(Page<Org> page,Org org){
		org.setType(LoanOrgType.STORE.key);
		org.setDelFlag(DeleteFlagType.NORMAL);
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("org", org);
		map.put("area", org.getArea());
		map.put("sourceType", org.getSourceType());
		PageList<Org> pageList = (PageList<Org>)dao.findStoresNotAssigned(map,pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	/**
	 * 获取所有门店
	 * 2015年12月24日
	 * By 陈伟东
	 * @return
	 */
	public List<Org> findAllStores(){
		Org org = new Org();
		org.setDelFlag(DeleteFlagType.NORMAL);
		org.setType(LoanOrgType.STORE.key);
		return dao.findOrgsByParams(org);
	}
	
	/**
	 * 获取有出借人服务部合同审核组组长角色，且当前所在组织机构在相应小组的所有未分派给组员的门店
	 * 2016年1月14日
	 * By 陈伟东
	 * @param user 含包含当前登陆人id,当前登陆人当前机构id、机构类型、角色类型
	 * @param org 表单查询条件 门店名称、区域名称
	 * @param orgType 机构类型key，可选参数合同审核小组key 和 利率审核小组key，参见BaseDeptOrgType.java
	 * @param leaderRoleType 组长角色类型key，可选参数合同审核小组组长角色类型的id 和 利率审核小组组长角色类型的id，参见BaseRoleType.java
	 * @return
	 */
	public Page<Org> findContractGroupStoresNotAssigned(Page<Org> page,User user,Org org,String orgType,String leaderRoleType){
		Org org2 = user.getDepartment();
		org2.setDelFlag(DeleteFlagType.NORMAL);
		org2.setType(BaseDeptOrgType.CONTRACT_APPROVE_TEAM.key);
		org2.setType(orgType);

		Role role = new Role();
		role.setRoleType(leaderRoleType);
		
		Map<String,  Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("org", user.getDepartment());
		map.put("role", role);
		map.put("area", org.getArea());
		map.put("store", org);
		map.put("sourceType", org.getSourceType());
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
		PageList<Org> pageList = (PageList<Org>)dao.findContractGroupStoresNotAssigned(map,pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	/**
	 * 获取有出借人服务部合同审核组组长角色，且当前所在组织机构在相应小组的所有门店
	 * 2016年1月14日
	 * By 陈伟东
	 * @param user 含包含当前登陆人id,当前登陆人当前机构id、机构类型、角色类型
	 * @return
	 */
	public List<Org> getContractGroupStores(User user){
		return getGroupStores(user,BaseDeptOrgType.CONTRACT_APPROVE_TEAM.key,BaseRole.CONTRACT_APPROVE_LEADER_ROLE_TYPE.id);
	}
	
	/**
	 * 
	 * 审核小组组长获取审核小组分派的所有门店
	 * 2016年1月14日
	 * By 陈伟东
	 * @param user 含包含当前登陆人id,当前登陆人当前机构id、机构类型、角色类型
	 * @param deptOrgTypeKey  机构类型key，参见BaseDeptOrgType。
	 * @param roleTypeId  角色类型id，参见BaseRoleType
	 * @return
	 */
	public List<Org> getGroupStores(User user,String deptOrgTypeKey,String roleTypeId){
		Org org2 = user.getDepartment();
		org2.setDelFlag(DeleteFlagType.NORMAL);
		org2.setType(deptOrgTypeKey);
		
		Role role = new Role();
		role.setRoleType(roleTypeId);
		
		Map<String,  Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("org", user.getDepartment());
		map.put("role", role);
		List<Org> contractGroupStores = dao.getContractGroupStores(map);
		return contractGroupStores;
	}
	
	/**
	 * 获取所有惠民出借人服务部合同审核组各个小组
	 * 2016年1月14日
	 * By 陈伟东
	 * @return
	 */
	public List<Org> findAllContractGroup(){
		return findAllGroup(BaseDeptOrgType.CONTRACT_APPROVE_TEAM.key,DeleteFlagType.NORMAL);
	}
	
	/**
	 * 查找审核小组
	 * 2016年2月2日
	 * By 陈伟东
	 * @param deptOrgType  机构类型key，参见BaseDeptOrgType
	 * @param deleteFlagType 删除标记类型，参见DeleteFlagType
	 * @return
	 */
	public List<Org> findAllGroup(String deptOrgType,String deleteFlagType){
		Org org = new Org();
		org.setType(deptOrgType);
		org.setDelFlag(deleteFlagType);
		return dao.findOrgsByParams(org);
	}
	
	/**
	 * 获取所有门店（分页）
	 * 2015年12月30日
	 * By 何军
	 * @return
	 */
	public Page<Org> findStoresPage(Page<Org> page,Org org){
		org.setDelFlag(DeleteFlagType.NORMAL);
		org.setType(LoanOrgType.STORE.key);
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
		PageList<Org> pageList = (PageList<Org>)dao.findOrgsByParams(org,pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	/**
	 * 获取所有门店（分页）
	 * 2015年12月30日
	 * By 赵红江
	 * @return
	 */
	public Page<Org> findStoresPage(Page<Org> page,Org org , String bussinessType){
		org.setDelFlag(DeleteFlagType.NORMAL);
		org.setType(bussinessType);
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
		PageList<Org> pageList = (PageList<Org>)dao.findOrgsByParams(org,pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	/**
	 * 检索员工关联机构
	 * @param userId
	 * @return List<Org>
	 */
	public List<Org> selUserSubOrg(String orgId, String orgType){
		Org org = new Org();
		org.setParentIds(orgId);
		org.setType(orgType);
		return dao.selUserSubOrg(org);
	}
	
	public List<Org> findByParams(Org org){
		Map<String,Object> queryMap = new HashMap<String,Object>();
		if(org==null){
			queryMap.put("parentIds", "0,%");
		}else{
			queryMap.put("id", org.getId());
			queryMap.put("rootParentId", OrgConstants.ORG_ROOT_ID);
		}
		return dao.findByParams(queryMap);
	}
	
	public Org getOrg(Map<String, Object> params){
		return dao.getByParams(params);
	}
	
	public List<Org> findByCode(Map<String, Object> params){
		return dao.findByCode(params);
	}
	
	public List<Org> loadOrg (String parentId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		params.put("parentId", parentId);
		List<Org> orgList = dao.loadByParams(params);
		return orgList;
	}
	
	@Transactional(readOnly = false)
	public void save(Org org) {
		boolean isNewRecord = false;
		String type="2";
		List<Org> list =new ArrayList<Org>();
		if(StringUtils.isBlank(org.getId())){
			isNewRecord = true;
			type="1";
		}
		//是否修改了所属机构
		boolean isModifyParentId = false;
		//是否修改了机构状态:可用，不可用
		boolean isModifyStatus = false;
		Org cachedOrg = new Org();
		if(!isNewRecord){	
			Org o=new Org();
			o.setParentIds("%,"+org.getId()+",%");
			list = dao.findByParentIdsLike(o);
			cachedOrg = getOrg(org.getId());
			if(ObjectHelper.isNotEmpty(cachedOrg)){
				if(!ObjectHelper.isEmpty(cachedOrg.getParent())){
					if(!cachedOrg.getParent().getId().equals(org.getParent().getId())){
						isModifyParentId = true;
					}
				}
				if(!org.getUseable().equals(cachedOrg.getUseable())){
					isModifyStatus = true;
				}
			}
		}
			
		super.save(org);
		
		Org orgNew = getOrg(org.getId());
		orgLogManager.insertOrgLog(cachedOrg, orgNew, type);
		
		for(Org oc:list){
			Org orgCNew = getOrg(oc.getId());
			orgLogManager.insertOrgLog(oc, orgCNew, type);
		}
		
		if(isModifyStatus){
			if(Global.NO.equals(org.getUseable())){  
				//机构状态由可用修改为不可用,设置该机构下所有的子机构要设置为冻结即不可用状态
				isModifyParentId = saveChildrenOrgWhenForzenOrg(org, isModifyParentId);
			}else{  
				//机构状态由不可用修改为可用,设置该机构下所有的子机构要设置为可用状态
				isModifyParentId = saveChildrenOrgWhenActiveOrg(org, isModifyParentId);
			}
		}
		String syncType = isNewRecord ? SyncType.TYPE_ADD.value : SyncType.TYPE_MODIFY.value;
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncOrg);
		saveSyncOrg(org, syncType, batchNo);
		saveThreeNetOrgData(org, syncType);
//		updateUserFrozen(org.getFrozenUser(),org);
		if(isModifyParentId){ //修改了parentId,清理缓存
			saveSyncChildOrg(org);
			RedisUtils.remove(Org.class.getName());
		}
	}

	/**
	 * 激活机构时，保存该机构下所有的子机构，使子机构也是激活状态
	 * 2016年5月23日
	 * By 张永生
	 * @param org
	 * @param isModifyParentId
	 * @return
	 */
	public boolean saveChildrenOrgWhenActiveOrg(Org org,
			boolean isModifyParentId) {
		Org orgN = new Org();
		orgN.setParentIds(org.getParentIds()+org.getId()+",");
		List<Org> orgList = selOrg(orgN);
		int i = 0 ;
		for (Org orgU : orgList) {
			if(Global.YES.equals(orgU.getUseable())){ continue;}
			i++;
			orgU.setUseable(Global.YES);
			orgU.setFrozenUser(Global.NO);
			Org cachedOrg = getOrg(orgU.getId());
			if(!ObjectHelper.isEmpty(cachedOrg.getParent())){
				if(!cachedOrg.getParent().getId().equals(orgU.getParent().getId())){
					isModifyParentId = true;
				}
			}
			super.save(orgU);
			Org orgNew = getOrg(orgU.getId());
			orgLogManager.insertOrgLog(cachedOrg, orgNew, "2");
			String syncType = SyncType.TYPE_MODIFY.value;
			int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncOrg);
			saveSyncOrg(orgU, syncType, batchNo);
			saveThreeNetOrgData(orgU, syncType);
		}
		if(i>0){
			RedisUtils.remove(Org.class.getName());
		}
		return isModifyParentId;
	}

	/**
	 * 冻结机构时，保存该机构下所有的子机构，使子机构也是冻结状态
	 * 2016年5月23日
	 * By 张永生
	 * @param org
	 * @param isModifyParentId
	 * @return
	 */
	public boolean saveChildrenOrgWhenForzenOrg(Org org, boolean isModifyParentId) {
		Org orgN = new Org();
		orgN.setParentIds(org.getParentIds() + org.getId() + ",");
		List<Org> orgList = selOrg(orgN);
		int i = 0;
		for (Org orgU : orgList) {
			if (Global.NO.equals(orgU.getUseable())) {  //机构冻结
				continue;
			}
			i++;
			orgU.setUseable(Global.NO);
			orgU.setFrozenUser(Global.YES);
			Org cachedOrg = getOrg(orgU.getId());
			if(!ObjectHelper.isEmpty(cachedOrg.getParent())){
				if(!cachedOrg.getParent().getId().equals(orgU.getParent().getId())){
					isModifyParentId = true;
				}
			}
			super.save(orgU);
			Org orgNew = getOrg(orgU.getId());
			orgLogManager.insertOrgLog(cachedOrg, orgNew, "2");
			String syncType = SyncType.TYPE_MODIFY.value;
			int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncOrg);
			saveSyncOrg(orgU, syncType, batchNo);
			saveThreeNetOrgData(orgU, syncType);
		}
		if(i>0){
			RedisUtils.remove(Org.class.getName());
		}
		return isModifyParentId;
	}

	/**
	 * 保存同步的子机构
	 * 2016年3月8日
	 * By 张永生
	 * @param org
	 */
	@Transactional(readOnly = false)
	public void saveSyncChildOrg(Org org) {
		Org o = new Org();
		o.setParentIds("%,"+org.getId()+",%");
		List<Org> childList = dao.findByParentIdsLike(o);
		for (Org childOrg : childList){
			int batch = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncOrg);
			saveSyncOrg(childOrg, SyncType.TYPE_MODIFY.value, batch);
			saveThreeNetOrgData(childOrg, SyncType.TYPE_MODIFY.value);
		}
	}
	
	@Transactional(readOnly = false)
	public void updateCarLoanCode(String orgId, String carLoanCode) {
		Org org = get(orgId);   
		org.setCarLoanCode(carLoanCode);
		dao.updateCarLoanCode(org);
		String syncType = SyncType.TYPE_MODIFY.value;
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncOrg);
		saveSyncOrg(org, syncType, batchNo);
		saveThreeNetOrgData(org, syncType);
		Org cachedOrg = OrgCache.getInstance().get(orgId);
		cachedOrg.setCarLoanCode(carLoanCode);
		OrgCache.getInstance().save(cachedOrg);
	}
	
	@Transactional(readOnly = false)
	public void delete(Org org) {
		Org oldOrg=dao.get(org);
		super.delete(org);
		Org newOrg=dao.get(org);
		orgLogManager.insertOrgLog(oldOrg, newOrg, "3");
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncOrg);
		String syncType = SyncType.TYPE_DELETE.value;
		saveSyncOrg(org, syncType, batchNo);
		saveThreeNetOrgData(org, syncType);
	}

	@Transactional(readOnly = false)
	private void saveThreeNetOrgData(Org org, String syncType) {
		int threeNetBatchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.ThreeNetOrg);
		saveThreeNetOrg(org, syncType, threeNetBatchNo);
	}
	
	/**
	 * 保存需要同步的组织机构
	 * 2015年12月16日
	 * By 张永生
	 * @param org
	 * @param syncType
	 * @param batchNo
	 */
	@Transactional(readOnly = false)
	public void saveSyncOrg(Org org, String syncType, int batchNo) {
		for (Map.Entry<String, String> entry : SyncSupportModule.getSupportModule().entrySet()) {
			SyncDataBatch syncDataBatch = SyncAssembleHelper
					.assembleSyncDataBatch(org.getId(), batchNo,
							entry.getValue(),
							NeedSyncTableName.SYNC_ORG.value,
							SyncGroupKeyType.ORGID_MODULENAME,
							GroupByCaseType.CASE_ORG);
			syncDataBatchDao.insert(syncDataBatch);
			SyncOrg syncOrg = SyncAssembleHelper.assembleSyncOrg(org, syncType, entry.getValue(), batchNo);
			syncOrgDao.insert(syncOrg);
		}
	}
	
	/**
	 * 保存三网需要同步的组织机构
	 * 2015年12月16日
	 * By 张永生
	 * @param org
	 * @param syncType
	 * @param batchNo
	 */
	@Transactional(readOnly = false)
	public void saveThreeNetOrg(Org org, String syncType, int batchNo) {
			ThreeNetDataBatch threeNetDataBatch = ThreeNetAssembleHelper
					.assembleSyncDataBatch(org.getId(), batchNo,
							ModuleName.MODULE_FORTUNE.value,
							NeedSyncTableName.THREENET_ORG.value,
							SyncGroupKeyType.ORGID_MODULENAME,
							GroupByCaseType.CASE_ORG);
			threeNetDataBatchDao.insert(threeNetDataBatch);
			ThreeNetOrg threeNetOrg = ThreeNetAssembleHelper.assembleSyncOrg(org, syncType,
				ModuleName.MODULE_FORTUNE.value, batchNo);
			threeNetOrgDao.insert(threeNetOrg);
	}
	
	public List<Map<String,String>> selUserOrgByUserId(String userId){
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("useable",  Global.YES);
		return dao.selUserOrgByUserId(params);
	}
	
	@Transactional(readOnly = false)
	public void updateUserFrozen(String status,Org org){
		Map<String,Object> params = new HashMap<String,Object>();
		String whereStatus = "1".equals(status) ? Global.YES : Global.IS_FROZEN;
		status = "1".equals(status)?Global.IS_FROZEN:Global.YES;
		params.put("delFlag",BaseEntity.DEL_FLAG_NORMAL);
		params.put("status", status);
		params.put("whereStatus", whereStatus);
		params.put("orgId", org.getId());
		params.put("parentIds", org.getParentIds()+org.getId()+",");
		userDao.updateUserFrozen(params);
	}
	
	/**
	 * 根据ID获取机构
	 * 2016年6月27日
	 * By 张永生
	 * @param id
	 * @return
	 */
	public Org getOrg(String id){
		return dao.get(id);
	}
	

	@Transactional(readOnly = true)
	public Page<Org> findForPage(Page<Org> page, Org org) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
		PageList<Org> pageList = (PageList<Org>)dao.findByParentIds(org,pageBounds);
		for(Org orgItem : pageList){
			orgItem.setTypeName(DictUtils.getDict(orgItem.getType(), DictTypeIndex.COM_ORG_TYPE).getLabel());
		}
        PageUtil.convertPage(pageList, page);
        return page;
	}

	public boolean getIpConfigBystoreCode(String storeCode) {
		Org org = new Org();
		org.setDelFlag(DeleteFlagType.NORMAL);
		org.setStoreCode(storeCode);
		List<Org> list = dao.findIpConfigByStoreCode(org);
		return ListUtils.isNotEmptyList(list) ? true : false;
	}
	/**
	 * 指定机构id查出所有的下属
	 * zmq
	 * @param children
	 * @return
	 */
	public List<Org> getOrgByParentIds(String parentIds){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		params.put("parentIds", parentIds);
		params.put("type", LoanOrgType.STORE.key);
		List<Org> orgList = dao.getOrgByParentIds(params);
		return orgList;
	}
	/**
	 * 指定机构id查出所有的下属与得到的storeOrgId是否包含在内
	 * zmq
	 * @param children
	 * @return
	 */
	public List<Org> getOrgByParentIdsAndStoreOrgId(String parentIds,String storeOrgId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		params.put("parentIds", parentIds);
		params.put("type", LoanOrgType.STORE.key);
		params.put("id", storeOrgId);
		List<Org> orgList = dao.getOrgByParentIdsAndStoreOrgId(params);
		return orgList;
	}
	
	/**
	 * 根据省、市、区、机构类型查机构
	 * By 任志远 2017年3月9日
	 *
	 * @param parentIds
	 * @param storeOrgId
	 * @return
	 */
	public List<Org> getOrgByTypeAndProvinceAndCityAndDistrict(String provinceId, String cityId, String districtId, LoanOrgType type){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", type.key);
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		params.put("provinceId", provinceId);
		params.put("cityId", cityId);
		params.put("districtId", districtId);
		List<Org> orgList = dao.getOrgByTypeAndProvinceAndCityAndDistrict(params);
		return orgList;
	}
}
