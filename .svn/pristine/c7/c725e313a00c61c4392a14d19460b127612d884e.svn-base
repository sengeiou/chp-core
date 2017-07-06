package com.creditharmony.core.users.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.entity.AdditionalUser;
import com.creditharmony.core.users.dao.AdditionalUserDao;
@Service
public class AdditionalUserManager extends CoreManager<AdditionalUserDao, AdditionalUser> {
	
	private static final Logger logger = LoggerFactory.getLogger(AdditionalUserManager.class);
	
	/**
	 * 
	 * @param loginName 登录用户名
	 * @param mobile 手机号
	 * @return 数据库是否含有该信息
	 */
	public boolean selectAdditionalUser(String loginName,String mobile) {
		logger.info("param,loginName:{},mobile:{}",loginName,mobile);
		AdditionalUser additionalUser = new AdditionalUser();
		additionalUser.setLoginName(loginName);
		additionalUser.setMobile(mobile);
		AdditionalUser dbAdditionalUser =dao.selectAdditionalUser(additionalUser);
	    if(null != dbAdditionalUser){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据代管账号登录名称 查询代管账号
	 * By 任志远 2017年3月28日
	 *
	 * @param loginName 登录名称
	 * @return
	 */
	public AdditionalUser selectAdditionalUser(String loginName) {
		logger.info("param,loginName:{}",loginName);
		AdditionalUser dbAdditionalUser =dao.selectAdditionalUserByLoginName(loginName);
		return dbAdditionalUser;
	}

}
