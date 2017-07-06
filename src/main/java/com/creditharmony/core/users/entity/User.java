package com.creditharmony.core.users.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.creditharmony.common.util.Collections3;
import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.excel.annotation.ExcelField;
import com.creditharmony.core.persistence.DataEntity;
import com.creditharmony.core.supcan.treelist.cols.annotation.SupCol;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

/**
 * 用户实体
 * @Class Name User
 * @author 张永生
 * @Create In 2015年12月15日
 */
public class User extends DataEntity<User> {
	
	private static final long serialVersionUID = -7578453641104820783L;
	public static final String  HAS_LOGIN_YES = "1";
	public static final String  HAS_LOGIN_NO = "0";

	private Org company;			// 归属公司
	private Org department;			// 归属部门
	@ExcelField(title = "用户名",sort=1)
	private String loginName;		// 登录名
	private String password;		// 密码
	@ExcelField(title = "工号",sort=2)
	private String userCode;    	// 工号,对应emp_code
	@ExcelField(title = "姓名",sort=3)
	private String name;			// 姓名
	private String email;			// 邮箱
	private String phone;			// 电话
	private String mobile;			// 手机
	private String userType;		// 用户类型
	private String loginIp;			// 最后登陆IP
	private Date loginDate;			// 最后登陆日期
	@ExcelField(title = "状态" ,sort=7, dictType="com_user_status")
	private String status;			// 状态:1-在职;0-离职;2-冻结
	private String oldLoginName;	// 原登录名
	private String newPassword;		// 新密码
	private String oldLoginIp;		// 上次登陆IP
	private Date oldLoginDate;		// 上次登陆日期
	@ExcelField(title = "角色",sort=6)
	private String roleStr;
	private String hasLogin;   		// 是否登录: 可以登录的是用户,不可登录的是员工
	@ExcelField(title = "入职时间",sort=8)
	private Date entryTime;   		// 入职时间
	@ExcelField(title = "性别" ,sort=4, dictType="sex")
	private String sex;         	// 用户性别
	private int level;				// 用户等级
	private String posPwd;     		// pos密码
	private String callEmpCode;     // 外呼工号,汇诚使用
	private String leaderId;        // 上级Id
	@ExcelField(title = "机构",sort=5)
	private String departmentStr;
	private int systemFlag;
	private String staffFlag;      //员工标识 1：员工  0 ：用户
	private String validateCode;
	private Date validateCodeTime;
	private Date startTime; 
	private Date endTime; 
	// 以下是辅助属性
	private Role role;				  // 根据角色查询用户条件
	private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表
	private List<Org> orgList = Lists.newArrayList();   // 拥有的组织机构列表
	private List<UserRoleOrg> userRoleOrgList = Lists.newArrayList();   // 拥有的组织机构列表
	private transient String statusName;
	
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getValidateCodeTime() {
		return validateCodeTime;
	}

	public void setValidateCodeTime(Date validateCodeTime) {
		this.validateCodeTime = validateCodeTime;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public User() {
		super();
	}
	
	public User(String id){
		super(id);
	}

	public User(String id, String loginName){
		super(id);
		this.loginName = loginName;
	}

	public User(Role role){
		super();
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@SupCol(isUnique="true", isHide="true")
	public String getId() {
		return id;
	}

	@JsonIgnore
	public Org getCompany() {
		return company;
	}

	public void setCompany(Org company) {
		this.company = company;
	}
	
	@JsonIgnore
	@NotNull(message="归属部门不能为空")
	public Org getDepartment() {
		return department;
	}

	public void setDepartment(Org department) {
		this.department = department;
	}

	@Length(min=1, max=100, message="登录名长度必须介于 1 和 100 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Length(min=1, max=100, message="姓名长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}
	
	@Length(min=1, max=100, message="工号长度必须介于 1 和 100 之间")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Email(message="邮箱格式不正确")
	@Length(min=0, max=200, message="邮箱长度必须介于 1 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=200, message="电话长度必须介于 1 和 200 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min=0, max=200, message="手机长度必须介于 1 和 200 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRemarks() {
		return remarks;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getOldLoginName() {
		return oldLoginName;
	}

	public void setOldLoginName(String oldLoginName) {
		this.oldLoginName = oldLoginName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldLoginIp() {
		if (oldLoginIp == null){
			return loginIp;
		}
		return oldLoginIp;
	}

	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOldLoginDate() {
		if (oldLoginDate == null){
			return loginDate;
		}
		return oldLoginDate;
	}

	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonIgnore
	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@JsonIgnore
	public List<String> getRoleIdList() {
		List<String> roleIdList = Lists.newArrayList();
		for (Role role : roleList) {
			roleIdList.add(role.getId());
		}
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		roleList = Lists.newArrayList();
		for (String roleId : roleIdList) {
			Role role = new Role();
			role.setId(roleId);
			roleList.add(role);
		}
	}
	
	/**
	 * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
	 */
	public String getRoleNames() {
		return Collections3.extractToString(roleList, "name", ",");
	}
	
	@JsonIgnore
	public List<Org> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}
	
	@JsonIgnore
	public List<String> getOrgIdList() {
		List<String> orgIdList = Lists.newArrayList();
		for (Org org : orgList) {
			orgIdList.add(org.getId());
		}
		return orgIdList;
	}

	public void setOrgIdList(List<String> orgIdList) {
		orgList = Lists.newArrayList();
		for (String orgId : orgIdList) {
			Org org = new Org();
			org.setId(orgId);
			orgList.add(org);
		}
	}
	
	/**
	 * 用户拥有的组织机构Id字符串,多个机构id用','分隔
	 * 2015年11月28日
	 * By 张永生
	 * @return
	 */
	public String getOrgIds() {
		return Collections3.extractToString(orgList, "id", ",");
	}
	
	/**
	 * 用户拥有的组织机构名称字符串, 多个组织机构名称用','分隔.
	 */
	public String getOrgNames() {
		return Collections3.extractToString(orgList, "name", ",");
	}

	//系统管理员
	public boolean isAdmin(){
		return isAdmin(this.id);
	}
	
	public static boolean isAdmin(String id){
		return id != null && "admin".equals(id);
	}
	//财富管理员
	public boolean isFortuneAdmin(){
		return isFortuneAdmin(this.id);
	}
	
	public static boolean isFortuneAdmin(String id){
		return id != null && "fortuneadmin".equals(id);
	}
	//汇金管理员
	public boolean isLoanAdmin(){
		return isLoanAdmin(this.id);
	}
	
	public static boolean isLoanAdmin(String id){
		return id != null && "loanadmin".equals(id);
	}
	//汇诚管理员
	public boolean isApproveAdmin(){
		return isApproveAdmin(this.id);
	}
	
	public static boolean isApproveAdmin(String id){
		return id != null && "approveadmin".equals(id);
	}
	
	@Override
	public String toString() {
		return id;
	}

	public List<UserRoleOrg> getUserRoleOrgList() {
		return userRoleOrgList;
	}

	public void setUserRoleOrgList(List<UserRoleOrg> userRoleOrgList) {
		this.userRoleOrgList = userRoleOrgList;
	}

	public String getRoleStr() {
		return roleStr;
	}

	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}

	public String getHasLogin() {
		return hasLogin;
	}

	public void setHasLogin(String hasLogin) {
		this.hasLogin = hasLogin;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPosPwd() {
		return posPwd;
	}

	public void setPosPwd(String posPwd) {
		this.posPwd = posPwd;
	}

	public String getCallEmpCode() {
		return callEmpCode;
	}

	public void setCallEmpCode(String callEmpCode) {
		this.callEmpCode = callEmpCode;
	}

	public String getDepartmentStr() {
		if(StringUtils.isEmpty(this.departmentStr)){
			return null==this.department?"":this.department.getName();
		}else{
			return this.departmentStr;
		}
		
	}

	public void setDepartmentStr(String departmentStr) {
		this.departmentStr = departmentStr;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public int getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(int systemFlag) {
		this.systemFlag = systemFlag;
	}

	public String getStaffFlag() {
		return staffFlag;
	}

	public void setStaffFlag(String staffFlag) {
		this.staffFlag = staffFlag;
	}

	
}