package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entities.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

//    @Query("INSERT into Dog () values ()")
//    public void createDog(Dog dog);

    @Query("SELECT d FROM Dog d where d.name=:name")
     List<Dog> getDogByName(String name);


    @Query("SELECT d.id, d.breed FROM Dog d where d.id=:id")
    String findBreedById(Long id);


    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
}
