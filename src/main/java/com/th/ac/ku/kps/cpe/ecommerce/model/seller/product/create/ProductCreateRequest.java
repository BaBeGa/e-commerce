package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductCreateRequest {
    private ProductCreateBodyRequest body;

    @JsonGetter
    public ProductCreateBodyRequest getBody() {
        return body;
    }
    @JsonSetter
    public void setBody(ProductCreateBodyRequest body) {
        this.body = body;
    }
}
