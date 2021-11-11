/*
 * Author: Lew Griffith
 */
package com.challenge.dao.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.challenge.dao.api.RestChallengeDao;
import com.challenge.models.GetInfo;

@Component
public class RestChallengeDaoImpl implements RestChallengeDao {
	
	@Autowired
	Environment environment;

	@Override
	public GetInfo getAppName() {
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
		String appName = environment.getProperty("spring.application.name");
		return new GetInfo(currentDate, appName);
	}

	@Override
	public Double calculateCircumference(Double radius) {
		return 2*Math.PI*radius;
	}

}
