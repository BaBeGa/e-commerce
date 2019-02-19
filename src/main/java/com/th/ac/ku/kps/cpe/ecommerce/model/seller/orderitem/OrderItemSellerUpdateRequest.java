package com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderitem;

import com.th.ac.ku.kps.cpe.ecommerce.model.allenum.OrderItemStatus;

public class OrderItemSellerUpdateRequest {
    private Integer id_item;
    private OrderItemStatus order_item_status;
    private String confirm;
    private String description_reject;

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public OrderItemStatus getOrder_item_status() {
        return order_item_status;
    }

    public void setOrder_item_status(OrderItemStatus order_item_status) {
        this.order_item_status = order_item_status;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getDescription_reject() {
        return description_reject;
    }

    public void setDescription_reject(String description_reject) {
        this.description_reject = description_reject;
    }
}
