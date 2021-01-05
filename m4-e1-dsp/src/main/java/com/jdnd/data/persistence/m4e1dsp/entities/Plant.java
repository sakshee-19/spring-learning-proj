package com.jdnd.data.persistence.m4e1dsp.entities;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Plant {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Column(name = "price", scale = 4, precision = 12)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}