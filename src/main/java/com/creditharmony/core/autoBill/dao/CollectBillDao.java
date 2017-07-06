package com.creditharmony.core.autoBill.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.autoBill.entity.DeductHistory;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface CollectBillDao extends CrudDao<DeductHistory> {
   /**
    * 取平台划扣成功且我方不为处理中的数据（结算对账）
    * 2016年2月23日
    * By 何军
    * @param params
    * @return
    */
   public List<DeductHistory> findCollectBill(Map<String,Object> params, PageBounds pageBounds);
   
   public List<DeductHistory> findCollectBill(Map<String,Object> params);
   
	/**
	 * 检索已对账数据
	 * 
	 * @param params
	 * @param pageBounds
	 * @return Page<DeductHistory>
	 */
   public List<DeductHistory> findCollectBilled(Map<String,Object> params, PageBounds pageBounds);
   
	/**
	 * 检索已对账数据（导出excel用）
	 * 
	 * @param params
	 * @return Page<DeductHistory>
	 */
   public List<DeductHistory> findCollectBilled(Map<String,Object> params);
   
   /**
    * 根据参数获取所有的批次号
    * 2016年2月23日
    * By 何军
    * @param params
    * @return
    */
   public List<DeductHistory> findCollectBillForBatchNo(Map<String,Object> params);
   
   
   public List<DeductHistory> findCollectBillByDate(Map<String,Object> params);
   
   /**
    * 根据参数获取所有值
    * 2016年2月24日
    * By 何军
    * @param params
    * @return
    */
   public Double findCollectBillForTotalMoney(Map<String,Object> params);
}