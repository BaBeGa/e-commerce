package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class RatingProductReadRatingProBodyResponse {
    private Integer id_rating_product;
    private Integer id_order_history;
    private Integer id_product;
    private String name_product;
    private Integer rating;
    private String content;
    private Timestamp rated_date;
    private String[] pic_comment;

    @JsonGetter
    public Integer getId_rating_product() {
        return id_rating_product;
    }

    @JsonSetter
    public void setId_rating_product(Integer id_rating_product) {
        this.id_rating_product = id_rating_product;
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
    public String[] getPic_comment() {
        return pic_comment;
    }

    @JsonSetter
    public void setPic_comment(String[] pic_comment) {
        this.pic_comment = pic_comment;
    }
}

