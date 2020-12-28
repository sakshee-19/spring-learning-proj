package com.udacity.dogBreed.repository;

import com.udacity.dogBreed.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
