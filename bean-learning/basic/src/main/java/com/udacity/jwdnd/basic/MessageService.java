package com.udacity.jwdnd.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageService {

    private String message;

    public MessageService(String message){
        this.message = message;
    }

    public String upperCase() {
        return this.message.toUpperCase();
    }


    public String lowerCase() {
        return this.message.toLowerCase();
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("creating message service bean");
    }


}
