package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Time;

public class OrderForSellerReadShipOfShopBodyResponse {
    private Integer id_ship;
    private String type;
    private Double price_ship;
    private Integer time_ship;

    @JsonGetter
    public Integer getId_ship() {
        return id_ship;
    }

    @JsonSetter
    public void setId_ship(Integer id_ship) {
        this.id_ship = id_ship;
    }

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

    @JsonGetter
    public Integer getTime_ship() {
        return time_ship;
    }

    @JsonSetter
    public void setTime_ship(Integer time_ship) {
        this.time_ship = time_ship;
    }
}