package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class ProductUpdateBodyRequest {
    private Integer id_product;
    private String name_product;
    private String description;
    private Integer catagory;
    private String condition;
    private List<ProductUpdateBodyVariationRequest> product_variation;

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
    public String getDescription() {
        return description;
    }
    @JsonSetter
    public void setDescription(String description) {
        this.description = description;
    }
    @JsonGetter
    public Integer getCatagory() {
        return catagory;
    }
    @JsonSetter
    public void setCatagory(Integer catagory) {
        this.catagory = catagory;
    }
    @JsonGetter
    public String getCondition() {
        return condition;
    }
    @JsonSetter
    public void setCondition(String condition) {
        this.condition = condition;
    }
    @JsonGetter
    public List<ProductUpdateBodyVariationRequest> getProduct_variation() {
        return product_variation;
    }
    @JsonSetter
    public void setProduct_variation(List<ProductUpdateBodyVariationRequest> product_variation) {
        this.product_variation = product_variation;
    }
}
