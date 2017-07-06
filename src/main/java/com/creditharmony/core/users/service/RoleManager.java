package com.creditharmony.core.users.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cache.RoleCache;
import com.creditharmony.core.common.type.ActionType;
import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.common.util.RunningNumberHelper;
import com.creditharmony.core.exception.code.LdapExceptionCode;
import com.creditharmony.core.log.service.RoleMenuResLogManager;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.sync.data.dao.SyncDataBatchDao;
import com.creditharmony.core.sync.data.dao.SyncRoleDao;
import com.creditharmony.core.sync.data.entity.SyncDataBatch;
import com.creditharmony.core.sync.data.entity.SyncRole;
import com.creditharmony.core.sync.data.type.NeedSyncTableName;
import com.creditharmony.core.sync.data.type.SyncBizConstants;
import com.creditharmony.core.sync.data.type.SyncGroupKeyType;
import com.creditharmony.core.sync.data.type.SyncSupportModule;
import com.creditharmony.core.sync.data.type.SyncType;
import com.creditharmony.core.sync.data.util.GroupByCaseType;
import com.creditharmony.core.sync.data.util.SyncAssembleHelper;
import com.creditharmony.core.threenet.dao.ThreeNetDataBatchDao;
import com.creditharmony.core.users.dao.ModuleDao;
import com.creditharmony.core.users.dao.RoleDao;
import com.creditharmony.core.users.entity.Module;
import com.creditharmony.core.users.entity.Resource;
import com.creditharmony.core.users.entity.ResourceAuth;
import com.creditharmony.core.users.entity.Role;
import com.creditharmony.core.users.entity.RoleModuleMenu;
import com.creditharmony.core.users.entity.UserRoleOrg;
import com.creditharmony.core.users.util.CallLdapHelper;
import com.creditharmony.core.users.util.SyncLdapPositionHelper;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.ldap.constants.LdapConstants;
import com.creditharmony.ldap.vo.VoSyncPosition;

/**
 * 角色管理manager
 * @Class Name RoleManager
 * @author 张永生
 * @Create In 2015年12月4日
 */
@Service
public class RoleManager extends CoreManager<RoleDao, Role> {
	
	@Autowired
	private SyncDataBatchDao syncDataBatchDao;
	@Autowired
	private SyncRoleDao syncRoleDao;
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private MenuManager menuManager;
	@Autowired
	private ThreeNetDataBatchDao threeNetDataBatchDao;	
	@Autowired
	private RoleMenuResLogManager roleMenuResLogManager;
	
	/**
	 * 根据id获取role对象
	 * 级联带出role关联的菜单集合menuList
	 * 2015年12月18日
	 * By 张永生
	 * @param id
	 * @return
	 */
	public Role getRole(String id){
		return dao.get(id);
	}
	

	public List<Role> getRoleByName(String name) {
		Role role = new Role();
		role.setName(name);
		return dao.getByName(role);
	}
	
	public List<Role> getRoleByEnName(String enName) {
		Role role = new Role();
		role.setEnName(enName);
		return dao.getByEnName(role);
	}
	
	public List<Role> findAllRole(){
//		return UserUtils.getRoleList();
		return RoleCache.getInstance().getList();
	}
	
	public List<Role> findRole(Role role){
		return dao.findList(role);
	}
	
	public Page<Role> findRoleByPage(Page<Role> page, Map<String,Object> filter) {
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        PageList<Role> pageList = (PageList<Role>)dao.findByParamsForPage(filter, pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	public List<Role> findByParams(Map<String,Object> params){
		return dao.findByParams(params);
	}
	
	/**
	 * 条件查询角色
	 * 根据机构类型查询
	 * 2016年6月20日
	 * By 张永生
	 * @param params
	 * @return
	 */
	public List<Role> queryByParams(Map<String,Object> params){
		return dao.queryByParams(params);
	}
	
	@Transactional(readOnly = false)
	public void saveRoleAuth(Role role) {
		
		List<RoleModuleMenu> roleModuleMenuOld=menuManager.queryRoleModuleMenu(role);
		List<ResourceAuth> resourceAuthOld=menuManager.queryResourceAuth(role);
		// 更新角色、模块与菜单的关联
		dao.deleteRoleModuleMenu(role);
		if (role.getMenuList().size() > 0){
			dao.insertRoleModuleMenu(role);
		}
		Map<String,String> params = new HashMap<String,String>();
		params.put("moduleId", role.getModule().getId());
		params.put("roleId", role.getId());
		params.put("type", Resource.TYPE_BUTTON);
		dao.deleteRoleResourceAuth(params);
		if (role.getResAuthList().size() > 0){
			dao.insertRoleResourceAuth(role);
		}
		List<RoleModuleMenu> roleModuleMenuNew=menuManager.queryRoleModuleMenu(role);
		List<ResourceAuth> resourceAuthNew=menuManager.queryResourceAuth(role);
		roleMenuResLogManager.insertRoleMenuResLog(role,roleModuleMenuOld, roleModuleMenuNew, resourceAuthOld, resourceAuthNew, "2 ");
	}
	
	@Transactional(readOnly = false)
	public void save(Role role) {
		String actionName = null;
		String syncBizType = null;  
		int exceptionCode;
		List<RoleModuleMenu> roleModuleMenuOld=new ArrayList<RoleModuleMenu>();
		List<ResourceAuth> resourceAuthOld=new ArrayList<ResourceAuth>();
		String type="";
		if (StringUtils.isBlank(role.getId())){
			role.preInsert();
			dao.insert(role);
			actionName = ActionType.INSERT;
			exceptionCode = LdapExceptionCode.ROLE_ADD_FAIL;
			syncBizType = SyncType.TYPE_ADD.value;
			type="1";
		}else{
			roleModuleMenuOld=menuManager.queryRoleModuleMenu(role);
			resourceAuthOld=menuManager.queryResourceAuth(role);
			role.preUpdate();
			dao.update(role);
			// 移除该角色在已拥有模块下的菜单项
			Role oldRole = new Role();
			oldRole.setId(role.getId());
			oldRole.setModuleList(role.getModuleList());
			List<Module> notSelModuleList = moduleDao.findByRole(oldRole);
			if(ArrayHelper.isNotEmpty(notSelModuleList)){
				oldRole.setModuleList(notSelModuleList);
				dao.removeRoleModuleMenu(oldRole);
			}
			
			actionName = ActionType.UPDATE;
			exceptionCode = LdapExceptionCode.ROLE_UPDATE_FAIL;
			syncBizType = SyncType.TYPE_MODIFY.value;
			type="2";
		}
		
		// 更新角色与模块的关联
		dao.deleteRoleModule(role);
		if (role.getModuleList().size() > 0){
			dao.insertRoleModule(role);
		}
		List<RoleModuleMenu> roleModuleMenuNew=menuManager.queryRoleModuleMenu(role);
		List<ResourceAuth> resourceAuthNew=menuManager.queryResourceAuth(role);
		roleMenuResLogManager.insertRoleMenuResLog(role,roleModuleMenuOld, roleModuleMenuNew, resourceAuthOld, resourceAuthNew, type);
		//插入同步数据表
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncRole);
		saveSyncRole(role, syncBizType, batchNo);
		
		String extMsg = "roleName:" + role.getName();
		syncRoleToLdap(role, "saveRole", actionName, exceptionCode, extMsg);
	}

	/**
	 * 保存同步角色对象
	 * 2015年12月25日
	 * By 陈伟东
	 * @param role
	 * @param syncType
	 * @param batchNo
	 */
	@Transactional(readOnly = false)
	public void saveSyncRole(Role role, String syncType, int batchNo) {
		for(Map.Entry<String, String> entry : SyncSupportModule.getSupportModule().entrySet()){
			SyncDataBatch syncDataBatch = SyncAssembleHelper
					.assembleSyncDataBatch(role.getId(), batchNo,
							entry.getValue(),
							NeedSyncTableName.SYNC_ROLE.value,
							SyncGroupKeyType.ROLEID_MODULENAME,
							GroupByCaseType.CASE_ROLE);
			syncDataBatchDao.insert(syncDataBatch);
			SyncRole syncRole = SyncAssembleHelper.assembleSyncRole(role,
					syncType, entry.getValue(), batchNo);
			syncRoleDao.insert(syncRole);
		}
	}
	
	private void syncRoleToLdap(Role role, String methodName,
			String actionName, int exceptionCode, String extMsg) {
		String operatorId = UserUtils.getUser().getId();
		VoSyncPosition syncPosition = SyncLdapPositionHelper
				.wrapperSyncPosition(role, LdapConstants.FLAG_POSITION_INSERT);
		CallLdapHelper.callRemoteRoleLdap(logger, role, syncPosition,
				operatorId, extMsg, methodName, actionName, exceptionCode);
	}
	
	@Transactional(readOnly = false)
	public void delete(Role role) {
		dao.delete(role);
		int batchNo = RunningNumberHelper.getNextNumber(SyncBizConstants.SyncTableName.SyncRole);
		saveSyncRole(role, SyncType.TYPE_DELETE.value, batchNo);
		
		VoSyncPosition syncPosition = SyncLdapPositionHelper
				.wrapperSyncPosition(role, LdapConstants.FLAG_POSITION_DELETE);
		String operatorId = UserUtils.getUser().getId();
		String extMsg = "roleName:" + role.getName();
		String methodName = "deleteRole";
		String actionName = ActionType.DELETE;
		int exceptionCode = LdapExceptionCode.ROLE_DELETE_FAIL;
		CallLdapHelper.callRemoteRoleLdap(logger, role, syncPosition,
				operatorId, extMsg, methodName, actionName, exceptionCode);
	}
	
	public List<Module> findModuleByRoleIds(List<String> ids){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("list", ids);
		params.put("delFlag", DeleteFlagType.NORMAL);
		return moduleDao.findModuleByRoleIds(params);
	}
	
}
