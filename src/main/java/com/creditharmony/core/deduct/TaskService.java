package com.creditharmony.core.deduct;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.common.util.ListUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.common.type.UseFlag;
import com.creditharmony.core.deduct.bean.in.DeductReq;
import com.creditharmony.core.deduct.bean.out.DeResult;
import com.creditharmony.core.deduct.dao.DeductReqDao;
import com.creditharmony.core.deduct.entity.PlatformBankEntity;
import com.creditharmony.core.deduct.service.PlatformBankService;
import com.creditharmony.core.deduct.type.CardOrBookType;
import com.creditharmony.core.deduct.type.DeductFlagType;
import com.creditharmony.core.deduct.type.DeductPlatType;
import com.creditharmony.core.deduct.type.DeductType;
import com.creditharmony.core.deduct.type.DeductWays;
import com.creditharmony.core.deduct.type.ResultType;
import com.creditharmony.core.deduct.type.TaskStatusType;
import com.creditharmony.core.dict.util.DictUtils;
import com.creditharmony.core.type.SystemFlag;

/**
 * 划扣-Service
 * 
 * @Class Name DeductService
 * @author 周亮
 * @Create In 2016年01月01日
 */
@Service
public class TaskService {
	
	private static DeductReqDao daoReq = SpringContextHolder.getBean(DeductReqDao.class);
	
	private static PlatformBankService plbs = SpringContextHolder.getBean(PlatformBankService.class);
	
	/**
	 * 添加划扣任务
	 * 
	 * @param recReq 划扣任务
	 * @return 提交结果
	 */
	@Transactional(value="coreTransactionManager",readOnly = false)
	public static DeResult addTask(DeductReq recReq) {
		
		DeResult ret = new DeResult();
		List<String> requestIdList = new ArrayList<String>();
		String newRule = recReq.getRule();
		String sysId = recReq.getSysId();
		String sys = "";
		if (sysId.startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
			sys = String.valueOf(SystemFlag.FORTUNE.value);
		} else {
			sys = String.valueOf(SystemFlag.LOAN.value);
		}
		if (!StringUtils.isEmpty(newRule)) {
			String[] rules = recReq.getRule().split(",");
			StringBuffer sb = new StringBuffer();
			for (String rule : rules) {
				String[] ru = rule.split(":");
				String platId = ru[0];
				String deducttype = ru[1];
				PlatformBankEntity pfbe = new PlatformBankEntity();
				pfbe.setPlatformId(platId);
				pfbe.setBankId(recReq.getBankId());
				pfbe.setDeductFlag(recReq.getDeductFlag());
				pfbe.setDeductType(deducttype);
				pfbe.setSysId(sys);
				pfbe.setStatus(UseFlag.QY.value);
				pfbe = plbs.getPlatformBank(pfbe);
				Long SingleLimitMoney = pfbe.getSingleLimitMoney();
				if (SingleLimitMoney == null || SingleLimitMoney == 0L) {
					continue;
				}
				sb.append(rule + ",");
			}
			newRule = sb.toString();
			if (newRule.endsWith(",")) {
				newRule = newRule.substring(0, newRule.length() - 1);
			}
			recReq.setRule(newRule);
		}
		String msg = validate(recReq);
		if (StringUtils.isNotBlank(msg) && msg.length() > 0) {
			ret.setReCode(ResultType.ADD_FAIL.getCode());
			ret.setReMge(msg);
			ret.setDeductReq(recReq);
			return ret;
		} else {
			// 添加划扣任务
			String requestId = recReq.getRequestId();
			if (StringUtils.isEmpty(requestId)) {
				requestId = getNowTime() + randomStr(10);
			}

			// 判断是否已存在
			if (Boolean.FALSE == isExites(requestId, sysId)) {
				
				recReq.setRequestId(requestId);								// 请求ID
				recReq.setStatus(TaskStatusType.ADDED.getCode());			// 划扣状态->0:待处理
				recReq.setUnsplitTimes(newRule.split(",").length);			// 拆分次数->划扣平台数
				recReq.setUnsplitAmount(convertMoney(recReq.getAmount()));	// 剩余金额->划扣金额
				recReq.setCreatby(getSys(sysId));							// 创建人
				recReq.setCreatTime(new Date());							// 创建时间
				recReq.setModifyby(getSys(sysId));							// 修改人
				recReq.setModifyTime(new Date());							// 修改时间
				recReq.setTable(getTableBySysId(sysId));
				daoReq.insert(recReq);
				ret.setReCode(ResultType.ADD_SUCCESS.getCode());
				ret.setReMge(ResultType.ADD_SUCCESS.getMsg());
				requestIdList.add(recReq.getRequestId());
				ret.setDeductReq(recReq);
			} else {
				ret.setReCode(ResultType.ADD_UPFAILED.getCode());
				ret.setReMge(ResultType.ADD_UPFAILED.getMsg());
				requestIdList.add(recReq.getRequestId());
				ret.setDeductReq(recReq);
			}
			return ret;
		}
	}
	/**
	 * 取得系统标识
	 * @param sysId 系统id
	 * @return 结果
	 */
	private static String getSys(String sysId) {
		if (sysId.startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
			return "Fortune";
		} else if (sysId.startsWith(String.valueOf(SystemFlag.LOAN.value))) {
			return "Loan";
		} else {
			return "Other";
		}
	}
	
	/**
	 * 判断数据是否已存在
	 * @param requestId 请求ID
	 * @return 结果
	 */
	private static boolean isExites(String requestId, String sysId) {
		int ret = 0;
		String table = getTableBySysId(sysId);
		ret = daoReq.selectCount(requestId, table);
		if (ret > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 撤销任务
	 * @param recReq 被撤销的任务
	 * @return 结果
	 */
	@Transactional(value="coreTransactionManager",readOnly = false)
	public static DeResult rollBack(DeductReq recReq) {
		DeResult ret = new DeResult();
		int u = delete(recReq.getRequestId(), recReq.getSysId());
		if (u == 0) {
			ret.setReCode(ResultType.ADD_UPFAILED.getCode());
			ret.setReMge(ResultType.ADD_UPFAILED.getMsg());
			ret.setDeductReq(recReq);
			return ret;
		}
		ret.setReCode(ResultType.ADD_RBSUCCESS.getCode());
		ret.setReMge(ResultType.ADD_RBSUCCESS.getMsg());
		ret.setDeductReq(recReq);
		return ret;
	}
	
	
	/**
	 * 提交任务更新
	 * @param requestList 请求IDList
	 * @return 结果
	 */
	public static DeResult commit(DeductReq recReq) {
		DeResult ret = new DeResult();
		String status = findStatus(recReq.getRequestId(), recReq.getSysId());
		if (TaskStatusType.PENDING.getCode().equals(status)
				|| TaskStatusType.PROCESSING.getCode().equals(status)
				|| TaskStatusType.DONE.getCode().equals(status)
				|| TaskStatusType.BATCHING.getCode().equals(status)
		) {
			ret.setReCode(ResultType.ADD_SUCCESS.getCode());
			ret.setReMge(ResultType.ADD_SUCCESS.getMsg());
			ret.setDeductReq(recReq);
			return ret;
		}
		int u = update(recReq.getRequestId(), recReq.getSysId());
		if (u == 0) {
			ret.setReCode(ResultType.ADD_UPFAILED.getCode());
			ret.setReMge(ResultType.ADD_UPFAILED.getMsg());
			ret.setDeductReq(recReq);
			return ret;
		}
		ret.setReCode(ResultType.ADD_SUCCESS.getCode());
		ret.setReMge(ResultType.ADD_SUCCESS.getMsg());
		ret.setDeductReq(recReq);
		return ret;
	}
	/**
	 * 删除请求任务
	 * @param requestId 请求ID
	 * @return 结果
	 */
	@Transactional(value="coreTransactionManager",readOnly = false)
	private static int delete(String requestId, String sysId) {
		int ret = 0;
		String table = getTableBySysId(sysId);
		try {
			ret = daoReq.delete(requestId, table);
		} catch (Exception e) {
			return ret;
		}
		return ret;
	}
	
	/**
	 * 查看处理状态
	 * @param requestId 请求ID
	 * @return 结果
	 */
	private static String findStatus(String requestId, String sysId) {
		String table = getTableBySysId(sysId);
		return daoReq.selectStatus(requestId, table);
	}
	
	
	/**
	 * 更新请求任务状态
	 * @param requestId 请求ID
	 * @return 结果
	 */
	@Transactional(value="coreTransactionManager",readOnly = false)
	private static int update(String requestId, String sysId) {
		int ret = 0;
		String table = getTableBySysId(sysId);
		try {
			ret = daoReq.update(requestId, TaskStatusType.PENDING.getCode(), table);
		} catch (Exception e) {
			return ret;
		}
		return ret;
	}
	
	/**
	 * 添加划扣任务
	 * 
	 * @param lsReq 划扣任务序列
	 * @return 提交结果
	 */
	@Transactional(value="coreTransactionManager",readOnly = false)
	public static DeResult addTask(List<DeductReq> lsReq) {
		
		DeResult ret = new DeResult();
		StringBuffer sb = new StringBuffer();
		List<DeResult> failResultList = new ArrayList<DeResult>();
//		List<String> requestIdList = new ArrayList<String>();
		for (DeductReq recReq : lsReq) {
			ret = addTask(recReq);
			if (ret.getReCode().equals(ResultType.ADD_FAIL.getCode())) {
				failResultList.add(ret);
			}
//			requestIdList.addAll(ret.getRequestIdList());
		}
		
		if (ListUtils.isNotEmptyList(failResultList)) {
			for (DeResult drt : failResultList) {
				String msg = drt.getReMge();
				sb.append(msg + "/r/n");
			}
			ret.setReCode(ResultType.ADD_FAIL.getCode());
			ret.setReMge(sb.toString());
//			ret.setRequestIdList(requestIdList);
			return ret;
		}
		
		ret.setReCode(ResultType.ADD_SUCCESS.getCode());
		ret.setReMge(ResultType.ADD_SUCCESS.getMsg());
//		ret.setRequestIdList(requestIdList);
		return ret;
	}
	
	
	/**
	 * 验证
	 * @param recReq
	 * @return
	 */
	public static String validate (DeductReq recReq){
		StringBuffer sb = new StringBuffer();
		boolean  okFlag = true;
		if (recReq == null) {
			sb.append("请求对象为空;");
			okFlag = false;
			return sb.toString();
		}
		String businessId = recReq.getBusinessId();
		sb.append("业务编号为：" + businessId + "的");
		/* 各项目check */
		// 划扣标志
		String deductFlag = recReq.getDeductFlag();
		if (StringUtils.isEmpty(deductFlag) || 
			(Boolean.FALSE == DeductFlagType.COLLECTION.getCode().equals(deductFlag) &&
				Boolean.FALSE == DeductFlagType.PAY.getCode().equals(deductFlag))
		) {
			sb.append("划扣标志不正确.");
			okFlag = false;
		}
		// 划扣/放款金额
		if (recReq.getAmount() == null 
				|| recReq.getAmount().equals(BigDecimal.ZERO) 
		) {
			sb.append("金额不得为空或为0.");
			okFlag = false;
		}
		// 划扣放款金额是否小于0
		if (recReq.getAmount().compareTo(BigDecimal.ZERO) == -1) {
			sb.append("金额不得为负数.");
			okFlag = false;
		}
		
		// 划扣平台及银行
		if (StringUtils.isEmpty(recReq.getRule())) {
			sb.append("划扣平台不正确.");
			okFlag = false;
		}
		if (StringUtils.isEmpty(recReq.getBankId())) {
			sb.append("划扣银行不得为空.");
			okFlag = false;
		}
		// 账号类型(为空时，默认为卡00)
		if (StringUtils.isEmpty(recReq.getAccountType())) {
			recReq.setAccountType(CardOrBookType.BANKCARD.getCode());
		}
		// 判断划扣平台合法性
		if (StringUtils.isEmpty(recReq.getRule())) {
			sb.append("平台跳转规则未配置或平台不支持." + "<br>");
			okFlag = false;
		} else {
			String[] rules = recReq.getRule().split(",");
			String plt = "";
			String type = "";
			for (String rule : rules) {
				String[] pAndt = rule.split(":");
				plt = pAndt[0];
				type = pAndt[1];
				if (DeductPlatType.FY.getCode().equals(plt) && DeductType.BATCH.getCode().equals(type)) {
					sb.append("富友平台无批量接口，提交数据不合法.");
					okFlag = false;
				}
				//**************卡联*********************
				if (DeductPlatType.KL.getCode().equals(plt)) {
					if(StringUtils.isEmpty(recReq.getBranchCode())) {
						sb.append("支行编号不能为空.");
						okFlag = false;
					}
					if(StringUtils.isEmpty(recReq.getBusObjType())) {
						sb.append("业务对象类型不能为空.");
						okFlag = false;
					}
				}
				//**************卡联*********************
				//**************畅捷通*********************
				if (DeductPlatType.CJT.getCode().equals(plt)) {
					if(StringUtils.isEmpty(recReq.getProtocolNo())) {
						sb.append("畅捷通平台的签约协议号不能为空.");
						okFlag = false;
					}
				}
				//**************畅捷通*********************
			}
			// 判断银行及平台是否支持
			if (recReq.getSysId().startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
				for (String rule : rules) {
					String[] ru = rule.split(":");
					String platId = ru[0];
					PlatformBankEntity platformBank = new PlatformBankEntity();
					platformBank.setPlatformId(platId);
					platformBank.setBankId(recReq.getBankId());
					platformBank.setDeductFlag(deductFlag);
					platformBank.setSysId(String.valueOf(SystemFlag.FORTUNE.value));
					platformBank = plbs.getPlatformBank(platformBank);
					Long SingleLimitMoney = platformBank.getSingleLimitMoney();
					if (SingleLimitMoney == null || SingleLimitMoney == 0L) {
//							String platformName = pfud.selPlatformNameById(platId);
						String platformName = DictUtils.getDictLabel(platId, "tz_deduct_plat", "");
						sb.append("所选银行" + platformName + "不支持.");
						okFlag = false;
					}
					
				}
				if (DeductFlagType.COLLECTION.getCode().equals(deductFlag)) {
					// 取得剩余平台可划扣金额合计
					Long sumDayLimit = 
							getRestSumDayLimit(
									recReq.getRule(), 
									rules.length, 
									recReq.getBankId(), 
									recReq.getSysId()
							);
					Long unsplitAmount = convertMoney(recReq.getAmount());
					if (unsplitAmount > sumDayLimit) {
						sb.append("划扣金额已大于平台单日限额.");
						okFlag = false;
					}
				}

			}
		}
		// 账号相关
		if (StringUtils.isEmpty(recReq.getAccountNo())
				|| StringUtils.isEmpty(recReq.getAccountName())
		) {
			sb.append("账号及账户名称不得为空.");
			okFlag = false;
		}
		// 证件相关
//		if (StringUtils.isEmpty(recReq.getIdType())) {
//			sb.append("证件类型不得为空.");
//			okFlag = false;
//		} else if ("0".equals(recReq.getIdType())){
//			if (Boolean.FALSE == IdcardUtils.validateIdCard18(recReq.getIdNo()) 
//					&& Boolean.FALSE == IdcardUtils.validateIdCard15(recReq.getIdNo())
//			) {
//				sb.append("证件不合法.");
//				okFlag = false;
//			}
//		} else if (StringUtils.isEmpty(recReq.getIdNo())) {
//			sb.append("证件编号不得为空.");
//			okFlag = false;
//		}

		// 批次号（市场订单号）没有的话，新生成
		if (StringUtils.isEmpty(recReq.getBatId())) {
			recReq.setBatId(getBatId());
		}
		// 返回
		if(!okFlag){
			return sb.toString();
		}
		return "";
	}
	
	
	/**
	 * 获取当前系统时间
	 * @param patten yyyy/MM/dd 或  "yyyy-MM-dd HH:mm:ss"
	 * @return String
	 */
	private static String getNowTime() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(new Date().getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(c.getTime());
	}
	
	/**
	 * 随机产生指定长度的数据字符串
	 * @param length 指定长度
	 * @return 结果
	 */
	private static String randomStr(int length) {
		if (length < 1) {
			return null;
		}
		Random strGen = new Random();
		char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz").toCharArray();
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[strGen.nextInt(35)];
		}
		return new String(randBuffer);
	}
	
	/**
	 * 将金额从元为单位转为以分为单位
	 * 
	 * @param money 金额（元）
	 * @return 结果
	 */
	private static Long convertMoney(BigDecimal money) {
		String ret = "";
		if (money == null || money == BigDecimal.ZERO) {
			return 0L;
		}
		money = money.multiply(new BigDecimal(100));

		int idx = money.toString().indexOf(".");
		if (idx > 0) {
			ret = money.toString().substring(0, idx);
		} else {
			ret = money.toString();
		}
		
		return Long.parseLong(ret);
	}
	/**
	 * 生成请求ID
	 * @return 请求ID
	 */
	public static String getRequestId() {
		return getNowTime() + randomStr(10);
	}
	
	
//	/** 
//     * 手机号验证 
//     *  
//     * @param  str 
//     * @return 验证通过返回true 
//     */  
//    private static boolean isMobile(String str) {   
//        Pattern p = null;  
//        Matcher m = null;  
//        boolean b = false;   
//        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号  
//        m = p.matcher(str);  
//        b = m.matches();   
//        return b;  
//    }
    /**
     * 取得市场订单号
     * @return
     */
    private static String getBatId() {
    	String base = DateUtils.getDate("yyyyMMdd") + "1200";
    	String batId = "";
    	try {
			Date b = DateUtils.parseDate(base, "yyyyMMddHHmm");
			Date n = new Date();
			if (Boolean.TRUE == DateUtils.dateAfter(n, b)) {
				batId = base + "99999999";
			} else {
				batId = base + "88888888";
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return batId;
    }
    /**
     * 算出所有平台单日限额总数
     * @param allRule
     * @param unsplitTimes
     * @param bankId
     * @param sysId
     * @return
     */
	private static Long getRestSumDayLimit(String allRule, int unsplitTimes, String bankId, String sysId) {
		Long sumDayLimit = 0L; 						// 单日限额合计
		PlatformBankEntity recPlat = null;			// 平台数据
		
		String[] arrAllRule = allRule.split(",");
		// 取得平台数
		int maxPlat = arrAllRule.length;
		// 剩余平台可划扣金额合计
		sumDayLimit = 0L;
		String sid = "";
		if (sysId.startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
			sid = String.valueOf(SystemFlag.FORTUNE.value);
		}
		if (sysId.startsWith(String.valueOf(SystemFlag.LOAN.value))) {
			sid = String.valueOf(SystemFlag.LOAN.value);
		}
		
		
		for (int j = maxPlat - unsplitTimes; j < maxPlat; j++) {
			String pfId = arrAllRule[j].split(":")[0];
			String deductType = arrAllRule[j].split(":")[1];
			recPlat = plbs.getPlatformBank(sid, pfId, bankId, DeductFlagType.COLLECTION.getCode(), deductType);
			if (recPlat.getDayLimitMoney() != null) {
				sumDayLimit += recPlat.getDayLimitMoney();
			}	
		}
		return sumDayLimit;
	}
	/**
	 * 根据业务ID取得表名称
	 * @param sysId 业务ID
	 * @return 结果
	 */
	private static String getTableBySysId(String sysId) {
		if (DeductWays.CF_01.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cf01";
		}
		if (DeductWays.CF_02.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cf02";
		}
		if (DeductWays.CF_03.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cf03";
		}
		if (DeductWays.HJ_01.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_hj01";
		}
		if (DeductWays.HJ_02.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_hj02";
		}
		if (DeductWays.HJ_03.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_hj03";
		}
		if (DeductWays.HJ_04.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_hj04";
		}
		if (DeductWays.CJHK_09.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cj04";
		}
		
		/******************车借划扣服务用系统处理ID类型******************/
		if (DeductWays.CJ_01.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cj01";
		}
		if (DeductWays.CJ_02.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cj02";
		}
		if (DeductWays.CJ_03.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cj03";
		}
		if (DeductWays.ZJ_01.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_zj01";
		}
		if (DeductWays.CJHK_10.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cj05";
		}
		return "";
	}
}
