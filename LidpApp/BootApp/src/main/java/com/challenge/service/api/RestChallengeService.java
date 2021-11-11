/*
 * Author: Lew Griffith
 */
package com.challenge.service.api;

import org.springframework.stereotype.Service;

import com.challenge.models.GetInfo;

@Service
public interface RestChallengeService {
	
	/**
	 * Retrieves the application name and the current date.
	 * 
	 * @return the app name and current date
	 * @author Lew Griffith
	 */
	GetInfo getAppName();
	
	/**
	 * Calculates the circumference of a circle with the provided {@code radius}.
	 * 
	 * @param radius
	 * @return the circumference
	 * @author Lew Griffith
	 */
	Double calculateCircumference(Double radius);

}
