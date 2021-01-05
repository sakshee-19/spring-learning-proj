package com.jdnd.data.persistence.m4e1dsp.entities;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Shrub extends Plant{

    BigDecimal height;

    BigDecimal width;

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }
}
