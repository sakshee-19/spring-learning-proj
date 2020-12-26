package com.udacity.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.services.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    DogRepository dogRepository;

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogBreedById(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent())
            return dog.get();
        else
            throw new DogNotFoundException("Dog Not found", id);
    }

}
