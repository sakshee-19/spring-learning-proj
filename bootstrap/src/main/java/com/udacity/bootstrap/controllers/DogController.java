package com.udacity.bootstrap.controllers;

import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    DogService dogService;

    @GetMapping("/{id}")
    public ResponseEntity getDogById(@PathVariable("id") Integer id){
        Dog result = dogService.getDogById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findAllDog(@RequestParam(required = false, name = "name") String name){
        List<Dog> result;
        if(name != null) {
             result = dogService.getDogByName(name);
        } else
            result = dogService.getAllDogs();
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
