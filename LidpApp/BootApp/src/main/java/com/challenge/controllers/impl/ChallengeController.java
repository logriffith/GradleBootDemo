/*
 * Author: Lew Griffith
 */
package com.challenge.controllers.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.controllers.api.IChallengeController;
import com.challenge.dao.api.UserDao;
import com.challenge.models.GetInfo;
import com.challenge.models.User;
import com.challenge.models.UserFavoriteColorRequest;
import com.challenge.models.UserRequest;
import com.challenge.service.api.DatabaseChallengeService;
import com.challenge.service.api.RestChallengeService;

@CrossOrigin
@RestController
public class ChallengeController implements IChallengeController {
	
	private static final String GET_DATE_AND_APP_NAME = "/challenge/info";
	private static final String CALCULATE_CIRCUMFERENCE = "/challenge/circumference";
	private static final String CHOOSE_FAVORITE_COLOR = "/challenge/database/choose";
	private static final String GET_FAVORITE_COLOR_FOR_USER = "/challenge/database/get-color";

	@Autowired
	Environment environment;
	
	@Autowired
	RestChallengeService restChallengeService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	DatabaseChallengeService databaseService;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = GET_DATE_AND_APP_NAME, produces = {"application/json"})
	public ResponseEntity<GetInfo> getAppInfo(){
		GetInfo info = restChallengeService.getAppName();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(info);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.POST, value = CALCULATE_CIRCUMFERENCE, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Double> calculateCircumference(@RequestBody Double radius){
		Double circumference = restChallengeService.calculateCircumference(radius);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(circumference);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = CHOOSE_FAVORITE_COLOR, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Boolean> chooseFavoriteColor(@RequestBody UserFavoriteColorRequest request) {
		final String firstName = request.getFirstName();
		final String lastName = request.getLastName();
		final String color = request.getColor();
		
		final User user = userDao.findUserByFirstNameAndLastName(firstName, lastName);
		final boolean hasFavorite = databaseService.chooseFavoriteColor(user, color);
		
		if(hasFavorite) {
			return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).build();
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).build();
		}
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = GET_FAVORITE_COLOR_FOR_USER, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<String> getFavoriteColor(UserRequest request) {
		final String firstName = request.getFirstName();
		final String lastName = request.getLastName();
		final User user = userDao.findUserByFirstNameAndLastName(firstName, lastName);
		
		final String favoriteColor = databaseService.getFavoriteColor(user).getColorName();
		
		if(Objects.nonNull(favoriteColor)) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(favoriteColor);
		}else {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).build();
		}
	}

	@Override
	public ResponseEntity<Boolean> updateFavoriteColor(UserFavoriteColorRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Boolean> deleteFavoriteColor(UserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}