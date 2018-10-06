package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductCreateBodyVariationRequest {
    private String name;
    private float price;
    private int stock;

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
