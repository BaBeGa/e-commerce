package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderitem;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;

public class OrderItemUpdateRequest {
    private Integer id_item;
    private OrderItemStatus order_item_status;
    private String description_reject;

    @JsonGetter
    public Integer getId_item() {
        return id_item;
    }

    @JsonSetter
    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    @JsonGetter
    public OrderItemStatus getOrder_item_status() {
        return order_item_status;
    }

    @JsonSetter
    public void setOrder_item_status(OrderItemStatus order_item_status) {
        this.order_item_status = order_item_status;
    }

    @JsonGetter
    public String getDescription_reject() {
        return description_reject;
    }

    @JsonSetter
    public void setDescription_reject(String description_reject) {
        this.description_reject = description_reject;
    }
}
