package com.udacity.jdnd.course1.mapper;

import com.udacity.jdnd.course1.db.Delivery;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface DeliveryMapper {

    @Select("SELECT * FROM delivery WHERE id=#{id}")
    Delivery findDelivery(String id);

    @Insert("INSERT into delivery (orderId, time) values (#{orderId},#{time} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addNewDelivery(Delivery delivery);

    @Delete("DELETE FROM delivery WHERE id=#{id}")
    void deleteDelivery(String id);

}
