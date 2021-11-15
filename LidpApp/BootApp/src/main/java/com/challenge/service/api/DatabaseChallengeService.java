package com.challenge.service.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.models.User;

@Service
public interface DatabaseChallengeService {
	
	boolean chooseFavoriteColor(String firstName, String lastName, String color);
	
	String getFavoriteColor(String firstName, String lastName);
	
	boolean updateFavoriteColor(String firstName, String lastName, String color);
	
	boolean deleteFavoriteColor(String firstName, String lastName);
	
	List<User> findAllUsers();

}
