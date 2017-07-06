package com.creditharmony.core.users.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.cache.redis.util.RedisUtils;
import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.MD5Util;
import com.creditharmony.core.cache.UserCache;
import com.creditharmony.core.common.type.ActionType;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.type.DictTypeIndex;
import com.creditharmony.core.common.type.HandleType;
import com.creditharmony.core.common.type.SymbolConstant;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.common.util.RunningNumberHelper;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.dict.util.DictUtils;
import com.creditharmony.core.exception.LdapException;
import com.creditharmony.core.exception.code.LdapExceptionCode;
import com.creditharmony.core.loan.type.YESNO;
import com.creditharmony.core.log.service.UserLogManager;
import com.creditharmony.core.log.service.UserRoleOrgLogManager;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.sync.data.dao.SyncDataBatchDao;
import com.creditharmony.core.sync.data.dao.SyncUserDao;
import com.creditharmony.core.sync.data.dao.SyncUserRoleOrgDao;
import com.creditharmony.core.sync.data.entity.SyncDataBatch;
import com.creditharmony.core.sync.data.entity.SyncUser;
import com.creditharmony.core.sync.data.entity.SyncUserRoleOrg;
import com.creditharmony.core.sync.data.type.NeedSyncTableName;
import com.creditharmony.core.sync.data.type.SyncBizConstants;
import com.creditharmony.core.sync.data.type.SyncGroupKeyType;
import com.creditharmony.core.sync.data.type.SyncSupportModule;
import com.creditharmony.core.sync.data.type.SyncType;
import com.creditharmony.core.sync.data.util.GroupByCaseType;
import com.creditharmony.core.sync.data.util.SyncAssembleHelper;
import com.creditharmony.core.sync.data.util.ThreeNetAssembleHelper;
import com.creditharmony.core.threenet.dao.ThreeNetDataBatchDao;
import com.creditharmony.core.threenet.dao.ThreeNetUserDao;
import com.creditharmony.core.threenet.entity.ThreeNetDataBatch;
import com.creditharmony.core.threenet.entity.ThreeNetUser;
import com.creditharmony.core.type.ModuleName;
import com.creditharmony.core.type.PartyType;
import com.creditharmony.core.users.constants.PosPassword;
import com.creditharmony.core.users.dao.OrgDao;
import com.creditharmony.core.users.dao.RoleDao;
import com.creditharmony.core.users.dao.UserDao;
import com.creditharmony.core.users.dao.UserRoleOrgDao;
import com.creditharmony.core.users.dto.ThreeNetUserDto;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.entity.UserRoleOrg;
import com.creditharmony.core.users.type.BaseDeptOrgType;
import com.creditharmony.core.users.type.ParameterSupport;
import com.creditharmony.core.users.type.UserStatus;
import com.creditharmony.core.users.util.CallLdapHelper;
import com.creditharmony.core.users.util.LdapLoggerHelper;
import com.creditharmony.core.users.util.PasswordUtil;
import com.creditharmony.core.users.util.SyncLdapUserHelper;
import com.creditharmony.core.users.util.SyncLdapUserPositionHelper;
import com.creditharmony.core.users.util.SystemFlagHelper;
import com.creditharmony.core.users.util.UserParameterHelper;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.ldap.constants.LdapConstants;
import com.creditharmony.ldap.handler.LdapDataHandlerFactory;
import com.creditharmony.ldap.vo.VoSyncUser;
import com.creditharmony.ldap.vo.VoSyncUserPosition;
import com.google.common.collect.Maps;

/**
 * 用户服务类
 * @Class Name UserManager
 * @author 张永生
 * @Create In 2015年12月4日
 */
@Service
public class UserManager extends CoreManager<UserDao, User> {
	protected Logger logger = LoggerFactory.getLogger(UserManager.class);
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private OrgDao orgDao;
	@Autowired
	private UserRoleOrgDao userRoleOrgDao;
	@Autowired
	private SyncUserDao syncUserDao;
	@Autowired
	private SyncUserRoleOrgDao syncUserRoleOrgDao;
	@Autowired
	private SyncDataBatchDao syncDataBatchDao;
	@Autowired
	private ThreeNetUserDao threeNetUserDao;
	@Autowired
	private ThreeNetDataBatchDao threeNetDataBatchDao;
	@Autowired
	private UserRoleOrgLogManager userRoleOrgLogManager;
	@Autowired
	private UserLogManager userLogManager;
	
	public static final String SPLIT_CHAR = ":";

	public User getUser(String id) {
		User user = get(new User(id));
		if (user == null){
			return null;
		}
		UserRoleOrg userRoleOrg = new UserRoleOrg();
		userRoleOrg.setUserId(id);
		if(null!=user.getDepartment()){
			userRoleOrg.setOrgId(user.getDepartment().getId());
		}
		userRoleOrg.setOrgUseable(Global.YES);
		List<UserRoleOrg> list = userRoleOrgDao.selUserRoleOrg(userRoleOrg);
		user.getUserRoleOrgList().clear();
		user.getUserRoleOrgList().addAll(list);
		return user;
	}
	
	/**
	 * 根据用户ID从数据库中查找用户
	 * 用于修正迁移过来的用户数据没有机构的情况或者机构id不正确
	 * 2016年6月27日
	 * By 张永生
	 * @param id
	 * @return
	 */
	public User getUserFromDb(String id) {
		User user = getUserById(id);
		if (user == null){
			return null;
		}
		UserRoleOrg userRoleOrg = new UserRoleOrg();
		userRoleOrg.setUserId(id);
		if(null!=user.getDepartment()){
			userRoleOrg.setOrgId(user.getDepartment().getId());
		}
		userRoleOrg.setOrgUseable(Global.YES);
		List<UserRoleOrg> list = userRoleOrgDao.selUserRoleOrg(userRoleOrg);
		user.getUserRoleOrgList().clear();
		user.getUserRoleOrgList().addAll(list);
		return user;
	}
	
	public User getUserForOrg(String id) {
		User user = dao.get(id);
		if (user == null){
			return null;
		}
		user.setRoleList(roleDao.findList(new Role(user)));
		List<UserRoleOrg> orgList = queryByUserId(user.getId());
		if(ArrayHelper.isNotEmpty(orgList)){
			user.setUserRoleOrgList(orgList);
		}
		return user;
	}
	
	public List<User> getAllGroupMembers(){
		Org org = new Org();
		org.setType(BaseDeptOrgType.CONTRACT_APPROVE_TEAM.key);
		List<User> allGroupMembers = dao.getAllGroupMembers(org);
		return allGroupMembers;
	}
	
	/**
	 * 获取指定机构的所有组员
	 * 2016年2月2日
	 * By 陈伟东
	 * @param deptOrgTypeKey 机构类型key。 参见BaseDeptOrgType
	 * @return
	 */
	public List<User> getAllGroupMembers(String deptOrgTypeKey){
		Org org = new Org();
		org.setType(deptOrgTypeKey);
		List<User> allGroupMembers = dao.getAllGroupMembers(org);
		return allGroupMembers;
	}
	
	public List<User> findAll(){
		return dao.findAllList(new User());
	}

	public Page<User> findUser(Page<User> page, Map<String,Object> filter) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        PageList<User> pageList = (PageList<User>)dao.findByParamsL(filter, pageBounds);
		for (User user : pageList) {
			user.setStatusName(DictUtils.getDictLabel(user.getStatus(),
					DictTypeIndex.COM_USER_STATUS, ""));
		}
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	/**
	 * 上线后，为了对迁移过来的没有部门的用户数据进行修正，特添加此方法
	 * 2016年6月27日
	 * By 张永生
	 * @param page
	 * @param filter
	 * @return
	 */
	public Page<User> findUserByParams(Page<User> page, Map<String,Object> filter) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        PageList<User> pageList = (PageList<User>)dao.findUserByParams(filter, pageBounds);
		for (User user : pageList) {
			user.setStatusName(DictUtils.getDictLabel(user.getStatus(),
					DictTypeIndex.COM_USER_STATUS, ""));
		}
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	public List<User> findByParams(Map<String,Object> filter) {
		return dao.findByParams(filter);
	}
	
	/**
	 * 通过部门ID获取用户列表
	 * 仅返回用户id和name（树查询用户时用）
	 * 2015年12月4日
	 * By 张永生
	 * @param orgId
	 * @return
	 */
	public List<User> findUserByOrgId(String orgId) {
		User user = new User();
		user.setDepartment(new Org(orgId));
		List<User> list = dao.findUserByOrgId(user);
		return list;
	}
	
	/**
	 * 获取组长列表
	 * TODO（目前筛选的是所有人员，需要加入组长条件） 获取所有未分派门店的组长
	 * 2015年12月24日
	 * By 陈伟东
	 * @return
	 */
	public List<User> findGroupLeaders(){
		User user = new User();
		user.setDelFlag(DeleteFlagType.NORMAL);
		List<User> users = dao.findUsersByParams(user);
		return users;
	}
	
	/**
	 * 获取合同审核小组组员
	 * 2016年1月14日
	 * By 陈伟东
	 * @param user 含有机构id
	 * @return
	 */
	public List<User> findContractGroupMember(User user){
		return findGroupMember(user,BaseDeptOrgType.CONTRACT_APPROVE_TEAM.key);
	}
	/**
	 * 获取审核小组组员
	 * 2016年1月14日
	 * By 陈伟东
	 * @param user 含有机构id
	 * @param deptOrgTypeKey 组织机构类型key。参见BaseDeptOrgType
	 * @return
	 */
	public List<User> findGroupMember(User user,String deptOrgTypeKey){
		user.setDelFlag(DeleteFlagType.NORMAL);
		user.getDepartment().setType(deptOrgTypeKey);
		List<User> users = dao.findContractGroupMember(user);
		return users;
	}
	
	public boolean isUserCodeExisted(String userCode) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userCode", userCode);
		queryMap.put("deleteFlag", DeleteFlagType.NORMAL);
		List<User> userList = dao.findByParams(queryMap);
		return ArrayHelper.isNotEmpty(userList) ? true : false;
	}
	/**
	 * 查询用户是否在tds中存在
	 * 2016年1月31日
	 * By 周树华
	 * @param user 用户对象
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean isExistInTDS(User user){
		int handleType = HandleType.QUERY;
		ParameterSupport paramSupport = UserParameterHelper.getParameterSupport(handleType);
		try{
			syncUserToLdap(user, paramSupport, null);
			return false;
		}catch(Exception e){
			if(LdapExceptionCode.USER_IS_EXIST_DESC.equals(e.getMessage()))
				return true;
		}
		return false;
	}
	
	/**
	 * 查询用户是否在db中存在
	 * 2016年1月31日
	 * By 周树华
	 * @param user 用户对象
	 * @return
	 */
	public boolean isExistInDB(User user){
		User userN = dao.get(user.getId());
		if(null != userN){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 检查用户是否存在于数据库中
	 * 用于修正迁移过来的用户数据,处理没有机构的用户
	 * 2016年6月27日
	 * By 张永生
	 * @param user
	 * @return
	 */
	public boolean checkUserIsExist(User user){
		User userN = dao.getUserById(user.getId());
		if(null != userN){
			return true;
		}else{
			return false;
		}
	}
	
	@Transactional(readOnly = false)
	public void save(User user) {
		String syncBizType = null;   		      //同步到业务模块(汇金汇诚和财富)的数据类型
		String methodName = null;
		user.setIsNewRecord(true);
		Org dept = orgDao.get(new Org(user.getDepartment().getId()));
		user.getDepartment().setName(dept!=null ? dept.getName() : "");
		user.setId(user.getLoginName());
		user.setLoginName(user.getLoginName().toLowerCase());
		user.setSystemFlag(SystemFlagHelper.getSystemFlag(dept != null ? dept.getPartyType() : ""));
		boolean isExisted = isExistInDB(user);
		String oldOrgId = null;  //用户修改前，所属机构Id
		User oldUser=new User();
		String type="2";
		if(isExisted){//数据库中已有该用户
			oldUser = UserCache.getInstance().get(user.getId());
			Org oldOrg = oldUser.getDepartment();
			oldOrgId = oldOrg != null ? oldOrg.getId() : "";
			user.preUpdate();
			dao.update(user);
			syncBizType = SyncType.TYPE_MODIFY.value;
		}else{//数据库中没有该用户
			type="1";
			user.preInsert();
			if(PartyType.HUIJIN.value.equals(dept!=null ? dept.getPartyType() : "")){
				user.setPosPwd(MD5Util.string2MD5(PosPassword.DEFAULT_PASSWORD));
			}
			user.setPassword(SystemConfigConstant.DEFAULT_USER_PASSWORD);
			dao.insert(user);
			syncBizType = SyncType.TYPE_ADD.value;
		}
		User newUser=dao.get(user.getId());
		userLogManager.insertUserLog(oldUser, newUser, type);		

		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUser);
		saveSyncUser(user, syncBizType, batchNo);
		//保存用户到三网用户表
		//saveUser2ThreeNet(user, syncBizType);
		int handleType;
		if(isExistInTDS(user)){  //TDS中已有该用户
			handleType = HandleType.UPDATE;
			methodName = "updateUser";
		}else{
			handleType = HandleType.INSERT;
			methodName = "saveUser";
		}
		switch(handleType){
			case HandleType.UPDATE:
				break;
			case HandleType.INSERT:
				ParameterSupport parameterSupport = UserParameterHelper.getParameterSupport(handleType);
				parameterSupport.setExtMsg("userName:"+ user.getName());
				parameterSupport.setMethodName(methodName);
				syncUserToLdap(user, parameterSupport, SystemConfigConstant.DEFAULT_USER_PASSWORD);
				break;
		}
		saveUserRoleOrg(user, oldOrgId);
	}
	
	/**
	 * 保存用户
	 * 此方法提供给用户批量导入时使用
	 * 因为用户批量异动的情况是要删除用户所有的角色，然后再保存新的角色。
	 * 2016年6月21日
	 * By 张永生
	 * @param user
	 */
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		String syncBizType = null;   		      //同步到业务模块(汇金汇诚和财富)的数据类型
		String methodName = null;
		user.setIsNewRecord(true);
		Org dept = orgDao.get(new Org(user.getDepartment().getId()));
		user.getDepartment().setName(dept!=null ? dept.getName() : "");
		user.setId(user.getLoginName());
		user.setLoginName(user.getLoginName().toLowerCase());
		user.setSystemFlag(SystemFlagHelper.getSystemFlag(dept != null ? dept.getPartyType() : ""));
		boolean isExisted = isExistInDB(user);
		User oldUser=new User();
		String type="2";
		if(isExisted){//数据库中已有该用户
			oldUser=dao.get(user.getId());
			user.preUpdate();
			dao.update(user);
			syncBizType = SyncType.TYPE_MODIFY.value;
		}else{//数据库中没有该用户
			type="1";
			user.preInsert();
			if(PartyType.HUIJIN.value.equals(dept!=null ? dept.getPartyType() : "")){
				user.setPosPwd(MD5Util.string2MD5(PosPassword.DEFAULT_PASSWORD));
			}
			user.setPassword(SystemConfigConstant.DEFAULT_USER_PASSWORD);
			dao.insert(user);
			syncBizType = SyncType.TYPE_ADD.value;
		}
		User newUser=dao.get(user.getId());
		userLogManager.insertUserLog(oldUser, newUser, type);	
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUser);
		saveSyncUser(user, syncBizType, batchNo);
		//保存用户到三网用户表
		// saveUser2ThreeNet(user, syncBizType);
		int handleType;
		if(isExistInTDS(user)){  //TDS中已有该用户
			handleType = HandleType.UPDATE;
			methodName = "updateUser";
		}else{
			handleType = HandleType.INSERT;
			methodName = "saveUser";
		}
		switch(handleType){
			case HandleType.UPDATE:
				break;
			case HandleType.INSERT:
				ParameterSupport parameterSupport = UserParameterHelper.getParameterSupport(handleType);
				parameterSupport.setExtMsg("userName:"+ user.getName());
				parameterSupport.setMethodName(methodName);
				syncUserToLdap(user, parameterSupport, SystemConfigConstant.DEFAULT_USER_PASSWORD);
				break;
		}
		saveUserRoleOrg(user);
	}
	
	/**
	 * 修正从2.0迁移过来的数据时，保存用户时调用该方法
	 * 其他场景不要调用该方法保存用户
	 * 2016年6月27日
	 * By 张永生
	 * @param user
	 */
	@Transactional(readOnly = false)
	public void saveUserWhenRecorrect(User user) {
		String syncBizType = null;   		      //同步到业务模块(汇金汇诚和财富)的数据类型
		String methodName = null;
		user.setIsNewRecord(true);
		Org dept = orgDao.get(new Org(user.getDepartment().getId()));
		user.getDepartment().setName(dept!=null ? dept.getName() : "");
		user.setId(user.getLoginName());
		user.setLoginName(user.getLoginName().toLowerCase());
		user.setSystemFlag(SystemFlagHelper.getSystemFlag(dept != null ? dept.getPartyType() : ""));
		boolean isExisted = checkUserIsExist(user);
		String oldOrgId = null;  //用户修改前，所属机构Id
		if(isExisted){//数据库中已有该用户
			User oldUser = dao.getUserById(user.getId());
			Org oldOrg = oldUser.getDepartment();
			oldOrgId = oldOrg != null ? oldOrg.getId() : "";
			user.preUpdate();
			dao.update(user);
			syncBizType = SyncType.TYPE_MODIFY.value;
		}else{//数据库中没有该用户
			user.preInsert();
			if(PartyType.HUIJIN.value.equals(dept!=null ? dept.getPartyType() : "")){
				user.setPosPwd(MD5Util.string2MD5(PosPassword.DEFAULT_PASSWORD));
			}
			user.setPassword(SystemConfigConstant.DEFAULT_USER_PASSWORD);
			dao.insert(user);
			syncBizType = SyncType.TYPE_ADD.value;
		}
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUser);
		saveSyncUser(user, syncBizType, batchNo);
		//保存用户到三网用户表
		//saveUser2ThreeNet(user, syncBizType);
		int handleType;
		if(isExistInTDS(user)){  //TDS中已有该用户
			handleType = HandleType.UPDATE;
			methodName = "updateUser";
		}else{
			handleType = HandleType.INSERT;
			methodName = "saveUser";
		}
		switch(handleType){
			case HandleType.UPDATE:
				break;
			case HandleType.INSERT:
				ParameterSupport parameterSupport = UserParameterHelper.getParameterSupport(handleType);
				parameterSupport.setExtMsg("userName:"+ user.getName());
				parameterSupport.setMethodName(methodName);
				syncUserToLdap(user, parameterSupport, SystemConfigConstant.DEFAULT_USER_PASSWORD);
				break;
		}
		saveUserRoleOrg(user, oldOrgId);
	}

	/**
	 * 保存用户到三网
	 * 即同步用户到财富系统
	 * 由财富系统通过接口发送数据给三网
	 * 2016年3月2日
	 * By 张永生
	 * @param user
	 * @param syncBizType
	 */
	@Transactional(readOnly = false)
	public void saveUser2ThreeNet(User user, String syncBizType) {
		String deptId = user.getDepartment().getId();
		Org org = orgDao.get(deptId);
		if(PartyType.CAIFU.value.equals(org!=null ? org.getPartyType() : "")){
			int threeNetBatchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.ThreeNetUser);
			saveThreeNetUser(user, syncBizType, threeNetBatchNo);
		}else{
			UserRoleOrg userRoleOrg = new UserRoleOrg();
			userRoleOrg.setUserId(user.getId());
			userRoleOrg.setOrgId(deptId);
			List<UserRoleOrg> uroList = userRoleOrgDao.selUserRoleOrg(userRoleOrg);
			if(ArrayHelper.isNotEmpty(uroList)){
				for(UserRoleOrg  uroItem : uroList){
					Org orgItem = orgDao.get(uroItem.getOrgId());
					if(PartyType.CAIFU.value.equals(orgItem!=null ? orgItem.getPartyType() : "")){
						int threeNetBatchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.ThreeNetUser);
						saveThreeNetUser(user, syncBizType, threeNetBatchNo, orgItem);
						break;
					}
				}
			}
		}
	}

	/**
	 * 保存同步用户对象
	 * 2015年12月7日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param batchNo
	 */
	@Transactional(readOnly = false)
	public void saveSyncUser(User user, String syncType, int batchNo) {
		for(Map.Entry<String, String> entry : SyncSupportModule.getSupportModule().entrySet()){
			SyncDataBatch syncDataBatch = SyncAssembleHelper
					.assembleSyncDataBatch(user.getId(), batchNo,
							entry.getValue(),
							NeedSyncTableName.SYNC_USER.value,
							SyncGroupKeyType.USERID_MODULENAME,
							GroupByCaseType.CASE_USER);
			syncDataBatchDao.insert(syncDataBatch);
			SyncUser syncUser = SyncAssembleHelper.assembleSyncUser(user,
					syncType, entry.getValue(), batchNo);
			syncUserDao.insert(syncUser);
		}
	}
	
	/**
	 * 保存三网用户
	 * 2016年3月1日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param batchNo
	 */
	@Transactional(readOnly = false)
	public void saveThreeNetUser(User user, String syncType, int batchNo) {
			ThreeNetDataBatch dataBatch = ThreeNetAssembleHelper
					.assembleSyncDataBatch(user.getId(), batchNo,
							ModuleName.MODULE_FORTUNE.value,
							NeedSyncTableName.THREENET_USER.value,
							SyncGroupKeyType.USERID_MODULENAME,
							GroupByCaseType.CASE_USER);
			threeNetDataBatchDao.insert(dataBatch);
			ThreeNetUser syncUser = ThreeNetAssembleHelper.assembleSyncUser(user,
					syncType, ModuleName.MODULE_FORTUNE.value, batchNo);
			threeNetUserDao.insert(syncUser);
	}
	
	/**
	 * 主要任职部门不是财富组织机构的用户
	 * 但又在多机构里设置了财富的机构和角色
	 * 例如：汇金用户在财富任职的情况，
	 * 三网要求这样的用户也要同步到三网，
	 * 但是任职部门要设置成财富的机构
	 * 如果某汇金用户在财富中有多个任职，则只取其一传递到三网
	 * 2016年3月30日
	 * By 张永生
	 * @param user
	 * @param syncType
	 * @param batchNo
	 * @param org  财富组织机构
	 */
	@Transactional(readOnly = false)
	public void saveThreeNetUser(User user, String syncType, int batchNo, Org org) {
			ThreeNetDataBatch dataBatch = ThreeNetAssembleHelper
					.assembleSyncDataBatch(user.getId(), batchNo,
							ModuleName.MODULE_FORTUNE.value,
							NeedSyncTableName.THREENET_USER.value,
							SyncGroupKeyType.USERID_MODULENAME,
							GroupByCaseType.CASE_USER);
			threeNetDataBatchDao.insert(dataBatch);
			ThreeNetUser syncUser = ThreeNetAssembleHelper.assembleSyncUser(user,
					syncType, ModuleName.MODULE_FORTUNE.value, batchNo);
			threeNetUserDao.insert(syncUser);
	}

	/**
	 * 保存同步数据批次对象
	 * 2015年12月5日
	 * By 张永生
	 * @param userId
	 * @param batchNo
	 */
	@Transactional(readOnly = false)
	public void saveSyncDataBatch(String userId, int batchNo,
			String tableName, String groupKeyDesc, int groupByCase) {
		for (Map.Entry<String, String> entry : SyncSupportModule
				.getSupportModule().entrySet()) {
			SyncDataBatch batchItem = SyncAssembleHelper.assembleSyncDataBatch(
					userId, batchNo, entry.getValue(), tableName, groupKeyDesc,
					groupByCase);
			syncDataBatchDao.insert(batchItem);
		}
	}

	/**
	 * 保存同步用户角色组织对象
	 * 2015年12月4日
	 * By 张永生
	 * @param userId
	 * @param orgList
	 * @param syncType
	 */
	@Transactional(readOnly = false)
	public void saveSyncUserRoleOrg(User user,
			String syncType, int batchNo) {
		List<UserRoleOrg> userRoleOrgList = user.getUserRoleOrgList();
		for (UserRoleOrg orgItem : userRoleOrgList) {
			for (Map.Entry<String, String> entry : SyncSupportModule
					.getSupportModule().entrySet()) {
				SyncDataBatch syncDataBatch = SyncAssembleHelper
						.assembleSyncDataBatch(user.getId(), batchNo,
								entry.getValue(),
								NeedSyncTableName.SYNC_USER_ROLE_ORG.value,
								SyncGroupKeyType.USERID_MODULENAME,
								GroupByCaseType.CASE_USER_ROLE_ORG);
				syncDataBatchDao.insert(syncDataBatch);
				SyncUserRoleOrg syncUserRoleOrg = SyncAssembleHelper
						.assembleSyncUserRoleOrg(user.getId(), orgItem.getOrgId(),orgItem.getRoleId(), syncType,
								entry.getValue(), batchNo);
				syncUserRoleOrgDao.insert(syncUserRoleOrg);
			}
		}
	}
	
	public List<Org> queryOrg(String userId) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		List<Org> orgList = orgDao.queryByParams(params);
		return orgList;
	}
	
	public List<UserRoleOrg> queryByUserId(String userId) {
		UserRoleOrg userRoleOrg = new UserRoleOrg();
		userRoleOrg.setUserId(userId);
		List<UserRoleOrg> orgList = userRoleOrgDao.selUserRoleOrg(userRoleOrg);
		List<UserRoleOrg> orgNewList = new ArrayList<UserRoleOrg>();
		Set<String> orgIdSet = new HashSet<String>();
		for(UserRoleOrg userRoleOrgN:orgList){
			String orgId = userRoleOrgN.getOrgId();
			if(orgIdSet.contains(orgId)){
				continue;
			}
			orgIdSet.add(orgId);
			List<Role> roles = new ArrayList<Role>();
			for(UserRoleOrg userRoleOrgN2:orgList){
				if(orgId.equals(userRoleOrgN2.getOrgId())){
					Role roleN = new Role();
					roleN.setId(userRoleOrgN2.getRoleId());
					roleN.setName(userRoleOrgN2.getRoleName());
					roles.add(roleN);
				}
			}
			userRoleOrgN.setRoles(roles);
			orgNewList.add(userRoleOrgN);
		}
		return orgNewList;
	}
	
	/**
	 * 检索员工关联机构
	 * @param userId
	 * @return List<UserRoleOrg>
	 */
	public List<UserRoleOrg> selUserOrg(String userId) {
		UserRoleOrg selParam = new UserRoleOrg();
		selParam.setUserId(userId);
		List<UserRoleOrg> ls = userRoleOrgDao.selUserRoleOrg(selParam);
		return ls;
	}
	
	@Transactional(readOnly = false)
	public void updateUserInfo(User user) {
		logger.info("update userinfo , username: "+ user.getName());
		User oldUser=dao.get(user.getId());
		user.preUpdate();
		dao.updateUserInfo(user);
		User newUser=dao.get(user.getId());
		userLogManager.insertUserLog(oldUser, newUser, "2");
	}
	
	@Transactional(readOnly = false)
	public void updatePasswordById(String id, String loginName, String newPassword) {
		logger.info("update password , username: "+ loginName + "new password: " + newPassword);
		User user = new User(id);
		user.setPassword(PasswordUtil.entryptPassword(newPassword));
		dao.updatePasswordById(user); 				//密码修改,不需要同步到业务模块
		user.setLoginName(loginName);
		ParameterSupport paramSupport = new ParameterSupport();
		paramSupport.setMethodName("modifyUser");
		paramSupport.setExtMsg("userName:" + user.getName());
		paramSupport.setSyncLdapType(LdapConstants.FLAG_USER_UPDATE);
		paramSupport.setActionType(ActionType.UPDATE);
		paramSupport.setExceptionCode(LdapExceptionCode.USER_UPDATE_FAIL);
		syncUserToLdap(user, paramSupport, newPassword);
	}
		
	@Transactional(readOnly = false)
	public void delete(User user) {
		List<UserRoleOrg> existedList = queryExistedUserRoleOrg(user);
		user.setDelFlag(DeleteFlagType.DELETE);
		User oldUser=dao.get(user.getId());
		dao.delete(user);
		User newUser=dao.get(user.getId());
		userLogManager.insertUserLog(oldUser, newUser, "3");
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUser);
		saveSyncUser(user, SyncType.TYPE_DELETE.value, batchNo);
		if(ArrayHelper.isNotEmpty(existedList)){
			user.setUserRoleOrgList(existedList);
			batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUserRoleOrg);
			saveSyncUserRoleOrg(user, SyncType.TYPE_DELETE.value, batchNo);
		}
		RedisUtils.remove(User.class.getName() + SPLIT_CHAR + user.getId());
		//saveUser2ThreeNet(user, SyncType.TYPE_DELETE.value);
	}
	
	@Transactional(readOnly = false)
	public Boolean outUserInRole(Role role, User user) {
		List<Role> roles = user.getRoleList();
		for (Role e : roles){
			if (e.getId().equals(role.getId())){
				roles.remove(e);
				save(user);
				return true;
			}
		}
		return false;
	}
	
	@Transactional(readOnly = false)
	public User assignUserToRole(Role role, User user) {
		if (user == null){
			return null;
		}
		List<String> roleIds = user.getRoleIdList();
		if (roleIds.contains(role.getId())) {
			return null;
		}
		user.getRoleList().add(role);
		save(user);
		return user;
	}
	
	/**
	 * 同步用户角色关系到ldap
	 * 2015年12月4日
	 * By 张永生
	 * @param user
	 * @param item
	 * @param methodName
	 * @param syncType
	 * @param exceptionCode
	 * @param extMsg
	 */
	public void syncUserRoleToLdap(User user, Role item, String methodName,
			String syncType, int exceptionCode, String extMsg) {
		VoSyncUserPosition synUserPosition = SyncLdapUserPositionHelper
				.wrapperSyncUserPosition(user, item, syncType);
		String operatorId = UserUtils.getUser().getId();
		String actionName = null;
		if(LdapConstants.FLAG_USERPOSITION_INSERT.equals(syncType)){
			actionName = ActionType.INSERT;
		}else if(LdapConstants.FLAG_USERPOSITION_DELETE.equals(syncType)){
			actionName = ActionType.DELETE;
		}
		try {
			LdapDataHandlerFactory.dealLdap(synUserPosition);
			LdapLoggerHelper.writeLdapLog(logger, methodName, actionName, operatorId, user.getUserCode(),
					item.getId(), item.getName(), item.getEnName(),
					LdapExceptionCode.getSuccessDesc(exceptionCode));
		} catch (Exception e) {
			LdapLoggerHelper.writeLdapLog(logger, methodName, actionName, operatorId, user.getUserCode(),
					item.getId(), item.getName(), item.getEnName(),
					LdapExceptionCode.getFailDesc(exceptionCode));
			if(!LdapConstants.FLAG_USERPOSITION_DELETE.equals(syncType)){  //ldap删除用户与角色关系时出现异常，不抛出
				throw new LdapException(
						LdapExceptionCode.getFailDesc(exceptionCode)
						+ SymbolConstant.COMMA + extMsg);
			}
		}
	}

	/**
	 * 同步用户到ldap
	 * 2015年12月4日
	 * By 张永生
	 * @param user
	 * @param paramSupport
	 * @param password
	 */
	public void syncUserToLdap(User user, ParameterSupport paramSupport,
			String password) {
		VoSyncUser syncUser = SyncLdapUserHelper.wrapperSyncUser(user, paramSupport.getSyncLdapType(), password);
		String operatorId = UserUtils.getUser().getId();
		CallLdapHelper.callRemoteUserLdap(logger, user, syncUser, operatorId,
				paramSupport.getMethodName(), paramSupport.getActionType(),
				paramSupport.getExceptionCode(), paramSupport.getExtMsg());
	}
	
	public  List<UserRoleOrg> findUserOrgByUserType(String userId,String orgId,String userType){
		return null;
	}
	
	/**
	 * 用户设置多机构时,保存用户角色机构关系
	 * 2016年5月19日
	 * By 张永生
	 * @param user
	 */
	@Transactional(readOnly = false)
	public void saveUserRoleOrg(User user){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		List<Role> roleList = roleDao.findByUserId(params);
		Map<String,Object> delParams = Maps.newHashMap();
		delParams.put("userId", user.getId());
		Map<String,Object> allParams = Maps.newHashMap();
		allParams.put("userId", user.getId());
		List<UserRoleOrg> userRoleOrgOld=userRoleOrgDao.query(allParams);
		List<UserRoleOrg> userRoleOrgNew=new ArrayList<UserRoleOrg>();
		dao.deleteUserRoleOrg(delParams);
		if(User.HAS_LOGIN_YES.equals(user.getHasLogin())){
			for(Role item : roleList){
				syncUserRoleToLdap(user, item, "saveUserRoleOrg",
						LdapConstants.FLAG_USERPOSITION_DELETE,
						LdapExceptionCode.USER_ROLE_DELETE_FAIL,
						"userId:"+ user.getId());
			}
		}
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUserRoleOrg);
		saveSyncUserRoleOrg(user, SyncType.TYPE_DELETE.value, batchNo);
		batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUserRoleOrg);
		// 插入同步数据表
		if(user.getUserRoleOrgList().size()>0){
			dao.insertUserRoleOrg(user);
			userRoleOrgNew=userRoleOrgDao.query(allParams);
			saveSyncUserRoleOrg(user, SyncType.TYPE_ADD.value, batchNo);
			if(User.HAS_LOGIN_YES.equals(user.getHasLogin())){
				for(UserRoleOrg item : user.getUserRoleOrgList()){
					Role roleItem = roleDao.get(item.getRoleId());
					syncUserRoleToLdap(user, roleItem,
							"saveUserRoleOrg",
							LdapConstants.FLAG_USERPOSITION_INSERT,
							LdapExceptionCode.USER_ROLE_ADD_FAIL,
							"userId:"+ user.getId());
				}
			}		
		}
		userRoleOrgLogManager.insertUserRoleOrgLog(userRoleOrgOld,userRoleOrgNew,"2");
		
		
	}
	
	/**
	 * 保存或修改用户时，保存用户角色机构关系
	 * 2016年5月19日
	 * By 张永生
	 * @param user
	 * @param oldOrgId 用户修改之前的机构Id
	 */
	@Transactional(readOnly = false)
	public void saveUserRoleOrg(User user, String oldOrgId){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userId", user.getId());
		params.put("orgId", oldOrgId);
		params.put("deleteFlag", DeleteFlagType.NORMAL);
		List<Role> roleList = roleDao.findByUserId(params);
		Map<String,Object> delParams = Maps.newHashMap();
		delParams.put("userId", user.getId());
		delParams.put("orgId", oldOrgId);
		Map<String,Object> allParams = Maps.newHashMap();
		allParams.put("userId", user.getId());
		List<UserRoleOrg> userRoleOrgOld=userRoleOrgDao.query(allParams);
		List<UserRoleOrg> userRoleOrgNew=new ArrayList<UserRoleOrg>();
		dao.deleteUserRoleOrg(delParams);
		if(User.HAS_LOGIN_YES.equals(user.getHasLogin())){
			for(Role item : roleList){
				syncUserRoleToLdap(user, item, "saveUserRoleOrg",
						LdapConstants.FLAG_USERPOSITION_DELETE,
						LdapExceptionCode.USER_ROLE_DELETE_FAIL,
						"userId:"+ user.getId());
			}
		}
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUserRoleOrg);
		saveSyncUserRoleOrg(user, SyncType.TYPE_DELETE.value, batchNo);
		batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUserRoleOrg);
		// 插入同步数据表
		if(user.getUserRoleOrgList().size()>0){
			dao.insertUserRoleOrg(user);
			if(User.HAS_LOGIN_YES.equals(user.getHasLogin())){
				for(UserRoleOrg item : user.getUserRoleOrgList()){
					Role roleItem = roleDao.get(item.getRoleId());
					syncUserRoleToLdap(user, roleItem,
							"saveUserRoleOrg",
							LdapConstants.FLAG_USERPOSITION_INSERT,
							LdapExceptionCode.USER_ROLE_ADD_FAIL,
							"userId:"+ user.getId());
				}
			}
			userRoleOrgNew=userRoleOrgDao.query(allParams);
			//换位
			user.setUserRoleOrgList(userRoleOrgNew);// 用户修改只传来主机构关系 接口会按userId删除信息，所以再同步关系时先查询所有关系		
			saveSyncUserRoleOrg(user, SyncType.TYPE_ADD.value, batchNo);
		}
		userRoleOrgLogManager.insertUserRoleOrgLog(userRoleOrgOld,userRoleOrgNew,"1");	
	}
	
	/**
	 * 查询已存在的UserRoleOrg
	 * 2016年1月8日
	 * By 张永生
	 * @param user
	 * @return
	 */
	private List<UserRoleOrg> queryExistedUserRoleOrg(User user) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", user.getId());
		List<UserRoleOrg> existedList = userRoleOrgDao.query(params);
		return existedList;
	}
	
	public List<Map<String,String>> findUserRoleOrgByUserId(String userId){
		UserRoleOrg userRoleOrg = new UserRoleOrg();
		userRoleOrg.setUserId(userId);
		return userRoleOrgDao.selUserRoleOrgByUserId(userRoleOrg);
	}
	
	@Transactional(readOnly = false)
	public void resetPassword(User user){
		logger.info("user: "+ user.getName() + "reset password: " + SystemConfigConstant.DEFAULT_USER_PASSWORD );
				
		int handleType;
		String methodName = null;
		if(isExistInTDS(user)){//TDS中已有该用户
			handleType = HandleType.UPDATE;
			methodName = "updateUser";
		}else{
			handleType = HandleType.INSERT;
			methodName = "saveUser";
		}
		ParameterSupport paramSupport = UserParameterHelper.getParameterSupport(handleType);
		paramSupport.setExtMsg("userName:"+ user.getName());
		paramSupport.setMethodName(methodName);
		syncUserToLdap(user, paramSupport, SystemConfigConstant.DEFAULT_USER_PASSWORD);
		user.setPassword(SystemConfigConstant.DEFAULT_USER_PASSWORD);
		dao.update(user);
	}
	
	@Transactional(readOnly = false)
	public void enableUser(String id){

		User user = dao.get(id);
		User oldUser = dao.get(id);
		user.setDelFlag(DeleteFlagType.NORMAL);
		dao.updateDeleteFlag(user);
		User newUser = dao.get(user.getId());
		userLogManager.insertUserLog(oldUser, newUser, "2");
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUser);
		saveSyncUser(user, SyncType.TYPE_MODIFY.value, batchNo);
		//saveUser2ThreeNet(user, SyncType.TYPE_MODIFY.value);
		RedisUtils.remove(User.class.getName() + SPLIT_CHAR + user.getId());
	}
	
	@Transactional(readOnly = false)
	public void enableUser(User user){

		User oldUser = dao.get(user.getId());
		user.setDelFlag(DeleteFlagType.NORMAL);
		dao.updateDeleteFlag(user);
		User newUser = dao.get(user.getId());
		userLogManager.insertUserLog(oldUser, newUser, "2");
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUser);
		saveSyncUser(user, SyncType.TYPE_MODIFY.value, batchNo);
		//saveUser2ThreeNet(user, SyncType.TYPE_MODIFY.value);
		RedisUtils.remove(User.class.getName() + SPLIT_CHAR + user.getId());
	}
	
	@Transactional(readOnly = false)
	public void updateStatus(User user){
		User oldUser = dao.get(user.getId());
		dao.updateStatus(user);
		User newUser = dao.get(user.getId());
		userLogManager.insertUserLog(oldUser, newUser, "2");
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncUser);
		saveSyncUser(user, SyncType.TYPE_MODIFY.value, batchNo);
		//saveUser2ThreeNet(user, SyncType.TYPE_MODIFY.value);
		RedisUtils.remove(User.class.getName() + SPLIT_CHAR + user.getId());
	}
	
	public List<User> findUsersByCodes(Map<String,Object> params){
		return dao.findUsersByCodes(params);
	}
	
	public List<User> findUsersByLoginName(Map<String,Object> params){
		return dao.findUsersByLoginName(params);
	}
	
	public List<User> findLeaders(String orgId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("delFlag", DeleteFlagType.NORMAL);
		params.put("orgId", orgId);
		params.put("status", UserStatus.ON);
		return dao.findLeaders(params);
	}
	
	public ThreeNetUserDto findStopManager(String userCode){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userCode", userCode);
		return dao.findManagerInfo(params);
	}
	
	public ThreeNetUserDto findSendInfo(String userCode){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userCode", userCode);
		return dao.findSendInfo(params);
	}
	
	public ThreeNetUserDto findSendInfo(String userCode,String userId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userCode", userCode);
		params.put("userId", userId);
		return dao.findSendInfo(params);
	}
	public ThreeNetUserDto findSendInfoById(String userId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		return dao.findSendInfoById(params);
	}
	
	
	/**
	 * 新增根据用户ID查找用户的方法
	 * 用于修正迁移过来的用户数据，不从缓存中取用户
	 * 2016年6月27日
	 * By 张永生
	 * @param id
	 * @return
	 */
	public User getUserById(String id){
		return dao.getUserById(id);
	}
	
	@Transactional(readOnly = false)
	public String updateUserTime(String userId, Date startTime, Date endTime){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		dao.updateUserTime(params);
		return "0";
	}
	
	
	public List<User> findUserTemporary(Map<String, Object> params){
		return dao.findUserTemporary(params);
	}
	
	/**
	 * 根据userCode, roleId, orgId 查询用户
	 * By 任志远 2017年3月28日
	 *
	 * @param userCode
	 * @param roleId
	 * @param orgId
	 * @return
	 */
	public User findUserByUserCodeAndRoleAndOrg(String userCode, String roleId, String orgId){
		
		Map<String, Object> params = new HashMap<>();
		params.put("userCode", userCode);
		params.put("roleId", roleId);
		params.put("orgId", orgId);
		
		return dao.findUserByUserCodeAndRoleAndOrg(params);
	}
	
	/**
	 * 根据角色ID和组织机构ID查询员工
	 * By 任志远 2017年5月7日
	 *
	 * @param roleId 角色ID
	 * @param parentOrgId	上级组织机构ID
	 * @return
	 */
	public List<User> findUserByRoleAndParentOrg(String roleId, String parentOrgId){
		
		Map<String, Object> params = new HashMap<>();
		params.put("roleId", roleId);
		params.put("parentId", parentOrgId);
		params.put("deleteFlag", YESNO.NO.getCode());
		params.put("status", YESNO.YES.getCode());
		
		return dao.findByParams(params);
	}
	
	/**
	 * 根据角色ID和组织机构ID查询员工
	 * By 任志远 2017年5月7日
	 *
	 * @param roleId 角色ID
	 * @param orgId	组织机构ID
	 * @return
	 */
	public List<User> findUserByRoleAndParentOrg(String roleId, String parentOrgId, String departmentId){
		
		Map<String, Object> params = new HashMap<>();
		params.put("roleId", roleId);
		params.put("parentId", parentOrgId);
		params.put("departmentId", departmentId);
		params.put("deleteFlag", YESNO.NO.getCode());
		params.put("status", YESNO.YES.getCode());
		
		return dao.findByParams(params);
	}
}
