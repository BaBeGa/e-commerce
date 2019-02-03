package com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderHistoryStatus;

import java.util.Date;

public class StatisticsOrderHistoryBodyResponse {
    private Integer id_order_history;
    private Integer id_buyer;
    private String username_buyer;
    private Integer id_item;
    private Integer id_product;
    private String name_product;
    private Integer id_variation;
    private String name_variation;
    private String type_shipping;
    private Integer quantity;
    private Double price;
    private Double shipping_price;
    private String receiver;
    private String address;
    private String sub_district;
    private String district;
    private String province;
    private String postal_code;
    private String name_type_payment;
    private Double income;
    private OrderHistoryStatus status;
    private Date successful_date;

    @JsonGetter
    public Integer getId_order_history() {
        return id_order_history;
    }

    @JsonSetter
    public void setId_order_history(Integer id_order_history) {
        this.id_order_history = id_order_history;
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
    public String getType_shipping() {
        return type_shipping;
    }

    @JsonSetter
    public void setType_shipping(String type_shipping) {
        this.type_shipping = type_shipping;
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
    public String getReceiver() {
        return receiver;
    }

    @JsonSetter
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @JsonGetter
    public String getAddress() {
        return address;
    }

    @JsonSetter
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonGetter
    public String getSub_district() {
        return sub_district;
    }

    @JsonSetter
    public void setSub_district(String sub_district) {
        this.sub_district = sub_district;
    }

    @JsonGetter
    public String getDistrict() {
        return district;
    }

    @JsonSetter
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonGetter
    public String getProvince() {
        return province;
    }

    @JsonSetter
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonGetter
    public String getPostal_code() {
        return postal_code;
    }

    @JsonSetter
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @JsonGetter
    public String getName_type_payment() {
        return name_type_payment;
    }

    @JsonSetter
    public void setName_type_payment(String name_type_payment) {
        this.name_type_payment = name_type_payment;
    }

    @JsonGetter
    public Double getIncome() {
        return income;
    }

    @JsonSetter
    public void setIncome(Double income) {
        this.income = income;
    }

    @JsonGetter
    public OrderHistoryStatus getStatus() {
        return status;
    }

    @JsonSetter
    public void setStatus(OrderHistoryStatus status) {
        this.status = status;
    }

    @JsonGetter
    public Date getSuccessful_date() {
        return successful_date;
    }

    @JsonSetter
    public void setSuccessful_date(Date successful_date) {
        this.successful_date = successful_date;
    }
}
