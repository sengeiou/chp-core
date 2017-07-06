package com.creditharmony.core.fortune.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.ListUtils;
import com.creditharmony.core.fortune.dao.BilldayCfgDao;
import com.creditharmony.core.fortune.entity.BilldayCfgEntity;

/**
 * 结算日账单日配置-Service
 * 
 * @Class Name CreditorService
 * @author 周亮
 * @Create In 2016年01月01日
 */
@Service
@Transactional(value = "fortuneTransactionManager", readOnly = true)
public class CreditorService {
	
	@Autowired
	private BilldayCfgDao daoBd;
	
	/**
	 * 检索结算日账单日配置
	 * 
	 * @param key
	 * @return List<BilldayCfgEntity>
	 */
	public List<BilldayCfgEntity> selBilldayCfg(BilldayCfgEntity key) {
		// 取得结算日账单日配置
		List<BilldayCfgEntity> ls = daoBd.selBilldayCfg(key);

		return ls;
	}

	/**
	 * 取得结算日账单日配置
	 * 
	 * @param key
	 * @return BilldayCfgEntity
	 */
	public BilldayCfgEntity getBilldayCfg(BilldayCfgEntity key) {
		// 取得结算日账单日配置
		List<BilldayCfgEntity> ls = selBilldayCfg(key);
		if (ListUtils.isEmptyList(ls)) {
			return new BilldayCfgEntity();
		}
		BilldayCfgEntity recPlat = ls.get(0);
		return recPlat;
	}
	
	/**
	 * 取得结算日账单日配置
	 * 
	 * @param key
	 * @return BilldayCfgEntity
	 */
	public BilldayCfgEntity getBilldayCfg(Date day) {
		// 结算日
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		int m = c.get(Calendar.MONTH) + 1;		// 月
		int d = c.get(Calendar.DAY_OF_MONTH);	// 日
		
		// 账单日
		Calendar t = Calendar.getInstance();
		t.setTime(day);

		// 如果结算日>15，则账单日是结算日的下个月
		if (d > 15) {
			t.add(Calendar.MONTH, 1);
		}
		
		// 取得结算日账单日配置
		BilldayCfgEntity key = new BilldayCfgEntity();
		key.setMonth(m);
		key.setSettleDay(d);
		// 如果结算日是2月最后一天，检索条件结算日置为30
		if (m == 2) {
			if (d == c.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				key.setSettleDay(30);
			}
		}
		BilldayCfgEntity cfg = getBilldayCfg(key);
		
		// 如果账单日没被test指定
		if (cfg.getBillDate() == null) {
			// 配置生成账单日
			if (cfg.getBillDay() != null) {
				t.set(Calendar.DAY_OF_MONTH, cfg.getBillDay());
				// 如果结算日是2月15日，账单日应是2月最后一天
				if (m == 2) {
					if (d == 15) {
						t.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				cfg.setBillDate(t.getTime());
			}
		} else {
			// test指定生成BillDate
			Calendar r = Calendar.getInstance();
			r.setTime(cfg.getBillDate());
			
			cfg.setBillDay(r.get(Calendar.DAY_OF_MONTH));	// 账单日
			// 如果test指定BillDate是2月最后一天，账单日应是30
			if (r.get(Calendar.MONTH) == 1) {
				if (r.get(Calendar.DAY_OF_MONTH) == r.getActualMaximum(Calendar.DAY_OF_MONTH)) {
					cfg.setBillDay(30);	// 账单日
				}
			}
		}
		
		return cfg;
	}
	
	/**
	 * 取得执行日配置
	 * 
	 * @param key
	 * @return BilldayCfgEntity
	 */
	public BilldayCfgEntity getExeDayCfg(Date day) {
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		int m = c.get(Calendar.MONTH) + 1;		// 月
		int d = c.get(Calendar.DAY_OF_MONTH);	// 日
		
		// 取得配置
		BilldayCfgEntity key = new BilldayCfgEntity();
		key.setMonth(m);
		key.setSettleDay(d);
		BilldayCfgEntity cfg = getBilldayCfg(key);
		
		// 如果账单日没被test指定
		if (cfg.getBillDate() == null) {
			cfg.setBillDate(day);
		} else {
			// test指定生成账单日
			Calendar r = Calendar.getInstance();
			r.setTime(cfg.getBillDate());
			
			cfg.setBillMonth(r.get(Calendar.MONTH) + 1);	// 账单月
			cfg.setBillDay(r.get(Calendar.DAY_OF_MONTH));	// 账单日
		}
		
		return cfg;
	}
	
}
