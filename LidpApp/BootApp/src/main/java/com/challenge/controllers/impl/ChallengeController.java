/*
 * Author: Lew Griffith
 */
package com.challenge.controllers.impl;

import java.util.List;
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
	
	private static final String CHOOSE_FAVORITE_COLOR = "/challenge/database/color/choose";
	
	private static final String GET_FAVORITE_COLOR_FOR_USER = "/challenge/database/color/get";
	
	private static final String UPDATE_FAVORITE_COLOR = "/challenge/database/color/update";
	
	private static final String DELETE_FAVORITE_COLOR = "/challenge/database/color/delete";
	
	private static final String GET_ALL_USERS = "/challenge/database/users";
	
	
	@Autowired
	RestChallengeService restChallengeService;
	
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
		final boolean hasFavorite = databaseService.chooseFavoriteColor(firstName, lastName, color);
		
		if(hasFavorite) {
			return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).build();
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).build();
		}
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, value = GET_FAVORITE_COLOR_FOR_USER, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<String> getFavoriteColor(@RequestBody UserRequest request) {
		
		final String firstName = request.getFirstName();
		final String lastName = request.getLastName();
		
		final String favoriteColor = databaseService.getFavoriteColor(firstName, lastName);
		
		if(Objects.nonNull(favoriteColor)) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(favoriteColor);
		}else {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).build();
		}
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = UPDATE_FAVORITE_COLOR, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Boolean> updateFavoriteColor(@RequestBody UserFavoriteColorRequest request) {
		
		final String firstName = request.getFirstName();
		final String lastName = request.getLastName();
		final String color = request.getColor();
		final boolean colorUpdated = databaseService.updateFavoriteColor(firstName, lastName, color);
		
		if(colorUpdated) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).build();
		}	
	}

	@Override
	@RequestMapping(method = RequestMethod.DELETE, value = DELETE_FAVORITE_COLOR, consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Boolean> deleteFavoriteColor(@RequestBody UserRequest request) {
		
		final String firstName = request.getFirstName();
		final String lastName = request.getLastName();
		
		final boolean colorDeleted = databaseService.deleteFavoriteColor(firstName, lastName);
		
		if(colorDeleted) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).build();
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).build();
		}
		
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = GET_ALL_USERS, produces = {"application/json"})
	public ResponseEntity<List<User>> findAllUsers() {
		
		final List<User> users = databaseService.findAllUsers();
		
		if(!users.isEmpty()) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(users);
		} else {
			return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).build();
		}
	}

}
