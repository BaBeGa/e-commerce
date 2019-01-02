package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderhistory;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class OrderHistoryReadBodyResponse {
    private List<OrderHistoryReadOrderHisBodyResponse> order_history;

    @JsonGetter
    public List<OrderHistoryReadOrderHisBodyResponse> getOrder_history() {
        return order_history;
    }

    @JsonSetter
    public void setOrder_history(List<OrderHistoryReadOrderHisBodyResponse> order_history) {
        this.order_history = order_history;
    }
}
