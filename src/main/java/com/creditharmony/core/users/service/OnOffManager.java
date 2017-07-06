package com.creditharmony.core.users.service;

import org.springframework.stereotype.Service;

import com.creditharmony.core.service.CoreManager;
import com.creditharmony.core.users.dao.OnOffDao;
import com.creditharmony.core.users.entity.OnOff;
@Service
public class OnOffManager extends CoreManager<OnOffDao, OnOff> {

	public OnOff selectByType(String type){
		return dao.selectByType(type);
	}
}
