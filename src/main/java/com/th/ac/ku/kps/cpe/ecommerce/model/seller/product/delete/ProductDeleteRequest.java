package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductDeleteRequest {
    private ProductDeleteBodyRequest body;

    @JsonGetter
    public ProductDeleteBodyRequest getBody() {
        return body;
    }
    @JsonSetter
    public void setBody(ProductDeleteBodyRequest body) {
        this.body = body;
    }
}
