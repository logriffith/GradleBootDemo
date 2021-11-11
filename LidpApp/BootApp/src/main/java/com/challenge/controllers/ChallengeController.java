/*
 * Author: Lew Griffith
 */
package com.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.models.GetInfo;
import com.challenge.service.api.RestChallengeService;

@CrossOrigin
@RestController
//@RequestMapping(value = "/challenge")
public class ChallengeController {
	
	private static final String GET_DATE_AND_APP_NAME = "/challenge/info";
	private static final String CALCULATE_CIRCUMFERENCE = "/challenge/circumference";

	@Autowired
	Environment environment;
	
	@Autowired
	RestChallengeService challengeService;
	
	@RequestMapping(method = RequestMethod.GET, value = GET_DATE_AND_APP_NAME, produces = {"application/json"})
	public ResponseEntity<GetInfo> getAppInfo(){
//		String today = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
//		String appName = environment.getProperty("spring.application.name");
//		GetInfo info = new GetInfo(today, appName);
		GetInfo info = challengeService.getAppName();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(info);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = CALCULATE_CIRCUMFERENCE, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Double> calculate(@RequestBody double radius){
		Double circumference = challengeService.calculateCircumference(radius);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(circumference);
	}
	
}
