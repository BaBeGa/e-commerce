package com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TrackingReadResponseMetaParam {
    private Integer code;

    @JsonGetter
    public Integer getCode() {
        return code;
    }

    @JsonSetter
    public void setCode(Integer code) {
        this.code = code;
    }
}
