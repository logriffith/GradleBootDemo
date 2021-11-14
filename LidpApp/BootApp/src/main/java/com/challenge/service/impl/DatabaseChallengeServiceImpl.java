package com.challenge.service.impl;

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
			user.setFavoriteColor(new Color(color));
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
			user.setFavoriteColor(new Color(color));
			userDao.save(user);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteFavoriteColor(String firstName, String lastName) {
		final User user = userDao.findUserByFirstNameAndLastName(firstName, lastName);
		
		if(Objects.isNull(user)) {
			return false;
		}
		
		final Color color = user.getFavoriteColor();
		colorDao.delete(color);
		user.setFavoriteColor(null);
		userDao.save(user);
		
		return true;
	}

}
