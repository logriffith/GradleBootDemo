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
	public boolean chooseFavoriteColor(User user, String color) {
		final Color favoriteColor = new Color(user.getFavoriteColor().getColorId(), color);
		final Color colorEntity = colorDao.save(favoriteColor);
		return Objects.nonNull(colorEntity);
	}

	@Override
	public Color getFavoriteColor(User user) {
		final Optional<Color> favoriteColor = colorDao.findById(user.getFavoriteColor().getColorId());
		return favoriteColor.isPresent() ? favoriteColor.get() : null;
	}

	@Override
	public boolean updateFavoriteColor(User user, String color) {
		final Optional<Color> favoriteColor = colorDao.findById(user.getFavoriteColor().getColorId());
		
		if(favoriteColor.isPresent()) {
			favoriteColor.get().setColorName(color);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteFavoriteColor(User user) {
		final Optional<Color> favoriteColor = colorDao.findById(user.getFavoriteColor().getColorId());
		
		if(favoriteColor.isPresent()) {
			user.setFavoriteColor(null);
			colorDao.delete(favoriteColor.get());
			return true;
		}
		
		return false;
	}

}
