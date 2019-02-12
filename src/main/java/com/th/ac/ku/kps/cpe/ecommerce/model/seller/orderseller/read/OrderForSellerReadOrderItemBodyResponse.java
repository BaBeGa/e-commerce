package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;

import java.util.List;

public class OrderForSellerReadOrderItemBodyResponse {

    private Integer id_item;
    private OrderForSellerReadProductBodyResponse product;
    private Integer quantity;
    private Double price;
    private OrderItemStatus status;
    private OrderForSellerReadProductDeliveryBodyResponse product_delivery;
    private String tracking_number;
    private List<OrderForSellerCheckPointBodyResponse> checkpoint;
    private OrderForSellerDeliveryAddressOrderReadResponse delivery_address;

    @JsonGetter
    public Integer getId_item() {
        return id_item;
    }

    @JsonSetter
    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    @JsonGetter
    public OrderForSellerReadProductBodyResponse getProduct() {
        return product;
    }

    @JsonSetter
    public void setProduct(OrderForSellerReadProductBodyResponse product) {
        this.product = product;
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
    public Double getPrice() {
        return price;
    }

    @JsonSetter
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonGetter
    public OrderItemStatus getStatus() {
        return status;
    }

    @JsonSetter
    public void setStatus(OrderItemStatus status) {
        this.status = status;
    }

    @JsonGetter
    public OrderForSellerReadProductDeliveryBodyResponse getProduct_delivery() {
        return product_delivery;
    }

    @JsonSetter
    public void setProduct_delivery(OrderForSellerReadProductDeliveryBodyResponse product_delivery) {
        this.product_delivery = product_delivery;
    }

    @JsonGetter
    public String getTracking_number() {
        return tracking_number;
    }

    @JsonSetter
    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    @JsonGetter
    public List<OrderForSellerCheckPointBodyResponse> getCheckpoint() {
        return checkpoint;
    }

    @JsonSetter
    public void setCheckpoint(List<OrderForSellerCheckPointBodyResponse> checkpoint) {
        this.checkpoint = checkpoint;
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
