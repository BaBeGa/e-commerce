package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderForSellerReadVariationBodyResponse {
    private Integer id_variation;
    private Integer id_product;
    private String name;
    @JsonGetter
    public Integer getId_variation() {
        return id_variation;
    }
    @JsonSetter
    public void setId_variation(Integer id_variation) {
        this.id_variation = id_variation;
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
    public String getName() {
        return name;
    }
    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }
}
