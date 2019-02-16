package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;

import java.util.List;

public class OrderReadOrderItemOrderBodyResponse {
    private int id_item;
    private OrderItemStatus order_item_status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description_reject;
    private int id_variation;
    private String name_variation;
    private Integer id_shop;
    private String shop_name;
    private Integer id_product;
    private String name_product;
    private String pic_product;
    private int quantity;
    private Double price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrderReadProductDeliveryOrderItemOrderBodyResponse product_delivery;
    private String tracking_number;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonGetter
    public int getId_variation() {
        return id_variation;
    }

    @JsonSetter
    public void setId_variation(int id_variation) {
        this.id_variation = id_variation;
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
    public String getShop_name() {
        return shop_name;
    }

    @JsonSetter
    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
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
    public String getName_variation() {
        return name_variation;
    }

    @JsonSetter
    public void setName_variation(String name_variation) {
        this.name_variation = name_variation;
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
    public String getPic_product() {
        return pic_product;
    }

    @JsonSetter
    public void setPic_product(String pic_product) {
        this.pic_product = pic_product;
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
    public OrderReadProductDeliveryOrderItemOrderBodyResponse getProduct_delivery() {
        return product_delivery;
    }

    @JsonSetter
    public void setProduct_delivery(OrderReadProductDeliveryOrderItemOrderBodyResponse product_delivery) {
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
    public List<OrderReadOrderItemCheckpointOrderItemResponse> getCheckpoint() {
        return checkpoint;
    }

    @JsonSetter
    public void setCheckpoint(List<OrderReadOrderItemCheckpointOrderItemResponse> checkpoint) {
        this.checkpoint = checkpoint;
    }
}
