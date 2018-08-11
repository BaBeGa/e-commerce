package com.th.ac.ku.kps.cpe.ecommerce.model.tracking;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TrackingRestRequest {
    private TrackingRestRequestBody tracking;

    @JsonGetter
    public TrackingRestRequestBody getTracking() {
        return tracking;
    }

    @JsonSetter
    public void setTracking(TrackingRestRequestBody tracking) {
        this.tracking = tracking;
    }
}
