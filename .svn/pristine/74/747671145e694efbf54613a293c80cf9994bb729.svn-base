package com.creditharmony.core.deduct.dao;

import java.util.List;
import com.creditharmony.core.deduct.entity.PlatformBankEntity;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

/**
 * 第三方平台银行关联配置表-Dao
 * 
 * @Class Name PlatformDao
 * @author 周亮
 * @Create In 2016年01月01日
 */
@CoreBatisDao
public interface PlatformBankDao {
	
	/**
	 * 检索第三方平台银行关联
	 * 
	 * @param  key		
	 * @return Platform 检索结果
	 */
    public List<PlatformBankEntity> selPlatformBank(PlatformBankEntity key);

	/**
	 * 添加第三方平台银行关联
	 * 
	 * @param  key 平台信息
	 * @return int 插入结果
	 */
    public int insPlatformBank(PlatformBankEntity key);

    /**
	 * 更新第三方平台银行关联
	 * 
	 * @param  key 平台信息
	 * @return int 更新结果
	 */
    public int updPlatformBank(PlatformBankEntity key);
    
    /**
	 * 更新第三方平台银行关联(财富)
	 * 
	 * @param  key 平台信息
	 * @return int 更新结果
	 */
    public int updPlatformBankFortune(PlatformBankEntity key);
    
	/**
	 * 删除第三方平台银行关联
	 * 
	 * @param platformId 平台id
	 * @return 删除结果
	 */
    public int deleteByPrimaryKey(PlatformBankEntity key);
}