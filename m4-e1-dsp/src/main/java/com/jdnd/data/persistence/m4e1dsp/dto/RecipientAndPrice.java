package com.jdnd.data.persistence.m4e1dsp.dto;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String recipientName;
    private BigDecimal price;

    public RecipientAndPrice(String name, BigDecimal price) {
        this.recipientName = name;
        this.price = price;
    }

    public RecipientAndPrice() { }

    public String getName() {
        return recipientName;
    }

    public void setName(String name) {
        this.recipientName = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
