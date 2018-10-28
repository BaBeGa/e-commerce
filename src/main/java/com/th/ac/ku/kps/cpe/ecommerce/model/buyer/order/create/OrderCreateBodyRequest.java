package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;

import java.util.List;

public class OrderCreateBodyRequest {
    private OrderStatus order_status;
    private Integer id_type_payment;
    private List<OrderCreateOrderItemBodyRequest> order_item;

    @JsonGetter
    public OrderStatus getOrder_status() {
        return order_status;
    }

    @JsonSetter
    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }

    @JsonGetter
    public Integer getId_type_payment() {
        return id_type_payment;
    }

    @JsonSetter
    public void setId_type_payment(Integer id_type_payment) {
        this.id_type_payment = id_type_payment;
    }

    @JsonGetter
    public List<OrderCreateOrderItemBodyRequest> getOrder_item() {
        return order_item;
    }

    @JsonSetter
    public void setOrder_item(List<OrderCreateOrderItemBodyRequest> order_item) {
        this.order_item = order_item;
    }
}
