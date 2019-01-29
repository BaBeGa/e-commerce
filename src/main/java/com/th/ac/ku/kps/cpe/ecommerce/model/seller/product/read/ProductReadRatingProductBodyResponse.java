package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class ProductReadRatingProductBodyResponse {
    private Integer id_rating_product;
    private Integer id_user;
    private String username;
    private Integer id_order_history;
    private Integer rating;
    private String content;
    private Timestamp rated_date;
    private String[] rating_product_pic;

    @JsonGetter
    public Integer getId_rating_product() {
        return id_rating_product;
    }

    @JsonSetter
    public void setId_rating_product(Integer id_rating_product) {
        this.id_rating_product = id_rating_product;
    }

    @JsonGetter
    public Integer getId_user() {
        return id_user;
    }

    @JsonSetter
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    @JsonGetter
    public String getUsername() {
        return username;
    }

    @JsonSetter
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonGetter
    public Integer getId_order_history() {
        return id_order_history;
    }

    @JsonSetter
    public void setId_order_history(Integer id_order_history) {
        this.id_order_history = id_order_history;
    }

    @JsonGetter
    public Integer getRating() {
        return rating;
    }

    @JsonSetter
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonGetter
    public String getContent() {
        return content;
    }

    @JsonSetter
    public void setContent(String content) {
        this.content = content;
    }

    @JsonGetter
    public Timestamp getRated_date() {
        return rated_date;
    }

    @JsonSetter
    public void setRated_date(Timestamp rated_date) {
        this.rated_date = rated_date;
    }

    @JsonGetter
    public String[] getRating_product_pic() {
        return rating_product_pic;
    }

    @JsonSetter
    public void setRating_product_pic(String[] rating_product_pic) {
        this.rating_product_pic = rating_product_pic;
    }
}
