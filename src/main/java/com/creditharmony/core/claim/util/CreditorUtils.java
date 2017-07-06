package com.creditharmony.core.claim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.creditharmony.core.fortune.type.BillDay;


/**
 * 债权匹配工具类
 * @Class Name CommonUtils
 * @author 柳慧
 * @Create In 2015年11月24日
 */
public class CreditorUtils {

	/**
	 * 通过出借日期获取账单日 
	 * 2016年1月13日
	 * By 柳慧
	 * @param lendDay 出借日
	 * @return
	 */
	public static Date getCreditDaybyLendday(Date lendDay){
		Date creditDay = null;
		Calendar lendDaytemp = Calendar.getInstance();// 出借日期
		lendDaytemp.setTime(lendDay);
		Calendar pdtempDate = lendDaytemp;
		pdtempDate.set(Calendar.DAY_OF_MONTH, 1);
		try {
			if(0<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=3){
				if(lendDaytemp.get(Calendar.MONTH)+1==2){
					 int lastDay = lendDaytemp.getActualMaximum(Calendar.DAY_OF_MONTH);
					 if(lastDay==28){
							 Calendar temp = lendDaytemp;
								temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
								temp.set(Calendar.DAY_OF_MONTH, 28);
								return temp.getTime();
					 }
					 if(lastDay==29){
							 Calendar temp = lendDaytemp;
								temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
								temp.set(Calendar.DAY_OF_MONTH, 29);
								return temp.getTime();
					 }
				}
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 30);
				creditDay =  temp.getTime();
			}else if(4<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=6){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 4);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+1);
				creditDay =  temp.getTime();
			}else if(7<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=10){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 7);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+1);
				creditDay =  temp.getTime();
			}
			else if(11<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=14){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 11);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+1);
				creditDay =  temp.getTime();
			}
			else if(15<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=18){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 15);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+1);
				creditDay =  temp.getTime();
			}
			else if(19<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=22){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 19);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+1);
				creditDay =  temp.getTime();
			}
			else if(23<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=25){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 23);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+1);
				creditDay =  temp.getTime();
			}else if(26<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=29){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 26);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+1);
				creditDay =  temp.getTime();
			}else {
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 1);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)+2); // 下下个月1日
				temp.add(Calendar.DAY_OF_MONTH, -1); // 下月最后一天

				int dateNum = temp.get(Calendar.DAY_OF_MONTH)<30?temp.get(Calendar.DAY_OF_MONTH):30; 
				temp.set(Calendar.DAY_OF_MONTH, dateNum);

				creditDay =  temp.getTime();
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creditDay;
	}
	
	/**
	 * 通过结算日获取账单日 
	 * 2016年1月13日
	 * By 柳慧
	 * @param day 结算日
	 * @return Date 账单日
	 */
	public static Date getCreditDaybySettleday(Date day) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		
		int m = c.get(Calendar.MONTH) + 1;
		int d = c.get(Calendar.DAY_OF_MONTH);
		
		Calendar t = Calendar.getInstance();
		t.setTime(day);
		t.add(Calendar.MONTH, 1);
		
		if (d == 4) {
			t.set(Calendar.DAY_OF_MONTH, 19);
		}else if (d == 7) {
			t.set(Calendar.DAY_OF_MONTH, 23);
		}else if (d == 11) {
			t.set(Calendar.DAY_OF_MONTH, 26);
		}else if (d == 15) {
			t.set(Calendar.DAY_OF_MONTH, 30);
		}else if (d == 19) {
			t.set(Calendar.DAY_OF_MONTH, 4);
		}else if (d == 23) {
			t.set(Calendar.DAY_OF_MONTH, 7);
		}else if (d == 26) {
			t.set(Calendar.DAY_OF_MONTH, 11);
		}else if (d == 30) {
			t.set(Calendar.DAY_OF_MONTH, 15);
		}else if (d==28 || d == 29) {
			if(m == 2 && d == c.getActualMaximum(Calendar.DAY_OF_MONTH)){
				t.set(Calendar.DAY_OF_MONTH, 15);
			}else{
				t.add(Calendar.MONTH, -1);
			}
		}else{
			t.add(Calendar.MONTH, -1);
		}
		return t.getTime();
	}
	
	/**
	 * 通过账单日 获取还款日
	 * 2016年1月13日
	 * By 赵红江
	 * @param day 结算日
	 * @return Date 账单日
	 */
	public static Integer getCreditBmDay(Integer billDate) {
		String billDay=String.valueOf(billDate);
		Integer bmDay=0;
		if (BillDay.FOUR.value.equals(billDay)) {
			bmDay=3;
		}else if (BillDay.SEVEN.value.equals(billDay)) {
			bmDay=7;
		}else if (BillDay.ELVEN.value.equals(billDay)) {
			bmDay=10;
		}else if (BillDay.FIFTEEN.value.equals(billDay)) {
			bmDay=15;
		}else if (BillDay.NINETEEN.value.equals(billDay)) {
			bmDay=18;
		}else if (BillDay.TWENTYTHREE.value.equals(billDay)) {
			bmDay=23;
		}else if (BillDay.TWENTYSIX.value.equals(billDay)) {
			bmDay=25;
		}else if (BillDay.THIRTY.value.equals(billDay)) {
			bmDay=30;
		}
		return bmDay;
	}
	/**
	 * 通过出借日期获取上一个账单日 
	 * 2016年1月13日
	 * By 柳慧
	 * @param lendDay 出借日
	 * @return
	 */
	public static Date getbeforCreditDaybyLendday(Date lendDay){
		Date creditDay = null;
		Calendar lendDaytemp = Calendar.getInstance();// 出借日期
		lendDaytemp.setTime(lendDay);
		Calendar pdtempDate = lendDaytemp;
		pdtempDate.set(Calendar.DAY_OF_MONTH, 1);
		try {
			if(0<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=3){
				if(lendDaytemp.get(Calendar.MONTH)+1==3){
					lendDaytemp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)-1);
					 int lastDay = lendDaytemp.getActualMaximum(Calendar.DAY_OF_MONTH);
					 if(lastDay==28){
							 Calendar temp = lendDaytemp;
								temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
								temp.set(Calendar.DAY_OF_MONTH, 28);
								return temp.getTime();
					 }
					 if(lastDay==29){
							 Calendar temp = lendDaytemp;
								temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
								temp.set(Calendar.DAY_OF_MONTH, 29);
								return temp.getTime();
					 }
				}
				Calendar temp = lendDaytemp;
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH)-1);
				temp.set(Calendar.DAY_OF_MONTH, 30);
				creditDay =  temp.getTime();
			}else if(4<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=6){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 4);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}else if(7<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=10){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 7);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}
			else if(11<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=14){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 11);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}
			else if(15<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=18){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 15);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}
			else if(19<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=22){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 19);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}
			else if(23<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=25){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 23);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}else if(26<=daysBetween(pdtempDate.getTime(),lendDay) && daysBetween(pdtempDate.getTime(),lendDay)<=29){
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 26);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}else {
				Calendar temp = lendDaytemp;
				temp.set(Calendar.DAY_OF_MONTH, 30);
				temp.set(Calendar.MONTH, lendDaytemp.get(Calendar.MONTH));
				creditDay =  temp.getTime();
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creditDay;
	}
	
	/**
	 *  通过出借日期 算数上一个账单日和下一个账单日之间的天数
	 * 2016年1月13日
	 * By 柳慧
	 * @param lendDay
	 * @return
	 */
	public static int  getDateNumberBylendDay(Date lendDay){
		Date beforDate = getbeforCreditDaybyLendday(lendDay);
		Date afertDate = getCreditDaybyLendday(lendDay);
		try {
			return daysBetween(beforDate,afertDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	
	}
	
	/** 计算两个日期之间相差的天数  
	  * by 柳慧
	 * @param smdate 较小的时间 
	 * @param bdate  较大的时间 
	 * @return 相差天数 
	 * @throws ParseException 
	  */    
	public static int daysBetween(Date smdate,Date bdate) throws ParseException{    
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	    long between_days= 0;
	    smdate=sdf.parse(sdf.format(smdate));  
	    bdate=sdf.parse(sdf.format(bdate));  
	    Calendar cal = Calendar.getInstance();    
	    cal.setTime(smdate);    
	    long time1 = cal.getTimeInMillis();                 
	    cal.setTime(bdate);    
	    long time2 = cal.getTimeInMillis();  
	    if(time1-time2>=0){
	    	  between_days=(time1-time2)/(1000*3600*24);  
	    }else{
	    	 between_days=(time2-time1)/(1000*3600*24);  
	    }
	   
	        
	   return Integer.parseInt(String.valueOf(between_days));           
	}    
}
