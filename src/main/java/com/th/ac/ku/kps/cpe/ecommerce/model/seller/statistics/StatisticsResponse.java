package com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class StatisticsResponse {
    private StatisticsBodyResponse body;
    private Integer status;
    private String msg;

    @JsonGetter
    public StatisticsBodyResponse getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(StatisticsBodyResponse body) {
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
