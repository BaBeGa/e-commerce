package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductUpdateBodyVariationRequest {
    private Integer id_variation;
    private String name;
    private Double price;
    private Integer stock;

    @JsonGetter
    public Integer getId_variation() {
        return id_variation;
    }
    @JsonSetter
    public void setId_variation(Integer id_variation) {
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
    public Double getPrice() {
        return price;
    }
    @JsonSetter
    public void setPrice(Double price) {
        this.price = price;
    }
    @JsonGetter
    public Integer getStock() {
        return stock;
    }
    @JsonSetter
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
