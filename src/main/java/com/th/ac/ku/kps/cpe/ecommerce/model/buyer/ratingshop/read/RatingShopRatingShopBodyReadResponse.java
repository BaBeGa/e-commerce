package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingshop.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class RatingShopRatingShopBodyReadResponse {
    private Integer id_rating_shop;
    private Integer id_order_history;
    private Integer id_shop;
    private String name_shop;
    private Integer rating;
    private String content;
    private Timestamp rated_date;

    @JsonGetter
    public Integer getId_rating_shop() {
        return id_rating_shop;
    }

    @JsonSetter
    public void setId_rating_shop(Integer id_rating_shop) {
        this.id_rating_shop = id_rating_shop;
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
    public Integer getId_shop() {
        return id_shop;
    }

    @JsonSetter
    public void setId_shop(Integer id_shop) {
        this.id_shop = id_shop;
    }

    @JsonGetter
    public String getName_shop() {
        return name_shop;
    }

    @JsonSetter
    public void setName_shop(String name_shop) {
        this.name_shop = name_shop;
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
}

