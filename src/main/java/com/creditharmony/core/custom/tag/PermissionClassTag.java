package com.creditharmony.core.custom.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.service.MenuManager;
import com.creditharmony.core.users.util.UserUtils;


/**
 * 权限标签
 * @Class Name PermissionTag
 * @author 张永生
 * @Create In 2016年1月19日
 */
public class PermissionClassTag extends BodyTagSupport {

	private static final long serialVersionUID = -4229214871614309228L;
	
	private static MenuManager menuManager = SpringContextHolder.getBean(MenuManager.class);
	
	private List<String> resKeyList;
	
	public boolean hasPermission() {
		String menuId = (String) this.pageContext.getRequest().getParameter("menuId");
		User user = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		if(null == user){
			return false;
		}
		resKeyList = menuManager.findResourceAuthNotIn(user.getId(), user.getDepartment().getId(), menuId);
		return ArrayHelper.isNotEmpty(resKeyList);
	}
	
	public int doStartTag() throws JspException {
		if(hasPermission()){
			return Tag.EVAL_BODY_INCLUDE;
		}else{
			return Tag.SKIP_BODY;
		}
	}
	
	public int doEndTag() throws JspException {
		if(null!=resKeyList && resKeyList.size()>0){
			StringBuffer sb = new StringBuffer();
			sb.append("<script type=\"text/javascript\"> $(document).ready(function(){");
			for(String resourceKey:resKeyList){
					sb.append("$('."+resourceKey+"').remove();");
			}
			sb.append("});</script>");
			try {
				this.pageContext.getOut().println(sb);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Tag.EVAL_PAGE;
	}
}
