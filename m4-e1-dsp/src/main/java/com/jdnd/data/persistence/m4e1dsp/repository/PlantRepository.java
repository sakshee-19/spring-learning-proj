package com.jdnd.data.persistence.m4e1dsp.repository;

import com.jdnd.data.persistence.m4e1dsp.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    DeliveredView getDeliveryDeliveredById(Long id);

    @Query("SELECT p.delivery.delivered FROM Plant p WHERE p.id = :id")
    Boolean hasDeliveredByPlantId(Long id);

    List<Plant> findAllByPriceLessThanEqual(BigDecimal price);

}
