package com.udacity.bootstrap.services;

import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> getAllDogs(){
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> findAllBreeds(){
        return dogRepository.findAllBreed();
    }

    public List<String> findAllName() {
        return dogRepository.findAllName();
    }

    public Dog getDogById(Integer id){
        Optional<Dog> dogRes = dogRepository.findById(id);
        if (dogRes.isPresent()){
            return dogRes.get();
        }
        return null;
    }

    public List<Dog> getDogByName(String name) {
        List<Dog> dogRes = dogRepository.getDogByName(name);
        return dogRes;

    }
}
