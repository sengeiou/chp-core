package com.creditharmony.core.deduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.ListUtils;
//import com.creditharmony.loanjob.;
import com.creditharmony.core.deduct.dao.PlatformBankDao;
import com.creditharmony.core.deduct.entity.PlatformBankEntity;
import com.creditharmony.core.persistence.Page;

/**
 * 第三方平台银行关联配置-Service
 * 
 * @Class Name PlatformBankService
 * @author 周亮
 * @Create In 2016年01月01日
 */
@Service
public class PlatformBankService {
	
	@Autowired
	private PlatformBankDao daoPb;
	
	/**
	 * 检索第三方平台银行关联
	 * 
	 * @param key
	 * @return Platform
	 */
	public List<PlatformBankEntity> selPlatformBank(PlatformBankEntity key) {
		// 取得第三方平台银行关联信息
		List<PlatformBankEntity> lsPlat = daoPb.selPlatformBank(key);
		return lsPlat;
	}

	/**
	 * 取得第三方平台银行关联信息
	 * @param key
	 * @return Platform
	 */
	public PlatformBankEntity getPlatformBank(PlatformBankEntity key) {
		// 取得第三方平台银行关联信息
		List<PlatformBankEntity> lsPlat = selPlatformBank(key);
		if (ListUtils.isEmptyList(lsPlat)) {
			return new PlatformBankEntity();
		}
		PlatformBankEntity recPlat = lsPlat.get(0);
		return recPlat;
	}
	
	/**
	 * 检索第三方平台银行关联列表（带分页）
	 * 
	 * @param page
	 * @param selParam
	 * @return Page<PlatformBankEntity>
	 */
	public Page<PlatformBankEntity> selPlatformBank(
		Page<PlatformBankEntity> page,
		PlatformBankEntity selParam
	) {
		selParam.setPage(page);
		// 检索第三方平台银行关联
		List<PlatformBankEntity> ls = selPlatformBank(selParam);
		page.setList(ls);
		return page;
	}
	
	/**
	 * 取得第三方平台银行关联信息
	 * @param sysId 系统ID
	 * @param platId 平台ID
	 * @param bankId 银行ID
	 * @param deductFlag 划扣标识
	 * @param deductType 划扣方式
	 * @return Platform 平台信息
	 */
	public PlatformBankEntity getPlatformBank(
		String sysId, 
		String platId, 
		String bankId, 
		String deductFlag, 
		String deductType
	) {
		// 取得第三方平台银行关联信息
		PlatformBankEntity keyPlat = new PlatformBankEntity();
		keyPlat.setSysId(sysId); 				// 系统ID
		keyPlat.setPlatformId(platId);			// 平台ID
		keyPlat.setDeductFlag(deductFlag);		// 划扣标识
		keyPlat.setDeductType(deductType);		// 划扣方式
		keyPlat.setBankId(bankId);				// 银行ID
		PlatformBankEntity recPlat = getPlatformBank(keyPlat);
		
		return recPlat;
	}
	
	/**
	 * 取得第三方平台下的银行编号
	 * @param platId 平台ID
	 * @param bankId 银行ID
	 * @return String 银行CD
	 */
	public String getBankCd(
		String sysId,
		String platId, 
		String bankId, 
		String deductFlag, 
		String deductType
	) {
		PlatformBankEntity recPlat = getPlatformBank(sysId, platId, bankId, deductFlag, deductType);
		return recPlat.getBankCd();
	}
	
	/**
	 * 添加第三方平台银行关联
	 * @param key
	 * @return int
	 */
	@Transactional(readOnly = false)
	public int insPlatformBank(PlatformBankEntity key) {
		// 添加第三方平台银行关联信息
		int rtn = daoPb.insPlatformBank(key);
		return rtn;
	}
	
	/**
	 * 更新第三方平台银行关联
	 * @param key
	 * @return int
	 */
	@Transactional(readOnly = false)
	public int updPlatformBank(PlatformBankEntity key) {
		// 更新第三方平台银行关联信息
		int rtn = daoPb.updPlatformBank(key);
		return rtn;
	}
	
	/**
	 * 更新第三方平台银行关联
	 * 
	 * @param key
	 * @return int
	 */
	@Transactional(readOnly = false)
	public int updPlatformBankFortune(PlatformBankEntity key) {
		// 更新第三方平台银行关联信息
		int rtn = daoPb.updPlatformBankFortune(key);
		return rtn;
	}
}
