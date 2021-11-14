package com.challenge.service.api;

import org.springframework.stereotype.Service;

import com.challenge.models.Color;
import com.challenge.models.User;

@Service
public interface DatabaseChallengeService {
	
	boolean chooseFavoriteColor(User user, String color);
	
	Color getFavoriteColor(User user);
	
	boolean updateFavoriteColor(User user, String color);
	
	boolean deleteFavoriteColor(User user);

}
