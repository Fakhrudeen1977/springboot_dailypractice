package com.example.daily.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practice")
public class MyController {

	@GetMapping("/home")
	public String getHomePage() {
		return "<h2>SpringBoot Aws Deployed Successfully</h2>";
		
	}
	
	
	
	
}


