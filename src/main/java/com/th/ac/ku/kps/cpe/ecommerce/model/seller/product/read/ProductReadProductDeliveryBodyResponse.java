package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductReadProductDeliveryBodyResponse {
    private Integer id_ship;
    private String name_ship;
    private Double price;
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
