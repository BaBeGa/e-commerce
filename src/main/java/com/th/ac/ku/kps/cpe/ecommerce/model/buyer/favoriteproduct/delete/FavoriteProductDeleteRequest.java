package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class FavoriteProductDeleteRequest {
    private Integer id_product;

    @JsonGetter
    public Integer getId_product() {
        return id_product;
    }

    @JsonSetter
    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }
}
