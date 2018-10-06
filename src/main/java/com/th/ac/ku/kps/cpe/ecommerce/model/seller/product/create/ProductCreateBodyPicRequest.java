package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductCreateBodyPicRequest {
    private String pic_product;

    @JsonGetter
    public String getPic_product() {
        return pic_product;
    }

    @JsonSetter
    public void setPic_product(String pic_product) {
        this.pic_product = pic_product;
    }
}
