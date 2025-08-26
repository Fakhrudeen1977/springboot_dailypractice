package com.example.daily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DailyPracticeApplication  {
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to SprigBoot Application");
		System.out.println("New Line added in Git Repo");
		SpringApplication.run(DailyPracticeApplication.class, args);
		 
	}

	
	
	
}
