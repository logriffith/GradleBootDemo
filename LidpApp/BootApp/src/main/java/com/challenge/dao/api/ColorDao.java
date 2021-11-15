package com.challenge.dao.api;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.models.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer>{

	Color findByColorName(String Color);
		
}
