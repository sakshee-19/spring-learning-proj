package com.jdnd.data.persistence.m4e1dsp.repository;

import org.springframework.beans.factory.annotation.Value;

public interface DeliveredView {

    @Value("#{target.delivery.delivered}")
    Boolean getDeliveredCheck();
}
