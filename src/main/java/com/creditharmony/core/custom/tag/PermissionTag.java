package com.creditharmony.core.custom.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import com.creditharmony.common.util.ArrayHelper;
import com.creditharmony.common.util.SpringContextHolder;
import com.creditharmony.core.common.type.SystemConfigConstant;
import com.creditharmony.core.users.entity.ResourceAuth;
import com.creditharmony.core.users.entity.User;
import com.creditharmony.core.users.service.MenuManager;
import com.creditharmony.core.users.util.UserUtils;


/**
 * 权限标签
 * @Class Name PermissionTag
 * @author 张永生
 * @Create In 2016年1月19日
 */
public class PermissionTag extends BodyTagSupport {

	private static final long serialVersionUID = -4229214871614309228L;
	
	private static MenuManager menuManager = SpringContextHolder.getBean(MenuManager.class);
	
	private String id;
	private String key;
	
	private List<ResourceAuth> resAuthList;
	
	public boolean hasPermission(String resourceKey) {
		String menuId = (String) this.pageContext.getRequest().getParameter("menuId");
		User user = (User) UserUtils.getSession().getAttribute(SystemConfigConstant.SESSION_USER_INFO);
		resAuthList = menuManager
				.findResourceAuth(user.getId(), user.getDepartment()
						.getId(), menuId, resourceKey);
		return ArrayHelper.isNotEmpty(resAuthList);
	}
	
	public int doStartTag() throws JspException {
		if(hasPermission(key)){
			return Tag.EVAL_BODY_INCLUDE;
		}else{
			return Tag.SKIP_BODY;
		}
	}
	
	public int doEndTag() throws JspException {
		StringBuffer sb = new StringBuffer();
		for(ResourceAuth resourceAuth:resAuthList){
			if(ResourceAuth.HAS_EDIT_NO.equals(resourceAuth.getHasEdit())){
				sb.append("<script type=\"text/javascript\">$('#");
				sb.append(id);
				sb.append("').attr('disabled','disabled');</script>");
				try {
					this.pageContext.getOut().println(sb);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return Tag.EVAL_PAGE;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
}
