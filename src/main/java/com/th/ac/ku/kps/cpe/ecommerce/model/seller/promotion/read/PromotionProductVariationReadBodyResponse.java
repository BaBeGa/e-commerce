package com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class PromotionProductVariationReadBodyResponse {
    private Integer id_product_has_promo;
    private Integer id_variation;
    private String name;
    private Double price;
    private Double new_price;
    private Timestamp time_start;
    private Timestamp time_end;

    @JsonGetter
    public Integer getId_product_has_promo() {
        return id_product_has_promo;
    }

    @JsonSetter
    public void setId_product_has_promo(Integer id_product_has_promo) {
        this.id_product_has_promo = id_product_has_promo;
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
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
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
    public Timestamp getTime_start() {
        return time_start;
    }

    @JsonSetter
    public void setTime_start(Timestamp time_start) {
        this.time_start = time_start;
    }

    @JsonGetter
    public Timestamp getTime_end() {
        return time_end;
    }

    @JsonSetter
    public void setTime_end(Timestamp time_end) {
        this.time_end = time_end;
    }
}
