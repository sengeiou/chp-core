package com.creditharmony.core.cms.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creditharmony.common.util.StringUtils;
import com.creditharmony.core.cms.dao.QuestionAnswerDao;
import com.creditharmony.core.cms.entity.QuestionAnswer;
import com.creditharmony.core.common.util.PageUtil;
import com.creditharmony.core.mybatis.paginator.domain.PageBounds;
import com.creditharmony.core.mybatis.paginator.domain.PageList;
import com.creditharmony.core.persistence.Page;
import com.creditharmony.core.service.CoreManager;

@Service
public class QuestionAnswerManager  extends CoreManager<QuestionAnswerDao, QuestionAnswer>{
    @Transactional(readOnly = false)
  	public Page<QuestionAnswer> findPage(Page<QuestionAnswer> page, QuestionAnswer questionAnswer) {
  		PageBounds pageBounds = new PageBounds(page.getPageNo(), page.getPageSize());
  		PageList<QuestionAnswer> pageList = (PageList<QuestionAnswer>) dao.findList(questionAnswer, pageBounds);
  		PageUtil.convertPage(pageList, page);
  		return page;
  	}
    
	@Transactional(readOnly = false)
	public void save(QuestionAnswer questionAnswer) {
		if (StringUtils.isBlank(questionAnswer.getId())){
			questionAnswer.preInsert();			
			dao.insert(questionAnswer);
		}else{
			questionAnswer.preUpdate();
			dao.updateByPrimaryKey(questionAnswer);
		}		
	}
	
	@Transactional(readOnly = false)
	public void delete(QuestionAnswer questionAnswer) {
		questionAnswer.setDelFlag(QuestionAnswer.DEL_FLAG_DELETE);
		dao.updateByPrimaryKeySelective(questionAnswer);
	}
	
  	public List<QuestionAnswer> findList(QuestionAnswer questionAnswer) {
  		List<QuestionAnswer> pageList =dao.findList(questionAnswer);
  		return pageList;
  	}
  	public List<QuestionAnswer> findListByIds(String idsStr) {
  		List<QuestionAnswer> pageList =dao.findListByIds(idsStr);
  		return pageList;
  	}
  	public List<Map<String,Object>> findAllKeys() {
  		List<Map<String,Object>> pageList =dao.findAllKeys();
  		return pageList;
  	}
}
