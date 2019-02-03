package com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductDeliveryCreateRequest {
    private ProductDeliveryCreateBodyRequest body;

    @JsonGetter
    public ProductDeliveryCreateBodyRequest getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(ProductDeliveryCreateBodyRequest body) {
        this.body = body;
    }
}
