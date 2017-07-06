package com.creditharmony.core.cms.dao;

import com.creditharmony.core.cms.entity.Comment;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface CommentDao extends CrudDao<Comment> {

}
