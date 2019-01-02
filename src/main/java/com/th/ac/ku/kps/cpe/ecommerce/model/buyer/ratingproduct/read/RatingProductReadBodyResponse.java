package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class RatingProductReadBodyResponse {
    private List<RatingProductReadRatingProBodyResponse> rating_product;

    @JsonGetter
    public List<RatingProductReadRatingProBodyResponse> getRating_product() {
        return rating_product;
    }

    @JsonSetter
    public void setRating_product(List<RatingProductReadRatingProBodyResponse> rating_product) {
        this.rating_product = rating_product;
    }
}
