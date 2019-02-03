package com.th.ac.ku.kps.cpe.ecommerce.model.seller.productdelivery.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class ProductDeliveryReadBodyResponse {

    private List<ProductDeliveryReadDataBodyResponse> product_delivery;
    @JsonGetter
    public List<ProductDeliveryReadDataBodyResponse> getProduct_delivery() {
        return product_delivery;
    }
    @JsonSetter
    public void setProduct_delivery(List<ProductDeliveryReadDataBodyResponse> product_delivery) {
        this.product_delivery = product_delivery;
    }
}
