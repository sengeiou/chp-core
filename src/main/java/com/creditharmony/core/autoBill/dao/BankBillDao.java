package com.creditharmony.core.autoBill.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.autoBill.entity.BankBillInfo;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface BankBillDao extends CrudDao<BankBillInfo> {
	
	public List<BankBillInfo> findBankBillList(Map<String,Object> params, PageBounds pageBounds);
	
	public List<BankBillInfo> findBankBillList(Map<String,Object> params);
	
	public List<String> findBillDate(Map<String,Object> params);
	
	public void updateStatus(Map<String,Object> params);
	
	public BankBillInfo findByDate(BankBillInfo bankBillInfo);
	public BankBillInfo findByBillDate(String billDate);
	
	
	
}
