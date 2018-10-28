package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class OrderReadBodyResponse {
    private List<OrderReadOrderBodyResponse> order;

    @JsonGetter
    public List<OrderReadOrderBodyResponse> getOrder() {
        return order;
    }

    @JsonSetter
    public void setOrder(List<OrderReadOrderBodyResponse> order) {
        this.order = order;
    }
}
