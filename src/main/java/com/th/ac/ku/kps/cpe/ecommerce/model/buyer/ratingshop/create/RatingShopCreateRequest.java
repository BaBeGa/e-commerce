package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingshop.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.validation.constraints.NotNull;

public class RatingShopCreateRequest {
    @NotNull(message = "id_order_history required")
    private Integer id_order_history;
    @NotNull(message = "rating required")
    private Integer rating;
    private String content;

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
}
