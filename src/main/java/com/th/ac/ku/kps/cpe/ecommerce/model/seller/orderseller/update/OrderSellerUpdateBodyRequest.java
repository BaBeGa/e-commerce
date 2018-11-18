package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderSellerUpdateBodyRequest {
    private Integer id_item;
    private String tracking_number;

    @JsonGetter
    public Integer getId_item() {
        return id_item;
    }

    @JsonSetter
    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    @JsonGetter
    public String getTracking_number() {
        return tracking_number;
    }

    @JsonSetter
    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }
}
