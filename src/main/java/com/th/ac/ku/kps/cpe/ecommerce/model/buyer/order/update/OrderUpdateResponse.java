package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderUpdateResponse {
    private Integer status;
    private String msg;

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
