package com.creditharmony.core.autoBill.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.autoBill.entity.PeriodBalanceInfo;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface PeriodBalanceDao extends CrudDao<PeriodBalanceInfo> {

	public List<PeriodBalanceInfo> findList(Map<String, Object> params);

	public PeriodBalanceInfo findByDate(PeriodBalanceInfo periodBalanceInfo);
	
	public PeriodBalanceInfo findByBillDate(String billDate);
	
	public void deleteByDate(PeriodBalanceInfo periodBalanceInfo);
	
	public void updateRechargeById(PeriodBalanceInfo periodBalanceInfo);

}
