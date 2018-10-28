package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderUpdateRequest {
    private OrderUpdateBodyRequest body;

    @JsonGetter
    public OrderUpdateBodyRequest getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(OrderUpdateBodyRequest body) {
        this.body = body;
    }
}
