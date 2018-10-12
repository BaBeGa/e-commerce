package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class ProductReadBodyResponse {
    private List<ProductReadProductBodyResponse> product;

    @JsonGetter
    public List<ProductReadProductBodyResponse> getProduct() {
        return product;
    }
    @JsonSetter
    public void setProduct(List<ProductReadProductBodyResponse> product) {
        this.product = product;
    }
}
