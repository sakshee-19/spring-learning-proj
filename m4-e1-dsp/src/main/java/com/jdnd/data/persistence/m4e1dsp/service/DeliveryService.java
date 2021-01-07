package com.jdnd.data.persistence.m4e1dsp.service;

import com.jdnd.data.persistence.m4e1dsp.dto.RecipientAndPrice;
import com.jdnd.data.persistence.m4e1dsp.entities.Delivery;
import com.jdnd.data.persistence.m4e1dsp.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public List<Delivery> getDeliveriesByName(String name) {
        return deliveryRepository.findDeliveryByName(name);
    }

    public RecipientAndPrice findRecipientInfo(Long id) {
        return deliveryRepository.findRecipientInfo(id);
    }
}
