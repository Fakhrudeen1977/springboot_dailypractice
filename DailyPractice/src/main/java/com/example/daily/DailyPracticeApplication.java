package com.example.daily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DailyPracticeApplication  {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(DailyPracticeApplication.class, args);
		 
	}

	
	
	
}
