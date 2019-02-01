package com.th.ac.ku.kps.cpe.ecommerce.common;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class ErrorResponse {
    private Integer status;
    private List<String> msg;

    @JsonGetter
    public Integer getStatus() {
        return status;
    }

    @JsonSetter
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonGetter
    public List<String> getMsg() {
        return msg;
    }

    @JsonSetter
    public void setMsg(List<String> msg) {
        this.msg = msg;
    }
}
