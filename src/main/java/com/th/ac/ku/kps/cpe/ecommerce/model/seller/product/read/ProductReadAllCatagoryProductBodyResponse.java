package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductReadAllCatagoryProductBodyResponse {
    private int id_category;
    private String name_category;

    @JsonGetter
    public int getId_category() {
        return id_category;
    }
    @JsonSetter
    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
    @JsonGetter
    public String getName_category() {
        return name_category;
    }
    @JsonSetter
    public void setName_category(String name_category) {
        this.name_category = name_category;
    }
}
