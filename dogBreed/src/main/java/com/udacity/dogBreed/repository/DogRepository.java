package com.udacity.dogBreed.repository;

import com.udacity.dogBreed.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d FROM Dog d where d.name=:name")
    List<Dog> getDogByName(String name);


    @Query("SELECT d.id, d.breed FROM Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("DELETE FROM Dog d where d.breed=:breed")
    void deleteByBreed(String breed);


    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
}
