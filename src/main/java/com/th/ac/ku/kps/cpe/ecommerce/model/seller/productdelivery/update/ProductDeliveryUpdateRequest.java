package com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductDeliveryUpdateRequest {
    private ProductDeliveryUpdateBodyRequest body;

    @JsonGetter
    public ProductDeliveryUpdateBodyRequest getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(ProductDeliveryUpdateBodyRequest body) {
        this.body = body;
    }
}
