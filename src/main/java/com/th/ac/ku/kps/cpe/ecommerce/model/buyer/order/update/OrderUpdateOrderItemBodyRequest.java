package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderUpdateOrderItemBodyRequest {
    private Integer id_item;
    private Integer id_variation;
    private Integer quantity;
    private Integer id_ship;
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
    public Integer getId_variation() {
        return id_variation;
    }

    @JsonSetter
    public void setId_variation(Integer id_variation) {
        this.id_variation = id_variation;
    }

    @JsonGetter
    public Integer getQuantity() {
        return quantity;
    }

    @JsonSetter
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonGetter
    public Integer getId_ship() {
        return id_ship;
    }

    @JsonSetter
    public void setId_ship(Integer id_ship) {
        this.id_ship = id_ship;
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
