package com.udacity.jdnd.course1.controllers;

import com.udacity.jdnd.course1.db.Delivery;
import com.udacity.jdnd.course1.mapper.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DeliveryResources {

    @Autowired
    DeliveryMapper deliveryMapper;

    @GetMapping("/delivery/{id}")
    public Delivery findDelivery(String id) {
        return deliveryMapper.findDelivery(id);
    }

}
