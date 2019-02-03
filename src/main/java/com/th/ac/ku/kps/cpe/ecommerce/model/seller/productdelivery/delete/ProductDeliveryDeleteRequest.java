package com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductDeliveryDeleteRequest {
    private ProductDeliveryDeleteBodyRequest body;

    @JsonGetter
    public ProductDeliveryDeleteBodyRequest getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(ProductDeliveryDeleteBodyRequest body) {
        this.body = body;
    }
}
