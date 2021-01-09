package com.jdnd.data.persistence.m4e1dsp.dao;

import com.jdnd.data.persistence.m4e1dsp.entities.CandyData;
import com.jdnd.data.persistence.m4e1dsp.entities.Candy_Delivery;
import com.jdnd.data.persistence.m4e1dsp.entities.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * sakshee
 */
@Repository
@Transactional
public class CandyDaoImpl implements CandyDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private final String CANDY_LIST = "select * from candy";

    private final String DELIVERY_CANDY_LIST = "select c.* from (select * from candy_delivery_map where delivery_id = :id) as cdm join candy as c on (c.id=cdm.candy_id)";
    final BeanPropertyRowMapper<CandyData> candyDataBeanPropertyRowMapper = new BeanPropertyRowMapper<>(CandyData.class);

    final BeanPropertyRowMapper<Delivery> deliveryBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Delivery.class);

    @Override
    public List<CandyData> getCandyList() {
        return jdbcTemplate.query(CANDY_LIST, new MapSqlParameterSource(), new BeanPropertyRowMapper<>(CandyData.class));
    }

    @Override
    public void mapCandyToDelivery(Long candyId, Long deliveryId) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getJdbcTemplate())
                .withTableName("candy_delivery_map");
        simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(new Candy_Delivery(candyId, deliveryId)));
    }

    @Override
    public List<CandyData> getListCandyByDelivery(Long deliveryId) {
        return jdbcTemplate.query(DELIVERY_CANDY_LIST, new MapSqlParameterSource().addValue("id", deliveryId), new BeanPropertyRowMapper<>(CandyData.class));
    }
}
