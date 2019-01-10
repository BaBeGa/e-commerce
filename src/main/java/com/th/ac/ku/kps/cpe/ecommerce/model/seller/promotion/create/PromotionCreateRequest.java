package com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class PromotionCreateRequest {
    private Integer id_promo_type;
    private Integer id_product_variation;
    private Double new_price;
    private Timestamp time_start;
    private Timestamp time_end;

    @JsonGetter
    public Integer getId_promo_type() {
        return id_promo_type;
    }

    @JsonSetter
    public void setId_promo_type(Integer id_promo_type) {
        this.id_promo_type = id_promo_type;
    }

    @JsonGetter
    public Integer getId_product_variation() {
        return id_product_variation;
    }

    @JsonSetter
    public void setId_product_variation(Integer id_product_variation) {
        this.id_product_variation = id_product_variation;
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

