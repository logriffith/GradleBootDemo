package com.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserFavoriteColorRequest  {
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("favoriteColor")
	private String color;
	
}
