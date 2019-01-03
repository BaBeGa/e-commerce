package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class FavoriteProductReadBodyResponse {


    private List<FavoriteProductReadBodyProductResponse> product_favorite;

    @JsonGetter
    public List<FavoriteProductReadBodyProductResponse> getProduct_favorite() {
        return product_favorite;
    }

    @JsonSetter
    public void setProduct_favorite(List<FavoriteProductReadBodyProductResponse> product_favorite) {
        this.product_favorite = product_favorite;
    }
}
