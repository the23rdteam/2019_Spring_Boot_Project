package com.the23rdTeam.HomeWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HomeWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeWorkApplication.class, args);
	}

}
