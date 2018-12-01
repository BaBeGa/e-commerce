package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderStatus;

import java.sql.Timestamp;
import java.util.List;

public class OrderForSellerReadOrderBodyResponse {
    private Integer id_order;
    private Integer id_buyer;
    private Timestamp order_created_at;
    private OrderStatus order_status;
    private OrderForSellerDeliveryAddressOrderReadResponse delivery_address;
    @JsonGetter
    public Integer getId_order() {
        return id_order;
    }
    @JsonSetter
    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }
    @JsonGetter
    public Integer getId_buyer() {
        return id_buyer;
    }
    @JsonSetter
    public void setId_buyer(Integer id_buyer) {
        this.id_buyer = id_buyer;
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
    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }

    @JsonGetter
    public OrderForSellerDeliveryAddressOrderReadResponse getDelivery_address() {
        return delivery_address;
    }

    @JsonSetter
    public void setDelivery_address(OrderForSellerDeliveryAddressOrderReadResponse delivery_address) {
        this.delivery_address = delivery_address;
    }
}
