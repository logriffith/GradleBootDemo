/*
 * Author: Lew Griffith
 */
package com.challenge.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.controllers.api.ChallengeApiController;
import com.challenge.models.GetInfo;
import com.challenge.service.api.RestChallengeService;

@CrossOrigin
@RestController
public class ChallengeControllerImpl implements ChallengeApiController {
	
	private static final String GET_DATE_AND_APP_NAME = "/challenge/info";
	private static final String CALCULATE_CIRCUMFERENCE = "/challenge/circumference";

	@Autowired
	Environment environment;
	
	@Autowired
	RestChallengeService challengeService;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = GET_DATE_AND_APP_NAME, produces = {"application/json"})
	public ResponseEntity<GetInfo> getAppInfo(){
		GetInfo info = challengeService.getAppName();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(info);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.POST, value = CALCULATE_CIRCUMFERENCE, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Double> calculateCircumference(@RequestBody Double radius){
		Double circumference = challengeService.calculateCircumference(radius);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(circumference);
	}
	
}
