package com.udacity.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.services.BreedNotFoundException;
import com.udacity.bootstrap.services.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    DogRepository dogRepository;

//    public Boolean deleteDogBreed(String breed) {
//        dogRepository.deleteByBreed(breed);
//        return true;
//    }
public boolean deleteDogBreed(String breed) {
    boolean deleted = false;
    Iterable<Dog> allDogs = dogRepository.findAll();
    // Loop through all dogs to check their breed
    for (Dog d:allDogs) {
        if (d.getBreed().equals(breed)) {
            // Delete if the breed is found
            dogRepository.delete(d);
            deleted = true;
        }
    }
    // Throw an exception if the breed doesn't exist
    if (!deleted) {
        throw new BreedNotFoundException("Breed Not Found", breed);
    }
    return deleted;
}


    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> existingDog = dogRepository.findById(id);
        if(existingDog.isPresent()){
            Dog dog = existingDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not found", id);
        }
    }
}
