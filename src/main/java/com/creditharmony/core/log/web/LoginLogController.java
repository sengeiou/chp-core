package com.creditharmony.core.log.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.config.Global;
import com.creditharmony.core.log.entity.LoginLog;
import com.creditharmony.core.log.service.LoginLogManager;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.util.UserUtils;
import com.creditharmony.core.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/sys/loginLog")
public class LoginLogController extends BaseController {
	@Autowired
	LoginLogManager loginLogManager;
	
	@ModelAttribute("loginLog")
	public LoginLog loginLog(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return loginLogManager.get(id);
		}else{
			return new LoginLog();
		}
	}
	
	
	@RequestMapping(value = {"list", ""})
	public String list(LoginLog loginLog, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		loginLog.setLoginName(StringUtils.isNotBlank(loginLog.getLoginName())?loginLog.getLoginName():null);
		loginLog.setUserCode(StringUtils.isNotBlank(loginLog.getUserCode())?loginLog.getUserCode():null);
		loginLog.setUserName(StringUtils.isNotBlank(loginLog.getUserName())?loginLog.getUserName():null);
		
		Page<LoginLog> page =loginLogManager.findPage(new Page<LoginLog>(request, response), loginLog);
		model.addAttribute("page", page);

		return "modules/sys/loginLogList";
	}
	
	@ResponseBody
	@RequestMapping(value="/insertLog")
	public String insertLog(Model model,HttpServletRequest request,
			HttpServletResponse response,String systemFlag){	
		loginLogManager.insertLoginLog((User) UserUtils.getSession().getAttribute(
				SystemConfigConstant.SESSION_USER_INFO), Global.LOGININ, request,systemFlag);
		return null;
	}
}
