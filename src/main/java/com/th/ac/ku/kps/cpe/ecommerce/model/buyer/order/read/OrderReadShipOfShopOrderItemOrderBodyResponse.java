package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderReadShipOfShopOrderItemOrderBodyResponse {
    private Integer id_ship_of_shop;
    private String slug;
    private Double price;
    private Integer time_ship;

    @JsonGetter
    public Integer getId_ship_of_shop() {
        return id_ship_of_shop;
    }

    @JsonSetter
    public void setId_ship_of_shop(Integer id_ship_of_shop) {
        this.id_ship_of_shop = id_ship_of_shop;
    }

    @JsonGetter
    public String getSlug() {
        return slug;
    }

    @JsonSetter
    public void setSlug(String slug) {
        this.slug = slug;
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
