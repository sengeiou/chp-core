package com.creditharmony.core.autoBill.dao;

import java.util.List;
import java.util.Map;

import com.creditharmony.core.autoBill.entity.AutoBillInfo;
import com.creditharmony.core.autoBill.entity.AutoBillTemp;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface AutoBillTempDao extends CrudDao<AutoBillTemp> {
   /**
    * 插入对账的数据
    * 2016年2月23日
    * By 何军
    * @param autoBillTemps
    */
   public void insertBatch(Map<String,List<AutoBillTemp>> map);
   /**
    * 插入已对账历史表
    * 2016年3月17日
    * By 何军
    * @param map
    */
   public void insertHisBatch(List<String> list);
   /**
    * 删除对账的数据
    * 2016年2月23日
    * By 何军
    * @param autoBillTemp
    */
   public void deleteBatch(List<String> list);
   
   public void deleteAll();
   
   /**
    * 回执数据状态
    * 2016年2月26日
    * By 何军
    * @param autoBillTemp
    */
   public void updateDeductHisStatus(List<AutoBillInfo> list);
   
   public void updateCollectHisStatus(List<AutoBillInfo> list);
   
   /**
    * 回执数据状态
    * 2016年2月26日
    * By 何军
    * @param autoBillTemp
    */
   public void updatePayHisStatus(Map<String,Object> params);
}
