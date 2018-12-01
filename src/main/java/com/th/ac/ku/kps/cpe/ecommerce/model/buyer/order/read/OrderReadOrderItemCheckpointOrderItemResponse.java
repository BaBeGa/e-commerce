package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;

public class OrderReadOrderItemCheckpointOrderItemResponse {
    private String slug;
    private Timestamp created_at;
    private String location;
    private String country_name;
    private String message;
    private String country_iso3;
    private String tag;
    private String subtag;
    private String subtag_message;
    private String checkpoint_time;

    @JsonGetter
    public String getSlug() {
        return slug;
    }

    @JsonSetter
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonGetter
    public Timestamp getCreated_at() {
        return created_at;
    }

    @JsonSetter
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @JsonGetter
    public String getLocation() {
        return location;
    }

    @JsonSetter
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonGetter
    public String getCountry_name() {
        return country_name;
    }

    @JsonSetter
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
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
    public String getCountry_iso3() {
        return country_iso3;
    }

    @JsonSetter
    public void setCountry_iso3(String country_iso3) {
        this.country_iso3 = country_iso3;
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
    public String getSubtag() {
        return subtag;
    }

    @JsonSetter
    public void setSubtag(String subtag) {
        this.subtag = subtag;
    }

    @JsonGetter
    public String getSubtag_message() {
        return subtag_message;
    }

    @JsonSetter
    public void setSubtag_message(String subtag_message) {
        this.subtag_message = subtag_message;
    }

    @JsonGetter
    public String getCheckpoint_time() {
        return checkpoint_time;
    }

    @JsonSetter
    public void setCheckpoint_time(String checkpoint_time) {
        this.checkpoint_time = checkpoint_time;
    }
}

