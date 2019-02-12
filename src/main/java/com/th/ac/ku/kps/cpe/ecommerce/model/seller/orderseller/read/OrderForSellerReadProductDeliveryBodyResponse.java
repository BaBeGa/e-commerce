package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Time;

public class OrderForSellerReadProductDeliveryBodyResponse {
    private String type;
    private Double price_ship;

    @JsonGetter
    public String getType() {
        return type;
    }

    @JsonSetter
    public void setType(String type) {
        this.type = type;
    }

    @JsonGetter
    public Double getPrice_ship() {
        return price_ship;
    }

    @JsonSetter
    public void setPrice_ship(Double price_ship) {
        this.price_ship = price_ship;
    }
}