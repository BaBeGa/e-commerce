package com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductDeliveryReadDataBodyResponse {
    private int id_ship;
    private int id_type;
    private String name_ship;
    private Double price;
    private Integer time_ship;

    @JsonGetter
    public int getId_ship() {
        return id_ship;
    }

    @JsonSetter
    public void setId_ship(int id_ship) {
        this.id_ship = id_ship;
    }

    @JsonGetter
    public int getId_type() {
        return id_type;
    }

    @JsonSetter
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    @JsonGetter
    public String getName_ship() {
        return name_ship;
    }
    @JsonSetter
    public void setName_ship(String name_ship) {
        this.name_ship = name_ship;
    }

    @JsonGetter
    public Double getPrice() {
        return price;
    }

    @JsonSetter
    public void setPrice(Double price) {
        this.price = price;
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
