package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderForSellerReadOrderItemBodyResponse {

    private Integer id_item;
    private OrderForSellerReadVariationBodyResponse product_variation;
    private Integer quantity;
    private Double price;
    private OrderForSellerReadShipOfShopBodyResponse ship_of_shop;
    private String tracking_number;
    private OrderForSellerReadOrderBodyResponse order;

    @JsonGetter
    public Integer getId_item() {
        return id_item;
    }

    @JsonSetter
    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    @JsonGetter
    public OrderForSellerReadVariationBodyResponse getProduct_variation() {
        return product_variation;
    }

    @JsonSetter
    public void setProduct_variation(OrderForSellerReadVariationBodyResponse product_variation) {
        this.product_variation = product_variation;
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
    public OrderForSellerReadShipOfShopBodyResponse getShip_of_shop() {
        return ship_of_shop;
    }

    @JsonSetter
    public void setShip_of_shop(OrderForSellerReadShipOfShopBodyResponse ship_of_shop) {
        this.ship_of_shop = ship_of_shop;
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
    public OrderForSellerReadOrderBodyResponse getOrder() {
        return order;
    }

    @JsonSetter
    public void setOrder(OrderForSellerReadOrderBodyResponse order) {
        this.order = order;
    }
}
