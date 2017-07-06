package com.creditharmony.core.log.entity;

import java.util.Date;

import com.creditharmony.core.persistence.DataEntity;

public class UserLog  extends DataEntity<UserLog>{
    private String id;

    private String userId;

    private String loginName;

    private String userName;

    private String userNameNew;

    private String userCode;

    private String userCodeNew;

    private String departmentId;

    private String departmentIdNew;

    private String status;

    private String statusNew;

    private String email;

    private String emailNew;

    private String phone;

    private String phoneNew;

    private String mobile;

    private String mobileNew;

    private Date entryTime;

    private Date entryTimeNew;

    private Integer level;

    private Integer levelNew;

    private String hasLogin;

    private String hasLoginNew;

    private String callEmpCode;

    private String callEmpCodeNew;

    private String delFlagNew;

    private String leaderId;

    private String leaderIdNew;

    private String remarks;

    private String remarksNew;
    
    private String delFlag;

    private String operateType;

    private Integer systemFlag;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNameNew() {
        return userNameNew;
    }

    public void setUserNameNew(String userNameNew) {
        this.userNameNew = userNameNew == null ? null : userNameNew.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserCodeNew() {
        return userCodeNew;
    }

    public void setUserCodeNew(String userCodeNew) {
        this.userCodeNew = userCodeNew == null ? null : userCodeNew.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentIdNew() {
        return departmentIdNew;
    }

    public void setDepartmentIdNew(String departmentIdNew) {
        this.departmentIdNew = departmentIdNew == null ? null : departmentIdNew.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStatusNew() {
        return statusNew;
    }

    public void setStatusNew(String statusNew) {
        this.statusNew = statusNew == null ? null : statusNew.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmailNew() {
        return emailNew;
    }

    public void setEmailNew(String emailNew) {
        this.emailNew = emailNew == null ? null : emailNew.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhoneNew() {
        return phoneNew;
    }

    public void setPhoneNew(String phoneNew) {
        this.phoneNew = phoneNew == null ? null : phoneNew.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMobileNew() {
        return mobileNew;
    }

    public void setMobileNew(String mobileNew) {
        this.mobileNew = mobileNew == null ? null : mobileNew.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getEntryTimeNew() {
        return entryTimeNew;
    }

    public void setEntryTimeNew(Date entryTimeNew) {
        this.entryTimeNew = entryTimeNew;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevelNew() {
        return levelNew;
    }

    public void setLevelNew(Integer levelNew) {
        this.levelNew = levelNew;
    }

    public String getHasLogin() {
        return hasLogin;
    }

    public void setHasLogin(String hasLogin) {
        this.hasLogin = hasLogin == null ? null : hasLogin.trim();
    }

    public String getHasLoginNew() {
        return hasLoginNew;
    }

    public void setHasLoginNew(String hasLoginNew) {
        this.hasLoginNew = hasLoginNew == null ? null : hasLoginNew.trim();
    }

    public String getCallEmpCode() {
        return callEmpCode;
    }

    public void setCallEmpCode(String callEmpCode) {
        this.callEmpCode = callEmpCode == null ? null : callEmpCode.trim();
    }

    public String getCallEmpCodeNew() {
        return callEmpCodeNew;
    }

    public void setCallEmpCodeNew(String callEmpCodeNew) {
        this.callEmpCodeNew = callEmpCodeNew == null ? null : callEmpCodeNew.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getDelFlagNew() {
        return delFlagNew;
    }

    public void setDelFlagNew(String delFlagNew) {
        this.delFlagNew = delFlagNew == null ? null : delFlagNew.trim();
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId == null ? null : leaderId.trim();
    }

    public String getLeaderIdNew() {
        return leaderIdNew;
    }

    public void setLeaderIdNew(String leaderIdNew) {
        this.leaderIdNew = leaderIdNew == null ? null : leaderIdNew.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getRemarksNew() {
        return remarksNew;
    }

    public void setRemarksNew(String remarksNew) {
        this.remarksNew = remarksNew == null ? null : remarksNew.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public Integer getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(Integer systemFlag) {
        this.systemFlag = systemFlag;
    }
}