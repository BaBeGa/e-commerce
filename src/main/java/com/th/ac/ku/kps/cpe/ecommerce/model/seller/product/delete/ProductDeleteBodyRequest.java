package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductDeleteBodyRequest {
    private int id_product;

    @JsonGetter
    public int getId_product() {
        return id_product;
    }
    @JsonSetter
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
}
