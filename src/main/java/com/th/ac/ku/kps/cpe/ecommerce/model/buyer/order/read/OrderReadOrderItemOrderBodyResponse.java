package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class OrderReadOrderItemOrderBodyResponse {
    private int id_item;
    private int id_variation;
    private int quantity;
    private Double price;
    private OrderReadShipOfShopOrderItemOrderBodyResponse id_ship_of_shop;
    private String tracking_number;
    private List<OrderReadOrderItemCheckpointOrderItemResponse> checkpoint;

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

    @JsonGetter
    public Double getPrice() {
        return price;
    }

    @JsonSetter
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonGetter
    public OrderReadShipOfShopOrderItemOrderBodyResponse getId_ship_of_shop() {
        return id_ship_of_shop;
    }

    @JsonSetter
    public void setId_ship_of_shop(OrderReadShipOfShopOrderItemOrderBodyResponse id_ship_of_shop) {
        this.id_ship_of_shop = id_ship_of_shop;
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
    public List<OrderReadOrderItemCheckpointOrderItemResponse> getCheckpoint() {
        return checkpoint;
    }

    @JsonSetter
    public void setCheckpoint(List<OrderReadOrderItemCheckpointOrderItemResponse> checkpoint) {
        this.checkpoint = checkpoint;
    }
}
