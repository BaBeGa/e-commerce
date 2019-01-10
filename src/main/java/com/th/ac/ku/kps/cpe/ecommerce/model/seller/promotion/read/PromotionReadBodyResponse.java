package com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class PromotionReadBodyResponse {
    private List<PromotionProductReadBodyResponse> promotion_product;

    @JsonGetter
    public List<PromotionProductReadBodyResponse> getPromotion_product() {
        return promotion_product;
    }

    @JsonSetter
    public void setPromotion_product(List<PromotionProductReadBodyResponse> promotion_product) {
        this.promotion_product = promotion_product;
    }
}
