package com.jdnd.data.persistence.m4e1dsp.entities;

public class Candy_Delivery {
    private Long candy_id;
    private Long delivery_id;

    public Long getCandy_id() {
        return candy_id;
    }

    public void setCandy_id(Long candy_id) {
        this.candy_id = candy_id;
    }

    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long delivery_id) {
        this.delivery_id = delivery_id;
    }

    public Candy_Delivery(Long candy_id, Long delivery_id) {
        this.candy_id = candy_id;
        this.delivery_id = delivery_id;
    }
}
