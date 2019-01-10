package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RatingProductReadRatingProBodyResponse {
    private Integer id_rating_product;
    private Integer id_user;
    private String username;
    private Integer id_product;
    private String name_product;
    private Integer rating;
    private String comment;
    private String pic_comment;

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
    public String getComment() {
        return comment;
    }

    @JsonSetter
    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonGetter
    public String getPic_comment() {
        return pic_comment;
    }

    @JsonSetter
    public void setPic_comment(String pic_comment) {
        this.pic_comment = pic_comment;
    }
}
