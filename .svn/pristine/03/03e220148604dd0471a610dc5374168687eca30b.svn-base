package com.creditharmony.core.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.creditharmony.core.cms.entity.QuestionAnswer;
import com.creditharmony.core.persistence.CrudDao;
import com.creditharmony.core.persistence.annotation.CoreBatisDao;

@CoreBatisDao
public interface QuestionAnswerDao  extends CrudDao<QuestionAnswer>{
    int deleteByPrimaryKey(String id);

    int insert(QuestionAnswer record);

    int insertSelective(QuestionAnswer record);

    QuestionAnswer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QuestionAnswer record);

    int updateByPrimaryKey(QuestionAnswer record);
    
    List<Map<String,Object>> findAllKeys();
    
    List<QuestionAnswer> findListByIds(@Param("idsStr") String idsStr);
}