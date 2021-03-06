package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;

import java.sql.Timestamp;
import java.util.List;

public class OrderReadOrderItemOrderBodyResponse {
    private Integer id_order;
    private Timestamp ordered_date;
    private int id_item;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrderItemStatus order_item_status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description_reject;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp auto_reject_date;
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
    private Double new_price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OrderReadProductDeliveryOrderItemOrderBodyResponse product_delivery;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tracking_number;
    private Timestamp expired_ship;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderReadOrderItemCheckpointOrderItemResponse> checkpoint;
    private Timestamp expired_buyer_comfirm;

    @JsonGetter
    public Integer getId_order() {
        return id_order;
    }

    @JsonSetter
    public void setId_order(Integer id_order) {
        this.id_order = id_order;
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
    public Timestamp getAuto_reject_date() {
        return auto_reject_date;
    }

    @JsonSetter
    public void setAuto_reject_date(Timestamp auto_reject_date) {
        this.auto_reject_date = auto_reject_date;
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
    public Double getNew_price() {
        return new_price;
    }

    @JsonSetter
    public void setNew_price(Double new_price) {
        this.new_price = new_price;
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
    public Timestamp getExpired_ship() {
        return expired_ship;
    }

    @JsonSetter
    public void setExpired_ship(Timestamp expired_ship) {
        this.expired_ship = expired_ship;
    }

    @JsonGetter
    public List<OrderReadOrderItemCheckpointOrderItemResponse> getCheckpoint() {
        return checkpoint;
    }

    @JsonSetter
    public void setCheckpoint(List<OrderReadOrderItemCheckpointOrderItemResponse> checkpoint) {
        this.checkpoint = checkpoint;
    }

    @JsonGetter
    public Timestamp getExpired_buyer_comfirm() {
        return expired_buyer_comfirm;
    }

    @JsonSetter
    public void setExpired_buyer_comfirm(Timestamp expired_buyer_comfirm) {
        this.expired_buyer_comfirm = expired_buyer_comfirm;
    }
}
