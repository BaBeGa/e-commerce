package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class FavoriteProductDeleteRequest {
    private Integer id_favorite;

    @JsonGetter
    public Integer getId_favorite() {
        return id_favorite;
    }

    @JsonSetter
    public void setId_favorite(Integer id_favorite) {
        this.id_favorite = id_favorite;
    }
}
