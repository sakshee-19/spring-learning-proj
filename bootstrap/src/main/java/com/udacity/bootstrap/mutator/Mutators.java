package com.udacity.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrap.entities.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.services.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Mutators implements GraphQLMutationResolver {
    @Autowired
    DogRepository dogRepository;

    public Boolean deleteDogBreed(String breed) {
        dogRepository.deleteByBreed(breed);
        return true;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> existingDog = dogRepository.findById(id);
        if(existingDog.isPresent()){
            Dog dog = existingDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog with the id "+id+" Not found");
        }
    }
}
