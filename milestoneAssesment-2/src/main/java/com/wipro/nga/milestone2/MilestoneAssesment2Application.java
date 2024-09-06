package com.wipro.nga.milestone2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MilestoneAssesment2Application {

	public static void main(String[] args) {
		SpringApplication.run(MilestoneAssesment2Application.class, args);
	}

}
