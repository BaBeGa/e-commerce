package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingshop.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

public class RatingShopReadResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RatingShopBodyReadResponse body;
    private Integer status;
    private String msg;

    @JsonGetter
    public RatingShopBodyReadResponse getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(RatingShopBodyReadResponse body) {
        this.body = body;
    }

    @JsonGetter
    public Integer getStatus() {
        return status;
    }

    @JsonSetter
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonGetter
    public String getMsg() {
        return msg;
    }

    @JsonSetter
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
