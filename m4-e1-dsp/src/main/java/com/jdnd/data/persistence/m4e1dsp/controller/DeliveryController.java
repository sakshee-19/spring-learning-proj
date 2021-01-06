package com.jdnd.data.persistence.m4e1dsp.controller;

import com.jdnd.data.persistence.m4e1dsp.dto.RecipientAndPrice;
import com.jdnd.data.persistence.m4e1dsp.entities.Delivery;
import com.jdnd.data.persistence.m4e1dsp.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping
    public List<Delivery> deliveriesByName(@RequestParam(value = "name", required = true) String name){
        return deliveryService.getDeliveriesByName(name);
    }

    @GetMapping("/{id}")
    public RecipientAndPrice deliveriesById(@PathVariable Long id){
        return deliveryService.findRecipientInfo(id);
    }
}