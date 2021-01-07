package com.jdnd.data.persistence.m4e1dsp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdnd.data.persistence.m4e1dsp.dto.PlantDTO;
import com.jdnd.data.persistence.m4e1dsp.entities.Plant;
import com.jdnd.data.persistence.m4e1dsp.repository.DeliveredView;
import com.jdnd.data.persistence.m4e1dsp.service.PlantService;
import lombok.Lombok;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    PlantService plantService;

    @GetMapping("/dto/{nam}")
    public PlantDTO getPlantDTO(@PathVariable String nam) {
        Plant plant = plantService.getPlantByName(nam);
        return convertToDto(plant);
    }

    @GetMapping("/{nam}")
    @JsonView(Views.Public.class)
    public Plant getPlantJSON(@PathVariable String nam) {
        Plant plant = plantService.getPlantByName(nam);
        return plant;
    }

    @GetMapping("/{id}/delivered")
    public ResponseEntity hasDelivered(@PathVariable Long id) {
        DeliveredView deliveredView = plantService.hasDelivered(id);
        if (deliveredView != null){
            System.out.println(deliveredView.getDeliveredCheck());
            return new ResponseEntity(deliveredView.getDeliveredCheck(), HttpStatus.OK);
        } else
            return new ResponseEntity("plant not found", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{id}/delivered2")
    public ResponseEntity hasDelivered2(@PathVariable Long id) {
        return new ResponseEntity(plantService.hasDelivered3(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getListCheaperPlants(@RequestParam(value = "max_price", required = true) BigDecimal maxPrice){
        return new ResponseEntity(plantService.findCheaperPlant(maxPrice), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity savePlant(@RequestBody Plant plant){
        Long id = plantService.savePlant(plant);
        return new ResponseEntity(id, HttpStatus.CREATED);
    }


    @PostMapping("/{id}/update")
    public ResponseEntity savePlant(@RequestBody Plant plant, @PathVariable Long id){
        Plant plant1 = plantService.updatePlant(plant, id);
        return new ResponseEntity(plant1, HttpStatus.OK);
    }


    private PlantDTO convertToDto(Plant plant) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
}
