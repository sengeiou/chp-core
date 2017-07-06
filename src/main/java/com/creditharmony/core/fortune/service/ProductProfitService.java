package com.creditharmony.core.fortune.service;

/**
 * 收益调整联动回款更新
 * @Class Name ProductProfitService<br/>
 * @author 陈广鹏<br/>
 * @Create In 2016年12月27日
 */
public interface ProductProfitService {
	
	/**
	 * <p>根据收益调整 Id 联动更新回款数据</p>
	 * 2016年12月27日<br/>
	 * By 陈广鹏<br/>
	 * @param roductProfitId 收益调整主键id
	 */
	public boolean updateBackMoney(String productProfitId);
	
	
	public String testHello(String name);

}
