package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderDeleteRequest {
    private OrderDeleteBodyRequest body;

    @JsonGetter
    public OrderDeleteBodyRequest getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(OrderDeleteBodyRequest body) {
        this.body = body;
    }
}
