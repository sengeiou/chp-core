package com.creditharmony.core.hldmng.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.common.util.ListUtils;
import com.creditharmony.core.hldmng.dao.HldMngDao;
import com.creditharmony.core.hldmng.entity.HldMngEntity;
import com.creditharmony.core.persistence.Page;

/**
 * 财富节假日管理-Service
 * 
 * @Class Name HldMngService
 * @author 周亮
 * @Create In 2015年12月9日
 */
@Service
public class HldMngService {

	@Autowired
	private HldMngDao hldDao;
	
	/**
	 * 检索节假日
	 * 
	 * @param page
	 * @param selParam
	 * @return Page<FortuneHldMngEntity>
	 */
	public Page<HldMngEntity> selHld(
		Page<HldMngEntity> page,
		HldMngEntity selParam
	) {
		selParam.setPage(page);
		// 检索节假日
		List<HldMngEntity> ls = hldDao.selHld(selParam);
		page.setList(ls);
		
		return page;
	}
	
	/**
	 * 添加节假日
	 * 
	 * @param insParam
	 */
	@Transactional(readOnly = false)
	public void insHld(HldMngEntity insParam) {
		// 添加节假日
		hldDao.insHld(insParam);
	}
	
	/**
	 * 删除节假日
	 * @param delParam
	 */
	@Transactional(readOnly = false)
	public void delHld(HldMngEntity delParam) {
		// 删除节假日
		hldDao.delHld(delParam);
	}
	
	/**
	 * 判断是否是节假日
	 * 
	 * @param day 
	 * @return boolean
	 */
	public boolean isHoliday(Date day) {
		HldMngEntity key = new HldMngEntity();
		key.setHoliday(day);
		// 检索节假日
		List<HldMngEntity> ls = hldDao.selHld(key);
		
		boolean rtn = false;
		if (ListUtils.isNotEmptyList(ls)) {
			if (ls.size() > 0) {
				rtn = true;
			}
		}
		
		return rtn;
	}
	
	/**
	 * 判断是否是工作日
	 * 
	 * @param day 
	 * @return boolean
	 */
	public boolean isWorkday(Date day) {
		boolean rtn = true;
		if (isHoliday(day)) {
			rtn = false;
		} 
		
		return rtn;
	}
	
	/**
	 * 取得当前日期的下一个工作日
	 * 
	 * @param day 
	 * @return Date
	 */
	public Date getNextWorkday() {
		Date nd = new Date();
		while (true) {
			nd = DateUtils.getNextday(nd);
			if (isWorkday(nd)) {
				break;
			}
		}
		
		return nd;
	}
	
	/**
	 * 取得指定日期的下一个工作日
	 * 
	 * @param day 
	 * @return Date
	 */
	public Date getNextWorkday(Date day) {
		Date nd = day;
		while (true) {
			nd = DateUtils.getNextday(nd);
			if (isWorkday(nd)) {
				break;
			}
		}
		
		return nd;
	}
	
	/**
	 * 取得当前日期的下几个工作日
	 * 
	 * @param day 
	 * @return Date
	 */
	public List<Date> getNextWorkdays(int i) {
		List<Date> ls = new ArrayList<Date>();
		int j = 0;
		Date nd = new Date();
		
		while (true) {
			nd = DateUtils.getNextday(nd);
			if (isWorkday(nd)) {
				ls.add(nd);
				j++;
				if (j == i) {
					break;
				}
			}
		}
		
		return ls;
	}
	
	/**
	 * 取得指定日期的下几个工作日
	 * 
	 * @param day 
	 * @return Date
	 */
	public List<Date> getNextWorkdays(Date day, int i) {
		List<Date> ls = new ArrayList<Date>();
		int j = 0;
		
		while (true) {
			day = DateUtils.getNextday(day);
			if (isWorkday(day)) {
				ls.add(day);
				j++;
				if (j == i) {
					break;
				}
			}
		}
		
		return ls;
	}
}
