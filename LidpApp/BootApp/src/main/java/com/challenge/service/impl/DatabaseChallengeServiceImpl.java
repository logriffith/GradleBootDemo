package com.challenge.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.dao.api.ColorDao;
import com.challenge.dao.api.UserDao;
import com.challenge.models.Color;
import com.challenge.models.User;
import com.challenge.service.api.DatabaseChallengeService;

@Component
public class DatabaseChallengeServiceImpl implements DatabaseChallengeService {
	
	@Autowired
	ColorDao colorDao;
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean chooseFavoriteColor(String firstName, String lastName, String color) {
		
		final User user = userDao.findUserByFirstNameAndLastName(firstName, lastName);
		
		if(Objects.nonNull(user) && Objects.isNull(user.getFavoriteColor())) {
			
			Color favoriteColor = colorDao.findByColorName(color);
			
			if(Objects.isNull(favoriteColor)) {
				favoriteColor = new Color(color);
			}
			
			user.setFavoriteColor(favoriteColor);
			userDao.save(user);
			return true;
		}
		
		return false;
	}

	@Override
	public String getFavoriteColor(String firstName, String lastName) {
		
		final User user = userDao.findUserByFirstNameAndLastName(firstName, lastName);
		final Color color = Objects.nonNull(user) ? user.getFavoriteColor() : null;
		final Optional<Color> favoriteColor = Objects.nonNull(color) ? colorDao.findById(user.getFavoriteColor().getColorId()) : Optional.empty();
		return favoriteColor.isPresent() ? favoriteColor.get().getColorName() : null;
	}

	@Override
	public boolean updateFavoriteColor(String firstName, String lastName, String color) {
		
		final User user = userDao.findUserByFirstNameAndLastName(firstName, lastName);
		
		if(Objects.nonNull(user)) {
			
			Color newFavorite = colorDao.findByColorName(color);
			
			if(Objects.isNull(newFavorite)) {
				newFavorite = new Color(color);
			}
			
			user.setFavoriteColor(newFavorite);
			userDao.save(user);
			return true;
			
		}
		
		return false;
	}

	@Override
	public boolean deleteFavoriteColor(String firstName, String lastName) {
		
		final User user = userDao.findUserByFirstNameAndLastName(firstName, lastName);
		
		if(Objects.isNull(user) || Objects.isNull(user.getFavoriteColor())) {
			return false;
		}
		
		Color color = colorDao.findByColorName(user.getFavoriteColor().getColorName());
		
		if(Objects.nonNull(color)) {
	
			user.setFavoriteColor(null);
			userDao.save(user);
			colorDao.delete(color);
			return true;
		}
		
		return false;
		
	}

	@Override
	public List<User> findAllUsers() {
		
		return userDao.findAll();
	}

}
