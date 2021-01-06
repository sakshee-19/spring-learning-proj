package com.jdnd.data.persistence.m4e1dsp.service;

import com.jdnd.data.persistence.m4e1dsp.entities.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    public Plant getPlantByName(String name) {
        Plant plant = new Plant();
        plant.setName(name);
        return plant;

    }
}
