package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderReadOrderItemOrderBodyResponse {
    private int id_item;
    private int id_variation;
    private int quantity;

    @JsonGetter
    public int getId_item() {
        return id_item;
    }

    @JsonSetter
    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    @JsonGetter
    public int getId_variation() {
        return id_variation;
    }

    @JsonSetter
    public void setId_variation(int id_variation) {
        this.id_variation = id_variation;
    }

    @JsonGetter
    public int getQuantity() {
        return quantity;
    }

    @JsonSetter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
