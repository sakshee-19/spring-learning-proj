package com.jdnd.data.persistence.m4e1dsp.repository;

import com.jdnd.data.persistence.m4e1dsp.dto.RecipientAndPrice;
import com.jdnd.data.persistence.m4e1dsp.entities.Delivery;
import com.jdnd.data.persistence.m4e1dsp.entities.Plant;
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

    public RecipientAndPrice findRecipientInfo(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<RecipientAndPrice> criteria = cb.createQuery(RecipientAndPrice.class);

        Root<Plant> root = criteria.from(Plant.class);
        criteria.select(cb.construct(RecipientAndPrice.class, root.get("delivery").get("name"), cb.sum(root.get("price"))));
        criteria.where(cb.equal(root.get("delivery").get("id"), deliveryId));

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
