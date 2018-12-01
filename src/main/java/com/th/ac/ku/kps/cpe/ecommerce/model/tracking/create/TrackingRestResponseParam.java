package com.th.ac.ku.kps.cpe.ecommerce.model.tracking.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackingRestResponseParam {
    private TrackingRestResponseMetaParam meta;

    @JsonGetter
    public TrackingRestResponseMetaParam getMeta() {
        return meta;
    }

    @JsonSetter
    public void setMeta(TrackingRestResponseMetaParam meta) {
        this.meta = meta;
    }
}
