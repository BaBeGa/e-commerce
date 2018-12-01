package com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TrackingRestRequestBodyCustomfield {
    private String product_name;
    private String product_price;

    @JsonGetter
    public String getProduct_name() {
        return product_name;
    }
    @JsonSetter
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    @JsonGetter
    public String getProduct_price() {
        return product_price;
    }
    @JsonSetter
    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}
