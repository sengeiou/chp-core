package com.creditharmony.core.common.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.core.common.dao.EntrustDao;
import com.creditharmony.core.common.entity.Entrust;
import com.creditharmony.core.common.service.EntrustManager;
import com.creditharmony.core.service.CoreManager;
import com.google.common.collect.Maps;


/**
 * 委托管理的service
 * @Class Name EntrustService
 * @author 王浩
 * @Create In 2015年12月8日
 */
@Service
public class EntrustManagerImpl  extends CoreManager<EntrustDao, Entrust> implements EntrustManager{

	@Autowired
	private EntrustDao entrustDao;	
	
	/**
	 * 根据用户名，查出被委托人
	 * 2016年2月2日
	 * By 王浩
	 * @param loginName 委托用户名
	 * @return 被委托人的用户id
	 */
	public String getEntrustAcceptUser(String loginName) {
		logger.info("into getEntrustAcceptUser.");
		Calendar cal = Calendar.getInstance();		
		// 查找当前生效委托A，并根据委托结束时间排序
		List<Entrust> list = entrustDao.searchEntrust(cal.getTime());
		
		HashMap<String, Entrust> entrustMap = Maps.newHashMap();		
		Entrust currEntrust = null;
		for (Entrust entrust : list) {
			String srcUserId = entrust.getEntrustUserCode();
			// 将list中所有记录存入map中，如果srcUserId相同，覆盖前面的
			entrustMap.put(srcUserId, entrust);
			// 如果根据当前用户id找到多条enturst记录，循环结束后，得到的当前entrust为结束时间最晚的
			if (loginName.equals(srcUserId)) {
				currEntrust = entrust;
			}
		}
		// 当前用户loginName没有委托记录，返回null
		if (currEntrust == null){
			return null;
		}
		
		Entrust temp = currEntrust;
		// 预防死循环(根据委托人A找到被委托人B，但此被委托人当前也被委托给C，而C被委托给B)
		HashMap<String, String> userCodeMap = new HashMap<String, String>();
		while (temp != null) {// 如果根据被委托人没有被委托，循环结束，返回被委托人
			String target = temp.getEntrustAcceptUserCode();
			currEntrust = temp;
			String ex = userCodeMap.get(target);
			// 被委托人出现第二次时，循环结束（死循环），返回当前被委托人
			if (ex != null) {
				break;
			}
			// 防止被委托人循环出现
			userCodeMap.put(target, target);
			temp = entrustMap.get(target);
		}
		
		logger.info("out from getEntrustAcceptUser.");
		return currEntrust.getEntrustAcceptUserCode();
	}

}
