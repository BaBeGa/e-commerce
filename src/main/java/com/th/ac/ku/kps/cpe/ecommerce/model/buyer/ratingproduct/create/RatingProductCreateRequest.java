package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RatingProductCreateRequest {
    private Integer id_product;
    private Integer rating;

    @JsonGetter
    public Integer getId_product() {
        return id_product;
    }

    @JsonSetter
    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    @JsonGetter
    public Integer getRating() {
        return rating;
    }

    @JsonSetter
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
