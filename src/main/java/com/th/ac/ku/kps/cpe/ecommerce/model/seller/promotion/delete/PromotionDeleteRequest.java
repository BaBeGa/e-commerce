package com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class PromotionDeleteRequest {
    private Integer id_product_has_promo;

    @JsonGetter
    public Integer getId_product_has_promo() {
        return id_product_has_promo;
    }

    @JsonSetter
    public void setId_product_has_promo(Integer id_product_has_promo) {
        this.id_product_has_promo = id_product_has_promo;
    }
}