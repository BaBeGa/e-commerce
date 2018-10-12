package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductReadVariationProductBodyResponse {
    private int id_variation;
    private String name;
    private double price;
    private int stock;
    private ProductReadPromotionVariationProductBodyResponse promotion;

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
    public double getPrice() {
        return price;
    }
    @JsonSetter
    public void setPrice(double price) {
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
    @JsonGetter
    public ProductReadPromotionVariationProductBodyResponse getPromotion() {
        return promotion;
    }
    @JsonSetter
    public void setPromotion(ProductReadPromotionVariationProductBodyResponse promotion) {
        this.promotion = promotion;
    }
}
