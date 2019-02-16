package com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OrderReadDeliveryAddressOrderResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id_address;
    private String receiver;
    private String address;
    private String sub_district;
    private String district;
    private String province;
    private String postal_code;
    private String phone_receiver;

    @JsonGetter
    public Integer getId_address() {
        return id_address;
    }

    @JsonSetter
    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    @JsonGetter
    public String getReceiver() {
        return receiver;
    }

    @JsonSetter
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @JsonGetter
    public String getAddress() {
        return address;
    }

    @JsonSetter
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonGetter
    public String getSub_district() {
        return sub_district;
    }

    @JsonSetter
    public void setSub_district(String sub_district) {
        this.sub_district = sub_district;
    }

    @JsonGetter
    public String getDistrict() {
        return district;
    }

    @JsonSetter
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonGetter
    public String getProvince() {
        return province;
    }

    @JsonSetter
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonGetter
    public String getPostal_code() {
        return postal_code;
    }

    @JsonSetter
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    @JsonGetter
    public String getPhone_receiver() {
        return phone_receiver;
    }

    @JsonSetter
    public void setPhone_receiver(String phone_receiver) {
        this.phone_receiver = phone_receiver;
    }
}
