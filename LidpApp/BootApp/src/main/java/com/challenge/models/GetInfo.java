/*
 * Author: Lew Griffith
 */
package com.challenge.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GetInfo {

	private final String date;
	private final String appName;
	
}
