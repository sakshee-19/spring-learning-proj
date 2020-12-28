package com.udacity.dogBreed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DogBreedApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogBreedApplication.class, args);
	}

}
