package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class OrderForSellerReadBodyResponse {
    private List<OrderForSellerReadOrderItemBodyResponse> order_item;

    @JsonGetter
    public List<OrderForSellerReadOrderItemBodyResponse> getOrder_item() {
        return order_item;
    }

    @JsonSetter
    public void setOrder_item(List<OrderForSellerReadOrderItemBodyResponse> order_item) {
        this.order_item = order_item;
    }
}
