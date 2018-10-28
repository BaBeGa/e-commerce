package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderDeleteBodyRequest {
    private Integer[] id_order;
    private Integer[] id_item;

    @JsonGetter
    public Integer[] getId_order() {
        return id_order;
    }

    @JsonSetter
    public void setId_order(Integer[] id_order) {
        this.id_order = id_order;
    }

    @JsonGetter
    public Integer[] getId_item() {
        return id_item;
    }

    @JsonSetter
    public void setId_item(Integer[] id_item) {
        this.id_item = id_item;
    }
}
