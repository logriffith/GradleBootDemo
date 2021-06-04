package com.challenge.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.models.GetInfo;

@CrossOrigin
@RestController
@RequestMapping(value = "/challenge")
public class GetController {
	
	@Autowired
	Environment environment;
	
	@GetMapping(value = "/info")
	public ResponseEntity<GetInfo> getAppInfo(){
		String today = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
		String appName = environment.getProperty("spring.application.name");
		GetInfo info = new GetInfo(today, appName);
		//return ResponseEntity.ok("Today is "+ currentDate.toString() + " and the name of the application in the application.properties is " + appName +".");
		return ResponseEntity.ok(info);
	}

}
