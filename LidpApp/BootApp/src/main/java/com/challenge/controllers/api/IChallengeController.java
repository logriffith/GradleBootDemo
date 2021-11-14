/*
 * Author: Lew Griffith
 */
package com.challenge.controllers.api;

import org.springframework.http.ResponseEntity;

import com.challenge.models.GetInfo;
import com.challenge.models.UserFavoriteColorRequest;
import com.challenge.models.UserRequest;

public interface IChallengeController {
	
	/**
	 * Web service to get the current date and the application name.
	 * 
	 * @return the app name and current date
	 * @author Lew Griffith
	 */
	ResponseEntity<GetInfo> getAppInfo();
	
	/**
	 * Web service to calculate the circumference of a circle.
	 * 
	 * @param radius
	 * @return the circumference
	 * @author Lew Griffith
	 */
	ResponseEntity<Double> calculateCircumference(Double radius);
	
	ResponseEntity<Boolean> chooseFavoriteColor(UserFavoriteColorRequest request);
	
	ResponseEntity<String> getFavoriteColor(UserRequest request);
	
	ResponseEntity<Boolean> updateFavoriteColor(UserFavoriteColorRequest request);
	
	ResponseEntity<Boolean> deleteFavoriteColor(UserRequest request);
	
}
