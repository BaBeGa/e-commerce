package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderForSellerReadProductBodyResponse {
    private Integer id_variation;
    private String name_variation;
    private Integer id_product;
    private String name_product;
    private String pic_product;

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
}
