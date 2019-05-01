package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderhistory;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;

import java.sql.Timestamp;

public class OrderHistoryReadOrderHisBodyResponse {
    private Integer id_order_history;
    private Timestamp ordered_date;
    private Integer id_buyer;
    private String username_buyer;
    private Integer id_item;
    private Integer id_shop;
    private String name_shop;
    private Integer id_product;
    private String name_product;
    private Integer id_variation;
    private String name_variation;
    private Integer quantity;
    private Double price;
    private Double shipping_price;
    private OrderItemStatus status;

    @JsonGetter
    public Integer getId_order_history() {
        return id_order_history;
    }

    @JsonSetter
    public void setId_order_history(Integer id_order_history) {
        this.id_order_history = id_order_history;
    }

    @JsonGetter
    public Timestamp getOrdered_date() {
        return ordered_date;
    }

    @JsonSetter
    public void setOrdered_date(Timestamp ordered_date) {
        this.ordered_date = ordered_date;
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
    public String getUsername_buyer() {
        return username_buyer;
    }

    @JsonSetter
    public void setUsername_buyer(String username_buyer) {
        this.username_buyer = username_buyer;
    }

    @JsonGetter
    public Integer getId_item() {
        return id_item;
    }

    @JsonSetter
    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    @JsonGetter
    public Integer getId_shop() {
        return id_shop;
    }

    @JsonSetter
    public void setId_shop(Integer id_shop) {
        this.id_shop = id_shop;
    }

    @JsonGetter
    public String getName_shop() {
        return name_shop;
    }

    @JsonSetter
    public void setName_shop(String name_shop) {
        this.name_shop = name_shop;
    }

    @JsonGetter
    public Integer getId_product() {
        return id_product;
    }

    @JsonSetter
    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    @JsonGetter
    public String getName_product() {
        return name_product;
    }

    @JsonSetter
    public void setName_product(String name_product) {
        this.name_product = name_product;
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
    public String getName_variation() {
        return name_variation;
    }

    @JsonSetter
    public void setName_variation(String name_variation) {
        this.name_variation = name_variation;
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
    public Double getShipping_price() {
        return shipping_price;
    }

    @JsonSetter
    public void setShipping_price(Double shipping_price) {
        this.shipping_price = shipping_price;
    }

    @JsonGetter
    public OrderItemStatus getStatus() {
        return status;
    }

    @JsonSetter
    public void setStatus(OrderItemStatus status) {
        this.status = status;
    }
}

