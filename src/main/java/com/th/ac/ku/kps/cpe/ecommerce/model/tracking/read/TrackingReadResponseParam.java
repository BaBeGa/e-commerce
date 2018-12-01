package com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TrackingReadResponseParam {
    private TrackingReadResponseMetaParam meta;
    private TrackingReadResponseDataParam data;

    @JsonGetter
    public TrackingReadResponseMetaParam getMeta() {
        return meta;
    }
    @JsonSetter
    public void setMeta(TrackingReadResponseMetaParam meta) {
        this.meta = meta;
    }

    @JsonGetter
    public TrackingReadResponseDataParam getData() {
        return data;
    }

    @JsonSetter
    public void setData(TrackingReadResponseDataParam data) {
        this.data = data;
    }
}
