package com.jdnd.data.persistence.m4e1dsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class M4E1DspApplication {

	public static void main(String[] args) {
		SpringApplication.run(M4E1DspApplication.class, args);
	}

	@Bean
	public String getPassword(){
		return "sakshee";
	}
}
