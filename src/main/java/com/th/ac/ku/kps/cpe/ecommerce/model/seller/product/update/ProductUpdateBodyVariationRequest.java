package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductUpdateBodyVariationRequest {
    private int id_variation;
    private String name;
    private float price;
    private int stock;

    @JsonGetter
    public int getId_variation() {
        return id_variation;
    }
    @JsonSetter
    public void setId_variation(int id_variation) {
        this.id_variation = id_variation;
    }
    @JsonGetter
    public String getName() {
        return name;
    }
    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }
    @JsonGetter
    public float getPrice() {
        return price;
    }
    @JsonSetter
    public void setPrice(float price) {
        this.price = price;
    }
    @JsonGetter
    public int getStock() {
        return stock;
    }
    @JsonSetter
    public void setStock(int stock) {
        this.stock = stock;
    }
}
