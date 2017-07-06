package com.creditharmony.core.cms.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creditharmony.core.cms.dao.CmsPushDao;
import com.creditharmony.core.cms.service.CmsPushService;
import com.creditharmony.core.web.BaseController;

@Controller
@RequestMapping(value = "${adminPath}/cmsPush")
public class CmsPushController extends BaseController {
	@Autowired
	private CmsPushService cmsPushService;
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request) {
		String id=request.getParameter("id");
		cmsPushService.deleteCmsPush(id);
		return "";
	}

}
