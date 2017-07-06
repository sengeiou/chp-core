package com.creditharmony.core.cms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.core.cms.dao.CommentDao;
import com.creditharmony.core.cms.entity.Comment;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.BaseEntity;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;

/**
 * 评论Manager
 * @Class Name CommentManager
 * @author 张永生
 * @Create In 2015年11月24日
 */
@Service
public class CommentManager extends CoreManager<CommentDao, Comment> {

	public Page<Comment> findPage(Page<Comment> page, Comment comment) {
		comment.getSqlMap().put("dsf", dataScopeFilter(comment.getCurrentUser(), "o", "u"));
		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
        PageList<Comment> pageList = (PageList<Comment>)dao.findList(comment, pageBounds);
        PageUtil.convertPage(pageList, page);
        return page;
	}
	
	@Transactional(readOnly = false)
	public void delete(Comment entity, Boolean isRe) {
		if(null!=isRe){
			entity.setDelFlag(isRe?BaseEntity.DEL_FLAG_AUDIT:BaseEntity.DEL_FLAG_DELETE);
		}else{
			entity.setDelFlag(BaseEntity.DEL_FLAG_DELETE);
		}
		super.delete(entity);
	}
}
