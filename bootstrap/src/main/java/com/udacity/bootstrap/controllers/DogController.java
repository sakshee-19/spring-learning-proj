package com.udacity.bootstrap.controllers;

import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.services.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is not expected please follow code format"),
        @ApiResponse(code = 403, message = "Forbidden .."),
        @ApiResponse(code = 401, message = "Due to BaD credential ypu can not continue")
        })
public class DogController {

    @Autowired
    DogService dogService;

    @GetMapping("/{id}")
    public ResponseEntity getDogById(@PathVariable("id") Long id){
        Dog result = dogService.getDogById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/breeds")
    public ResponseEntity findAllBreeds(){
        return new ResponseEntity(dogService.findAllBreeds(), HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity findAllNames(){
        return new ResponseEntity(dogService.findAllName(), HttpStatus.OK);
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
