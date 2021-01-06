package com.jdnd.data.persistence.m4e1dsp.repository;

import com.jdnd.data.persistence.m4e1dsp.entities.Delivery;
import org.springframework.beans.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        return delivery;
    }

    public Delivery merge(Delivery delivery){
        Delivery managedEntity = entityManager.merge(delivery);
        BeanUtils.copyProperties(delivery, managedEntity);
        return managedEntity;
    }

    public void delete(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }
}
