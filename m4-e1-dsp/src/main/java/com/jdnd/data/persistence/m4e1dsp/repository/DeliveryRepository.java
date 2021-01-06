package com.jdnd.data.persistence.m4e1dsp.repository;

import com.jdnd.data.persistence.m4e1dsp.dto.RecipientAndPrice;
import com.jdnd.data.persistence.m4e1dsp.entities.Delivery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
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
        return entityManager.merge(delivery);

    }

    public void delete(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

    public List<Delivery> findDeliveryByName(String name) {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.ByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public RecipientAndPrice findRecipientInfo(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Delivery> criteria = cb.createQuery(Delivery.class);

        Root<Delivery> root = criteria.from(Delivery.class);
        criteria.select(root);
        criteria.where(cb.equal(root.get("id"), id));

        List<Delivery> deliveries = entityManager.createQuery(criteria).getResultList();
        RecipientAndPrice rap = new RecipientAndPrice();
        BeanUtils.copyProperties(deliveries, rap);
        return rap;
    }
}
