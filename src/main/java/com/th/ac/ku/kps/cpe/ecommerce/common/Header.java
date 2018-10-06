package com.th.ac.ku.kps.cpe.ecommerce.common;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Header {
    private int id_user;
    private String token;

    @JsonGetter
    public int getId_user() {
        return id_user;
    }

    @JsonSetter
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @JsonGetter
    public String getToken() {
        return token;
    }

    @JsonSetter
    public void setToken(String token) {
        this.token = token;
    }
}
