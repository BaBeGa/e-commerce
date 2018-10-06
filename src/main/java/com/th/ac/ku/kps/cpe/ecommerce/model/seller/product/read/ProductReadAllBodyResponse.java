package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class ProductReadAllBodyResponse {
    private List<ProductReadAllProductBodyResponse> product;

    @JsonGetter
    public List<ProductReadAllProductBodyResponse> getProduct() {
        return product;
    }
    @JsonSetter
    public void setProduct(List<ProductReadAllProductBodyResponse> product) {
        this.product = product;
    }
}
