package com.creditharmony.core.deduct.proxy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.common.util.IdcardUtils;
import com.creditharmony.common.util.ListUtils;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.common.type.CertificateType;
import com.creditharmony.core.common.type.DictTypeIndex;
import com.creditharmony.core.common.util.DeductHelper;
import com.creditharmony.core.common.util.MoneyUtil;
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
 * 处理划扣业务的代理业务类
 * 用途：供汇金业务类调用，保存划扣请求数据
 * @Class Name DeductProxy
 * @author 张永生
 * @Create In 2016年5月20日
 */
@Component
public class DeductTaskProxy {
	
	public final static Logger logger = LoggerFactory.getLogger(DeductTaskProxy.class);

	public static DeductReqDao deductRequsetDao = SpringContextHolder.getBean(DeductReqDao.class);

	public static PlatformBankService platformBankService = SpringContextHolder.getBean(PlatformBankService.class);

	/**
	 * 添加划扣任务
	 * @param recReq 划扣任务
	 * @return 提交结果
	 */
	@Transactional(value = "coreTransactionManager", readOnly = false)
	public DeResult saveDeductRequest(DeductReq deductRequest) {
		DeResult deductResult = new DeResult();
		List<String> requestIdList = new ArrayList<String>();
		String newRule = deductRequest.getRule();
		String sysId = deductRequest.getSysId();
		String systemFlag = "";
		if (sysId.startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
			systemFlag = String.valueOf(SystemFlag.FORTUNE.value);
		} else {
			systemFlag = String.valueOf(SystemFlag.LOAN.value);
		}
		if (StringUtils.isNotEmpty(newRule)
				&& DeductFlagType.COLLECTION.getCode().equals(deductRequest.getDeductFlag())) {
			String[] rules = deductRequest.getRule().split(",");
			StringBuffer result = new StringBuffer();
			for (String rule : rules) {
				String[] ruleArray = rule.split(":");
				String platformId = ruleArray[0];
				String deductType = ruleArray[1];
				PlatformBankEntity platformBank = new PlatformBankEntity();
				platformBank.setPlatformId(platformId);
				platformBank.setBankId(deductRequest.getBankId());
				platformBank.setDeductFlag(DeductFlagType.COLLECTION.getCode());
				platformBank.setDeductType(deductType);
				platformBank.setSysId(systemFlag);
				platformBank = platformBankService.getPlatformBank(platformBank);
				Long singleLimitMoney = platformBank.getSingleLimitMoney();
				if (singleLimitMoney == null || singleLimitMoney == 0L) {
					continue;
				}
				result.append(rule + ",");
			}
			newRule = result.toString();
			if (newRule.endsWith(",")) {
				newRule = newRule.substring(0, newRule.length() - 1);
			}
			deductRequest.setRule(newRule);
		}
		String msg = validate(deductRequest);
		if (StringUtils.isNotBlank(msg) && msg.length() > 0) {
			deductResult.setReCode(ResultType.ADD_FAIL.getCode());
			deductResult.setReMge(msg);
			deductResult.setDeductReq(deductRequest);
			return deductResult;
		} else {
			// 添加划扣任务
			String requestId = deductRequest.getRequestId();
			if (StringUtils.isEmpty(requestId)) {
				requestId = DateUtils.getNowTime() + DeductHelper.randomStr(10);
			}
			// 判断是否已存在
			if (Boolean.FALSE == isExisted(requestId, sysId)) {
				deductRequest.setRequestId(requestId); // 请求ID
				deductRequest.setStatus(TaskStatusType.ADDED.getCode()); // 划扣状态->0:待处理
				deductRequest.setUnsplitTimes(newRule.split(",").length); // 拆分次数->划扣平台数
				deductRequest.setUnsplitAmount(MoneyUtil.convertMoney(deductRequest.getAmount())); // 剩余金额->划扣金额
				deductRequest.setCreatby(DeductHelper.getSystemFlag(deductRequest.getSysId())); // 创建人
				deductRequest.setCreatTime(new Date()); // 创建时间
				deductRequest.setModifyby(DeductHelper.getSystemFlag(deductRequest.getSysId())); // 修改人
				deductRequest.setModifyTime(new Date()); // 修改时间
				deductRequsetDao.insert(deductRequest);
				deductResult.setReCode(ResultType.ADD_SUCCESS.getCode());
				deductResult.setReMge(ResultType.ADD_SUCCESS.getMsg());
				requestIdList.add(deductRequest.getRequestId());
				deductResult.setDeductReq(deductRequest);
			} else {
				deductResult.setReCode(ResultType.ADD_UPFAILED.getCode());
				deductResult.setReMge(ResultType.ADD_UPFAILED.getMsg());
				requestIdList.add(deductRequest.getRequestId());
				deductResult.setDeductReq(deductRequest);
			}
			return deductResult;
		}
	}

	/**
	 * 判断划扣请求数据是否已存在db中
	 * 2016年5月20日
	 * By 张永生
	 * @param requestId
	 * @return
	 */
	private static boolean isExisted(String requestId, String sysId) {
		int ret = 0;
		String table = getTableBySysId(sysId);
		ret = deductRequsetDao.selectCount(requestId, table);
		if (ret > 0) {
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * 撤销任务
	 * 2016年5月20日
	 * By 张永生
	 * @param deductRequest
	 * @return
	 */
	@Transactional(value = "coreTransactionManager", readOnly = false)
	public DeResult cancelDeductRequest(DeductReq deductRequest) {
		DeResult deductResult = new DeResult();
		int result = deleteDeductRequest(deductRequest.getRequestId(), deductRequest.getSysId());
		if (result == 0) {
			deductResult.setReCode(ResultType.ADD_UPFAILED.getCode());
			deductResult.setReMge(ResultType.ADD_UPFAILED.getMsg());
		} else {
			deductResult.setReCode(ResultType.ADD_RBSUCCESS.getCode());
			deductResult.setReMge(ResultType.ADD_RBSUCCESS.getMsg());
		}
		deductResult.setDeductReq(deductRequest);
		return deductResult;
	}

	/**
	 * 提交划扣请求
	 * 2016年5月20日
	 * By 张永生
	 * @param recReq
	 * @return
	 */
	@Transactional(value = "coreTransactionManager", readOnly = false)
	public DeResult commitDeductRequest(DeductReq deductRequest) {
		DeResult deductResult = new DeResult();
		String status = findStatus(deductRequest.getRequestId(), deductRequest.getSysId());
		if (TaskStatusType.PENDING.getCode().equals(status)
				|| TaskStatusType.PROCESSING.getCode().equals(status)
				|| TaskStatusType.DONE.getCode().equals(status)
				|| TaskStatusType.BATCHING.getCode().equals(status)) {
			deductResult.setReCode(ResultType.ADD_SUCCESS.getCode());
			deductResult.setReMge(ResultType.ADD_SUCCESS.getMsg());
			deductResult.setDeductReq(deductRequest);
			return deductResult;
		} 
		int result = updateDeductRequest(deductRequest.getRequestId(), deductRequest.getSysId());
		if (result == 0) {
			deductResult.setReCode(ResultType.ADD_UPFAILED.getCode());
			deductResult.setReMge(ResultType.ADD_UPFAILED.getMsg());
		} else{
			deductResult.setReCode(ResultType.ADD_SUCCESS.getCode());
			deductResult.setReMge(ResultType.ADD_SUCCESS.getMsg());
		}
		deductResult.setDeductReq(deductRequest);
		return deductResult;
	}

	/**
	 * 删除划扣请求
	 * 2016年5月20日
	 * By 张永生
	 * @param requestId
	 * @return
	 */
	@Transactional(value = "coreTransactionManager", readOnly = false)
	public int deleteDeductRequest(String requestId, String sysId) {
		int ret = 0;
		String table = getTableBySysId(sysId);
		try {
			ret = deductRequsetDao.delete(requestId, table);
		} catch (Exception e) {
			return ret;
		}
		return ret;
	}
	
	

	/**
	 * 查看处理状态
	 * 2016年5月20日
	 * By 张永生
	 * @param requestId
	 * @return
	 */
	public String findStatus(String requestId, String sysId) {
		String table = getTableBySysId(sysId);
		return deductRequsetDao.selectStatus(requestId, table);
	}
	/**
	 * 更新划扣请求状态
	 * 2016年5月20日
	 * By 张永生
	 * @param requestId
	 * @return
	 */
	@Transactional(value = "coreTransactionManager", readOnly = false)
	public int updateDeductRequest(String requestId, String sysId) {
		int ret = 0;
		String table = getTableBySysId(sysId);
		try {
			ret = deductRequsetDao.update(requestId, TaskStatusType.PENDING.getCode(), table);
		} catch (Exception e) {
			return ret;
		}
		return ret;
	}
	
	

	/**
	 * 保存批量划扣请求
	 * 2016年5月20日
	 * By 张永生
	 * @param deductReqList
	 * @return
	 */
	@Transactional(value = "coreTransactionManager", readOnly = false)
	public DeResult saveBatchDeductRequest(List<DeductReq> deductReqList) {
		DeResult deductResult = new DeResult();
		StringBuffer sb = new StringBuffer();
		List<DeResult> failResultList = new ArrayList<DeResult>();
		for (DeductReq deductRequest : deductReqList) {
			deductResult = saveDeductRequest(deductRequest);
			if (deductResult.getReCode().equals(ResultType.ADD_FAIL.getCode())) {
				failResultList.add(deductResult);
			}
		}
		if (ListUtils.isNotEmptyList(failResultList)) {
			for (DeResult deResult : failResultList) {
				String msg = deResult.getReMge();
				sb.append(msg + "/r/n");
			}
			deductResult.setReCode(ResultType.ADD_FAIL.getCode());
			deductResult.setReMge(sb.toString());
		} else{
			deductResult.setReCode(ResultType.ADD_SUCCESS.getCode());
			deductResult.setReMge(ResultType.ADD_SUCCESS.getMsg());
		}
		return deductResult;
	}

	/**
	 * 验证
	 * @param recReq
	 * @return
	 */
	public String validate(DeductReq deductRequest) {
		StringBuffer message = new StringBuffer();
		boolean okFlag = true;
		if (deductRequest == null) {
			message.append("请求对象为空;");
			okFlag = false;
			return message.toString();
		}
		String businessId = deductRequest.getBusinessId();
		message.append("业务编号为：" + businessId + "的");
		/* 各项目check */
		// 划扣标志
		String deductFlag = deductRequest.getDeductFlag();
		if (StringUtils.isEmpty(deductFlag)
				|| (Boolean.FALSE == DeductFlagType.COLLECTION.getCode()
						.equals(deductFlag) && Boolean.FALSE == DeductFlagType.PAY
						.getCode().equals(deductFlag))) {
			message.append("划扣标志不正确.");
			okFlag = false;
		}
		// 划扣/放款金额
		if (deductRequest.getAmount() == null
				|| deductRequest.getAmount().equals(BigDecimal.ZERO)) {
			message.append("金额不得为空或为0.");
			okFlag = false;
		}
		// 划扣放款金额是否小于0
		if (deductRequest.getAmount().compareTo(BigDecimal.ZERO) == -1) {
			message.append("金额不得为负数.");
			okFlag = false;
		}

		// 划扣平台及银行
		if (StringUtils.isEmpty(deductRequest.getRule())) {
			message.append("划扣平台不正确.");
			okFlag = false;
		}
		if (StringUtils.isEmpty(deductRequest.getBankId())) {
			message.append("划扣银行不得为空.");
			okFlag = false;
		}
		// 账号类型(为空时，默认为卡00)
		if (StringUtils.isEmpty(deductRequest.getAccountType())) {
			deductRequest.setAccountType(CardOrBookType.BANKCARD.getCode());
		}
		// 判断划扣平台合法性
		if (StringUtils.isEmpty(deductRequest.getRule())) {
			message.append("平台跳转规则未配置或平台不支持." + "<br>");
			okFlag = false;
		} else {
			String[] rules = deductRequest.getRule().split(",");
			String platformId = "";
			String deductType = "";
			for (String rule : rules) {
				String[] ruleArray = rule.split(":");
				platformId = ruleArray[0];
				deductType = ruleArray[1];
				if (DeductPlatType.FY.getCode().equals(platformId)
						&& DeductType.BATCH.getCode().equals(deductType)) {
					message.append("富友平台无批量接口，提交数据不合法.");
					okFlag = false;
				}
				if (DeductPlatType.FY.getCode().equals(platformId)) {
					if (StringUtils.isEmpty(deductRequest.getMobile())) {
						message.append("联系方式不得为空.");
						okFlag = false;
					}
				}
			}
			// 判断银行及平台是否支持
			if (deductRequest.getSysId().startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
				for (String rule : rules) {
					String[] ruleArray = rule.split(":");
					String platformItemId = ruleArray[0];
					PlatformBankEntity platformBank = new PlatformBankEntity();
					platformBank.setPlatformId(platformItemId);
					platformBank.setBankId(deductRequest.getBankId());
					platformBank.setDeductFlag(deductRequest.getDeductFlag());
					platformBank.setSysId(String.valueOf(SystemFlag.FORTUNE.value));
					platformBank = platformBankService.getPlatformBank(platformBank);
					Long SingleLimitMoney = platformBank.getSingleLimitMoney();
					if (SingleLimitMoney == null || SingleLimitMoney == 0L) {
						String platformName = DictUtils.getDictLabel(platformItemId, DictTypeIndex.TZ_DEDUCT_PLAT, "");
						message.append("所选银行" + platformName + "不支持.");
						okFlag = false;
					}
				}
				// 取得剩余平台可划扣金额合计
				Long sumDayLimit = getRestSumDayLimit(deductRequest.getRule(),
						rules.length, deductRequest.getBankId(), deductRequest.getSysId());
				Long unsplitAmount = MoneyUtil.convertMoney(deductRequest.getAmount());
				if (unsplitAmount > sumDayLimit) {
					message.append("划扣金额已大于平台单日限额.");
					okFlag = false;
				}
			}
		}
		// 账号相关
		if (StringUtils.isEmpty(deductRequest.getAccountNo())
				|| StringUtils.isEmpty(deductRequest.getAccountName())) {
			message.append("账号及账户名称不得为空.");
			okFlag = false;
		}
		// 证件相关
		if (StringUtils.isEmpty(deductRequest.getIdType())) {
			message.append("证件类型不得为空.");
			okFlag = false;
		} else if (CertificateType.SFZ.getCode().equals(deductRequest.getIdType())) {
			if (Boolean.FALSE == IdcardUtils.validateIdCard18(deductRequest.getIdNo())
					&& Boolean.FALSE == IdcardUtils.validateIdCard15(deductRequest
							.getIdNo())) {
				message.append("证件不合法.");
				okFlag = false;
			}
		} else if (StringUtils.isEmpty(deductRequest.getIdNo())) {
			message.append("证件编号不得为空.");
			okFlag = false;
		}
		// 批次号（市场订单号）没有的话，新生成
		if (StringUtils.isEmpty(deductRequest.getBatId())) {
			deductRequest.setBatId(DeductHelper.getBatchNo());
		}
		if (!okFlag) {
			return message.toString();
		}
		return "";
	}
	
	/**
	 * 算出所有平台单日限额总数
	 * @param allRule
	 * @param unsplitTimes
	 * @param bankId
	 * @param sysId
	 * @return
	 */
	public Long getRestSumDayLimit(String allRule, int unsplitTimes,
			String bankId, String sysId) {
		Long sumDayLimit = 0L; // 单日限额合计
		PlatformBankEntity platformBank = null; // 平台数据
		String[] allRuleArray = allRule.split(",");
		// 取得平台数
		int maxPlat = allRuleArray.length;
		// 剩余平台可划扣金额合计
		sumDayLimit = 0L;
		String systemId = "";
		if (sysId.startsWith(String.valueOf(SystemFlag.FORTUNE.value))) {
			systemId = String.valueOf(SystemFlag.FORTUNE.value);
		}
		if (sysId.startsWith(String.valueOf(SystemFlag.LOAN.value))) {
			systemId = String.valueOf(SystemFlag.LOAN.value);
		}
		for (int j = maxPlat - unsplitTimes; j < maxPlat; j++) {
			String platformId = allRuleArray[j].split(":")[0];
			String deductType = allRuleArray[j].split(":")[1];
			platformBank = platformBankService.getPlatformBank(systemId, platformId, bankId,
					DeductFlagType.COLLECTION.getCode(), deductType);
			if (platformBank.getDayLimitMoney() != null) {
				sumDayLimit += platformBank.getDayLimitMoney();
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
		if (DeductWays.ZJ_01.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_zj01";
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
		if (DeductWays.CJHK_09.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cj04";
		}
		if (DeductWays.CJHK_10.getCode().equals(sysId)) {
			return "gl.t_gl_deduct_req_cj05";
		}
		return "";
	}
}
