/*
 * Author: Lew Griffith
 */
package com.challenge.dao.api;

import org.springframework.stereotype.Repository;

import com.challenge.models.GetInfo;

@Repository
public interface RestChallengeDao {
	
	/**
	 * Retrieve the name of the application from the application.properties file 
	 * and the current date from the local system.
	 * 
	 * @return The app name and current date as a GetInfo object
	 * @author Lew Griffith
	 */
	GetInfo getAppName();
	
	/**
	 * Calculates the circumference of a circle with the provided {@code radius}.
	 * 
	 * @param radius
	 * @return The circumference
	 * @author Lew Griffith
	 */
	Double calculateCircumference(Double radius);
	
}
