package com.udacity.jwdnd.basic;

import com.udacity.jwdnd.basic.services.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}

	@Bean
	public String message(){
		System.out.println("getMessage bean");
		return "Hello Spring!";
	}

	@Bean
	public String uppercaseMessage(MessageService msgService){
		System.out.println("Bean uppercaseMessage");
		return msgService.upperCase();
	}

	@Bean
	public String lowercaseMessage(MessageService msgService){
		System.out.println("Bean lowercaseMessage");
		return msgService.lowerCase();
	}


}
