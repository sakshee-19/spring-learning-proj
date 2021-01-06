package com.jdnd.data.persistence.m4e1dsp.entities;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;



@Entity
@NamedQuery(
        name = "Delivery.ByName",
        query = "select d from Delivery d where d.name = :name"
)
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;

    @Column(name = "address_full", length = 500)
    private String address;

    private LocalDateTime deliveryTime; // includes both date and time - simpler than having two separate fields

    @Type(type = "yes_no")
    private boolean delivered;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
