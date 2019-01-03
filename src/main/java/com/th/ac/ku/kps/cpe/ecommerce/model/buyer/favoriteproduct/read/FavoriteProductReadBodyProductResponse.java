package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class FavoriteProductReadBodyProductResponse {
    private Integer id_favorite;
    private Integer id_product;
    private String name_product;
    private String pic_product;

    @JsonGetter
    public Integer getId_favorite() {
        return id_favorite;
    }

    @JsonSetter
    public void setId_favorite(Integer id_favorite) {
        this.id_favorite = id_favorite;
    }

    @JsonGetter
    public Integer getId_product() {
        return id_product;
    }

    @JsonSetter
    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    @JsonGetter
    public String getName_product() {
        return name_product;
    }

    @JsonSetter
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    @JsonGetter
    public String getPic_product() {
        return pic_product;
    }

    @JsonSetter
    public void setPic_product(String pic_product) {
        this.pic_product = pic_product;
    }
}
