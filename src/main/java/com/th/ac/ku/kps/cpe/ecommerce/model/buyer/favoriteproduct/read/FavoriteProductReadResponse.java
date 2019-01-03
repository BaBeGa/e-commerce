package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class FavoriteProductReadResponse {
    private FavoriteProductReadBodyResponse body;
    private Integer status;
    private String msg;

    @JsonGetter
    public FavoriteProductReadBodyResponse getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(FavoriteProductReadBodyResponse body) {
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
