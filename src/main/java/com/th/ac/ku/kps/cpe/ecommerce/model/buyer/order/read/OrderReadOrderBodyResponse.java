package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;

import java.sql.Timestamp;
import java.util.List;

public class OrderReadOrderBodyResponse {
    private Integer id_order;
    private Timestamp order_created_at;
    private OrderStatus order_status;
    private List<OrderReadOrderItemOrderBodyResponse> order_item;

    @JsonGetter
    public Integer getId_order() {
        return id_order;
    }

    @JsonSetter
    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    @JsonGetter
    public Timestamp getOrder_created_at() {
        return order_created_at;
    }

    @JsonSetter
    public void setOrder_created_at(Timestamp order_created_at) {
        this.order_created_at = order_created_at;
    }

    @JsonGetter
    public OrderStatus getOrder_status() {
        return order_status;
    }

    @JsonSetter
    public void setOrder_status(OrderStatus orderStatus) {
        this.order_status = orderStatus;
    }


    @JsonGetter
    public List<OrderReadOrderItemOrderBodyResponse> getOrder_item() {
        return order_item;
    }

    @JsonSetter
    public void setOrder_item(List<OrderReadOrderItemOrderBodyResponse> order_item) {
        this.order_item = order_item;
    }
}
