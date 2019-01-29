package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;
import java.util.List;

public class ProductReadProductBodyResponse {
    private int id_product;
    private String name_product;
    private String description;
    private ProductReadCatagoryProductBodyResponse catagory;
    private String condition;
    private Timestamp created_at;
    private List<ProductReadProductpicProductBodyResponse> product_pic;
    private List<ProductReadVariationProductBodyResponse> product_variation;
    private List<ProductReadRatingProductBodyResponse> rating_product;
    private Double mean_rating;
    private Integer count_rating;

    @JsonGetter
    public int getId_product() {
        return id_product;
    }

    @JsonSetter
    public void setId_product(int id_product) {
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
    public ProductReadCatagoryProductBodyResponse getCatagory() {
        return catagory;
    }

    @JsonSetter
    public void setCatagory(ProductReadCatagoryProductBodyResponse catagory) {
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
    public Timestamp getCreated_at() {
        return created_at;
    }

    @JsonSetter
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @JsonGetter
    public List<ProductReadProductpicProductBodyResponse> getProduct_pic() {
        return product_pic;
    }

    @JsonSetter
    public void setProduct_pic(List<ProductReadProductpicProductBodyResponse> product_pic) {
        this.product_pic = product_pic;
    }

    @JsonGetter
    public List<ProductReadVariationProductBodyResponse> getProduct_variation() {
        return product_variation;
    }

    @JsonSetter
    public void setProduct_variation(List<ProductReadVariationProductBodyResponse> product_variation) {
        this.product_variation = product_variation;
    }

    @JsonGetter
    public List<ProductReadRatingProductBodyResponse> getRating_product() {
        return rating_product;
    }

    @JsonSetter
    public void setRating_product(List<ProductReadRatingProductBodyResponse> rating_product) {
        this.rating_product = rating_product;
    }

    @JsonGetter
    public Double getMean_rating() {
        return mean_rating;
    }

    @JsonSetter
    public void setMean_rating(Double mean_rating) {
        this.mean_rating = mean_rating;
    }

    @JsonGetter
    public Integer getCount_rating() {
        return count_rating;
    }

    @JsonSetter
    public void setCount_rating(Integer count_rating) {
        this.count_rating = count_rating;
    }
}
