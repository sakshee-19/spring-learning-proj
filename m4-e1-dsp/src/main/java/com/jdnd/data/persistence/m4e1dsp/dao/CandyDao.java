package com.jdnd.data.persistence.m4e1dsp.dao;

import com.jdnd.data.persistence.m4e1dsp.entities.CandyData;

import java.util.List;

public interface CandyDao {
    List<CandyData> getCandyList();
    void mapCandyToDelivery(Long candyId, Long deliveryId);
    List<CandyData> getListCandyByDelivery(Long deliveryId);
}
