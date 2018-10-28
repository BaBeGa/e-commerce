package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderCreateOrderItemBodyRequest {
    private Integer id_variation;
    private Integer quantity;

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
}
