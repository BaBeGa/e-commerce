package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductUpdateResponse {
    private int status;
    private String msg;

    @JsonGetter
    public int getStatus() {
        return status;
    }
    @JsonSetter
    public void setStatus(int status) {
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
