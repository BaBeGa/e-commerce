package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RatingProductReadBodyResponse {
    private RatingProductReadRatingProBodyResponse rating_product;

    @JsonGetter
    public RatingProductReadRatingProBodyResponse getRating_product() {
        return rating_product;
    }

    @JsonSetter
    public void setRating_product(RatingProductReadRatingProBodyResponse rating_product) {
        this.rating_product = rating_product;
    }
}
