package com.creditharmony.core.log.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.creditharmony.core.persistence.DataEntity;
import com.creditharmony.core.supcan.treelist.cols.annotation.SupCol;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LoginLog  extends DataEntity<LoginLog>{
    private String id;

    private String loginName;

    private String userCode;

    private String userName;

    private Date loginTime;

    private String loginIp;

    private Date logoutTime;

    private String logoutIp;

    private String type;

    private String systemFlag;
	@SupCol(isUnique="true", isHide="true")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }
	@Length(min=1, max=100, message="登录名长度必须介于 1 和 100 之间")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }
	@Length(min=1, max=100, message="登录名长度必须介于 1 和 100 之间")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getLogoutIp() {
        return logoutIp;
    }

    public void setLogoutIp(String logoutIp) {
        this.logoutIp = logoutIp == null ? null : logoutIp.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(String systemFlag) {
        this.systemFlag = systemFlag;
    }
}