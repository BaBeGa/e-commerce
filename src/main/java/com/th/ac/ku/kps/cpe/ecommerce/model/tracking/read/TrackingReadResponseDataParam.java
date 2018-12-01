package com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class TrackingReadResponseDataParam {
    private TrackingsTrackingReadResponseDataParam tracking;

    @JsonGetter
    public TrackingsTrackingReadResponseDataParam getTracking() {
        return tracking;
    }

    @JsonSetter
    public void setTracking(TrackingsTrackingReadResponseDataParam tracking) {
        this.tracking = tracking;
    }
}
