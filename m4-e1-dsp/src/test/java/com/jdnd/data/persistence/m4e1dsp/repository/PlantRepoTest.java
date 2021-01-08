package com.jdnd.data.persistence.m4e1dsp.repository;

import com.jdnd.data.persistence.m4e1dsp.entities.Delivery;
import com.jdnd.data.persistence.m4e1dsp.entities.Plant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PlantRepoTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PlantRepository plantRepository;

    List<Object> plantsIds = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        for(int i=0; i<3; ++i) {
            Plant p = new Plant();
            p.setName("plant"+i);
            p.setPrice(new BigDecimal(10+i*3));
            Object id  = testEntityManager.persistAndGetId(p);
            System.out.println(id);
            plantsIds.add(id);
        }
    }

    public Long createDelivery(Long plantId, Boolean status) {
        Delivery d = new Delivery();
        d.setDelivered(status);
        Plant plant = testEntityManager.find(Plant.class, plantId);
        plant.setDelivery(d);
        d.setPlants(Arrays.asList(plant));
        return (Long) testEntityManager.persistAndGetId(d);
    }

    @Test
    public void testPriceLessThan() {
        List<Plant> res = plantRepository.findAllByPriceLessThanEqual(new BigDecimal(13));
        for(int i=0; i<res.size();++i) {
            System.out.println(res.get(i));
        }
        assertEquals(2, res.size());
    }

    @Test
    public void testDelivery() {
        createDelivery((Long) plantsIds.get(0), true);
        createDelivery((Long) plantsIds.get(1), false);
        Boolean res = plantRepository.hasDeliveredByPlantId((Long) plantsIds.get(0));
        Boolean res2 = plantRepository.hasDeliveredByPlantId((Long) plantsIds.get(1));
        assertTrue(res);
        assertFalse(res2);
    }
}
