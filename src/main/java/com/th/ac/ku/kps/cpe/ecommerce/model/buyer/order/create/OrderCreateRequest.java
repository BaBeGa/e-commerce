package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class OrderCreateRequest {
    private OrderCreateBodyRequest body;

    @JsonGetter
    public OrderCreateBodyRequest getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(OrderCreateBodyRequest body) {
        this.body = body;
    }
}
