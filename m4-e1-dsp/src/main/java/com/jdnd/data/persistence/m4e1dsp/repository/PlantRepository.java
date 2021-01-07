package com.jdnd.data.persistence.m4e1dsp.repository;

import com.jdnd.data.persistence.m4e1dsp.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    DeliveredView getDeliveryDeliveredById(Long id); //fails when plant.delivery is null

//    //check if a plant by this id exists where delivery has been completed
//    Boolean existsPlantByIdAndHasDeliveredByPlantId(Long id, Boolean delivered);

    @Query("SELECT p.delivery.delivered FROM Plant p WHERE p.id = :id")
    Boolean hasDeliveredByPlantId(Long id);

    //to return a wrapper class, you may need to construct it as a projection
    @Query("select new java.lang.Boolean(p.delivery.delivered) from Plant p where p.id = :plantId")
    Boolean deliveryCompletedBoolean(Long plantId);

    List<Plant> findAllByPriceLessThanEqual(BigDecimal price);

}
