package com.creditharmony.core.common.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.creditharmony.core.common.type.DeleteFlagType;
import com.creditharmony.core.log.entity.Log;
import com.creditharmony.core.log.facade.LogFacade;
import com.creditharmony.core.log.view.LogListView;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.web.BaseController;

/**
 * 日志控制器
 * @Class Name LogController
 * @author 张永生
 * @Create In 2015年11月24日
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/log")
public class LogController extends BaseController {
	
	@Autowired
	private LogFacade logFacade;
	
	@RequestMapping(value = {"list", ""})
	public String list(Log log, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Map<String, Object> filter = new HashMap<String, Object>();
 		filter.put("deleteFlag", DeleteFlagType.NORMAL);
		Page<LogListView> page = logFacade.findLog(new Page<Log>(request, response), log);
		model.addAttribute("page", page);
		return "modules/sys/logList";
	}

}
