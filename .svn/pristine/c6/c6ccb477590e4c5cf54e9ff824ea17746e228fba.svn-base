package com.creditharmony.core.autoBill.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.autoBill.entity.DeductHistory;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface DeductBillDao extends CrudDao<DeductHistory> {
   
   /**
    * 取划扣请求及其回盘结果（划扣对账）
    * 2016年2月23日
    * By 何军
    * @param params
    * @return
    */
   public List<DeductHistory> findDeductBill(Map<String,Object> params, PageBounds pageBounds);
   
   public List<DeductHistory> findDeductBill(Map<String,Object> params);
   
	/**
	 * 检索已对账数据
	 * 
	 * @param params
	 * @param pageBounds
	 * @return Page<DeductHistory>
	 */
   public List<DeductHistory> findDeductBilled(Map<String, Object> params, PageBounds pageBounds);
   
	/**
	 * 检索已对账数据（导出excel用）
	 * 
	 * @param params
	 * @return Page<DeductHistory>
	 */
   public List<DeductHistory> findDeductBilled(Map<String, Object> params);
   
   /**
    * 根据参数获取所有的批次号
    * 2016年2月23日
    * By 何军
    * @param params
    * @return
    */
   public List<DeductHistory> findDeductBillForBatchNo(Map<String,Object> params);
   
   /**
    * 根据参数获取所有值
    * 2016年2月24日
    * By 何军
    * @param params
    * @return
    */
   public Double findDeductBillForTotalMoney(Map<String,Object> params);
   
}
