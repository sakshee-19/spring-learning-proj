package com.jdnd.data.persistence.m4e1dsp.service;

import com.jdnd.data.persistence.m4e1dsp.entities.Plant;
import com.jdnd.data.persistence.m4e1dsp.repository.DeliveredView;
import com.jdnd.data.persistence.m4e1dsp.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name) {
        Plant plant = new Plant();
        plant.setName(name);
        return plant;

    }

    public DeliveredView hasDelivered(Long plantId) {
        if(plantRepository.findById(plantId).isPresent())
            return plantRepository.getDeliveryDeliveredById(plantId);
        return null;
    }

    public Boolean hasDelivered2(Long plantId) {
        if(plantRepository.findById(plantId).isPresent())
            return plantRepository.hasDeliveredByPlantId(plantId);
        return null;
    }

    public List<Plant> findCheaperPlant(BigDecimal price) {
        List<Plant> plants = plantRepository.findAllByPriceLessThanEqual(price);
        if(plants == null){
            return new ArrayList<>();
        } else {
            return plants;
        }
    }
}
