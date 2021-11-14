package com.challenge.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	User findUserByFirstNameAndLastName(String firstName, String lastName);
	
}
