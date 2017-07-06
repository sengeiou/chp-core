package com.creditharmony.core.log.facade;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditharmony.common.util.DateUtils;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.log.entity.Log;
import com.creditharmony.core.log.service.LogManager;
import com.creditharmony.core.log.view.LogListView;
import com.creditharmony.core.mybatis.paginator.domain.Order;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.proxy.UserProxy;

/**
 * 日志转换层
 * @Class Name LogFacade
 * @author 张永生
 * @Create In 2015年11月24日
 */
@Service
public class LogFacade {

	@Autowired
	private LogManager logManager;

	@Autowired
	private UserProxy userProxy;

	public Page<LogListView> findLog(Page<Log> page, Log log) throws Exception {
		Page<LogListView> logPage = new Page<LogListView>();
		if (log.getBeginDate() == null){
			log.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
		}
		if (log.getEndDate() == null){
			log.setEndDate(DateUtils.addMonths(log.getBeginDate(), 1));
		}
		String sortString = "id.asc";
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize(), Order.formString(sortString));
		PageList<Log> pageList = (PageList<Log>) logManager.findList(log,
				pageBounds);
        PageUtil.convertPage(pageList, page);
		List<LogListView> viewList = new ArrayList<LogListView>();
		for (Log item : page.getList()) {
			LogListView itemView = new LogListView();
			BeanUtils.copyProperties(itemView, item);
			User createBy = userProxy.getUser(item.getCreateBy());
			itemView.setCreateByName(createBy.getName());
			itemView.setCreateByCompanyName(createBy.getCompany()!=null ? createBy.getCompany().getName() : "");
			itemView.setCreateByDeptName(createBy.getDepartment().getName());
			User modifyBy = userProxy.getUser(item.getModifyBy());
			itemView.setUpdateByName(modifyBy!=null ?modifyBy.getName():"");
			itemView.setUpdateByCompanyName(modifyBy!=null ?modifyBy.getCompany().getName():"");
			itemView.setUpdateByDeptName(modifyBy!=null ?modifyBy.getDepartment().getName():"");
			viewList.add(itemView);
		}
		PageUtil.convertPage(page, logPage, viewList);
		return logPage;
	}
}
