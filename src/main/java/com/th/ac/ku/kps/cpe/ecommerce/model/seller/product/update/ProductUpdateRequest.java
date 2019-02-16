package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductUpdateRequest {

    private ProductUpdateBodyRequest body;

    @JsonGetter
    public ProductUpdateBodyRequest getBody() {
        return body;
    }
    @JsonSetter
    public void setBody(ProductUpdateBodyRequest body) {
        this.body = body;
    }
}
