package com.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.dao.api.RestChallengeDao;
import com.challenge.models.GetInfo;
import com.challenge.service.api.RestChallengeService;

@Component
public class RestChallengeServiceImpl implements RestChallengeService {
	
	@Autowired
	RestChallengeDao challengeDao;

	@Override
	public GetInfo getAppName() {
		return challengeDao.getAppName();
	}

	@Override
	public Double calculateCircumference(Double radius) {
		return challengeDao.calculateCircumference(radius);
	}

}
