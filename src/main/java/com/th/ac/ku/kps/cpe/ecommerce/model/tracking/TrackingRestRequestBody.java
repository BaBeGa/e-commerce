package com.th.ac.ku.kps.cpe.ecommerce.model.tracking;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackingRestRequestBody {
    @NotNull
    private String slug;

    @NotNull
    private String tracking_number;

    private String title;
    private List<String> smses;
    private List<String> emails;
    private String order_id;
    private String order_id_path;
    private TrackingRestRequestBodyCustomfield custom_fields;
    private String language;

    @JsonGetter
    public String getSlug() {
        return slug;
    }
    @JsonSetter
    public void setSlug(String slug) {
        this.slug = slug;
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
    public String getTitle() {
        return title;
    }
    @JsonSetter
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonGetter
    public List<String> getSmses() {
        return smses;
    }
    @JsonSetter
    public void setSmses(List<String> smses) {
        this.smses = smses;
    }
    @JsonGetter
    public List<String> getEmails() {
        return emails;
    }
    @JsonSetter
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
    @JsonGetter
    public String getOrder_id() {
        return order_id;
    }
    @JsonSetter
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    @JsonGetter
    public String getOrder_id_path() {
        return order_id_path;
    }
    @JsonSetter
    public void setOrder_id_path(String order_id_path) {
        this.order_id_path = order_id_path;
    }
    @JsonGetter
    public TrackingRestRequestBodyCustomfield getCustom_fields() {
        return custom_fields;
    }
    @JsonSetter
    public void setCustom_fields(TrackingRestRequestBodyCustomfield custom_fields) {
        this.custom_fields = custom_fields;
    }
    @JsonGetter
    public String getLanguage() {
        return language;
    }
    @JsonSetter
    public void setLanguage(String language) {
        this.language = language;
    }
}
