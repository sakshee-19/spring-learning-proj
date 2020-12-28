package com.udacity.dogBreed.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog Not Found")
public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException(){}

    public DogNotFoundException(String message){ super(message);}
}
