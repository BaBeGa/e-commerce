package com.th.ac.ku.kps.cpe.ecommerce.model.tracking.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class TrackingsTrackingReadResponseDataParam {
    private String id;
    private String tracking_number;
    private String slug;
    private String tag;
    private List<CheckpointsParam> checkpoints;

    @JsonGetter
    public String getId() {
        return id;
    }

    @JsonSetter
    public void setId(String id) {
        this.id = id;
    }

    @JsonGetter
    public String getTracking_number() {
        return tracking_number;
    }

    @JsonSetter
    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    @JsonGetter
    public String getSlug() {
        return slug;
    }

    @JsonSetter
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonGetter
    public String getTag() {
        return tag;
    }

    @JsonSetter
    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonGetter
    public List<CheckpointsParam> getCheckpoints() {
        return checkpoints;
    }

    @JsonSetter
    public void setCheckpoints(List<CheckpointsParam> checkpoints) {
        this.checkpoints = checkpoints;
    }
}
