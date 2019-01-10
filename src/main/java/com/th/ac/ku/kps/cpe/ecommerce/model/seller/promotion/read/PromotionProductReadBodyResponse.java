package com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class PromotionProductReadBodyResponse {
    private Integer id_product;
    private String name_product;
    private String pic_product;
    private List<PromotionProductVariationReadBodyResponse> product_variation;

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
    public String getPic_product() {
        return pic_product;
    }

    @JsonSetter
    public void setPic_product(String pic_product) {
        this.pic_product = pic_product;
    }

    @JsonGetter
    public List<PromotionProductVariationReadBodyResponse> getProduct_variation() {
        return product_variation;
    }

    @JsonSetter
    public void setProduct_variation(List<PromotionProductVariationReadBodyResponse> product_variation) {
        this.product_variation = product_variation;
    }
}
