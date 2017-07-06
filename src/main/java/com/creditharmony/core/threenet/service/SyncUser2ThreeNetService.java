package com.creditharmony.core.threenet.service;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.core.role.type.FortuneRole;
import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.sync.data.dao.SyncRoleDao;
import com.creditharmony.core.sync.data.dao.SyncUserDao;
import com.creditharmony.core.sync.data.dao.SyncUserRoleOrgDao;
import com.creditharmony.core.sync.data.entity.SyncUser;
import com.creditharmony.core.threenet.entity.ThreeNetUser;
import com.creditharmony.core.users.dto.ThreeNetUserDto;
import com.creditharmony.core.users.entity.Org;
import com.creditharmony.core.users.proxy.OrgProxy;
import com.creditharmony.core.users.service.OrgManager;
import com.creditharmony.core.users.service.UserManager;
import com.creditharmony.core.users.service.UserRoleOrgManager;
import com.creditharmony.core.users.type.FortuneOrgType;
import com.google.common.collect.Lists;

/**
 * 同步用户业务类
 * @Class Name SyncUserManager
 * @author 张永生
 * @Create In 2015年12月2日
 */
@Service
public class SyncUser2ThreeNetService extends CoreManager<SyncUserDao, SyncUser> {

	@Autowired
	private OrgProxy orgProxy;
	
	@Autowired
	private SyncUserDao syncUserDao;
	
	@Autowired
	private SyncUserRoleOrgDao syncUserOrgDao;
	
	@Autowired
	private SyncRoleDao syncRoleDao;
	
	@Autowired
	private SyncUserRoleOrgDao syncUserRoleOrgDao;

	@Autowired
	private UserManager userManager;
	@Autowired
	private OrgManager orgManager;
	@Autowired
	private UserRoleOrgManager userRoleOrgManager;
    private static List<String> allowOrgTypes = Lists.newArrayList();
    
    
    static {
    	if(!ArrayHelper.isNotEmpty(allowOrgTypes)){
    		allowOrgTypes.add(FortuneOrgType.BUSINESS_DEPT.key);
    		allowOrgTypes.add(FortuneOrgType.DISTRICT.key);
    		allowOrgTypes.add(FortuneOrgType.CITY.key);
    		allowOrgTypes.add(FortuneOrgType.STORE.key);
    		allowOrgTypes.add(FortuneOrgType.TEAM.key);
    		allowOrgTypes.add(FortuneOrgType.CENTER.key);
    		allowOrgTypes.add(FortuneOrgType.DATA_DEPT.key);
    		allowOrgTypes.add(FortuneOrgType.MANAGE_DEPT.key);
    	}
    }
	public ThreeNetUser syncUser2ThreeNet(ThreeNetUser userItem) {
			String departmentId = userItem.getDepartmentId();
			if(StringUtils.isNotEmpty(departmentId)){
				Org org = orgManager.get(departmentId);
				if(isAllowSync(org)){
					// 查询理离职理财经理
//					ThreeNetUserDto user = userManager.findStopManager(userItem.getUserCode());
//					if(user != null && "0".equals(user.getStatus())){
//						// 同步离职理财经理信息
//						user.setFlag("1");
//						ThreeNetUser threeNetUser = assembleSyncUser(user,userItem.getSyncType(),"");
//						/**
//						 * todo
//						 */
//						return threeNetUser;
//					}
					//在职判断发送的用户信息
					ThreeNetUserDto u = userManager.findSendInfo(userItem.getUserCode());
					if(u != null){
						if("0".equals(u.getStatus())){
							// 用户离职
							//　发送离职信息,发送当前查询的机构
							Org o = orgManager.get(u.getOrgId()!=null ? u.getOrgId() : "");
							if(o != null){
								if(FortuneOrgType.TEAM.key.equals(o.getType())){
									u.setTeamId(u.getOrgId() != null ? u.getOrgId() : "");
									String parentId = o.getParentId();
									u.setBussnessId(parentId != null ? parentId : "");
								}else{
									//　组织机构不是团队
									u.setTeamId(u.getOrgId() != null ? u.getOrgId() : "");
									u.setBussnessId(u.getOrgId() != null ? u.getOrgId() : "");
								}
								ThreeNetUser threeNetUser = assembleSyncUser(u,userItem.getSyncType(),"");
								return threeNetUser;
							}
						}else{
							if(FortuneRole.FINANCING_MANAGER.id.equals(u.getRoleType())){
								// 判断用户是否是理财经理，如果是理财经理此时对应teamId 和 bussnessId 正常
								// 同步离职理财经理信息
								Org o = orgManager.get(u.getOrgId() !=null ? u.getOrgId() : "");
								if(o != null){
									u.setTeamId(u.getOrgId() !=null ? u.getOrgId() : "");
									String parentId = o.getParentId();
									u.setBussnessId(parentId != null ? parentId : "");
									ThreeNetUser threeNetUser = assembleSyncUser(u,userItem.getSyncType(),"");
									return threeNetUser;
								}
							}else{
								// 根据用户id 查询当前的departmentId 作为当前 teamId 和 businessId
								//　发送离职信息,发送当前查询的机构
								Org o = orgManager.get(u.getOrgId()!=null ? u.getOrgId() : "");
								if(o != null){
									if(FortuneOrgType.TEAM.key.equals(o.getType())){
										u.setTeamId(u.getOrgId()!=null ? u.getOrgId() : "");
										String parentId = o.getParentId();
										u.setBussnessId(parentId != null ? parentId : "");
									}else{
										//　组织机构不是团队
										u.setTeamId(u.getOrgId()!=null ? u.getOrgId() : "");
										u.setBussnessId(u.getOrgId()!=null ? u.getOrgId() : "");
									}
									ThreeNetUser threeNetUser = assembleSyncUser(u,userItem.getSyncType(),"");
									return threeNetUser;
								}
							}
						}
					}
					
				} else {
					logger.info("用户所属部门的机构类型是财富的机构类型,但是不在允许同步的机构类型之列,无需同步");
				}
			} else {
				logger.info("用户所属部门的departmentId为空,不能同步");
			}
		return null;
	}
	
	public boolean isAllowSync(Org org) {
		return org!=null && StringUtils.isNotEmpty(org.getType()) && allowOrgTypes.contains(org.getType());
	}
	
	public ThreeNetUser assembleSyncUser(ThreeNetUserDto user, String syncType, String position){
		ThreeNetUser syncUser = new ThreeNetUser();
		syncUser.setUserCode(user.getUserCode());
		syncUser.setUserId(user.getId());
		syncUser.setSyncType(syncType);
		syncUser.setName(user.getName());
		syncUser.setStatus(user.getStatus());
		syncUser.setSex(user.getSex());
		syncUser.setLeaderId(user.getLeaderId());
		syncUser.setMobile(user.getMobile());
		syncUser.setEmail(user.getEmail());
		syncUser.setCreateTime(user.getCreateTime());
		syncUser.setModifyTime(user.getModifyTime());
		syncUser.setTeamId(user.getTeamId());
		syncUser.setBusinessId(user.getBussnessId());
		syncUser.setPosition(position);
		syncUser.setStatusFlag(user.getFlag());
		
		//syncUser.setUserId(user.getUserId());				//CX
		syncUser.setLoginName(user.getLoginName());			//CX
		syncUser.setPassword(user.getPassword());			//CX
		syncUser.setLeaderId(user.getLeaderId());			//CX
		syncUser.setDepartmentId(user.getDepartmentId());	//CX
		
		return syncUser;
	}
	
}
