package com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackingRestResponseMetaParam {
    private Integer code;
    private String message;
    private String type;

    @JsonGetter
    public Integer getCode() {
        return code;
    }

    @JsonSetter
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonGetter
    public String getMessage() {
        return message;
    }

    @JsonSetter
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonGetter
    public String getType() {
        return type;
    }

    @JsonSetter
    public void setType(String type) {
        this.type = type;
    }
}
